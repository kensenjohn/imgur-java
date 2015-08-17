package com.imgur.sdk.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.imgur.bean.*;
import com.imgur.common.Utility;
import com.imgur.sdk.ImgurRestResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 3:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataModel {

    private ImgurRestResponse response = new ImgurRestResponse();
    public DataModel(ImgurRestResponse response) {
        this.response = response;
    }

    public DataBean generateAccountBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            AccountBean accountBean = new AccountBean( hmData );

            dataBean.setAccountBean( accountBean );
        }

        return dataBean;
    }

    public DataBean generateBasicBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;

            BasicBean basicBean = new BasicBean();
        }

        return dataBean;
    }

    public DataBean generateFavoritedDataBasicBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            String sFavorited = (String)basicObj.get("data") ;

            if("favorited".equalsIgnoreCase(sFavorited)){
                dataBean.setSuccess( true );
            } else{
                dataBean.setSuccess( false );
            }

        }

        return dataBean;
    }

    public DataBean generateBooleanDataBasicBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            boolean isSuccess = (Boolean)basicObj.get("data") ;
            dataBean.setSuccess( isSuccess );
        }

        return dataBean;
    }

    public DataBean generateAccountSettingsBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            AccountSettingsBean accountSettingsBean = new AccountSettingsBean( hmData );

            dataBean.setAccountSettingsBean(accountSettingsBean);
        }

        return dataBean;
    }

    public DataBean generateAccountGalleryProfile() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){

            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            GalleryProfileBean galleryProfileBean = new GalleryProfileBean( hmData );

            dataBean.setGalleryProfileBean(galleryProfileBean);
        }

        return dataBean;
    }

    public DataBean generateGalleryBean() {
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<HashMap<String,Object>> arrData = (ArrayList<HashMap<String,Object>>)basicObj.get("data") ;

            if(arrData!=null && !arrData.isEmpty()) {
                ArrayList<GalleryBean> arrGalleryBean = new ArrayList<GalleryBean>();
                for(HashMap<String,Object> hmGalleryFavoriteData : arrData ){
                    //boolean isAlbum = Utility.sTob( (String)hmGalleryFavoriteData.get("is_album"));

                    boolean isAlbum =  (Boolean)hmGalleryFavoriteData.get("is_album") ;

                    GalleryBean galleryBean = new GalleryBean();
                    if(isAlbum) {
                        galleryBean = new GalleryAlbumBean(hmGalleryFavoriteData);
                    } else {
                        galleryBean = new GalleryImageBean(hmGalleryFavoriteData);
                    }

                    arrGalleryBean.add( galleryBean );
                }
                dataBean.setArrGalleryBean( arrGalleryBean );
            }
        }
        return dataBean;
    }

    public DataBean generateAlbumBeanList() {

        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<HashMap<String,Object>> arrData = (ArrayList<HashMap<String,Object>>)basicObj.get("data") ;

            if(arrData!=null && !arrData.isEmpty()) {
                ArrayList<AlbumBean> arrAlbumBean = new ArrayList<AlbumBean>();
                for(HashMap<String,Object> hmAlbumBeanData : arrData ){
                    AlbumBean albumBean = new AlbumBean( hmAlbumBeanData );

                    arrAlbumBean.add( albumBean );
                }
                dataBean.setArrAlbumBean( arrAlbumBean );
            }
        }
        return dataBean;
    }

    public DataBean generateAlbumBean(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            AlbumBean albumBean = new AlbumBean( hmData );

            dataBean.setAlbumBean( albumBean );
        }
        return dataBean;
    }

    public DataBean generateAlbumBeanIdList(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<String> albumId = (ArrayList<String>)basicObj.get("data") ;
            dataBean.setAlbumIds( albumId );
        }
        return dataBean;
    }

    public DataBean generateAlbumBeanCount(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            Integer albumCount = (Integer)basicObj.get("data") ;
            dataBean.setAlbumCount( albumCount );
        }
        return dataBean;
    }



    public DataBean generateCommentBeanList() {

        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<HashMap<String,Object>> arrData = (ArrayList<HashMap<String,Object>>)basicObj.get("data") ;
            System.out.println("CommentBeanList arrData : " + arrData);
            if(arrData!=null && !arrData.isEmpty()) {
                ArrayList<CommentBean> arrCommentBean = new ArrayList<CommentBean>();
                for(HashMap<String,Object> hmCommentBeanData : arrData ){
                    CommentBean commentBean = new CommentBean( hmCommentBeanData );

                    arrCommentBean.add( commentBean );
                }
                dataBean.setArrCommentBean( arrCommentBean );
            }
        }
        return dataBean;
    }


    public DataBean generateCommentBean(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            CommentBean commentBean = new CommentBean( hmData );

            dataBean.setCommentBean(commentBean);
        }
        return dataBean;
    }

    public DataBean generateCommentBeanIdList(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<String> commentIds = (ArrayList<String>)basicObj.get("data") ;
            dataBean.setCommentIds( commentIds );
        }
        return dataBean;
    }

    public DataBean generateCommentBeanCount(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            Integer commentCount = (Integer)basicObj.get("data") ;
            dataBean.setCommentCount( commentCount );
        }
        return dataBean;
    }

    public DataBean generateImageBean(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            HashMap hmData = (HashMap)basicObj.get("data") ;
            ImageBean imageBean = new ImageBean( hmData );

            dataBean.setImageBean( imageBean );
        }
        return dataBean;
    }

    public DataBean generateImageBeanIdList(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<String> imageIds = (ArrayList<String>)basicObj.get("data") ;
            dataBean.setImageIds( imageIds );
        }
        return dataBean;
    }

    public DataBean generateImageBeanCount(){
        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            Integer imageCount = (Integer)basicObj.get("data") ;
            dataBean.setImageCount( imageCount );
        }
        return dataBean;
    }

    public DataBean generateAlbumImages() {

        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<HashMap<String,Object>> arrData = (ArrayList<HashMap<String,Object>>)basicObj.get("data") ;

            if(arrData!=null && !arrData.isEmpty()) {
                ArrayList<ImageBean> arrImageBean = new ArrayList<ImageBean>();
                for(HashMap<String,Object> hmAlbumImageData : arrData ){
                    ImageBean imageBean = new ImageBean( hmAlbumImageData );

                    arrImageBean.add( imageBean );
                }
                dataBean.setArrImageBean(arrImageBean);
            }
        }
        return dataBean;
    }


    public DataBean generateNotificationBeanList() {

        DataBean dataBean = new DataBean();
        if(this.response!=null){
            Map<String, Object> basicObj = this.response.toMap();
            ArrayList<HashMap<String,Object>> arrData = (ArrayList<HashMap<String,Object>>)basicObj.get("data") ;
            if(arrData!=null && !arrData.isEmpty()) {
                ArrayList<NotificationBean> arrNotificationBean = new ArrayList<NotificationBean>();
                for(HashMap<String,Object> hmNotificationBeanData : arrData ){
                    NotificationBean notificationBean = new NotificationBean( hmNotificationBeanData );

                    arrNotificationBean.add( notificationBean );
                }
                dataBean.setArrNotificationBean( arrNotificationBean );
            }
        }
        return dataBean;
    }
}
