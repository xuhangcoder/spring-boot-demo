package com.xuhang.springbootdemo.wps;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author xuhang
 * @date 2021/7/19 18:39
 */
public class MergePic {
    /**
     *
     * @Title: modifyImagetogeter
     * @Description: 将几张图片合成一张图片
     * @param: @param b1
     * @param: @param b2
     * @param: @param b3
     * @param: @return
     * @return: BufferedImage
     * @throws
     * @author:石德斌
     * @date:2020年4月21日 下午3:26:41
     */
    public static BufferedImage modifyImagetogeter(BufferedImage[] image) {
        //创建一个304*304的图片
        BufferedImage tag = new BufferedImage(3330,2500,BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D graphics = tag.createGraphics();
            //设置颜色为218，223，224
            graphics.setColor(new Color(218,223,224));
            //填充颜色
            graphics.fillRect(0, 0, 304, 304);
            int count = image.length;
            //根据不同的合成图片数量设置图片放置位置
            if(count == 1){
                int startX = 108;
                int startY = 108;
                BufferedImage b = image[0];
                graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
            }else if(count == 2){
                int startX = 60;
                int startY = 108;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
            }else if(count == 3){
                int startX = 108;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = 60;
                startY = 60 + b1.getHeight() + 8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                BufferedImage b3 = image[2];
                startX = startX + b2.getWidth()+8;
                graphics.drawImage(b3, startX, startY, b3.getWidth(), b3.getHeight(), null);
            }else if(count == 4){
                int startX = 60;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = 60 + b1.getWidth() + 8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                BufferedImage b3 = image[2];
                startX = 60;
                startY = 60 + b2.getHeight() + 8;
                graphics.drawImage(b3, startX, startY, b3.getWidth(), b3.getHeight(), null);
                BufferedImage b4 = image[3];
                startX = 60 + b3.getWidth() + 8;
                graphics.drawImage(b4, startX, startY, b4.getWidth(), b4.getHeight(), null);
            }else if(count == 5){
                int startX = 60;
                int startY = 60;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                startX = 12;
                startY = 12 + startY + b2.getHeight();
                for(int i = 2;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                }
            }else if(count == 6){
                int startX = 10;
                int startY = 10;
                for(int i = 0;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if((i+1)%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 10;
                    }
                }
            }else if(count == 7){
                int startX = 108;
                int startY = 12;
                BufferedImage b = image[0];
                graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                startX = 12;
                startY = startY + 8 + b.getHeight();
                for(int i = 1;i<count;i++){
                    b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if(i%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }else if(count == 8){
                int startX = 60;
                int startY = 12;
                BufferedImage b1 = image[0];
                graphics.drawImage(b1, startX, startY, b1.getWidth(), b1.getHeight(), null);
                BufferedImage b2 = image[1];
                startX = startX + b1.getWidth()+8;
                graphics.drawImage(b2, startX, startY, b2.getWidth(), b2.getHeight(), null);
                startX = 12;
                startY = 12 + b2.getHeight() + 8;
                for(int i = 2;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if(i == 4){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }else if(count == 9){
                int startX = 12;
                int startY = 12;
                for(int i = 0;i<count;i++){
                    BufferedImage b = image[i];
                    graphics.drawImage(b, startX, startY, b.getWidth(), b.getHeight(), null);
                    startX = startX + b.getWidth() + 8;
                    if((i+1)%3 == 0){
                        startY = startY + b.getHeight() + 8;
                        startX = 12;
                    }
                }
            }
            graphics.dispose();
        } catch (Exception e) {
            System.out.println("推送同比压缩图片出错"+e);
        }

        return tag;
    }

    public static BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
//        	return ImageIO.read(new URL(imgName));
        } catch (IOException e) {
            System.out.println("推送同比压缩图片出错"+e);
        }
        return null;
    }

    public static void writeImageLocal(String newImage, BufferedImage img) {
        if (newImage != null && img != null) {
            try {
                File outputfile = new File(newImage);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println("推送同比压缩图片出错"+e);
            }
        }
    }

    /**
     *
     * @Title: handleLarge
     * @Description: 同比例压缩图片，使图片形成相同大小
     * @param: @param image
     * @param: @return
     * @return: BufferedImage[]
     * @throws
     * @author:石德斌
     * @date:2020年4月23日 上午10:36:11
     */
    private static BufferedImage[] handleLarge(Integer width,Integer height,BufferedImage[] image) {
        BufferedImage[] b = new BufferedImage[image.length];
        for (int i = 0; i < image.length; i++) {
            BufferedImage sourceImage = image[i];
            try {
                b[i] = zoom2(width, height, sourceImage);
            } catch (Exception e) {
                System.out.println("推送同比压缩图片出错"+e);
            }
        }
        return b;
    }

    public static void main(String[] args) {
//		BufferedImage b1 = loadImageLocal("C:\\Users\\Admin\\Documents\\WeChat Files\\a010662716\\FileStorage\\File\\2020-04\\头像\\");
        try {
            //用于合成的图片数量
            int count = 6;
            BufferedImage[] image =new BufferedImage[count];
            for(int i =0;i<count;i++){
                image[i]=loadImageLocal("F:\\9gongge\\"+(i+1)+".JPG");
            }
            writeImageLocal("F:\\9gongge_bak"+count+".JPG", modifyImagetogeter(handleLarge(1100,1250,image)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage zoom2(int width,int height,BufferedImage sourceImage) throws Exception {

        if( sourceImage == null ){
            return sourceImage;
        }
        // 计算x轴y轴缩放比例--如需等比例缩放，在调用之前确保參数width和height是等比例变化的
        double ratiox  = (new Integer(width)).doubleValue()/ sourceImage.getWidth();
        double ratioy  = (new Integer(height)).doubleValue()/ sourceImage.getHeight();
        AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratiox, ratioy), null);
        BufferedImage bufImg = op.filter(sourceImage, null);
        return bufImg;
    }
}
