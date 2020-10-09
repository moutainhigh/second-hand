package com.example.payment.center.controller;


import com.example.payment.center.dao.SecondBossSettingMapper;
import com.example.payment.center.manual.Authentication;
import com.example.payment.center.model.SecondBossSetting;
import com.example.payment.center.model.SecondBossSettingExample;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/PayBoss")
@Api
public class PayBossController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
@Autowired
private SecondBossSettingMapper secondBossSettingMapper;
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "payment/car";

    @ApiOperation(value = "证书上传", notes = "证书上传")
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public String payment(MultipartFile uploadFile, HttpServletRequest request, SecondBossSetting payBoss)
            throws JSONException, IOException {
        if(uploadFile.isEmpty()){
            //返回选择文件提示
            return "请选择上传文件";
        }
        payBoss.setBossId(1);
        SecondBossSettingExample payBossExample = new SecondBossSettingExample();
        payBossExample.createCriteria().andBossIdEqualTo(payBoss.getBossId()).andIsDeletedEqualTo((byte) 0);
        List<SecondBossSetting> payBossList = secondBossSettingMapper.selectByExample(payBossExample);
        payBoss.setAppId(payBoss.getAppId());
        payBoss.setModifyTime(LocalDateTime.now());
        payBoss.setBossType(Authentication.LoginType.getState(payBoss.getBossType()).getState());
        if (payBossList.size()==0){
            payBoss.setIsDeleted((byte) 0);
            payBoss.setCreateTime(LocalDateTime.now());
            secondBossSettingMapper.insertSelective(payBoss);
        } else {
            payBoss.setId(payBossList.get(0).getId());
            secondBossSettingMapper.updateByPrimaryKeySelective(payBoss);
        }


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("second-payment-center/src/main/resources/" + UPLOAD_PATH_PREFIX);
        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + payBoss.getBossId());
        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/payment/" + format + newName;
            logger.info("-----------【"+ filePath +"】-----------");
            payBoss.setApiclientCert(UPLOAD_PATH_PREFIX+payBoss.getBossId()+"/"+newName);
            secondBossSettingMapper.updateByPrimaryKeySelective(payBoss);
            return filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }
}
