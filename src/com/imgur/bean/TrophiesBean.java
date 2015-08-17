package com.imgur.bean;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TrophiesBean {
    /*
    Trophy Object Information
Key	Format	Description
id	integer	The ID of the trophy, this is unique to each trophy
name	string	The name of the trophy
name_clean	string	Can be thought of as the ID of a trophy type
description	string	A description of the trophy and how it was earned.
data	string	The ID of the image or the ID of the comment where the trophy was earned
data_link	string	A link to where the trophy was earned
datetime	integer	Date the trophy was earned, epoch time
image	string	URL of the image representing the trophy
     */

    private String id = "";
    private String name = "";
    private String nameClean = "";
    private String description = "";
    private String data = "";
    private String dataLink = "";
    private Long dateTime = 0L;
    private String image = "";

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

    public String getNameClean() {
        return nameClean;
    }

    public void setNameClean(String nameClean) {
        this.nameClean = nameClean;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataLink() {
        return dataLink;
    }

    public void setDataLink(String dataLink) {
        this.dataLink = dataLink;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
