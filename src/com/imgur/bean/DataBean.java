package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/7/14
 * Time: 8:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class DataBean {
    public DataBean(){
    }

    public DataBean(HashMap<String,Object> hmData){
    }

    private AccountBean accountBean = new AccountBean();
    private GalleryBean galleryBeanBean = new GalleryBean();
    private ArrayList<GalleryBean> arrGalleryBean = new ArrayList<GalleryBean>();
    private AccountSettingsBean accountSettingsBean = new AccountSettingsBean();
    private GalleryProfileBean galleryProfileBean = new GalleryProfileBean();
    private AlbumBean albumBean = new AlbumBean( );
    private ArrayList<AlbumBean> arrAlbumBean = new ArrayList<AlbumBean>();
    private ArrayList<ImageBean> arrImageBean = new ArrayList<ImageBean>();
    private ImageBean imageBean = new ImageBean( );
    private CommentBean commentBean = new CommentBean( );
    private ArrayList<CommentBean> arrCommentBean = new ArrayList<CommentBean>();
    private boolean isSuccess = false;
    private ArrayList<String> albumIds = new ArrayList<String>();
    private ArrayList<String> commentIds = new ArrayList<String>();
    private ArrayList<String> imageIds = new ArrayList<String>();
    private Integer albumCount = 0;
    private Integer commentCount = 0;
    private Integer imageCount = 0;
    private ArrayList<NotificationBean> arrNotificationBean = new ArrayList<NotificationBean>();

    public ArrayList<NotificationBean> getArrNotificationBean() {
        return arrNotificationBean;
    }

    public void setArrNotificationBean(ArrayList<NotificationBean> arrNotificationBean) {
        this.arrNotificationBean = arrNotificationBean;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public ArrayList<String> getImageIds() {
        return imageIds;
    }

    public void setImageIds(ArrayList<String> imageIds) {
        this.imageIds = imageIds;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public ArrayList<String> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(ArrayList<String> commentIds) {
        this.commentIds = commentIds;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public ArrayList<String> getAlbumIds() {
        return albumIds;
    }

    public void setAlbumIds(ArrayList<String> albumIds) {
        this.albumIds = albumIds;
    }

    public ArrayList<CommentBean> getArrCommentBean() {
        return arrCommentBean;
    }

    public void setArrCommentBean(ArrayList<CommentBean> arrCommentBean) {
        this.arrCommentBean = arrCommentBean;
    }

    public CommentBean getCommentBean() {
        return commentBean;
    }

    public void setCommentBean(CommentBean commentBean) {
        this.commentBean = commentBean;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ImageBean getImageBean() {
        return imageBean;
    }

    public void setImageBean(ImageBean imageBean) {
        this.imageBean = imageBean;
    }

    public ArrayList<ImageBean> getArrImageBean() {
        return arrImageBean;
    }

    public void setArrImageBean(ArrayList<ImageBean> arrImageBean) {
        this.arrImageBean = arrImageBean;
    }

    public ArrayList<AlbumBean> getArrAlbumBean() {
        return arrAlbumBean;
    }

    public void setArrAlbumBean(ArrayList<AlbumBean> arrAlbumBean) {
        this.arrAlbumBean = arrAlbumBean;
    }

    public AlbumBean getAlbumBean() {
        return albumBean;
    }

    public void setAlbumBean(AlbumBean albumBean) {
        this.albumBean = albumBean;
    }

    public GalleryProfileBean getGalleryProfileBean() {
        return galleryProfileBean;
    }

    public void setGalleryProfileBean(GalleryProfileBean galleryProfileBean) {
        this.galleryProfileBean = galleryProfileBean;
    }

    public AccountSettingsBean getAccountSettingsBean() {
        return accountSettingsBean;
    }

    public void setAccountSettingsBean(AccountSettingsBean accountSettingsBean) {
        this.accountSettingsBean = accountSettingsBean;
    }

    public AccountBean getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean) {
        this.accountBean = accountBean;
    }

    public GalleryBean getGalleryBeanBean() {
        return galleryBeanBean;
    }

    public void setGalleryBeanBean(GalleryBean galleryBeanBean) {
        this.galleryBeanBean = galleryBeanBean;
    }

    public ArrayList<GalleryBean> getArrGalleryBean() {
        return arrGalleryBean;
    }

    public void setArrGalleryBean(ArrayList<GalleryBean> arrGalleryBean) {
        this.arrGalleryBean = arrGalleryBean;
    }
}
