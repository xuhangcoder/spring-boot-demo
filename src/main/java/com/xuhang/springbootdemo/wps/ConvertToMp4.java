package com.xuhang.springbootdemo.wps;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Frame;

import java.io.File;

/**
 * @author xuhang
 * @date 2021/7/20 16:57
 */
public class ConvertToMp4 {



    public static String convert(File file) {
        FFmpegFrameGrabber frameGrabber = new FFmpegFrameGrabber(file);

        String fileName = null;

        Frame captured_frame = null;

        FFmpegFrameRecorder recorder = null;

        try {
            frameGrabber.start();

            fileName = file.getAbsolutePath() + "__.mp4";

            recorder = new FFmpegFrameRecorder(fileName, frameGrabber.getImageWidth(), frameGrabber.getImageHeight(), frameGrabber.getAudioChannels());

            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);

            recorder.setFormat("mp4");

            recorder.setFrameRate(frameGrabber.getFrameRate());

            recorder.setSampleRate(frameGrabber.getSampleRate());

            recorder.setAudioChannels(frameGrabber.getAudioChannels());

            recorder.setFrameRate(frameGrabber.getFrameRate());

            recorder.start();

            while ((captured_frame = frameGrabber.grabFrame()) != null) {
                try {
                    recorder.record(captured_frame);

                } catch (Exception e) {
                    System.out.println(e);

                }

            }

            recorder.stop();

            recorder.release();

            frameGrabber.stop();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return fileName;

    }

    public static void main(String[] args) {

        convert(new File("F:\\xuhang\\求婚快闪\\求婚快闪.webm"));
    }

}
