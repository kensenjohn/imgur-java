package com.imgur.bean;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class BlockedUsersBean {

    /*
    "blocked_id" : 384077,
            "blocked_url": "joshTest"
     */

    private String blockedId = "";
    private String blockedURL = "";

    public String getBlockedId() {
        return blockedId;
    }

    public void setBlockedId(String blockedId) {
        this.blockedId = blockedId;
    }

    public String getBlockedURL() {
        return blockedURL;
    }

    public void setBlockedURL(String blockedURL) {
        this.blockedURL = blockedURL;
    }
}
