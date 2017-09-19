package org.spring.springboot.utils;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

/**
 * Created by Jony.lai on 2017/5/17.
 */
public class WriteScriptFile {

    private static Logger logger = (Logger) LoggerFactory.getLogger(WriteScriptFile.class);

    public static void writeScriptFile(String channelId,String fileSrc,String fileName){
        logger.info("write start");
        String src = fileSrc + channelId + fileName;
        File file = new File(src);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * 读出js文件
         */

        String content="";//content保存文件内容，
        BufferedReader br=null;//定义BufferedReader
        Resource resource = new ClassPathResource("/script/behaviorListener.js");
        try{
             br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            //按行读取文件并加入到content中。
            //当readLine方法返回null时表示文件读取完毕。
            String line;
            while((line=br.readLine())!=null){
                content+=line+"\n";
                }
            }catch(IOException e){
            e.printStackTrace();
            }finally{
            //最后要在finally中将reader对象关闭
            if(br!=null){
                try{
                    br.close();
                    }catch(IOException e){
                    e.printStackTrace();
                    }}
        }

        try {
            FileWriter fw = new FileWriter(src, true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("write end");
    }
}
