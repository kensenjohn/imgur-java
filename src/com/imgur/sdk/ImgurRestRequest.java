package com.imgur.sdk;

import com.imgur.common.Utility;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/9/14
 * Time: 6:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImgurRestRequest {
    private String acceptToken = "";
    private String clientId = "";
    private String username = "";
    private String endpoint = "";

    public String getAcceptToken() {
        return acceptToken;
    }

    public void setAcceptToken(String acceptToken) {
        this.acceptToken = acceptToken;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public boolean isAcceptTokenPresent(){
        return !Utility.isNullOrEmpty(acceptToken);
    }

    public boolean isClientIdPresent() {
        return !Utility.isNullOrEmpty(clientId);
    }
}
