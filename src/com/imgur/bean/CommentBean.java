package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommentBean {

    private String id = "";
    private String imageId = "";
    private String comment = "";
    private String author = "";
    private Integer authorId = 0;
    private boolean onAlbum = false;
    private String albumCover = "";
    private Integer ups = 0;
    private Integer downs = 0;
    private double points = 0.0;
    private Long dateTime = 0L;
    private String parentId = "";
    private boolean isDeleted = false;
    private String vote = "";
    private ArrayList<CommentBean> arrCommentBean = new ArrayList<CommentBean>();

    public CommentBean(HashMap<String,Object> hmData) {
        if(hmData!=null && !hmData.isEmpty()) {
            Object objId = hmData.get("id");
            if (objId != null) {
                if(objId instanceof Integer){
                    this.id =  ( (Integer) objId ).toString();
                } else {
                    this.id = (String) objId;
                }

            }

            Object objImageId = hmData.get("image_id");
            if (objImageId != null) {
                this.imageId = (String) objImageId;
            }

            Object objComment = hmData.get("comment");
            if (objComment != null) {
                this.comment = (String) objComment;
            }

            Object objAuthor = hmData.get("author");
            if (objAuthor != null) {
                this.author = (String) objAuthor;
            }

            Object objAuthorId = hmData.get("author_id");
            if (objAuthorId != null) {
                this.authorId = ((Integer)objAuthorId);
            }

            Object objOnAlbum = hmData.get("on_album");
            if (objOnAlbum != null) {
                this.onAlbum = (Boolean) objOnAlbum;
            }

            Object objAlbumCover = hmData.get("album_cover");
            if (objAlbumCover != null) {
                this.albumCover = (String) objAlbumCover;
            }

            Object objUps =  hmData.get("ups");
            if( objUps!=null ){
                this.ups =  (Integer)objUps;
            }

            Object objDowns =  hmData.get("downs");
            if( objDowns!=null ){
                this.downs =  (Integer)objDowns;
            }

            Object objPoints =  hmData.get("points");
            if( objPoints!=null ){
                this.points = new Double(  (Integer)objPoints );
            }

            Object objDateTime=  hmData.get("datetime");
            if( objDateTime!=null ){
                this.dateTime = new Long( (Integer) objDateTime );
            }

            Object objParentId = hmData.get("parent_id");
            if (objParentId != null) {
                this.parentId = ((Integer) objParentId).toString();
            }

            Object objDeleted = hmData.get("deleted");
            if (objDeleted != null) {
                this.isDeleted = (Boolean) objDeleted;
            }

            Object objVote = hmData.get("vote");
            if (objVote != null) {
                this.vote = (String) objVote;
            }

            Object objChildren = hmData.get("children");
            if(objChildren!=null){
                ArrayList<HashMap<String,Object>> arrHmChildren = (ArrayList<HashMap<String,Object>>) objChildren;

                if(arrHmChildren!=null && !arrHmChildren.isEmpty() ){
                    for( HashMap<String,Object> hmChildCommentBean : arrHmChildren ) {
                        CommentBean childCommentBean = new CommentBean( hmChildCommentBean );

                        this.arrCommentBean.add( childCommentBean );
                    }
                }
            }
        }
    }

    public CommentBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public boolean isOnAlbum() {
        return onAlbum;
    }

    public void setOnAlbum(boolean onAlbum) {
        this.onAlbum = onAlbum;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public ArrayList<CommentBean> getArrCommentBean() {
        return arrCommentBean;
    }

    public void setArrCommentBean(ArrayList<CommentBean> arrCommentBean) {
        this.arrCommentBean = arrCommentBean;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentBean{");
        sb.append("id=").append(id);
        sb.append(", imageId='").append(imageId).append('\'');
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", authorId='").append(authorId).append('\'');
        sb.append(", onAlbum=").append(onAlbum);
        sb.append(", albumCover='").append(albumCover).append('\'');
        sb.append(", ups=").append(ups);
        sb.append(", downs=").append(downs);
        sb.append(", points=").append(points);
        sb.append(", dateTime=").append(dateTime);
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", vote='").append(vote).append('\'');
        sb.append(", arrCommentBean=").append(arrCommentBean);
        sb.append('}');
        return sb.toString();
    }
}
