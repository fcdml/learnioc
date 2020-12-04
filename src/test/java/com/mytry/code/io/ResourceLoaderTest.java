package com.mytry.code.io;

import com.mytry.code.beans.io.Resource;
import com.mytry.code.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname ResourceLoaderTest
 * @Description TODO
 * @Date 2020/12/4 8:06
 * @Created by 2413776263@qq.com
 */
public class ResourceLoaderTest {
    @Test
    public  void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("learnioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
