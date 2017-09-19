package org.spring.springboot.utils;


import java.io.*;

/**
 * Created by Jony.lai on 2017/5/17.
 */
public class WriteJsonFile {
    public static void writeConfigJson(String args,String channelId,String fileSrc,String fileName) {
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

        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(args);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
