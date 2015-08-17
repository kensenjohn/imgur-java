package com.imgur.request;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/8/14
 * Time: 7:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumRequest  extends ApiRequest {
    private String id = "";
    private String title = "";
    private String description = "";
    private String privacy = "";
    private String layout = "";
    private String coverid = "";
    private String deleteHashId = "";
    private ArrayList<String> arrImageId = new ArrayList<String>();

    public String getDeleteHashId() {
        return deleteHashId;
    }

    public void setDeleteHashId(String deleteHashId) {
        this.deleteHashId = deleteHashId;
    }

    public ArrayList<String> getArrImageId() {
        return arrImageId;
    }

    public void setArrImageId(ArrayList<String> arrImageId) {
        this.arrImageId = arrImageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getCoverid() {
        return coverid;
    }

    public void setCoverid(String coverid) {
        this.coverid = coverid;
    }
}
