package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class GalleryAlbumBean extends GalleryBean {

    public GalleryAlbumBean(){
        super();
    }


    public GalleryAlbumBean(HashMap<String,Object> hmData){
        super(hmData);

        if(hmData!=null){
            Object objId =  hmData.get("id");
            if( objId!=null ){
                this.id =  (String)objId;
            }

            Object objTitle =  hmData.get("title");
            if( objTitle!=null ){
                this.title =  (String)objTitle;
            }

            Object objDescription =  hmData.get("description");
            if( objDescription!=null ){
                this.description =  (String)objDescription;
            }

            Object objDateTime=  hmData.get("datetime");
            if( objDateTime!=null ){
                this.dateTime = new Long( (Integer) objDateTime );
            }

            Object objCover =  hmData.get("cover");
            if( objCover!=null ){
                this.coverId =  (String)objCover;
            }

            Object objCoverWidth =  hmData.get("cover_width");
            if( objCoverWidth!=null ){
                this.coverWidth =  (Integer)objCoverWidth;
            }

            Object objCoverHeight =  hmData.get("cover_height");
            if( objCoverHeight!=null ){
                this.coverHeight =  (Integer)objCoverHeight;
            }

            Object objAccountUrl =  hmData.get("account_url");
            if( objAccountUrl!=null ){
                this.accountUrl =  (String)objAccountUrl;
            }
        }
    }

    /*
         id	string	The ID for the image
title	string	The title of the album in the gallery
description	string	The description of the album in the gallery
datetime	integer	Time inserted into the gallery, epoch time
cover	string	The ID of the album cover image
cover_width	integer	The width, in pixels, of the album cover image
cover_height	integer	The height, in pixels, of the album cover image
account_url	string	The account username or null if it's anonymous.
account_id	integer	The account ID of the account that uploaded it, or null.
privacy	string	The privacy level of the album, you can only view public if not logged in as album owner
layout	string	The view layout of the album.
views	integer	The number of image views
link	string	The URL link to the album
ups	integer	Upvotes for the image
downs	integer	Number of downvotes for the image
score	integer	Imgur popularity score
is_album	boolean	if it's an album or not
vote	string	The current user's vote on the album. null if not signed in or if the user hasn't voted on it.
favorite	boolean	Indicates if the current user favorited the album. Defaults to false if not signed in.
nsfw	boolean	Indicates if the album has been marked as nsfw or not. Defaults to null if information is not available.
images_count	integer	The total number of images in the album
images	Array of Images	An array of all the images in the album (only available when requesting the direct album)
     */

    private String id = "";
    private String title = "";
    private String description = "";
    private Long dateTime = 0L;
    private String coverId = "";
    private Integer coverWidth = 0;
    private Integer coverHeight = 0;
    private String accountUrl = "";
    private String accountId = "";
    private String privacy = "";
    private String layout = "";
    private Integer views = 0;
    private String link = "";
    private Integer ups = 0;
    private Integer down = 0;
    private Integer score = 0;
    private boolean isAlbum = false;
    private boolean isFavorite = false;
    private boolean isNSFW = false;
    private Integer imageCount = 0;
    private ArrayList<ImageBean> arrImageBean = new ArrayList<ImageBean>();

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

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getCoverId() {
        return coverId;
    }

    public void setCoverId(String coverId) {
        this.coverId = coverId;
    }

    public Integer getCoverWidth() {
        return coverWidth;
    }

    public void setCoverWidth(Integer coverWidth) {
        this.coverWidth = coverWidth;
    }

    public Integer getCoverHeight() {
        return coverHeight;
    }

    public void setCoverHeight(Integer coverHeight) {
        this.coverHeight = coverHeight;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isAlbum() {
        return isAlbum;
    }

    public void setAlbum(boolean album) {
        isAlbum = album;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isNSFW() {
        return isNSFW;
    }

    public void setNSFW(boolean NSFW) {
        isNSFW = NSFW;
    }

    public Integer getImageCount() {
        return imageCount;
    }

    public void setImageCount(Integer imageCount) {
        this.imageCount = imageCount;
    }

    public ArrayList<ImageBean> getArrImageBean() {
        return arrImageBean;
    }

    public void setArrImageBean(ArrayList<ImageBean> arrImageBean) {
        this.arrImageBean = arrImageBean;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GalleryAlbumBean{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append(", coverId='").append(coverId).append('\'');
        sb.append(", coverWidth=").append(coverWidth);
        sb.append(", coverHeight=").append(coverHeight);
        sb.append(", accountUrl='").append(accountUrl).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", privacy='").append(privacy).append('\'');
        sb.append(", layout='").append(layout).append('\'');
        sb.append(", views=").append(views);
        sb.append(", link='").append(link).append('\'');
        sb.append(", ups=").append(ups);
        sb.append(", down=").append(down);
        sb.append(", score=").append(score);
        sb.append(", isAlbum=").append(isAlbum);
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", isNSFW=").append(isNSFW);
        sb.append(", imageCount=").append(imageCount);
        sb.append(", arrImageBean=").append(arrImageBean);
        sb.append('}');
        return sb.toString();
    }
}
