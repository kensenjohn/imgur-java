package com.imgur.request;

/**
 * Created by root on 10/24/14.
 */
public class AccountRequest extends ApiRequest{
    private String albumId = "";
    private String commentId = "";
    private String imageId = "";
    private boolean showNewNotifications = true;

    public boolean isShowNewNotifications() {
        return showNewNotifications;
    }

    public void setShowNewNotifications(boolean showNewNotifications) {
        this.showNewNotifications = showNewNotifications;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
}
