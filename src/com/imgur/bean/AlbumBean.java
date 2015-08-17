package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumBean {

    public AlbumBean(){

    }

    public AlbumBean( HashMap<String,Object> hmData ) {
        if(hmData!=null && !hmData.isEmpty()){
            Object objId =  hmData.get("id");
            if( objId!=null ){
                this.id =  (String)objId;
            }

            Object objDeleteHash =  hmData.get("deletehash");
            if( objDeleteHash!=null ){
                this.deletehash =  (String)objDeleteHash;
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

    private String id = "";
    private String title = "";
    private String description = "";
    private Long dateTime = 0L;
    private String coverId = "";
    private Integer coverWidth = 0;
    private Integer coverHeight = 0;
    private String accountUrl = "";
    private String privacy = "";
    private String layout = "";
    private Integer views = 0;
    private String link = "";
    private boolean isFavorite = false;
    private boolean isNSFW = false;
    private String section = "";
    private Integer order = 0;
    private String deletehash = "";
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
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
        final StringBuilder sb = new StringBuilder("AlbumBean{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append(", coverId='").append(coverId).append('\'');
        sb.append(", coverWidth=").append(coverWidth);
        sb.append(", coverHeight=").append(coverHeight);
        sb.append(", accountUrl='").append(accountUrl).append('\'');
        sb.append(", privacy='").append(privacy).append('\'');
        sb.append(", layout='").append(layout).append('\'');
        sb.append(", views=").append(views);
        sb.append(", link='").append(link).append('\'');
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", isNSFW=").append(isNSFW);
        sb.append(", section='").append(section).append('\'');
        sb.append(", order=").append(order);
        sb.append(", deletehash='").append(deletehash).append('\'');
        sb.append(", imageCount=").append(imageCount);
        sb.append(", arrImageBean=").append(arrImageBean);
        sb.append('}');
        return sb.toString();
    }
}
