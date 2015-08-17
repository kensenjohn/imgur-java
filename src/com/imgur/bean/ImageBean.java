package com.imgur.bean;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 8:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageBean {

    public ImageBean() {
    }

    public ImageBean( HashMap<String,Object> hmData ){
        if(hmData!=null && !hmData.isEmpty() ){
            Object objId =  hmData.get("id");
            if( objId!=null ){
                this.id = (String)objId ;
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

            Object objDeleteHash =  hmData.get("deletehash");
            if( objDeleteHash!=null ){
                this.deletehash =  (String)objDeleteHash;
            }

        }
    }

    private String id = "";
    private String title = "";
    private String description = "";
    private Long dateTime = 0L;
    private String type = "";
    private boolean isAnimated = false;
    private Integer width = 0;
    private Integer height = 0;
    private Integer size = 0;
    private Integer views = 0;
    private Integer bandwidth = 0;
    private String deletehash = "";
    private String section = "";
    private String link = "";
    private boolean isFavorite = false;
    private boolean isNSFW = false;
    private String vote = "";
    private String accountUrl = "";

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAnimated() {
        return isAnimated;
    }

    public void setAnimated(boolean animated) {
        isAnimated = animated;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDeletehash() {
        return deletehash;
    }

    public void setDeletehash(String deletehash) {
        this.deletehash = deletehash;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ImageBean{");
        sb.append("id='").append(id).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append(", type='").append(type).append('\'');
        sb.append(", isAnimated=").append(isAnimated);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", size=").append(size);
        sb.append(", views=").append(views);
        sb.append(", bandwidth=").append(bandwidth);
        sb.append(", deletehash='").append(deletehash).append('\'');
        sb.append(", section='").append(section).append('\'');
        sb.append(", link='").append(link).append('\'');
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", isNSFW=").append(isNSFW);
        sb.append(", vote='").append(vote).append('\'');
        sb.append(", accountUrl='").append(accountUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
