package com.imgur.common.examples;

import com.imgur.bean.AlbumBean;
import com.imgur.bean.ImageBean;
import com.imgur.request.AlbumRequest;
import com.imgur.request.ImageRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestRequest;
import com.imgur.sdk.api.Album;
import com.imgur.sdk.api.Image;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/23/14
 * Time: 9:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class AlbumExample {
    public static void main(String[] args){
        try{
            ImgurRestRequest imgurRestRequest = new ImgurRestRequest();
            imgurRestRequest.setAcceptToken("7c98d3a15ca30e8ade5ebfe241a0c47b7212f63e");

            ImgurRestClient imgurRestClient = new ImgurRestClient(imgurRestRequest);


            ImgurRestRequest anonyImgurRestRequest = new ImgurRestRequest();
            anonyImgurRestRequest.setClientId("8cd5f7001304bc5");

            ImgurRestClient anonImgurRestClient = new ImgurRestClient(anonyImgurRestRequest);


            // Creating anymous album
            AlbumRequest albumRequest = new AlbumRequest();
            Album anonAlbum = anonImgurRestClient.getAlbum( albumRequest );
            AlbumBean anonymousAlbumBean = anonAlbum.createAlbum();

            System.out.println("anonymousAlbumBean : " + anonymousAlbumBean );

            // Delete album
            if(anonymousAlbumBean!=null){
                AlbumRequest deleteAlbumRequest = new AlbumRequest();
                deleteAlbumRequest.setDeleteHashId( anonymousAlbumBean.getDeletehash() );

                Album deleteAnonAlbum = anonImgurRestClient.getAlbum( deleteAlbumRequest );
                boolean isSuccess = deleteAnonAlbum.deleteAlbum();
                if(isSuccess){
                    System.out.println("anonymous successfully deleted" );
                }

            }
            albumRequest.setTitle("Hello World : " + new Date() );
            Album album =  imgurRestClient.getAlbum( albumRequest );
            AlbumBean albumBean = album.createAlbum();


            System.out.println("albumBean  : " + albumBean );
            // Favorite An Album
            if(albumBean!=null){
                ImageRequest imageRequest = new ImageRequest();
                imageRequest.setUrl("http://lorempixel.com/1200/800/nightlife/");
                imageRequest.setType("URL");
                imageRequest.setAlbumId( albumBean.getId() );

                Image albumImage = imgurRestClient.getImage(imageRequest);
                ImageBean imageBean = albumImage.imageUpload();
                System.out.println("uploaded imageBean : " + imageBean );

                AlbumRequest favoriteAlbumRequest = new AlbumRequest();
                favoriteAlbumRequest.setId( albumBean.getId() );

                Album favoriteAlbum = imgurRestClient.getAlbum( favoriteAlbumRequest );
                boolean isSuccess = favoriteAlbum.favoriteAnAlbum();
                if(isSuccess){
                    System.out.println("successfully favorited" );
                }



            }


            albumRequest.setTitle("Setting images Album: " + new Date() );
            Album settingImagesAlbum =  imgurRestClient.getAlbum( albumRequest );
            AlbumBean settingImageAlbumBean = settingImagesAlbum.createAlbum();

            if(settingImageAlbumBean!=null){
                ArrayList<String> arrImageIds = new ArrayList<String>();
                arrImageIds.add("GFmRLTy");
                arrImageIds.add("OY5Zm22");

                albumRequest.setId( settingImageAlbumBean.getId() );
                albumRequest.setArrImageId( arrImageIds );

                boolean isSuccess = settingImagesAlbum.setAlbumImages();
                if(isSuccess){
                    System.out.println("successfully set images in album : " + settingImageAlbumBean.getId() );
                }


                // adding new images
                arrImageIds = new ArrayList<String>();
                arrImageIds.add("zitUWih");


                albumRequest.setArrImageId( arrImageIds );
                isSuccess = settingImagesAlbum.addAlbumImages();
                if(isSuccess){
                    System.out.println("successfully added images in album : " + settingImageAlbumBean.getId() );
                }

                // adding new images
                arrImageIds = new ArrayList<String>();
                arrImageIds.add("GFmRLTy");

                albumRequest.setArrImageId( arrImageIds );
                isSuccess = settingImagesAlbum.removeAlbumImages();
                if(isSuccess){
                    System.out.println("successfully removed images in album : " + settingImageAlbumBean.getId() );
                }
            }




        }  catch (ImgurRestException e){
            System.out.println("Error Message " + e.getErrorMessage() + " Code : " + e.getErrorCode() );

            e.printStackTrace();
        }
    }
}
