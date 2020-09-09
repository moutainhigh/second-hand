package com.example.user.center.controller;

import com.example.user.center.dao.SecondCityMapper;
import com.example.user.center.dao.SecondCollegesMapper;
import com.example.user.center.model.SecondCity;
import com.example.user.center.model.SecondColleges;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @author shihao
 * @Title: CityController
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@RestController
public class CityController {
    @Autowired
    SecondCityMapper secondCityMapper;
    @Autowired
    SecondCollegesMapper secondCollegesMapper;
    Map<String,Integer> cityMap = new HashMap();
    List<SecondColleges> colleges = new ArrayList<>();
    @RequestMapping(value = "/getCity")
    public Map<String,Integer> getProduct() throws IOException {
        Document doc = Jsoup.connect("https://gaokao.chsi.com.cn/sch/search.do").get();

        cityMap = cityInfo(doc,cityMap);
        System.out.println(cityMap);
        citySave(cityMap);
        return cityMap;
    }
//    public static void main(String[] args) throws IOException {
//        Document doc = Jsoup.connect("https://gaokao.chsi.com.cn/sch/search.do").get();
////        System.out.println(doc);
////取出所有的城市，并编号
//        Map<String,Integer> cityMap = new HashMap();
//        cityMap = cityInfo(doc,cityMap);
//        System.out.println(cityMap);
////保存城市信息
//        citySave(cityMap);
//    }

    /**
     * 爬取城市信息
     * @param doc
     * @param cityMap
     * @return
     */
    public static Map<String,Integer> cityInfo(Document doc, Map<String, Integer> cityMap){
        //获取城市列表元素
        Elements cityList = doc.getElementsByClass("ch-select ch-hide").get(0).children();
        //跳过第一行
        boolean isFirst = true;
        for(Node city : cityList){
            if(isFirst){
                isFirst = false;
                continue;
            }
            Integer cityNum = ((Element) city).attr("value")==null? 10000 : Integer.parseInt(((Element) city).attr("value"));
            String cityName = city.childNodes().get(0).outerHtml();
            //组装map
            cityMap.put(cityName.trim(),cityNum);
        }
        return cityMap;
    }
    /**
     * 保存城市信息
     * @param cityMap
     */
    private void citySave(Map<String, Integer> cityMap) {
        //map迭代器
        Iterator<Map.Entry<String, Integer>> entries = cityMap.entrySet().iterator();
        //存库列表
        List<SecondCity> citys = new ArrayList<>();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            SecondCity secondCity = new SecondCity();
            secondCity.setCityId(entry.getValue());
            secondCity.setName(entry.getKey());
            citys.add(secondCity);
        }
        System.out.println(citys);
        citys.forEach(city->{
            secondCityMapper.insertSelective(city);
        });

        //先删除所有
//        cityRepository.deleteAll();
        //存库
//        cityRepository.saveAll(citys);
    }

    @RequestMapping(value = "/getColleges")
    public String getColleges() throws IOException, InterruptedException {
        Integer start = 0;
        cityMap = getProduct();
        while (true) {
            String paramUrl = "https://gaokao.chsi.com.cn/sch/search.do" + "?start=" + start;
            Document docs = Jsoup.connect(paramUrl).get();
            Elements collegeList = docs.getElementsByClass("ch-table");
            //拿到需要表格的页面元素集合
            String html = collegeList.get(0).children().get(0).children().get(1).children().get(0).childNodes().get(0).outerHtml();
            if ("很抱歉，没有找到您要搜索的数据！".equals(html)) {
                break;
            } else {
                Elements collegeElements = collegeList.get(0).children().get(0).children();
                colleges = new CityController().collegeInfo(collegeElements, colleges, cityMap);
            }
            start += 20;
            //休眠一秒
            Thread.sleep(1000);
        }
        colleges.forEach(c->{
            secondCollegesMapper.insertSelective(c);
        });
        return "0";
    }
    public List<SecondColleges> collegeInfo(Elements collegeElements, List<SecondColleges> collegList, Map<String,Integer> cityMap){
        //遍历表格每一行
        boolean isFirst = true;
        for(Element element : collegeElements){
            //跳过表格第一行
            if(isFirst){
                isFirst = false;
                continue;
            }
            //从第二行开始遍历
            Elements elements = element.getAllElements();
            //记列数
            int column = 0;
            //遍历每一列
            SecondColleges college = new SecondColleges();
            for(Element elem : elements){
                if(null == elem.children() || elem.children().size() ==0){
                    //1.学校名
                    if(column == 0){
                        college.setName(elem.childNodes().get(0).outerHtml().trim());
                    }else if(column == 1){
                        college.setCityId(cityMap.get(elem.childNodes().get(0).outerHtml().trim()));
                    }else if(column == 4){//本科
                        college.setRecord(elem.childNodes().get(0).outerHtml());
                    }else if(column == 5){//985|211
                        if(elem.childNodes().size() != 0){
                            college.setFeatures(elem.childNodes().get(0).outerHtml());
                        }
                    }else if(column == 6){//|211
                        if(StringUtils.isBlank(college.getFeatures())){
                            college.setFeatures(elem.childNodes().get(0).outerHtml());
                        }else {
                            college.setFeatures(college.getFeatures() +"|"+elem.childNodes().get(0).outerHtml());
                        }
                    }else if(column == 7){//是否是研究生院校
                        if(elem.tag().getName().contains("i")){
                            college.setInstitute(true);
                        }else {
                            college.setInstitute(false);
                        }
                    }
                    column ++;
                }
            }
            //保存高校列表
            collegList.add(college);
            System.out.println(college);
//            log.info(college.toString());
        }
        return collegList;
    }
}
