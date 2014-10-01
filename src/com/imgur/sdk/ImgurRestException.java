package com.imgur.sdk;

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
            message = (String) data.get("message");

            if (data.get("code") != null) {
                errorCode = (Integer) data.get("code");
            }
            if (data.get("more_info") != null) {
                moreInfo = (String) data.get("more_info");
            }
        }

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
