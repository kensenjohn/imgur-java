package com.imgur.bean;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 8:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConversationsBean {

    private String id = "";
    private String lastMessagePreview = "";
    private Long dateTime = 0L;
    private String withAccountId = "";
    private String withAccount = "";
    private Integer messageCount = 0;
    private ArrayList<MessageBean> arrMessageBean = new ArrayList<MessageBean>();
    private boolean isDone = false;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastMessagePreview() {
        return lastMessagePreview;
    }

    public void setLastMessagePreview(String lastMessagePreview) {
        this.lastMessagePreview = lastMessagePreview;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getWithAccountId() {
        return withAccountId;
    }

    public void setWithAccountId(String withAccountId) {
        this.withAccountId = withAccountId;
    }

    public String getWithAccount() {
        return withAccount;
    }

    public void setWithAccount(String withAccount) {
        this.withAccount = withAccount;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public ArrayList<MessageBean> getArrMessageBean() {
        return arrMessageBean;
    }

    public void setArrMessageBean(ArrayList<MessageBean> arrMessageBean) {
        this.arrMessageBean = arrMessageBean;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
