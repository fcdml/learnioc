package com.mytry.code.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname Resource
 * @Description TODO spring内部定位资源的接口
 * @Date 2020/12/3 23:31
 * @Created by 2413776263@qq.com
 */
public interface Resource {
    InputStream getInputStream() throws IOException;

}
