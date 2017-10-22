package com.grocery.configuration;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * Created by Jason on 22/10/2017.
 */

public class UEditorConfig {

    public static String readUEditorConfig() {

        String ueditorConfig = null;

        System.out.println();

        try {
            FileReader fileReader = new FileReader(ResourceUtils.getFile("classpath:config/UEditorConfigDetail.json"));

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String temp = null;

            while((temp = bufferedReader.readLine()) != "") {
                ueditorConfig = ueditorConfig + temp + "\r";
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ueditorConfig;
    }

}
