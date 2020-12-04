package com.mytry.code;

import org.junit.Assert;

/**
 * @Classname OutPutService
 * @Description TODO
 * @Date 2020/12/4 12:58
 * @Created by 2413776263@qq.com
 */
public class OutPutService {
    private HelloWorldService helloWorldService;
    public void output(String text){
        //TODO Assert用法
        Assert.assertNotNull(helloWorldService);
        System.out.println("text = " + text);
    }

    public HelloWorldService getHelloWorldService() {
        return helloWorldService;
    }
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
