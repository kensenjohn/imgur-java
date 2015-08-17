package com.imgur.sdk.api;

import com.imgur.bean.*;
import com.imgur.common.Utility;
import com.imgur.request.AccountRequest;
import com.imgur.request.ApiRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Account extends Resource  {

    private AccountRequest accountRequest = new AccountRequest();
    public Account( ImgurRestClient client ,ApiRequest apiRequest ){
        super(client);
        this.accountRequest = (AccountRequest) apiRequest;
    }

    @Override
    protected String getResourceLocation() {
        return getClient().getEndpoint() + "/" + ImgurRestClient.DEFAULT_VERSION;
    }

    public AccountBean getAccountInfo() throws ImgurRestException {
        AccountBean accountBean = new AccountBean();
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(null) ;

        Map<String, String> vars = new HashMap<String, String>();

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAccountBean();
        if(dataBean!=null){
            accountBean = dataBean.getAccountBean();
        }
        return accountBean;

    }

    public ArrayList<GalleryBean> getAccountGalleryFavorites() throws ImgurRestException {

        ArrayList<GalleryBean> arrGalleryBean = new ArrayList<GalleryBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "gallery_favorites" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateGalleryBean();

        if(dataBean!=null){
            arrGalleryBean = dataBean.getArrGalleryBean();
        }
        return  arrGalleryBean;
    }

    public ArrayList<GalleryBean> getAccountFavorites() throws ImgurRestException {

        ArrayList<GalleryBean> arrGalleryBean = new ArrayList<GalleryBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "favorites" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateGalleryBean();

        if(dataBean!=null){
            arrGalleryBean = dataBean.getArrGalleryBean();
        }
        return  arrGalleryBean;
    }

    public ArrayList<GalleryBean> getAccountSubmissions() throws ImgurRestException {
        ArrayList<GalleryBean> arrGalleryBean = new ArrayList<GalleryBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "submissions" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateGalleryBean();

        if(dataBean!=null){
            arrGalleryBean = dataBean.getArrGalleryBean();
        }
        System.out.println("arrGalleryBean : " + arrGalleryBean );
        return  arrGalleryBean;
    }

    public AccountSettingsBean getAccountSettings() throws ImgurRestException {
        AccountSettingsBean accountSettingsBean = new AccountSettingsBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "settings" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAccountSettingsBean();
        if(dataBean!=null){
            accountSettingsBean = dataBean.getAccountSettingsBean();
        }
        return accountSettingsBean;
    }

    /*public void getChangeAccountSettings() throws ImgurRestException {
        // TODO : Change Account Settingsneeds to be fleshed out
    }*/
    public GalleryProfileBean getAccountGalleryProfile() throws ImgurRestException {
        GalleryProfileBean galleryProfileBean = new GalleryProfileBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "gallery_profile" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAccountGalleryProfile();
        if(dataBean!=null){
            galleryProfileBean = dataBean.getGalleryProfileBean();
        }
        return galleryProfileBean;
    }

    /*public void verifyUsersEmail() throws ImgurRestException {
        // TODO : Verify Users Email needs to be fleshed out
    }*/

    /*public void senhdVerifyUsersEmail() throws ImgurRestException {
        // TODO : Sends an email to the user to verify that their email needs to be fleshed out
    }*/

    public ArrayList<AlbumBean> getAlbums() throws ImgurRestException {
        ArrayList<AlbumBean> arrAlbumBean = new ArrayList<AlbumBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "albums" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateAlbumBeanList();
        if(dataBean!=null){
            arrAlbumBean = dataBean.getArrAlbumBean();
        }

        return arrAlbumBean;
    }

    public AlbumBean getAlbum() throws ImgurRestException {
        AlbumBean albumBean = new AlbumBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "album" );
        hmResourceName.put(1, this.accountRequest.getAlbumId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateAlbumBean();
        if(dataBean!=null){
            albumBean = dataBean.getAlbumBean();
        }

        return albumBean;
    }

    public ArrayList<String> getAlbumIds() throws ImgurRestException {
        ArrayList<String> albumId = new ArrayList<String>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "albums" );
        hmResourceName.put(1, "ids" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateAlbumBeanIdList();
        if(dataBean!=null){
            albumId = dataBean.getAlbumIds();
        }
        return albumId;
    }

    public Integer getAlbumCount() throws ImgurRestException {
        Integer numberOfAlbums = 0;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "albums" );
        hmResourceName.put(1, "count" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAlbumBeanCount();
        if(dataBean!=null){
            numberOfAlbums = dataBean.getAlbumCount();
        }
        return numberOfAlbums;
    }

    public boolean getDeleteAlbum() throws ImgurRestException {
        boolean isDeleted = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "album" );
        hmResourceName.put(1, this.accountRequest.getAlbumId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isDeleted = dataBean.isSuccess();
        }
        return isDeleted;
    }

    public ArrayList<ImageBean> getImages() throws ImgurRestException {
        ArrayList<ImageBean> arrImageBean = new ArrayList<ImageBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "images" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateAlbumImages();
        if(dataBean!=null){
            arrImageBean = dataBean.getArrImageBean();
        }

        return arrImageBean;
    }

    public ImageBean getImage() throws ImgurRestException {
        ImageBean imageBean = new ImageBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "image" );
        hmResourceName.put(1, this.accountRequest.getImageId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateImageBean();
        if(dataBean!=null){
            imageBean = dataBean.getImageBean();
        }
        return imageBean;
    }

    public ArrayList<String> getImageIds() throws ImgurRestException {
        ArrayList<String> imageIds = new ArrayList<String>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "images" );
        hmResourceName.put(1, "ids" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateImageBeanIdList();
        if(dataBean!=null){
            imageIds = dataBean.getImageIds();
        }
        return imageIds;
    }

    public Integer getImageCount() throws ImgurRestException {
        Integer commentCount = 0;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "images" );
        hmResourceName.put(1, "count" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateImageBeanCount();
        if(dataBean!=null){
            commentCount = dataBean.getImageCount();
        }
        return commentCount;
    }

    public boolean getDeleteImage() throws ImgurRestException {
        boolean isDeleted = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "image" );
        hmResourceName.put(1, this.accountRequest.getImageId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isDeleted = dataBean.isSuccess();
        }
        return isDeleted;
    }


    public ArrayList<CommentBean> getComments() throws ImgurRestException {
        ArrayList<CommentBean> arrCommentBean = new ArrayList<CommentBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "comments" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateCommentBeanList();
        if(dataBean!=null){
            arrCommentBean = dataBean.getArrCommentBean();
        }

        return arrCommentBean;
    }

    public CommentBean getComment() throws ImgurRestException {
        CommentBean commentBean = new CommentBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "comment" );
        hmResourceName.put(1, this.accountRequest.getCommentId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateCommentBean();
        if(dataBean!=null){
            commentBean = dataBean.getCommentBean();
        }
        return commentBean;
    }

    public ArrayList<String> getCommentIds() throws ImgurRestException {
        ArrayList<String> commentIds = new ArrayList<String>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "comments" );
        hmResourceName.put(1, "ids" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateCommentBeanIdList();
        if(dataBean!=null){
            commentIds = dataBean.getCommentIds();
        }
        return commentIds;
    }

    public Integer getCommentCount() throws ImgurRestException {
        Integer commentCount = 0;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "comments" );
        hmResourceName.put(1, "count" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateCommentBeanCount();
        if(dataBean!=null){
            commentCount = dataBean.getCommentCount();
        }
        return commentCount;
    }

    public boolean getDeleteComment() throws ImgurRestException {
        boolean isDeleted = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "comment" );
        hmResourceName.put(1, this.accountRequest.getCommentId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isDeleted = dataBean.isSuccess();
        }
        return isDeleted;
    }

    public ArrayList<NotificationBean> getReplies()  throws ImgurRestException  {

        ArrayList<NotificationBean> arrNotificationBean  = new ArrayList<NotificationBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, "notifications" );
        hmResourceName.put(1, "replies" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();

        if( !this.accountRequest.isShowNewNotifications() ) {
            vars.put("new", "false");
        } else {
            vars.put("new", "true");
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateNotificationBeanList();
        if(dataBean!=null){
            arrNotificationBean = dataBean.getArrNotificationBean();
        }
        return arrNotificationBean;
    }

    private String generateSubResourceLocation(HashMap<Integer,String> hmResourceName){
        StringBuilder strSubResource = new StringBuilder();
        strSubResource.append("/").append( "account" ).append("/").append( this.getClient().getUserName() );
        if(hmResourceName!=null && !hmResourceName.isEmpty()){
            for(Integer iTrack = 0; iTrack<hmResourceName.size(); iTrack++) {
                strSubResource.append("/").append(hmResourceName.get(iTrack));
            }
        }
        return strSubResource.toString();
    }
}
