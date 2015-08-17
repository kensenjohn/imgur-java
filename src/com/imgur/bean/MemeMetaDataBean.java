package com.imgur.bean;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/2/14
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MemeMetaDataBean {

    /*
    meme_name	String	The name of the meme used.
top_text	String	The top text of the meme.
bottom_text	String	The bottom text of the meme.
bg_image
     */

    private String memeName = "";
    private String topText = "";
    private String bottomText = "";
    private String backgroundImage = "";

    public String getMemeName() {
        return memeName;
    }

    public void setMemeName(String memeName) {
        this.memeName = memeName;
    }

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(String bottomText) {
        this.bottomText = bottomText;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}
