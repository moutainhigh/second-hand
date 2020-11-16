package com.example.product.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.product.center.dao.SecondCategoryMapper;
import com.example.product.center.dao.SecondFileMapper;
import com.example.product.center.dao.SecondProductMapper;
import com.example.product.center.manual.CategoryEnum;
import com.example.product.center.manual.CategoryInfo;
import com.example.product.center.model.*;
import com.second.common.service.FileMangeService;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import com.second.utils.response.handler.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: CategoryController
 * @ProjectName Second-order-center
 * @Description:分类
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Category")
@CrossOrigin
public class CategoryController {
//    分类
    @Autowired
    SecondCategoryMapper secondCategoryMapper;
//    商品
    @Autowired
    SecondProductMapper secondProductMapper;
//    文件
    @Autowired
    private SecondFileMapper secondFileMapper;

    @RequestMapping(path = "/addCategory", method = RequestMethod.POST)
    @ApiOperation(value = "添加分类", notes = "添加分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "fileId", value = "文件id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryName", value = "类目名称", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "parentCategoryId", value = "上级类目id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "levelId", value = "级别", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryType", value = "分类类型", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> addCategory(
            @RequestParam(value = "fileId", required = false) String fileId,
            @RequestParam(value = "categoryName", required = false) String categoryName,
            @RequestParam(value = "parentCategoryId", required = false) Integer parentCategoryId,
            @RequestParam(value = "categoryType", required = false) String categoryType,
            @RequestParam(value = "levelId", required = false) Integer levelId,
            HttpServletResponse response
    ) throws Exception {
        //防止非一级类目上级类目传空
        if (levelId !=0 && parentCategoryId==null || levelId !=0 && parentCategoryId==0|| levelId !=0 && parentCategoryId.equals("")){
            response.sendError(HttpStatus.FORBIDDEN.value(), "请选择上级类目");
        }
        SecondCategory secondCategory1 = secondCategoryMapper.selectByPrimaryKey(parentCategoryId);
        if (levelId<=secondCategory1.getLevelId()){
            response.sendError(HttpStatus.FORBIDDEN.value(), "上级类目同级或者更高级");
        }
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondCategory secondCategory = new SecondCategory();
        secondCategory.setLevelId(levelId);
        secondCategory.setCategoryType(CategoryEnum.Relation.getState(categoryType).getState());
        secondCategory.setSecondName(categoryName);
        secondCategory.setParentCategoryId(parentCategoryId);
        secondCategory.setCreateTime(LocalDateTime.now());
        secondCategory.setModifyTime(LocalDateTime.now());
        secondCategory.setIsDeleted((short) 0);
        if (fileId!=null && !fileId.equals("")){
            secondCategory.setFile(fileId);
        }
        secondCategoryMapper.insertSelective(secondCategory);
        return builder.body(ResponseUtils.getResponseBody(secondCategory));
    }

    @RequestMapping(path = "/deleteCategory", method = RequestMethod.POST)
    @ApiOperation(value = "删除分类", notes = "删除分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> deleteCategory(
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
//        判断是否有下级类目
        SecondCategoryExample secondCategoryExample = new SecondCategoryExample();
        secondCategoryExample.createCriteria().andParentCategoryIdEqualTo(categoryId).andIsDeletedEqualTo((short) 0);
        List<SecondCategory> secondCategories = secondCategoryMapper.selectByExample(secondCategoryExample);
        if (secondCategories.size()!=0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "有下级类目");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
//        判断类目下是否有商品
        SecondProductExample secondProductExample = new SecondProductExample();
        secondProductExample.createCriteria().andCategoryIdEqualTo(categoryId).andIsDeletedEqualTo((short) 0);
        List<SecondProduct> secondProducts = secondProductMapper.selectByExample(secondProductExample);
        if (secondProducts.size()!=0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "类目下有商品");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        //判断都没有 逻辑删除删除类目
//        SecondCategory secondCategory1 = secondCategoryMapper.selectByPrimaryKey(categoryId);
//        String str = secondCategory1.getFile();

        SecondCategory secondCategory = new SecondCategory();
        secondCategory.setId(categoryId);
        secondCategory.setIsDeleted((short) 1);
        secondCategoryMapper.updateByPrimaryKeySelective(secondCategory);
        //删除图片
//        if (str!=null){
//            String str1=str.substring(0, str.indexOf("="));
//            String str2=str.substring(str1.length()+1, str.length());
//            System.out.println(str2);
//            SecondFile secondFile =  secondFileMapper.selectByPrimaryKey(Integer.valueOf(str2));
//            if (secondFile!=null){
//                FileMangeService fileManageService = new FileMangeService();
//                fileManageService.deleteFile(secondFile.getGroupName(), secondFile.getRemoteFilename());
//                secondFileMapper.deleteByPrimaryKey(secondFile.getId());
//            }
//        }
        return builder.body(ResponseUtils.getResponseBody(0));

    }
    @RequestMapping(path = "/updateCategory", method = RequestMethod.POST)
    @ApiOperation(value = "修改分类", notes = "修改分类")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "fileId", value = "文件id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryName", value = "类目名称", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> updateCategory(
            @RequestParam(value = "categoryId", required = false) Integer categoryId,
            @RequestParam(value = "fileId", required = false) String fileId,
            @RequestParam(value = "categoryName", required = false) String categoryName,
            HttpServletResponse response
    ) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondCategory secondCategory1 = secondCategoryMapper.selectByPrimaryKey(categoryId);
        String str = secondCategory1.getFile();
        SecondCategory secondCategory = new SecondCategory();
        secondCategory.setSecondName(categoryName);
        secondCategory.setId(categoryId);
        if (fileId!=null && !fileId.equals("")){
            secondCategory.setFile(fileId);
        }

        secondCategoryMapper.updateByPrimaryKeySelective(secondCategory);
        //删除图片
//        if (fileId!=null){
//            String str1=str.substring(0, str.indexOf("="));
//            String str2=str.substring(str1.length()+1, str.length());
//            System.out.println(str2);
//            SecondFile secondFile =  secondFileMapper.selectByPrimaryKey(Integer.valueOf(str2));
//            if (secondFile!=null){
//                FileMangeService fileManageService = new FileMangeService();
//                fileManageService.deleteFile(secondFile.getGroupName(), secondFile.getRemoteFilename());
//                secondFileMapper.deleteByPrimaryKey(secondFile.getId());
//            }
//        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }
    @ApiOperation(value = "获取类目", notes = "添加类目时获取类目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "parentCategoryId", value = "上级的类目id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "levelId", value = "类目级别", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "categoryType", value = "类目类型", required = false, type = "String")
    })
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> listCategory(
            @RequestParam(name = "parentCategoryId", required = false) Integer parentCategoryId,
            @RequestParam(name = "categoryType", required = false) String categoryType,
            @RequestParam(name = "levelId", required = false) Integer levelId
           )
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        List<SecondCategory> secondCategories = new ArrayList<>();
//        根据上级类目查询其下级所有类目
        if (parentCategoryId!=null){
            SecondCategoryExample secondCategoryExample = new SecondCategoryExample();
            secondCategoryExample.createCriteria().andParentCategoryIdEqualTo(parentCategoryId).andIsDeletedEqualTo((short) 0);
            secondCategories = secondCategoryMapper.selectByExample(secondCategoryExample);
        }
//        查询某一级别下所有类目
        if (levelId!=null){
            SecondCategoryExample secondCategoryExample = new SecondCategoryExample();
            secondCategoryExample.createCriteria().andLevelIdEqualTo(levelId)
                    .andIsDeletedEqualTo((short) 0)
            .andCategoryTypeEqualTo(CategoryEnum.Relation.getState(categoryType).getState());
            secondCategories = secondCategoryMapper.selectByExample(secondCategoryExample);
        }
        return builder.body(ResponseUtils.getResponseBody(secondCategories));
    }
    @ApiOperation(value = "获取所有类目", notes = "获取所有类目")
    @RequestMapping(value = "/categoryList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "categoryType", value = "类目类型", required = false, type = "String")
    })
    public ResponseEntity<JSONObject> categoryList(
            @RequestParam(name = "categoryType", required = false) String categoryType,
            HttpServletRequest request)
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
//        查询所有一级类目
        SecondCategoryExample secondCategoryExample = new SecondCategoryExample();
        secondCategoryExample.createCriteria().andLevelIdEqualTo(0)
                .andIsDeletedEqualTo((short) 0)
        .andCategoryTypeEqualTo(CategoryEnum.Relation.getState(categoryType).getState());
        List<SecondCategory> secondCategorys = secondCategoryMapper.selectByExample(secondCategoryExample);
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        secondCategorys.forEach(secondCategory -> {
//            一级
            CategoryInfo categoryInfo = new CategoryInfo();
            categoryInfo.setDate(secondCategory.getCreateTime());
            categoryInfo.setLevel(secondCategory.getLevelId());
            categoryInfo.setFileId(secondCategory.getFile());
            categoryInfo.setId(secondCategory.getId());
            categoryInfo.setName(secondCategory.getSecondName());
//            根据一级查询下级类目
            SecondCategoryExample secondCategoryExample1 = new SecondCategoryExample();
            secondCategoryExample1.createCriteria().andParentCategoryIdEqualTo(secondCategory.getId()).andIsDeletedEqualTo((short) 0);
            List<SecondCategory> secondCategoryList = secondCategoryMapper.selectByExample(secondCategoryExample1);
//          二级数组
            List<CategoryInfo> categoryInfos1 = new ArrayList<>();
            if (secondCategoryList.size()!=0){
                secondCategoryList.forEach(secondCategory1 -> {
//                二级
                    CategoryInfo categoryInfo1 = new CategoryInfo();
                    categoryInfo1.setId(secondCategory1.getId());
                    categoryInfo1.setLevel(secondCategory1.getLevelId());
                    categoryInfo1.setDate(secondCategory1.getCreateTime());
                    categoryInfo1.setFileId(secondCategory1.getFile());
                    categoryInfo1.setName(secondCategory1.getSecondName());
//                    三级查询
                    SecondCategoryExample secondCategoryExample2 = new SecondCategoryExample();
                    secondCategoryExample2.createCriteria().andParentCategoryIdEqualTo(secondCategory1.getId()).andIsDeletedEqualTo((short) 0);
                    List<SecondCategory> secondCategoryList2 = secondCategoryMapper.selectByExample(secondCategoryExample2);
//                    三级数组
                    List<CategoryInfo> categoryInfos2 = new ArrayList<>();
                    if (secondCategoryList2.size()!=0){
                        secondCategoryList2.forEach(secondCategory2 -> {
//                            三级
                            CategoryInfo categoryInfo2 = new CategoryInfo();
                            categoryInfo2.setId(secondCategory2.getId());
                            categoryInfo2.setLevel(secondCategory2.getLevelId());
                            categoryInfo2.setDate(secondCategory2.getCreateTime());
                            categoryInfo2.setFileId(secondCategory2.getFile());
                            categoryInfo2.setName(secondCategory2.getSecondName());
                            categoryInfos2.add(categoryInfo2);
                        });
                        //三级加入二级
                        categoryInfo1.setCategories(categoryInfos2);
                    }
                    categoryInfos1.add(categoryInfo1);
                });
//                二级加入一级
                categoryInfo.setCategories(categoryInfos1);
            }
            categoryInfos.add(categoryInfo);
        });
        return builder.body(ResponseUtils.getResponseBody(categoryInfos));
    }
    @ApiOperation(value = "获取一级下所有类目", notes = "获取一级下所有类目")
    @RequestMapping(value = "/categoryFirstList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "categoryId", value = "类目id", required = false, type = "Integer")
    })
    public ResponseEntity<JSONObject> categoryFirstList(
            @RequestParam(name = "categoryId", required = false) Integer categoryId,
            HttpServletRequest request)
            throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
//        查询一个一级类目
        SecondCategoryExample secondCategoryExample = new SecondCategoryExample();
        secondCategoryExample.createCriteria().andLevelIdEqualTo(0)
                .andIsDeletedEqualTo((short) 0)
                .andIdEqualTo(categoryId);
        List<SecondCategory> secondCategorys = secondCategoryMapper.selectByExample(secondCategoryExample);
        List<CategoryInfo> categoryInfos = new ArrayList<>();
        secondCategorys.forEach(secondCategory -> {
//            一级
            CategoryInfo categoryInfo = new CategoryInfo();
            categoryInfo.setDate(secondCategory.getCreateTime());
            categoryInfo.setLevel(secondCategory.getLevelId());
            categoryInfo.setFileId(secondCategory.getFile());
            categoryInfo.setId(secondCategory.getId());
            categoryInfo.setName(secondCategory.getSecondName());
//            根据一级查询下级类目
            SecondCategoryExample secondCategoryExample1 = new SecondCategoryExample();
            secondCategoryExample1.createCriteria().andParentCategoryIdEqualTo(secondCategory.getId()).andIsDeletedEqualTo((short) 0);
            List<SecondCategory> secondCategoryList = secondCategoryMapper.selectByExample(secondCategoryExample1);
//          二级数组
            List<CategoryInfo> categoryInfos1 = new ArrayList<>();
            if (secondCategoryList.size()!=0){
                secondCategoryList.forEach(secondCategory1 -> {
//                二级
                    CategoryInfo categoryInfo1 = new CategoryInfo();
                    categoryInfo1.setId(secondCategory1.getId());
                    categoryInfo1.setLevel(secondCategory1.getLevelId());
                    categoryInfo1.setDate(secondCategory1.getCreateTime());
                    categoryInfo1.setFileId(secondCategory1.getFile());
                    categoryInfo1.setName(secondCategory1.getSecondName());
//                    三级查询
                    SecondCategoryExample secondCategoryExample2 = new SecondCategoryExample();
                    secondCategoryExample2.createCriteria().andParentCategoryIdEqualTo(secondCategory1.getId()).andIsDeletedEqualTo((short) 0);
                    List<SecondCategory> secondCategoryList2 = secondCategoryMapper.selectByExample(secondCategoryExample2);
//                    三级数组
                    List<CategoryInfo> categoryInfos2 = new ArrayList<>();
                    if (secondCategoryList2.size()!=0){
                        secondCategoryList2.forEach(secondCategory2 -> {
//                            三级
                            CategoryInfo categoryInfo2 = new CategoryInfo();
                            categoryInfo2.setId(secondCategory2.getId());
                            categoryInfo2.setLevel(secondCategory2.getLevelId());
                            categoryInfo2.setDate(secondCategory2.getCreateTime());
                            categoryInfo2.setFileId(secondCategory2.getFile());
                            categoryInfo2.setName(secondCategory2.getSecondName());
                            categoryInfos2.add(categoryInfo2);
                        });
                        //三级加入二级
                        categoryInfo1.setCategories(categoryInfos2);
                    }
                    categoryInfos1.add(categoryInfo1);
                });
//                二级加入一级
                categoryInfo.setCategories(categoryInfos1);
            }
            categoryInfos.add(categoryInfo);
        });
        return builder.body(ResponseUtils.getResponseBody(categoryInfos));
    }
}
