package com.tedu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取sys的配置文件
 * 目的：实现读取文件上传的路径协议
 */
public class PropUtil {

    public static String read(String key){
        Properties properties = new Properties();
        InputStream in =  PropUtil.class.getClassLoader().getResourceAsStream("sys.properties");
        String value = null;
        try {
            properties.load(in);
            value = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
