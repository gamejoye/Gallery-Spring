package com.gamejoye.controller;

import com.gamejoye.constant.URLConstants;
import com.gamejoye.utils.FileUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RequestMapping("image-lib")
@Controller
public class ImageLib {
    static final String localPath = URLConstants.localPath;
    @RequestMapping(value = "/{id}.{type}")
    @ResponseBody
    public ResponseEntity<byte[]> getImg(@PathVariable String id, @PathVariable String type, HttpServletRequest request) throws Exception {
        String eTag = request.getHeader("If-None-Match");
        String curTag = "W/\""+id+"\"";
        if(eTag != null && eTag.equals(curTag)) {
            return new ResponseEntity<byte[]>(new HttpHeaders(), HttpStatus.NOT_MODIFIED);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        File file = new File(localPath+id+"."+type);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = fileInputStream.readAllBytes();
        headers.setContentLength(bytes.length);
        headers.setETag(curTag);
        headers.setLastModified(new Date().getTime());
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
    }

}
