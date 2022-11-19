package com.gamejoye.controller;

import com.alibaba.fastjson.JSON;
import com.gamejoye.constant.URLConstants;
import com.gamejoye.pojo.Picture;
import com.gamejoye.service.PictureService;
import com.gamejoye.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.gamejoye.constant.URLConstants.localPath;

@RequestMapping(value = "images")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true",maxAge = 3600)
@Controller
public class Image {
    static final String URL_Path = URLConstants.URL_PATH;
    @Autowired
    PictureService pictureService;
    @RequestMapping(value = "/acquisition")
    @ResponseBody
    public String getImagesPojo() {
        List<Picture> pictures = pictureService.selectAllPictures();
        return JSON.toJSONString(pictures);
    }

    @RequestMapping(value = "updation")
    @ResponseBody
    public void updateImages() {

    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(MultipartHttpServletRequest request) {
        List<Picture> pictures = new ArrayList<>();
        Map<String, MultipartFile> multiFileMap = request.getFileMap();
        multiFileMap.forEach((key, file) -> {
            String uuid = UUID.randomUUID().toString();
            String[] splits = file.getOriginalFilename().split("\\.");
            String newName = uuid + "." + splits[splits.length-1];
            FileUtils.upload(file, localPath, newName.toString());
            Picture picture = new Picture(URL_Path+newName,"", "");
            pictures.add(picture);
            pictureService.addPicture(picture);
        });
        return JSON.toJSONString(pictures);
    }
}
