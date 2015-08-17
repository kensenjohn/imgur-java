package com.imgur.bean;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 2:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class GalleryImageBean extends GalleryBean{

    public GalleryImageBean(){
        super();
    }


    public GalleryImageBean(HashMap<String,Object> hmData){
        super(hmData);

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
                this.title =  (String)objDescription;
            }

            Object objDateTime=  hmData.get("datetime");
            if( objDateTime!=null ){
                this.dateTime = new Long( (Integer) objDateTime );
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
    private String link = "";
    private String vote = "";
    private boolean isFavorite = false;
    private boolean isNSFW = false;
    private String section = "";
    private String accountUrl = "";
    private String accountId = "";
    private Integer ups = 0;
    private Integer down = 0;
    private Integer score = 0;
    private boolean isAlbum = false;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GalleryImageBean{");
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
        sb.append(", link='").append(link).append('\'');
        sb.append(", vote='").append(vote).append('\'');
        sb.append(", isFavorite=").append(isFavorite);
        sb.append(", isNSFW=").append(isNSFW);
        sb.append(", section='").append(section).append('\'');
        sb.append(", accountUrl='").append(accountUrl).append('\'');
        sb.append(", accountId='").append(accountId).append('\'');
        sb.append(", ups=").append(ups);
        sb.append(", down=").append(down);
        sb.append(", score=").append(score);
        sb.append(", isAlbum=").append(isAlbum);
        sb.append('}');
        return sb.toString();
    }
}
