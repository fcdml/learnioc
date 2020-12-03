package com.mytry.code.beans.io;

import java.net.URL;

/**
 * @Classname ResourceLoader
 * @Description TODO
 * @Date 2020/12/3 23:39
 * @Created by 2413776263@qq.com
 */
public class ResourceLoader {
    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
