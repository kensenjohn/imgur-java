package com.imgur.bean;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class NotificationBean {

    /*id	integer	The ID for the notification
    account_id	integer	The Account ID for the notification
    viewed	boolean	Has the user viewed the image yet?
    content	Mixed	This can be any other model, currently only using comments and conversation metadata.*/
    public NotificationBean() {
    }

    public NotificationBean( HashMap<String,Object> hmData ){
        if(hmData!=null && !hmData.isEmpty() ){
            Object objId =  hmData.get("id");
            if( objId!=null ){
                if(objId instanceof Integer){
                    this.id =  ( (Integer) objId ).toString();
                } else {
                    this.id = (String) objId;
                }
            }

            Object objAccountId =  hmData.get("id");
            if( objAccountId!=null ){
                if(objAccountId instanceof Integer){
                    this.accountId =  ( (Integer) objAccountId ).toString();
                } else {
                    this.accountId = (String) objAccountId;
                }
            }

            Object objViewed = hmData.get("deleted");
            if (objViewed != null) {
                this.isViewed = (Boolean) objViewed;
            }
        }
    }
    private String id = "";
    private String accountId = "";
    private boolean isViewed = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean isViewed() {
        return isViewed;
    }

    public void setViewed(boolean viewed) {
        isViewed = viewed;
    }
}
