package com.xuhang.springbootdemo.test;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.security.PdfEncryptionKeySize;
import com.spire.pdf.security.PdfPermissionsFlags;

/**
 * @author xuhang
 * @date 2021/5/17 15:03
 */
public class EncryptPDF {

    public static void main(String[] args) throws Exception {
        //创建PdfDocument实例
        PdfDocument doc = new PdfDocument();
        //加载带密码保护的PDF文件
        doc.loadFromFile("C:\\Users\\xu.hang\\Desktop\\文件\\新建文件夹\\123.pdf", "open");

        //解除文档中的密码保护
        doc.getSecurity().encrypt("", "", PdfPermissionsFlags.getDefaultPermissions(), PdfEncryptionKeySize.Key_256_Bit, "edit");

        //保存文件
        doc.saveToFile("C:\\Users\\xu.hang\\Desktop\\文件\\新建文件夹\\456.pdf");
        doc.close();
    }
    }

