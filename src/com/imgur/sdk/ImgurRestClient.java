package com.imgur.sdk;

import com.imgur.common.Utility;
import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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


    /** The account sid. */
    private final String acceptToken;

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



    /** The httpclient. */
    private HttpClient httpclient;

    public void setHttpclient(final HttpClient httpclient) {
        this.httpclient = httpclient;
    }

    public HttpClient getHttpClient() {
        return httpclient;
    }

    public ImgurRestClient(final String acceptToken) {
        this(acceptToken , null);
    }
    public ImgurRestClient(final String acceptToken, final String endpoint) {
        this.acceptToken = acceptToken;

        if(!Utility.isNullOrEmpty(endpoint)){
            this.endpoint = endpoint;
        }

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        setHttpclient( httpClient );
        httpclient.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        httpclient.getParams().setParameter("http.socket.timeout", new Integer(READ_TIMEOUT));
        httpclient.getParams().setParameter("http.connection.timeout", new Integer(CONNECTION_TIMEOUT));
        httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");


    }


    /**
     * Generate parameters.
     *
     * @param vars the vars
     * @return the list
     */
    private static List<NameValuePair> generateParameters(final Map<String, String> vars) {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();

        if (vars != null) {
            for (final String var : vars.keySet()) {
                qparams.add(new BasicNameValuePair(var, vars.get(var)));
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
     * @param params the params
     * @return the http uri request
     */
    private HttpUriRequest buildMethod(final String method, final String path, final List<NameValuePair> params) {
        if (method.equalsIgnoreCase("GET")) {
            return generateGetRequest(path, params);
        } else if (method.equalsIgnoreCase("POST")) {
            return generatePostRequest(path, params);
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
     * @param params the params
     * @return the http post
     */
    private HttpPost generatePostRequest(final String path, final List<NameValuePair> params) {
        URI uri = buildUri(path);

        UrlEncodedFormEntity entity = buildEntityBody(params);

        HttpPost post = new HttpPost(uri);
        post.setEntity(entity);

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

    /**
     * sendRequst Sends a REST Request to the Twilio REST API.
     *
     * @param path the URL (absolute w.r.t. the endpoint URL - i.e. /2010-04-01/Accounts)
     * @param method the HTTP method to use, defaults to GET
     * @param paramMap for POST or PUT, a map of data to send, for GET will be appended to the URL as querystring
     * params
     * <p/>
     * This method is public for backwards compatibility with the old twilio helper library
     * @return the twilio rest response
     */
    public ImgurRestResponse request(final String path, final String method, final Map<String, String> paramMap) throws
            ImgurRestException {

        List<NameValuePair> paramList = generateParameters(paramMap);
        return request(path, method, paramList);
    }

    public ImgurRestResponse request(final String path, final String method,
                                      final List<NameValuePair> paramList) throws ImgurRestException {

        HttpUriRequest request = setupRequest(path, method, paramList);

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

            ImgurRestResponse restResponse = new ImgurRestResponse(request.getURI().toString(), responseBody,
                    statusCode);

            // For now we only set the first content type seen
            for (final Header h : contentTypeHeaders) {
                restResponse.setContentType(h.getValue());
                break;
            }

            return restResponse;

        } catch (final ClientProtocolException e1) {
            throw new RuntimeException(e1);
        } catch (final IOException e1) {
            throw new RuntimeException(e1);
        }
    }

    /**
     * Setup request.
     *
     * @param path the path
     * @param method the method
     * @param params the vars
     * @return the http uri request
     */
    private HttpUriRequest setupRequest(String path, final String method, final List<NameValuePair> params) {

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

        HttpUriRequest request = buildMethod(method, path, params);

        request.addHeader(new BasicHeader("Authorization", "Bearer " + acceptToken));
        request.addHeader(new BasicHeader("User-Agent", "imgur-java/" + VERSION));
        request.addHeader(new BasicHeader("Accept", "application/json"));
        request.addHeader(new BasicHeader("Accept-Charset", "utf-8"));
        return request;
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
     * @param endpoint The location of the endpoint (e.g. https://api.twilio.com)
     */
    public void setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
    }


}
