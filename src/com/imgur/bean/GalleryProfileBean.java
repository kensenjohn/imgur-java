package com.imgur.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class GalleryProfileBean {

    public GalleryProfileBean() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GalleryProfileBean{");
        sb.append("totalGalleryComments=").append(totalGalleryComments);
        sb.append(", totalGalleryFavorites=").append(totalGalleryFavorites);
        sb.append(", totalGallerySubmissions=").append(totalGallerySubmissions);
        sb.append(", arrTrophiesBean=").append(arrTrophiesBean);
        sb.append('}');
        return sb.toString();
    }

    public GalleryProfileBean(HashMap<String,Object> hmData) {
        if(hmData!=null){
            Object objTotalGalleryComments =  hmData.get("total_gallery_comments");
            if( objTotalGalleryComments!=null ){
                this.totalGalleryComments = (Integer)objTotalGalleryComments;
            }

            Object objTotalGalleryFavorites =  hmData.get("total_gallery_favorites");
            if( objTotalGalleryFavorites!=null ){
                this.totalGalleryFavorites = (Integer)objTotalGalleryFavorites;
            }

            Object objTotalGallerySubmissions =  hmData.get("total_gallery_submissions");
            if( objTotalGallerySubmissions!=null ){
                this.totalGallerySubmissions = (Integer)objTotalGallerySubmissions;
            }
        }
    }
    /*
    total_gallery_comments	integer	Total number of comments the user has made in the gallery
total_gallery_favorites	integer	Total number of items favorited by the user in the gallery
total_gallery_submissions	integer	Total number of images submitted by the user.
trophies	Array	An array of trophies that the user has.



    {
    "data": {
        "total_gallery_comments": 40,
        "total_gallery_likes": 23,
        "total_gallery_submissions": 4,
        "trophies": [
            {
                "id": 1,
                "name": "1 Year",
                "name_clean": "1Years",
                "description": "Be a member of Imgur for one year.",
                "data": null,
                "data_link": null,
                "datetime": 1357344455,
                "image": "http://s.imgur.com/images/trophies/a84ade.png"
            }
        ]
    },
    "success": true,
    "status": 200
}
     */

    private Integer totalGalleryComments = 0;
    private Integer totalGalleryFavorites = 0;
    private Integer totalGallerySubmissions = 0;

    private ArrayList<TrophiesBean> arrTrophiesBean = new ArrayList<TrophiesBean>();

    public Integer getTotalGalleryComments() {
        return totalGalleryComments;
    }

    public void setTotalGalleryComments(Integer totalGalleryComments) {
        this.totalGalleryComments = totalGalleryComments;
    }

    public Integer getTotalGalleryFavorites() {
        return totalGalleryFavorites;
    }

    public void setTotalGalleryFavorites(Integer totalGalleryFavorites) {
        this.totalGalleryFavorites = totalGalleryFavorites;
    }

    public Integer getTotalGallerySubmissions() {
        return totalGallerySubmissions;
    }

    public void setTotalGallerySubmissions(Integer totalGallerySubmissions) {
        this.totalGallerySubmissions = totalGallerySubmissions;
    }

    public ArrayList<TrophiesBean> getArrTrophiesBean() {
        return arrTrophiesBean;
    }

    public void setArrTrophiesBean(ArrayList<TrophiesBean> arrTrophiesBean) {
        this.arrTrophiesBean = arrTrophiesBean;
    }
}
