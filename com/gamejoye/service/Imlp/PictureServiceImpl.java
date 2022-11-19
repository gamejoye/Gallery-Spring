package com.gamejoye.service.Imlp;

import com.gamejoye.mapper.ImageMapper;
import com.gamejoye.pojo.Picture;
import com.gamejoye.service.PictureService;
import com.gamejoye.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "pictureService")
public class PictureServiceImpl implements PictureService {
    SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtil.sqlSessionFactoryGet();
    SqlSession sqlSession = sqlSessionFactory.openSession();
    ImageMapper imageMapper = sqlSession.getMapper(ImageMapper.class);
    @Override
    public List<Picture> selectAllPictures() {
        List<Picture> pictures = imageMapper.selectAllPicture();
        return pictures;
    }

    @Override
    public void addPicture(Picture picture) {
        imageMapper.addPicture(picture);
        sqlSession.commit();
    }
}
