package com.mytry.code;

/**
 * @Classname HelloWorldService
 * @Description TODO
 * @Date 2020/12/4 8:00
 * @Created by 2413776263@qq.com
 */
public class HelloWorldService {
    private String text;
    private OutPutService outPutService;
    public void helloWorld(){
        System.out.println(text);
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public OutPutService getOutPutService() {
        return outPutService;
    }
    public void setOutPutService(OutPutService outPutService) {
        this.outPutService = outPutService;
    }
}
