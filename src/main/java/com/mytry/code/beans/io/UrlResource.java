package com.mytry.code.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Classname UrlResource
 * @Description TODO
 * @Date 2020/12/3 23:33
 * @Created by 2413776263@qq.com
 */
public class UrlResource implements Resource {
    private final URL url;
    //FIXME 可以不写无参构造  ？？？
    public UrlResource(URL url) {
        this.url = url;
    }
    @Override
    public InputStream getInputStream() throws IOException {
       //FIXME 用处？？？
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
