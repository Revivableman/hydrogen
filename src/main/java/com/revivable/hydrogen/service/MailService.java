package com.revivable.hydrogen.service;

public interface MailService {

    boolean sendSimpleMail(String toUser,String subject,String content);

    boolean sendHtmlMail(String toUser,String subject,String content);

    boolean sendFilesMail(String toUser,String subject,String content,String filePath);

    boolean sendInlineMail(String toUser,String subject,String content,String rscId,String rscPath);

    boolean sendTemplateMail(String toUser,String subject,String content);
}
