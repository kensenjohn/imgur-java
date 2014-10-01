package com.imgur.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imgur.sdk.ImgurRestResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/30/14
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class JsonResponseParser implements ResponseParser {
    public Map<String, Object> parse(ImgurRestResponse response) {
        return this.parseJson(response.getResponseText());
    }


    /**
     * Parses the json.
     *
     * @param jsonString the json string
     * @return the map
     */
    @SuppressWarnings("unchecked")
    protected Map<String, Object> parseJson(String jsonString) {
        Map<String, Object> ret = new HashMap<String, Object>();

        try {
            ret = new ObjectMapper().readValue(jsonString, HashMap.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ret;
    }
}
