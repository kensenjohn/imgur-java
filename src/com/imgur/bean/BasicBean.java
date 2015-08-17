package com.imgur.bean;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasicBean {

    private DataBean data = new DataBean();
    private String status = "";
    private boolean isSuccess = false;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
