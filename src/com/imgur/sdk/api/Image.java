package com.imgur.sdk.api;

import com.imgur.bean.AlbumBean;
import com.imgur.bean.BasicBean;
import com.imgur.bean.DataBean;
import com.imgur.bean.ImageBean;
import com.imgur.common.Utility;
import com.imgur.request.ApiRequest;
import com.imgur.request.ImageRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestResponse;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/8/14
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Image extends Resource {

    private ImageRequest imageRequest = new ImageRequest();
    public Image( ImgurRestClient client ,ApiRequest apiRequest ){
        super(client);
        this.imageRequest = (ImageRequest) apiRequest;
    }
    public ImageBean getImageInfo() throws ImgurRestException {
        ImageBean imageBean  = new ImageBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, imageRequest.getId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateImageBean();
        if(dataBean!=null){
            imageBean = dataBean.getImageBean();
        }

        return imageBean;
    }
    public ImageBean imageUpload() throws ImgurRestException {
        ImageBean imageBean  = new ImageBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        Map<String, String> files = new HashMap<String, String>();

        String sType = this.imageRequest.getType();
        String sImageData = "";
        if("file".equalsIgnoreCase( sType )) {
            files.put("image", this.imageRequest.getFile() );
        } else if("base64".equalsIgnoreCase( sType )) {
            vars.put("image", this.imageRequest.getBase64() );
        } else if("URL".equalsIgnoreCase( sType )) {
            vars.put("image", this.imageRequest.getUrl() );
        }


        vars.put("type", sType );
        vars.put("album", this.imageRequest.getAlbumId());

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        resourceRequestParams.setFiles( files );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", resourceRequestParams );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateImageBean();
        if(dataBean!=null){
            imageBean = dataBean.getImageBean();
        }

        return imageBean;

    }

    public boolean deleteImage() throws ImgurRestException {
        boolean isSuccess = false;
        if( !this.getClient().isAnnonymousExecution() ) {
            HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
            hmResourceName.put(0, this.imageRequest.getId() );

            String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

            ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );

            DataModel dataModel = new DataModel(response);
            DataBean dataBean = dataModel.generateBooleanDataBasicBean();
            if(dataBean!=null){
                isSuccess = dataBean.isSuccess();
            }
        } else {
            // Anonymous images cannot be deleted
        }
        return isSuccess;
    }

    public boolean updateImageInformation() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, imageRequest.getId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;


        String sTitle = this.imageRequest.getTitle();
        String sDescription = this.imageRequest.getDescription();

        Map<String, String> vars = new HashMap<String, String>();
        if( !Utility.isNullOrEmpty(sTitle)) {
            vars.put("title", sTitle );
        }

        if( !Utility.isNullOrEmpty(sDescription)) {
            vars.put("description", sDescription );
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "PUT", resourceRequestParams );
        System.out.println("response : " + response.getResponseText() );
        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }

        return isSuccess;
    }

    public boolean favoriteAnImage() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.imageRequest.getId() );
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

    private String generateSubResourceLocation(HashMap<Integer,String> hmResourceName){
        StringBuilder strSubResource = new StringBuilder();
        strSubResource.append("/").append( "image" );
        if(hmResourceName!=null && !hmResourceName.isEmpty()){
            for(Integer iTrack = 0; iTrack<hmResourceName.size(); iTrack++) {
                strSubResource.append("/").append(hmResourceName.get(iTrack));
            }
        }
        return strSubResource.toString();
    }

    @Override
    protected String getResourceLocation() {
        return getClient().getEndpoint() + "/" + ImgurRestClient.DEFAULT_VERSION;
    }
}
