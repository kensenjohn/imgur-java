package com.imgur.request;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/8/14
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageRequest extends ApiRequest{
    private String id = "";
    private String albumId = "";
    private String name = "";
    private String title = "";
    private String url = "";
    private String base64 = "";
    private String type = "";
    private String description = "";
    private String file =  "";

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
