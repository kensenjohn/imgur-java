package com.imgur.sdk;

import com.imgur.common.Utility;
import com.imgur.request.ApiRequest;
import com.imgur.sdk.api.*;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/30/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImgurRestClient {

    /** imgur endpoint. */
    private String endpoint = "https://api.imgur.com";

    private Integer numRetries = 3;


    /** The accept token for Imgur API call. */
    private String acceptToken;

    /** The client Id for Imgur API call. */
    private String clientId;

    /**
     * The default HTTP Connection timeout
     */
    private static final int CONNECTION_TIMEOUT = 10000;

    /**
     * The default timeout to use for requests to Imgur
     */
    private static final int READ_TIMEOUT = 30500;

    /** The Constant VERSION. */
    private static final String VERSION = "3";

    /** The Constant DEFAULT_VERSION. */
    public static final String DEFAULT_VERSION = "3";


    /** The Constant DEFAULT_VERSION. */
    public static final String DEFAULT_USERNAME = "me";

    private String userName;

    private boolean isAnnonymousExecution = false;



    /** The httpclient. */
    private CloseableHttpClient httpclient;

    public void setHttpclient(final CloseableHttpClient httpclient) {
        this.httpclient = httpclient;
    }

    public CloseableHttpClient getHttpClient() {
        return httpclient;
    }

    public ImgurRestClient(ImgurRestRequest imgurRestRequest) {
        if(imgurRestRequest!=null) {
            if(imgurRestRequest.isAcceptTokenPresent()){
                this.acceptToken = imgurRestRequest.getAcceptToken();
            }

            if(imgurRestRequest.isClientIdPresent()){
                this.clientId = imgurRestRequest.getClientId();
                isAnnonymousExecution = true;
            }

            if(!Utility.isNullOrEmpty(imgurRestRequest.getEndpoint())){
                this.endpoint = imgurRestRequest.getEndpoint();
            }

            if( !Utility.isNullOrEmpty(imgurRestRequest.getUsername()) ) {
                this.userName = imgurRestRequest.getUsername();
            } else {
                this.userName = DEFAULT_USERNAME;
            }
        }




        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        setHttpclient( httpClient );
    }

    public boolean isAnnonymousExecution() {
        return isAnnonymousExecution;
    }

    /**
     *
     * @param resourceRequestParams
     * @return
     */
    private static ImgurRestRequestParams generateParameters(final ResourceRequestParams resourceRequestParams) {
        ImgurRestRequestParams imgurRestRequestParams = new ImgurRestRequestParams();
        if(resourceRequestParams!=null) {
            if(resourceRequestParams.isUploadBinaryFile()){
                MultipartEntityBuilder builder = generateMultipartEntityBuilderParameters( resourceRequestParams );
                imgurRestRequestParams.setMultipartEntityBuilder( builder );
                imgurRestRequestParams.setMultipartRequestPresent( true );
            } else {
                List<NameValuePair> qparams = generateNameValueParameters(resourceRequestParams);
                imgurRestRequestParams.setListNameValuePairs( qparams );
            }
        }
        return imgurRestRequestParams;
    }

    private static MultipartEntityBuilder  generateMultipartEntityBuilderParameters(final ResourceRequestParams resourceRequestParams){
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        if(resourceRequestParams!=null){
            Map<String, String> vars = resourceRequestParams.getVars();

            if (vars != null  && !vars.isEmpty()) {
                for (final String var : vars.keySet()) {
                    builder.addTextBody(var, vars.get(var));
                }
            }

            Map<String, ArrayList<String> > multipleVars = resourceRequestParams.getMultipleVars();

            if( multipleVars!=null && !multipleVars.isEmpty() ){
                for (final String multiVarKey : multipleVars.keySet()) {

                    ArrayList<String> multiVarValue = multipleVars.get(multiVarKey);

                    for(String value : multiVarValue ) {
                        builder.addTextBody(multiVarKey, value);
                    }

                }
            }

            Map<String, String> files = resourceRequestParams.getFiles();
            if (files != null  && !files.isEmpty()) {
                for (final String filekey : files.keySet()) {
                    String sFilePath = files.get(filekey);
                    File file = new File(sFilePath);
                    FileBody fb = new FileBody(file);
                    builder.addPart(filekey, fb);
                }
            }
        }
        return builder;
    }

    private static List<NameValuePair> generateNameValueParameters( final ResourceRequestParams resourceRequestParams){
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();

        if(resourceRequestParams!=null){
            Map<String, String> vars = resourceRequestParams.getVars();

            if (vars != null  && !vars.isEmpty()) {
                for (final String var : vars.keySet()) {
                    qparams.add(new BasicNameValuePair(var, vars.get(var)));
                }
            }

            Map<String, ArrayList<String> > multipleVars = resourceRequestParams.getMultipleVars();

            if( multipleVars!=null && !multipleVars.isEmpty() ){
                for (final String multiVarKey : multipleVars.keySet()) {

                    ArrayList<String> multiVarValue = multipleVars.get(multiVarKey);

                    for(String value : multiVarValue ) {
                        qparams.add(new BasicNameValuePair(multiVarKey, value ));
                    }

                }
            }
        }
        return qparams;
    }

	/*
	 *
	 * Method builders
	 */

    /**
     * Builds the method.
     *
     * @param method the method
     * @param path the path
     * @param imgurRestRequestParams the params
     * @return the http uri request
     */
    private HttpUriRequest buildMethod(final String method, final String path,  final ImgurRestRequestParams imgurRestRequestParams) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if( imgurRestRequestParams!=null && !imgurRestRequestParams.isMultipartRequestPresent() ){
            params = imgurRestRequestParams.getListNameValuePairs();
        }
        if (method.equalsIgnoreCase("GET")) {
            return generateGetRequest(path, params);
        } else if (method.equalsIgnoreCase("POST")) {
            return generatePostRequest(path, imgurRestRequestParams);
        } else if (method.equalsIgnoreCase("PUT")) {
            return generatePutRequest(path, params);
        } else if (method.equalsIgnoreCase("DELETE")) {
            return generateDeleteRequest(path, params);
        } else {
            throw new IllegalArgumentException("Unknown Method: " + method);
        }
    }

    /**
     * Generate get request.
     *
     * @param path the path
     * @param params the params
     * @return the http get
     */
    private HttpGet generateGetRequest(final String path, final List<NameValuePair> params) {

        URI uri = buildUri(path, params);
        return new HttpGet(uri);
    }

    /**
     * Generate post request.
     *
     * @param path the path
     * @param imgurRestRequestParams the params
     * @return the http post
     */
    private HttpPost generatePostRequest(final String path, final ImgurRestRequestParams imgurRestRequestParams) {
        URI uri = buildUri(path);
        HttpPost post = new HttpPost(uri);

        if(imgurRestRequestParams!=null && !imgurRestRequestParams.isMultipartRequestPresent()){
            List<NameValuePair> params = imgurRestRequestParams.getListNameValuePairs();
            UrlEncodedFormEntity entity = buildEntityBody(params);
            post.setEntity(entity);
        } else {
            MultipartEntityBuilder builder = imgurRestRequestParams.getMultipartEntityBuilder();
            post.setEntity( buildEntityBody(builder) );
        }
        return post;
    }

    /**
     * Generate put request.
     *
     * @param path the path
     * @param params the params
     * @return the http put
     */
    private HttpPut generatePutRequest(final String path, final List<NameValuePair> params) {
        URI uri = buildUri(path);

        UrlEncodedFormEntity entity = buildEntityBody(params);

        HttpPut put = new HttpPut(uri);
        put.setEntity(entity);

        return put;
    }

    /**
     * Generate delete request.
     *
     * @param path the path
     * @param params the params
     * @return the http delete
     */
    private HttpDelete generateDeleteRequest(final String path, final List<NameValuePair> params) {
        URI uri = buildUri(path);
        return new HttpDelete(uri);
    }

    /*
	 *
	 * Helper functions for building methods
	 */

    /**
     * Builds the entity body.
     *
     * @param params the params
     * @return the url encoded form entity
     */
    private UrlEncodedFormEntity buildEntityBody(final List<NameValuePair> params) {
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(params, "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    private HttpEntity buildEntityBody(MultipartEntityBuilder builder){
        return builder.build();
    }

    /**
     * Builds the uri.
     *
     * @param path the path
     * @return the uRI
     */
    private URI buildUri(final String path) {
        return buildUri(path, null);
    }

    /**
     * Builds the uri.
     *
     * @param path the path
     * @param queryStringParams the query string params
     * @return the uRI
     */
    private URI buildUri(final String path, final List<NameValuePair> queryStringParams) {
        StringBuilder sb = new StringBuilder();
        sb.append(path);

        if (queryStringParams != null && queryStringParams.size() > 0) {
            sb.append("?");
            sb.append(URLEncodedUtils.format(queryStringParams, "UTF-8"));
        }

        URI uri;
        try {
            uri = new URI(sb.toString());
        } catch (final URISyntaxException e) {
            throw new IllegalStateException("Invalid uri", e);
        }

        return uri;
    }

    public ImgurRestResponse request(final String path, final String method,
                                      final ImgurRestRequestParams imgurRestRequestParams) throws ImgurRestException {

        HttpUriRequest request = setupRequest(path, method, imgurRestRequestParams);

        HttpResponse response;
        try {
            response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            Header[] contentTypeHeaders = response.getHeaders("Content-Type");
            String responseBody = "";

            if (entity != null) {
                responseBody = EntityUtils.toString(entity);
            }

            StatusLine status = response.getStatusLine();
            int statusCode = status.getStatusCode();
            System.out.println(request.getURI().toString() + " - " + responseBody + " - " + statusCode );
            ImgurRestResponse restResponse = new ImgurRestResponse(request.getURI().toString(), responseBody, statusCode);

            // For now we only set the first content type seen
            for (final Header h : contentTypeHeaders) {
                restResponse.setContentType(h.getValue());
                break;
            }
            return restResponse;

        } catch (final ClientProtocolException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1);
        } catch (final IOException e1) {
            e1.printStackTrace();
            throw new RuntimeException(e1);
        }
    }

    /**
     * Setup request.
     *
     * @param path the path
     * @param method the method
     * @param imgurRestRequestParams the vars
     * @return the http uri request
     */
    private HttpUriRequest setupRequest(String path, final String method, final ImgurRestRequestParams imgurRestRequestParams) {

        String normalizedPath = path.toLowerCase();
        StringBuilder sb = new StringBuilder();

        // If we've given a fully qualified uri then skip building the endpoint
        if (normalizedPath.startsWith("http://") || normalizedPath.startsWith("https://")) {
            sb.append(path);
        } else {
            sb.append(getEndpoint());

            if (!normalizedPath.startsWith("/")) {
                sb.append("/");
            }
            sb.append(path);
        }

        path = sb.toString();

        HttpUriRequest request = buildMethod(method, path, imgurRestRequestParams);
        if(isAnnonymousExecution){
            request.addHeader(new BasicHeader("Authorization", "Client-ID " + clientId));
        } else {
            request.addHeader(new BasicHeader("Authorization", "Bearer " + acceptToken));
        }

        request.addHeader(new BasicHeader("User-Agent", "imgur-java/" + VERSION));
        request.addHeader(new BasicHeader("Accept", "application/json"));
        request.addHeader(new BasicHeader("Accept-Charset", "utf-8"));
        return request;
    }

    public ImgurRestResponse safeRequest(final String path, final String method, final ResourceRequestParams resourceRequestParams) throws
            ImgurRestException {
        ImgurRestRequestParams imgurRestRequestParams = generateParameters(resourceRequestParams);
        return safeRequest(path, method, imgurRestRequestParams);
    }



    /**
     * Make a request, handles retries + back-off for server/network errors
     *
     * @param path the URL (absolute w.r.t. the endpoint URL - i.e. /2010-04-01/Accounts)
     * @param method the HTTP method to use, defaults to GET
     * @param imgurRestRequestParams for POST or PUT, a list of data to send, for GET will be appended to the URL as querystring
     * params
     * @return The response
     * @throws ImgurRestException if there's an client exception returned by the TwilioApi
     */
    public ImgurRestResponse safeRequest(final String path, final String method,
                                          final ImgurRestRequestParams imgurRestRequestParams) throws ImgurRestException {

        ImgurRestResponse response = null;
        for (int retry = 0; retry < numRetries; retry++) {
            response = request(path, method, imgurRestRequestParams);
            if (response.isClientError()) {
                throw ImgurRestException.parseResponse(response);
            } else if (response.isServerError()) {
                try {
                    Thread.sleep(100 * retry); // Backoff on our sleep
                } catch (final InterruptedException e) {
                }
                continue;
            }

            return response;
        }
        int errorCode = response == null ? -1 : response.getHttpStatus();
        throw new ImgurRestException("Cannot fetch: " + method + " " + path, errorCode);
    }

    /**
     * Get the current endpoint this client is pointed at.
     *
     * @return String the api endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Set the endpoint this rest client uses.
     *
     * @param endpoint The location of the endpoint
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * Get the current endpoint this client is pointed at.
     *
     * @return String the api userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the endpoint this rest client uses.
     *
     * @param userName
     */
    public void getUserName(final String userName) {
        this.userName = userName;
    }

    public Account getAccount(){
        return getAccount(new ApiRequest());
    }
    public Account getAccount(ApiRequest apiRequest){
        Account account = new Account(this,apiRequest);
        return account;
    }

    public Album getAlbum(ApiRequest apiRequest){
        Album album = new Album(this,apiRequest);
        return album;
    }

    public Image getImage(ApiRequest apiRequest){
        Image image = new Image(this,apiRequest);
        return image;
    }

    public Comment getComment(ApiRequest apiRequest){
        Comment comment = new Comment(this,apiRequest);
        return comment;
    }
}
