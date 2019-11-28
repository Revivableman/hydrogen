package com.revivable.hydrogen.entity;

import com.baomidou.mybatisplus.annotation.TableId;

import javax.validation.constraints.NotNull;

public class MailMessage {
    @TableId
    private Integer id;
    @NotNull
    private String fromUser;
    @NotNull
    private String toUser;
    @NotNull
    private String subject;
    private String content;

    public MailMessage() {
    }

    public MailMessage(@NotNull String fromUser, @NotNull String toUser, @NotNull String subject, String content) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.subject = subject;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
