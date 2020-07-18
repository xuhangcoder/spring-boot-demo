package com.xuhang.springbootdemo.controller;

import com.xuhang.springbootdemo.send_msg.SendEmailUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhang
 * @date 2019/7/10 10:22
 */
@RestController
public class EmailController {

    @PostMapping("sendEmail")
    public void  sendEmail(@RequestParam("title") String title,
                           @RequestParam("content") String content,
                           @RequestParam("distName") String distName,
                           @RequestParam("sourceName") String sourceName){
            SendEmailUtil.sendEmail(title, content, distName, sourceName);
    }
}
