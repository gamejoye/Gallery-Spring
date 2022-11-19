package com.gamejoye.constant;

public class URLConstants {
    private final static boolean IS_DEV = true;
    //"http://localhost:3000"
    //"http://112.74.55.177:3002"
    public final static String URL = IS_DEV ? "http://localhost:3000" : "http://112.74.55.177:3002";
    //"/users/gamejoye/images/gallery/"
    //"/usr/local/images/"
    public final static String localPath = IS_DEV ? "/users/gamejoye/images/gallery/" : "/usr/local/images/gallery/";
    //"http://localhost:8082/image-lib/"
    //"http://112.74.55.177/files/blogs/images/"
    public final static String URL_PATH = IS_DEV ? "http://localhost:8082/image-lib/" :
            "http://112.74.55.177/Blog/files/blogs/images/";
}
