package com.imgur.parser;

import com.imgur.sdk.ImgurRestResponse;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/30/14
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ResponseParser {
    /**
     * Parses the.
     *
     * @param response the response
     * @return the map
     */
    public Map<String, Object> parse(ImgurRestResponse response);
}
