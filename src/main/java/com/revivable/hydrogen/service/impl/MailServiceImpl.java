package com.revivable.hydrogen.service.impl;

import com.revivable.hydrogen.dao.MailDao;
import com.revivable.hydrogen.entity.MailMessage;
import com.revivable.hydrogen.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    @Value("${spring.mail.username}")
    private String fromUser;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailDao mailDao;

    @Resource
    TemplateEngine templateEngine;

    @Override
    public boolean sendSimpleMail(String toUser, String subject, String content) {
        MailMessage mailMessage = new MailMessage(fromUser,toUser,subject,content);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toUser);
        message.setFrom(fromUser);
        message.setSubject(subject);
        message.setText(content);
        try{
            mailDao.insert(mailMessage);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendHtmlMail(String toUser, String subject, String content) {
        MailMessage mailMessage = new MailMessage(fromUser,toUser,subject,content);

        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            helper.setTo(toUser);
            helper.setFrom(fromUser);
            helper.setSubject(subject);
            helper.setText(content,true);

            mailDao.insert(mailMessage);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendFilesMail(String toUser, String subject, String content, String filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MailMessage mailMessage = new MailMessage(fromUser,toUser,subject,content);
        System.out.println("filepath:"+filePath);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            helper.setTo(toUser);
            helper.setFrom(fromUser);
            helper.setSubject(subject);
            helper.setText(content, true);
            helper.addAttachment(fileName, file);

            mailDao.insert(mailMessage);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendInlineMail(String toUser,String subject,
                                  String content,String rscId,String rscPath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MailMessage mailMessage = new MailMessage(fromUser,toUser,subject,content);

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message,true);

            helper.setFrom(fromUser);
            helper.setTo(toUser);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId,res);

            mailDao.insert(mailMessage);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean sendTemplateMail(String toUser, String subject, String content) {
        Context context = new Context();
        context.setVariable("id","17763");

        String emailContent = templateEngine.process("emailTemplate",context);
        boolean reVal = this.sendHtmlMail(toUser,subject,emailContent);
        return reVal;
    }
}
