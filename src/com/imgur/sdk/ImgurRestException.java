package com.imgur.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 9/30/14
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImgurRestException extends Exception{
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -181355409302925081L;

    /** The error code. */
    private int errorCode;

    /** The message. */
    private String message;

    /** The more info. */
    private String moreInfo;

    /**
     * Instantiates a new imgur rest exception.
     *
     * @param message the message
     * @param errorCode the error code
     */
    public ImgurRestException(String message, int errorCode) {
        this(message, errorCode, "");
    }

    /**
     * Instantiates a new imgur rest exception.
     *
     * @param message the message
     * @param errorCode the error code
     * @param moreInfo the more info
     */
    public ImgurRestException(String message, int errorCode, String moreInfo) {
        super(message);

        this.message = message;
        this.errorCode = errorCode;
        this.moreInfo = moreInfo;
    }

    /**
     * Parses the response.
     *
     * @param response the response
     * @return the imgur rest exception
     */
    public static ImgurRestException parseResponse(ImgurRestResponse response) {
        Map<String, Object> data = response.toMap();
        String message = "";
        String moreInfo = "";
        int errorCode = 0;
        if (response.isJson()) {

            ObjectMapper exceptionMapper = new ObjectMapper();

            try {
                JsonNode jsonExceptionNode = exceptionMapper.readTree(response.getResponseText());
                JsonNode jsonExceptionData = jsonExceptionNode.findValue("data");

                if(jsonExceptionData!=null){
                    JsonNode jsonError = jsonExceptionData.findValue("error");
                    message = jsonError.asText("Oops!! We were unable to process your request at this time (imgur-java-error)");
                }

                JsonNode jsonExceptionStatusCode = jsonExceptionNode.findValue("status");
                if(jsonExceptionStatusCode!=null){
                    errorCode = jsonExceptionStatusCode.asInt();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            moreInfo = "";
        }
        System.out.println("message:"+message+ " errorCode:"+errorCode+ " moreInfo:"+moreInfo);
        return new ImgurRestException(message, errorCode, moreInfo);
    }

    /**
     * Gets the error code.
     *
     * @return the error code
     */
    public int getErrorCode() {
        return this.errorCode;
    }

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return this.message;
    }

    /**
     * Gets the more info.
     *
     * @return the more info
     */
    public String getMoreInfo() {
        return moreInfo;
    }

}
