package com.gamejoye.service;

import com.gamejoye.pojo.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureService {
    List<Picture> selectAllPictures();
    void addPicture(Picture picture);
}
