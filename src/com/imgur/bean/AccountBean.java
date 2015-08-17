package com.imgur.bean;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountBean{
    public AccountBean(){
    }

    public AccountBean(HashMap<String,Object> hmData){
        if(hmData!=null){
            Object objId =  hmData.get("id");
            if( objId!=null ){
                this.id = new Integer((Integer)objId).toString();
            }

            Object objUrl =  hmData.get("url");
            if( objUrl!=null ){
                this.url = (String)objUrl;
            }

            Object objBio =  hmData.get("bio");
            if( objBio!=null ){
                this.bio = (String)objBio;
            }

            Object objReputation =  hmData.get("reputation");
            if( objReputation!=null ){
                this.reputation = new Integer((Integer)objReputation).toString();
            }

            Object objCreated =  hmData.get("created");
            if( objCreated!=null ){
                this.created = new Long((Integer)objCreated);
            }

            Object objProExpiration =  hmData.get("pro_expiration");
            if( objProExpiration!=null ){
                try{
                    this.isPro = (Boolean)objProExpiration;
                } catch (Exception e) {
                    this.isPro = true;
                }

            }

            if(this.isPro && objProExpiration!=null){
                this.proExpirationDate = (Long)objProExpiration;
            }
        }
    }
    private String id = "";
    private String url = "";
    private String bio = "";
    private String reputation = "";
    private Long created = 0L;
    private boolean isPro = false;
    private Long proExpirationDate = 0L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setPro(boolean pro) {
        isPro = pro;
    }

    public Long getProExpirationDate() {
        return proExpirationDate;
    }

    public void setProExpirationDate(Long proExpirationDate) {
        this.proExpirationDate = proExpirationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountBean{");
        sb.append("id='").append(id).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", bio='").append(bio).append('\'');
        sb.append(", reputation='").append(reputation).append('\'');
        sb.append(", created=").append(created);
        sb.append(", isPro=").append(isPro);
        sb.append(", proExpirationDate=").append(proExpirationDate);
        sb.append('}');
        return sb.toString();
    }
}
