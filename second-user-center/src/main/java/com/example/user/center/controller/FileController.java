package com.example.user.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.user.center.dao.SecondFileMapper;
import com.example.user.center.model.SecondFile;
import com.second.common.service.FileMangeService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shihao
 * @Title: FileController
 * @ProjectName Second-order-center
 * @Description:
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/File")
@CrossOrigin
public class FileController {
    @Autowired
    private SecondFileMapper secondFileMapper;

    private static final String LOCK = "LOCK";

    /**图片上传
     *
     * @param file 图片
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "上传图片", notes = "上传图片")
    @RequestMapping(value = "/fileUpLoad", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> fileUpLoad(MultipartFile file) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String arr[];
        FileMangeService fileMangeService = new FileMangeService();
        arr = fileMangeService.uploadFile(file.getBytes(), String.valueOf("-1"));
        SecondFile fileDesc = new SecondFile();
        fileDesc.setFileName(file.getName());
        fileDesc.setGroupName(arr[0]);
        fileDesc.setRemoteFilename(arr[1]);
        fileDesc.setUserId(-1);
        fileDesc.setCreateTime(LocalDateTime.now());
        fileDesc.setModifyTime(LocalDateTime.now());
        fileDesc.setIsDeleted((short) 0);
        secondFileMapper.insert(fileDesc);
//        InetAddress ip = null;
//        ip=ip.getLocalHost();
//        String localname=ip.getHostName();
//        String localip=ip.getHostAddress();
        String s = "https://www.tjsichuang.cn:1443/second/user/File/getPicture?id=";
//        String s = "http://39.100.237.144:7004/user/File/getPicture?id=";
        return builder.body(ResponseUtils.getResponseBody(s+String.valueOf(fileDesc.getId())));
    }
    //压缩过
    @ApiOperation(value = "获取图片", notes = "获取图片")
    @RequestMapping(value = "/getPicture", method = RequestMethod.GET)
    public void getPicture(Integer id, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        SecondFile fileDesc = secondFileMapper.selectByPrimaryKey(id);
        if (fileDesc == null) {
            throw new Exception("file not exists");
        }
        FileMangeService fileManageService = new FileMangeService();
        synchronized (LOCK) {
            byte[] file = fileManageService.downloadFile(fileDesc.getGroupName(), fileDesc.getRemoteFilename());
            InputStream sbs = new ByteArrayInputStream(file);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
//            Thumbnails.of(sbs).scale(1f).outputFormat("jpg").outputQuality(0.1).toOutputStream(os);
            file = os.toByteArray();
            ByteArrayInputStream stream = new ByteArrayInputStream(file);
            BufferedImage readImg = ImageIO.read(stream);
            stream.reset();
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(readImg, "png", outputStream);
            outputStream.close();
        }
    }

    @ApiOperation(value = "删除图片", notes = "删除")
    @RequestMapping(value = "/fileDelete", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> filedelete(Integer fileId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        SecondFile fileDesc = secondFileMapper.selectByPrimaryKey(fileId);
        FileMangeService fileManageService = new FileMangeService();
        if (fileDesc != null) {
            fileManageService.deleteFile(fileDesc.getGroupName(), fileDesc.getRemoteFilename());
        }
        secondFileMapper.deleteByPrimaryKey(fileId);
        return builder.body(ResponseUtils.getResponseBody(fileId));
    }

    @ApiOperation(value = "删除图片2", notes = "删除")
    @RequestMapping(value = "/fileDelete2", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> fileDelete2(String file) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String str1=file.substring(0, file.indexOf("="));
        String str2=file.substring(str1.length()+1, file.length());

        SecondFile fileDesc = secondFileMapper.selectByPrimaryKey(Integer.valueOf(str2));
        FileMangeService fileManageService = new FileMangeService();
        if (fileDesc != null) {
            fileManageService.deleteFile(fileDesc.getGroupName(), fileDesc.getRemoteFilename());
        }
        secondFileMapper.deleteByPrimaryKey(Integer.valueOf(str2));
        return builder.body(ResponseUtils.getResponseBody(Integer.valueOf(str2)));
    }
    public static String getV4IP() {
        String ip = "";
        String chinaz = "http://ip.chinaz.com";

        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            while ((read = in.readLine()) != null) {
                inputLine.append(read + "\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if (m.find()) {
            ip = m.group(1);
        }
        return ip;
    }


    public static void main(String[] args) {
         System.out.println(getV4IP());
    }
}
