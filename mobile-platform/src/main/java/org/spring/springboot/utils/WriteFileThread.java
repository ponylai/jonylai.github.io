package org.spring.springboot.utils;

/**
 * Created by jony.lai on 2017/5/17.
 */
public class WriteFileThread extends Thread{

    String StingJson = "";//定义线程内json变量
    String channelId = "";//定义线程内channel变量
    String fileSrc = "";
    String fileName = "";
    public WriteFileThread(String StingJson,String channelId,String fileSrc,String fileName){//定义带参数的构造函数,达到初始化线程内变量的值
        this.StingJson = StingJson;
        this.channelId = channelId;
        this.fileSrc = fileSrc;
        this.fileName = fileName;
    }
    @Override
    public void run() {
        WriteJsonFile.writeConfigJson(StingJson,channelId,fileSrc,fileName);
    }
}
