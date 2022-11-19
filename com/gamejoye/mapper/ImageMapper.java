package com.gamejoye.mapper;

import com.gamejoye.pojo.Picture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ImageMapper {
    List<Picture> selectAllPicture();
    void addPicture(Picture picture);
}
