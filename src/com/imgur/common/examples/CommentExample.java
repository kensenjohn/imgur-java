package com.imgur.common.examples;

import com.imgur.bean.AccountBean;
import com.imgur.bean.AlbumBean;
import com.imgur.bean.CommentBean;
import com.imgur.request.CommentRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestRequest;
import com.imgur.sdk.api.Account;
import com.imgur.sdk.api.Comment;

import java.util.ArrayList;

/**
 * Created by root on 10/23/14.
 */
public class CommentExample {

    public static void main(String[] args){
        try{
            ImgurRestRequest imgurRestRequest = new ImgurRestRequest();
            imgurRestRequest.setAcceptToken("cd0066d428f2056f3e4c2a98b5b98eb2722f1bb2");

            ImgurRestClient imgurRestClient = new ImgurRestClient(imgurRestRequest);

            Account account = imgurRestClient.getAccount();
            AccountBean accountInfo = account.getAccountInfo();

            ArrayList<CommentBean> arrCommentBean = account.getComments();

            if(arrCommentBean!=null && !arrCommentBean.isEmpty()) {
                for(CommentBean tmpCommentBean : arrCommentBean){
                    CommentRequest commentRequest = new CommentRequest();
                    commentRequest.setId(tmpCommentBean.getId().toString());

                    Comment comment = imgurRestClient.getComment(commentRequest);
                    CommentBean commentBean = comment.getCommentInfo();
                    System.out.println("commentBean : " + commentBean);
                }
            }

            // Creating a comment
            CommentRequest commentCreateRequest = new CommentRequest();
            commentCreateRequest.setComment("Slurping Tasty");
            commentCreateRequest.setImageId("");  // specify the image_id
            commentCreateRequest.setParentId("0");

            Comment commentCreator = imgurRestClient.getComment(commentCreateRequest);
            // CommentBean commentBean = commentCreator.createComment();  // Commenting it out to preent spamming
            // System.out.println("created commentBean : " + commentBean);


            // Delete Comment
            try {

                CommentRequest commentDeletRequest = new CommentRequest();
                commentDeletRequest.setId("302609004");

                Comment commentDeletor = imgurRestClient.getComment(commentDeletRequest);
                boolean isSuccess =commentDeletor.deleteComment();
                if(isSuccess) {
                    System.out.println("success commentDeletor : " + isSuccess);
                } else {
                    System.out.println("did not delete comment, comment maybe missing : " + isSuccess);
                }
            }  catch (ImgurRestException e){
                System.out.println("Error Message " + e.getErrorMessage() + " Code : " + e.getErrorCode() );

                e.printStackTrace();
            }

            // Replies
            CommentRequest commentRepliesRequest = new CommentRequest();
            commentRepliesRequest.setId("302607792");

            Comment commentReplies = imgurRestClient.getComment(commentRepliesRequest);
            CommentBean commentRepliesBean = commentReplies.getReplies();
            System.out.println("commentRepliesBean : " + commentRepliesBean);

            // Create Reply
            CommentRequest createReplyRequest = new CommentRequest();
            createReplyRequest.setId("302607792");
            createReplyRequest.setImageId( "oIqEa" );
            createReplyRequest.setComment("Crying for Help!! Help me.");

            Comment commentCreateReply = imgurRestClient.getComment(createReplyRequest);
            // CommentBean commentBean = commentCreateReply.createReply();  // commented to prevent spamming
            // System.out.println("Comment Reply : " + commentBean );


            // Vote Comment Down
            CommentRequest voteDownRequest = new CommentRequest();
            voteDownRequest.setId("142162068");

            Comment commentVoteDown = imgurRestClient.getComment(voteDownRequest);
            commentVoteDown.voteUp();

        }  catch (ImgurRestException e){
            System.out.println("Error Message " + e.getErrorMessage() + " Code : " + e.getErrorCode() );

            e.printStackTrace();
        }
    }
}
