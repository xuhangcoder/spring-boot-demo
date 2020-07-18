package com.xuhang.springbootdemo.test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author xuhang
 * @date 2019/10/17 15:27
 */
public class TestFile {

    public static void main(String[] args) throws Exception {

        File  file = new File("D:\\F_SERVICE_LOG_20191017_20191017000001.csv");


        FileOutputStream stream = new FileOutputStream(file);
        ZipOutputStream zos = new ZipOutputStream(stream);

        zos.putNextEntry(new ZipEntry(file.getName()));
        InputStream in = new FileInputStream(file);
        byte[] buf = new byte[10240];
        int len = 0;
        while((len=in.read(buf))!=-1){
            zos.write(buf,0,len);
            zos.flush();
        }

        zos.closeEntry();
        in.close();
        zos.close();
    }

}
