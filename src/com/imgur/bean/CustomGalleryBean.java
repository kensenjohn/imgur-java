package com.imgur.bean;

import java.util.ArrayList;

/**
 * Created by root on 10/28/14.
 */
public class CustomGalleryBean {

    /*
    id	string	The ID for the custom gallery
name	string	Name of the custom gallery
datetime	int	Time custom gallery was created, epoch time
account_url	string	Username of the account that created the custom gallery
link	string	The URL link to the custom gallery
tags	array	An array of all the tag names in the custom gallery
item_count	integer	The total number of gallery items in the custom gallery (only available when requesting the direct custom gallery).
items	Array of Gallery Images and Gallery Albums
     */

    private String id = "";
    private String name = "";
    private Long dateTime = 0L;
    private String accountUrl = "";
    private String link = "";
    private ArrayList<String> arrTags = new ArrayList<String>();
    private Integer itemCount = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getAccountUrl() {
        return accountUrl;
    }

    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<String> getArrTags() {
        return arrTags;
    }

    public void setArrTags(ArrayList<String> arrTags) {
        this.arrTags = arrTags;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}
