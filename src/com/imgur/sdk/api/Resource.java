package com.imgur.sdk.api;

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
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Resource {
    /** The client. */
    private ImgurRestClient client;

    /**
     * Instantiates a new resource.
     *
     * @param client the client
     */
    public Resource(ImgurRestClient client) {
        this.client = client;
    }

    protected ImgurRestClient getClient(){
        return this.client;
    }

    protected ImgurRestResponse invokeImgurApi( String sResourceEndpoint, String method, ResourceRequestParams resourceRequestParams ) throws ImgurRestException {
        ImgurRestResponse response = this.getClient().safeRequest( sResourceEndpoint , method , resourceRequestParams);
        return response;
    }

    protected abstract String getResourceLocation();
}
