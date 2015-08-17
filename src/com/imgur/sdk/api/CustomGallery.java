package com.imgur.sdk.api;

import com.imgur.request.ApiRequest;
import com.imgur.request.CustomGalleryRequest;
import com.imgur.sdk.ImgurRestClient;

import java.util.HashMap;

/**
 * Created by root on 10/28/14.
 */
public class CustomGallery    extends Resource {

    private CustomGalleryRequest customGalleryRequest = new CustomGalleryRequest();
    public CustomGallery( ImgurRestClient client ,ApiRequest apiRequest ){
        super(client);
        this.customGalleryRequest = (CustomGalleryRequest) apiRequest;
    }


    private String generateSubResourceLocation(HashMap<Integer,String> hmResourceName){
        StringBuilder strSubResource = new StringBuilder();
        strSubResource.append("/").append( "g" );
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
