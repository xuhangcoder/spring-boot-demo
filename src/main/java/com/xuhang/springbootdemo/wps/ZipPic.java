package com.xuhang.springbootdemo.wps;


import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhang
 * @date 2021/7/19 17:24
 */
public class ZipPic {
    public static void main(String[] args) throws Exception {
        File f = new File("F:\\xuhang");
        File[] tempList = f.listFiles();

        for (File file : tempList) {
            String path = file.getName();
            Thumbnails.of(file)
                    .scale(1f)
                    .outputQuality(0.3f)
                    .toOutputStream(new FileOutputStream("F:\\xuhang_bak\\"+path));
        }
        System.out.println("处理完成");
    }

}
