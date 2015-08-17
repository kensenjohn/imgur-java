package com.imgur.sdk.api;

import com.imgur.bean.AlbumBean;
import com.imgur.bean.DataBean;
import com.imgur.bean.ImageBean;
import com.imgur.common.Utility;
import com.imgur.request.AlbumRequest;
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
 * Date: 10/8/14
 * Time: 7:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Album  extends Resource {

    private AlbumRequest albumRequest = new AlbumRequest();
    public Album( ImgurRestClient client ,ApiRequest apiRequest ){
        super(client);
        this.albumRequest = (AlbumRequest) apiRequest;
    }

    @Override
    protected String getResourceLocation() {
        return getClient().getEndpoint() + "/" + ImgurRestClient.DEFAULT_VERSION;
    }

    public AlbumBean getAlbumInfo() throws ImgurRestException {
        AlbumBean albumBean = new AlbumBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, albumRequest.getId() );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAlbumBean();
        if(dataBean!=null){
            albumBean = dataBean.getAlbumBean();
        }

        return albumBean;
    }

    public ArrayList<ImageBean> getAlbumImages()  throws ImgurRestException {
        ArrayList<ImageBean> arrImageBean = new ArrayList<ImageBean>();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, albumRequest.getId() );
        hmResourceName.put(1, "images");

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAlbumImages();
        if(dataBean!=null){
            arrImageBean = dataBean.getArrImageBean();
        }


        return arrImageBean;
    }

    public ImageBean getAlbumImage(String imageId) throws ImgurRestException {
        ImageBean imageBean = new ImageBean();

        if(imageId!=null && !"".equalsIgnoreCase(imageId)){
            HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
            hmResourceName.put(0, albumRequest.getId() );
            hmResourceName.put(1, "image");
            hmResourceName.put(2, imageId );

            String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

            Map<String, String> vars = new HashMap<String, String>();
            ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
            resourceRequestParams.setVars( vars );

            ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );

            DataModel dataModel = new DataModel(response);
            DataBean dataBean = dataModel.generateImageBean();
            if(dataBean!=null){
                imageBean = dataBean.getImageBean();
            }
        }
        return imageBean;
    }

    private AlbumBean manipulateAlbum( String sResourceEndpoint )  throws ImgurRestException {
        AlbumBean albumBean  = new AlbumBean();
        Map<String, String> vars = new HashMap<String, String>();

        if( !Utility.isNullOrEmpty(albumRequest.getTitle())){
            vars.put("title", albumRequest.getTitle() );
        }
        if( !Utility.isNullOrEmpty(albumRequest.getDescription())){
            vars.put("description", albumRequest.getDescription() );
        }
        if( !Utility.isNullOrEmpty(albumRequest.getPrivacy())){
            vars.put("privacy", albumRequest.getPrivacy() );
        }
        if( !Utility.isNullOrEmpty(albumRequest.getLayout())){
            vars.put("layout", albumRequest.getLayout() );
        }
        if( !Utility.isNullOrEmpty(albumRequest.getCoverid())){
            vars.put("cover", albumRequest.getCoverid() );
        }

        Map<String, ArrayList<String> > mulitpleVars = new HashMap<String, ArrayList<String>  >();
        if( albumRequest.getArrImageId()!=null && !albumRequest.getArrImageId().isEmpty() ) {
            ArrayList<String> arrImageId = albumRequest.getArrImageId();
            mulitpleVars.put("ids[]", arrImageId);
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        resourceRequestParams.setMultipleVars( mulitpleVars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateAlbumBean();
        if(dataBean!=null){
            albumBean = dataBean.getAlbumBean();
        }
        return albumBean;
    }
    public AlbumBean createAlbum() throws ImgurRestException {
        AlbumBean albumBean  = new AlbumBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;
        albumBean = manipulateAlbum( sResourceEndpoint );
        return albumBean;
    }

    public AlbumBean updateAlbum() throws ImgurRestException {
        AlbumBean albumBean  = new AlbumBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        if( !this.getClient().isAnnonymousExecution() ) {
            hmResourceName.put(0, this.albumRequest.getId() );
        } else {
            hmResourceName.put(0, this.albumRequest.getDeleteHashId() );
        }
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        albumBean = manipulateAlbum( sResourceEndpoint );
        return albumBean;
    }

    public boolean deleteAlbum() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        if( !this.getClient().isAnnonymousExecution() ) {
            hmResourceName.put(0, this.albumRequest.getId() );
        } else {
            hmResourceName.put(0, this.albumRequest.getDeleteHashId() );
        }
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }
        return isSuccess;
    }

    public boolean favoriteAnAlbum() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.albumRequest.getId() );
        hmResourceName.put(1, "favorite" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST",  new ResourceRequestParams() );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateFavoritedDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }

        return isSuccess;
    }


    private boolean manipulateAlbumImageContent(String sResourceEndpoint, String sAction)  throws ImgurRestException  {
        boolean isSuccess = false;
        Map<String, ArrayList<String> > mulitpleVars = new HashMap<String, ArrayList<String>  >();
        if( albumRequest.getArrImageId()!=null && !albumRequest.getArrImageId().isEmpty() ) {
            ArrayList<String> arrImageId = albumRequest.getArrImageId();
            mulitpleVars.put("ids[]", arrImageId);
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setMultipleVars(mulitpleVars);

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, sAction,  resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }
        return isSuccess;
    }
    public boolean setAlbumImages() throws ImgurRestException {
        boolean isSuccess = false;


        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.albumRequest.getId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        isSuccess = manipulateAlbumImageContent( sResourceEndpoint , "POST");

        return isSuccess;
    }

    public boolean addAlbumImages() throws ImgurRestException {
        boolean isSuccess = false;


        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.albumRequest.getId() );
        hmResourceName.put(1, "add" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        isSuccess = manipulateAlbumImageContent( sResourceEndpoint , "POST");

        return isSuccess;
    }

    public boolean removeAlbumImages() throws ImgurRestException {
        boolean isSuccess = false;


        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        if( this.getClient().isAnnonymousExecution() ) {
            hmResourceName.put(0, this.albumRequest.getDeleteHashId() );
        } else {
            hmResourceName.put(0, this.albumRequest.getId() );
        }
        hmResourceName.put(1, "remove_images" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        isSuccess = manipulateAlbumImageContent( sResourceEndpoint , "DELETE");

        return isSuccess;
    }

    private String generateSubResourceLocation(HashMap<Integer,String> hmResourceName){
        StringBuilder strSubResource = new StringBuilder();
        strSubResource.append("/").append( "album" );
        if(hmResourceName!=null && !hmResourceName.isEmpty()){
            for(Integer iTrack = 0; iTrack<hmResourceName.size(); iTrack++) {
                strSubResource.append("/").append(hmResourceName.get(iTrack));
            }
        }
        return strSubResource.toString();
    }
}
