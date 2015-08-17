package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class AccountSettingsBean {
    public AccountSettingsBean(){
    }

    public AccountSettingsBean(HashMap<String,Object> hmData){
        if(hmData!=null){
            Object objEmail =  hmData.get("email");
            if( objEmail!=null ){
                this.email = (String)objEmail;
            }

            Object objIsHighQualityAllowed =  hmData.get("high_quality");
            if( objIsHighQualityAllowed!=null ){
                    this.isHighQualityAllowed = (Boolean)objIsHighQualityAllowed;

            }

            Object objIsPublicImagesAllowed =  hmData.get("public_images");
            if( objIsPublicImagesAllowed!=null ){
                this.isPublicImagesAutomaticallyAllowed = (Boolean)objIsPublicImagesAllowed;

            }

            Object objAlbumPrivacy =  hmData.get("album_privacy");
            if( objAlbumPrivacy!=null ){
                this.albumCreationPrivacy = (String)objAlbumPrivacy;
            }

            Object objProExpiration =  hmData.get("pro_expiration");
            if( objProExpiration!=null ){
                try{
                    this.isProAccount = (Boolean)objProExpiration;
                } catch (Exception e) {
                    this.isProAccount = true;
                }

            }

            if(this.isProAccount && objProExpiration!=null){
                this.proExpirationDate = (Long)objProExpiration;
            }

            Object objIsGalleryTermsAccepted =  hmData.get("accepted_gallery_terms");
            if( objIsGalleryTermsAccepted!=null ){
                this.isGalleryTermsAccepted = (Boolean)objIsGalleryTermsAccepted;

            }

            Object objIsIncomingMessageEnabled =  hmData.get("messaging_enabled");
            if( objIsIncomingMessageEnabled!=null ){
                this.isIncomingMessageEnabled = (Boolean)objIsIncomingMessageEnabled;

            }
        }
    }

    private String  email = "";
    private boolean  isHighQualityAllowed = false;
    private boolean  isPublicImagesAutomaticallyAllowed = false;
    private String  albumCreationPrivacy = "";
    private boolean  isProAccount = false;
    private Long proExpirationDate = 0L;
    private boolean  isGalleryTermsAccepted = false;
    private ArrayList<String> arrActiveEmails = new ArrayList<String>();
    private boolean  isIncomingMessageEnabled = false;
    private ArrayList<BlockedUsersBean> arrBlockedUsersBean = new ArrayList<BlockedUsersBean>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHighQualityAllowed() {
        return isHighQualityAllowed;
    }

    public void setHighQualityAllowed(boolean highQualityAllowed) {
        isHighQualityAllowed = highQualityAllowed;
    }

    public boolean isPublicImagesAutomaticallyAllowed() {
        return isPublicImagesAutomaticallyAllowed;
    }

    public void setPublicImagesAutomaticallyAllowed(boolean publicImagesAutomaticallyAllowed) {
        isPublicImagesAutomaticallyAllowed = publicImagesAutomaticallyAllowed;
    }

    public String getAlbumCreationPrivacy() {
        return albumCreationPrivacy;
    }

    public void setAlbumCreationPrivacy(String albumCreationPrivacy) {
        this.albumCreationPrivacy = albumCreationPrivacy;
    }

    public boolean isProAccount() {
        return isProAccount;
    }

    public void setProAccount(boolean proAccount) {
        isProAccount = proAccount;
    }

    public Long getProExpirationDate() {
        return proExpirationDate;
    }

    public void setProExpirationDate(Long proExpirationDate) {
        this.proExpirationDate = proExpirationDate;
    }

    public boolean isGalleryTermsAccepted() {
        return isGalleryTermsAccepted;
    }

    public void setGalleryTermsAccepted(boolean galleryTermsAccepted) {
        isGalleryTermsAccepted = galleryTermsAccepted;
    }

    public ArrayList<String> getArrActiveEmails() {
        return arrActiveEmails;
    }

    public void setArrActiveEmails(ArrayList<String> arrActiveEmails) {
        this.arrActiveEmails = arrActiveEmails;
    }

    public boolean isIncomingMessageEnabled() {
        return isIncomingMessageEnabled;
    }

    public void setIncomingMessageEnabled(boolean incomingMessageEnabled) {
        isIncomingMessageEnabled = incomingMessageEnabled;
    }

    public ArrayList<BlockedUsersBean> getArrBlockedUsersBean() {
        return arrBlockedUsersBean;
    }

    public void setArrBlockedUsersBean(ArrayList<BlockedUsersBean> arrBlockedUsersBean) {
        this.arrBlockedUsersBean = arrBlockedUsersBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountSettingsBean{");
        sb.append("email='").append(email).append('\'');
        sb.append(", isHighQualityAllowed=").append(isHighQualityAllowed);
        sb.append(", isPublicImagesAutomaticallyAllowed=").append(isPublicImagesAutomaticallyAllowed);
        sb.append(", albumCreationPrivacy='").append(albumCreationPrivacy).append('\'');
        sb.append(", isProAccount=").append(isProAccount);
        sb.append(", proExpirationDate=").append(proExpirationDate);
        sb.append(", isGalleryTermsAccepted=").append(isGalleryTermsAccepted);
        sb.append(", arrActiveEmails=").append(arrActiveEmails);
        sb.append(", isIncomingMessageEnabled=").append(isIncomingMessageEnabled);
        sb.append(", arrBlockedUsersBean=").append(arrBlockedUsersBean);
        sb.append('}');
        return sb.toString();
    }
}
