package com.revivable.hydrogen.controller;

import com.revivable.hydrogen.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendSimpleMail")
    public Map<String,Boolean> sendSimpleMail(@RequestParam("toUser") String toUser,
                                              @RequestParam("subject") String subject,
                                              @RequestParam("content") String content){
        boolean reVal = this.mailService.sendSimpleMail(toUser,subject,content);
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        map.put("status",reVal);

        return map;
    }

    @PostMapping("/sendHtmlMail")
    public Map<String,Boolean> sendHtmlMail(@RequestParam("toUser") String toUser,
                                            @RequestParam("subject") String subject,
                                            @RequestParam("content") String content){
        boolean reVal = this.mailService.sendHtmlMail(toUser,subject,content);
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        map.put("status",reVal);

        return map;
    }

    @PostMapping("/sendFileMail")
    public Map<String,Boolean> sendFileMail(@RequestParam("toUser") String toUser,
                                            @RequestParam("subject") String subject,
                                            @RequestParam("content") String content){
        String path = "D:\\one.jpg";
        boolean reVal = this.mailService.sendFilesMail(toUser,subject,content,path);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        map.put("status",reVal);
        return map;
    }

    @PostMapping("/sendInlineMail")
    public Map<String,Boolean> sendInlineMail(@RequestParam("toUser") String toUser,
                                              @RequestParam("subject") String subject,
                                              @RequestParam("content") String content){
        String rscId = "pic1";
        String rscPath = "D:\\testPic.jpg";
        content = "<html><body>图片:<img src=\'cid:" + rscId
                + "\'></img>" + "这儿是你传入的内容：" + content
                + "</body></html>";
        boolean reVal = this.mailService.sendInlineMail(toUser,subject,content,rscId,rscPath);
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        map.put("status",reVal);
        return map;
    }

    @PostMapping("/sendTemplateMail")
    public Map<String,Boolean> sendTemplateMail(@RequestParam("toUser") String toUser,
                                                @RequestParam("subject") String subject,
                                                @RequestParam("content") String content){
        boolean reVal = this.mailService.sendTemplateMail(toUser,subject,content);
        Map<String,Boolean> map = new HashMap<String, Boolean>();
        map.put("status",reVal);
        return map;
    }
}
