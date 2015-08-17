package com.imgur.sdk;

import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/16/14
 * Time: 6:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImgurRestRequestParams {
    private List<NameValuePair> listNameValuePairs = new ArrayList<NameValuePair>();
    private MultipartEntityBuilder multipartEntityBuilder = null;
    private boolean isMultipartRequestPresent = false;

    public MultipartEntityBuilder getMultipartEntityBuilder() {
        return multipartEntityBuilder;
    }

    public void setMultipartEntityBuilder(MultipartEntityBuilder multipartEntityBuilder) {
        this.multipartEntityBuilder = multipartEntityBuilder;
    }

    public List<NameValuePair> getListNameValuePairs() {
        return listNameValuePairs;
    }

    public void setListNameValuePairs(List<NameValuePair> listNameValuePairs) {
        this.listNameValuePairs = listNameValuePairs;
    }

    public boolean isMultipartRequestPresent() {
        return isMultipartRequestPresent;
    }

    public void setMultipartRequestPresent(boolean multipartRequestPresent) {
        isMultipartRequestPresent = multipartRequestPresent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImgurRestRequestParams{");
        sb.append("listNameValuePairs=").append(listNameValuePairs);
        sb.append(", multipartEntityBuilder=").append(multipartEntityBuilder);
        sb.append(", isMultipartRequestPresent=").append(isMultipartRequestPresent);
        sb.append('}');
        return sb.toString();
    }
}
