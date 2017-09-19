package org.spring.springboot.utils;

/**
 * Created by jony.lai on 2017/5/17.
 */
public class WriteScriptThread extends Thread{

    String channelId = "";//定义线程内channel变量
    String fileSrc = "";
    String fileName = "";
    public WriteScriptThread( String channelId,String fileSrc,String fileName){//定义带参数的构造函数,达到初始化线程内变量的值
        this.channelId = channelId;
        this.fileSrc = fileSrc;
        this.fileName = fileName;
    }
    @Override
    public void run() {
        WriteScriptFile.writeScriptFile(channelId,fileSrc,fileName);
    }
}
