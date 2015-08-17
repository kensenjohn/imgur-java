package com.imgur.sdk.api;

import com.imgur.bean.CommentBean;
import com.imgur.bean.DataBean;
import com.imgur.common.Utility;
import com.imgur.request.ApiRequest;
import com.imgur.request.CommentRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 10/23/14.
 */
public class Comment   extends Resource {

    private CommentRequest commentRequest = new CommentRequest();
    public Comment( ImgurRestClient client ,ApiRequest apiRequest ){
        super(client);
        this.commentRequest = (CommentRequest) apiRequest;
    }


    @Override
    protected String getResourceLocation() {
        return getClient().getEndpoint() + "/" + ImgurRestClient.DEFAULT_VERSION;
    }

    public CommentBean getCommentInfo() throws ImgurRestException {
        CommentBean commentBean = new CommentBean();

        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, commentRequest.getId() );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        Map<String, String> vars = new HashMap<String, String>();
        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateCommentBean();
        if(dataBean!=null){
            commentBean = dataBean.getCommentBean();
        }
        return commentBean;
    }

    public CommentBean createComment() throws ImgurRestException {
        CommentBean commentBean = new CommentBean();
        HashMap<Integer, String> hmResourceName = new HashMap<Integer, String>();
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName);

        Map<String, String> vars = new HashMap<String, String>();

        if( !Utility.isNullOrEmpty(this.commentRequest.getImageId())){
            vars.put("image_id", this.commentRequest.getImageId() );
        } else {
            throw new ImgurRestException("Missing image id", 400 );
        }
        if( !Utility.isNullOrEmpty(this.commentRequest.getComment())){
            vars.put("comment", this.commentRequest.getComment() );
        } else {
            throw new ImgurRestException("Missing comment text", 400 );
        }
        if( !Utility.isNullOrEmpty(this.commentRequest.getParentId())){
            vars.put("parent_id", this.commentRequest.getParentId() );
        } else {
            throw new ImgurRestException("Missing parent id", 400 );
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateCommentBean();
        if(dataBean!=null){
            commentBean = dataBean.getCommentBean();
        }
        return commentBean;
    }

    public boolean deleteComment()  throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.commentRequest.getId() );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "DELETE", new ResourceRequestParams() );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }

        return isSuccess;
    }


    public CommentBean getReplies() throws ImgurRestException{
        CommentBean commentBean = new CommentBean();
        HashMap<Integer,String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0, this.commentRequest.getId() );
        hmResourceName.put(1, "replies" );

        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName) ;

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "GET", new ResourceRequestParams() );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateCommentBean();
        if(dataBean!=null){
            commentBean = dataBean.getCommentBean();
        }
        return commentBean;
    }

    public CommentBean createReply() throws ImgurRestException {
        CommentBean commentBean = new CommentBean();
        HashMap<Integer, String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0,this.commentRequest.getId() );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName);

        Map<String, String> vars = new HashMap<String, String>();

        if( !Utility.isNullOrEmpty(this.commentRequest.getImageId())){
            vars.put("image_id", this.commentRequest.getImageId() );
        } else {
            throw new ImgurRestException("Missing image id", 400 );
        }
        if( !Utility.isNullOrEmpty(this.commentRequest.getComment())){
            vars.put("comment", this.commentRequest.getComment() );
        } else {
            throw new ImgurRestException("Missing comment text", 400 );
        }

        ResourceRequestParams resourceRequestParams = new ResourceRequestParams();
        resourceRequestParams.setVars( vars );
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", resourceRequestParams );

        DataModel dataModel = new DataModel(response);
        DataBean dataBean = dataModel.generateCommentBean();
        if(dataBean!=null){
            commentBean = dataBean.getCommentBean();
        }
        return commentBean;
    }

    public boolean voteUp() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer, String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0,this.commentRequest.getId() );
        hmResourceName.put(1,"vote" );
        hmResourceName.put(2,"up" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName);

        isSuccess = vote(sResourceEndpoint);
        return isSuccess;
    }

    public boolean voteDown() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer, String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0,this.commentRequest.getId() );
        hmResourceName.put(1,"vote" );
        hmResourceName.put(2,"down" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName);

        isSuccess = vote(sResourceEndpoint);
        return isSuccess;
    }

    private boolean  vote(String sResourceEndpoint)  throws ImgurRestException {
        boolean isSuccess = false;
        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }
        return isSuccess;
    }

    public boolean report() throws ImgurRestException {
        boolean isSuccess = false;
        HashMap<Integer, String> hmResourceName = new HashMap<Integer, String>();
        hmResourceName.put(0,this.commentRequest.getId() );
        hmResourceName.put(1,"report" );
        String sResourceEndpoint = getResourceLocation() + generateSubResourceLocation(hmResourceName);

        ImgurRestResponse response = invokeImgurApi( sResourceEndpoint, "POST", new ResourceRequestParams() );
        DataModel dataModel = new DataModel(response);

        DataBean dataBean = dataModel.generateBooleanDataBasicBean();
        if(dataBean!=null){
            isSuccess = dataBean.isSuccess();
        }
        return isSuccess;
    }


    private String generateSubResourceLocation(HashMap<Integer,String> hmResourceName){
        StringBuilder strSubResource = new StringBuilder();
        strSubResource.append("/").append( "comment" );
        if(hmResourceName!=null && !hmResourceName.isEmpty()){
            for(Integer iTrack = 0; iTrack<hmResourceName.size(); iTrack++) {
                strSubResource.append("/").append(hmResourceName.get(iTrack));
            }
        }
        return strSubResource.toString();
    }
}
