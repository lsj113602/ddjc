package com.ddjc.controller;

import com.ddjc.utils.FileUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * author: LongDuping
 * date  : 2017-07-09 11:06
 * email : 610215675@qq.com
 * --------------------------------------------------
 * function: 获取上传的静态文件
 */
@Controller
public class StaticController {

    @RequestMapping(value = "/uploads/{fileName}.{ext}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> uploads(@PathVariable("fileName") String fileName,
                                          @PathVariable("ext") String ext) throws IOException {
        String ym = DateFormatUtils.format(Calendar.getInstance().getTime(), "yyyyMM");
        String path = "D:\\uploads";
        path += "\\" + ym + "_" + fileName + "." + ext;
        File file = new File(path);
        if (!file.exists()) {
            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
        }
        byte[] bytes = FileUtil.toByteArray(file);
        HttpHeaders headers = new HttpHeaders();
        if ("png".equals(ext.toLowerCase())) {
            headers.setContentType(MediaType.IMAGE_PNG);
        } else if ("jpg".equals(ext.toLowerCase()) || "jpeg".equals(ext.toLowerCase())) {
            headers.setContentType(MediaType.IMAGE_JPEG);
        }
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }
}
