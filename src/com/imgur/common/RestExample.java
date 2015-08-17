package com.imgur.common;

import com.imgur.bean.*;
import com.imgur.request.AlbumRequest;
import com.imgur.request.ImageRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.api.Account;
import com.imgur.sdk.api.Album;
import com.imgur.sdk.api.Image;
import com.imgur.sdk.ImgurRestRequest;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 10/1/14
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestExample {

    public static void main(String[] args){

        try{
            ImgurRestRequest imgurRestRequest = new ImgurRestRequest();
            imgurRestRequest.setAcceptToken("03ed837425fa35cb0d390a82254dfa1326ff242d");


            ImgurRestClient imgurRestClient = new ImgurRestClient(imgurRestRequest);

            Account account = imgurRestClient.getAccount();
            AccountBean accountInfo = account.getAccountInfo();
            account.getAccountGalleryFavorites();
            account.getAccountFavorites();
            AccountSettingsBean accountSettingsBean = account.getAccountSettings();
            System.out.println("accountSettingsBean : " + accountSettingsBean );



            GalleryProfileBean galleryProfileBean = account.getAccountGalleryProfile();
            System.out.println("galleryProfileBean : " + galleryProfileBean );

            ArrayList<AlbumBean> arrAlbumBean = account.getAlbums();

            if(arrAlbumBean!=null && !arrAlbumBean.isEmpty()) {

                for(AlbumBean tmpAlbumBean : arrAlbumBean){
                    AlbumRequest albumRequest = new AlbumRequest();
                    albumRequest.setId(tmpAlbumBean.getId());

                    Album album = imgurRestClient.getAlbum(albumRequest);
                    AlbumBean albumBean = album.getAlbumInfo();

                    ArrayList<ImageBean> arrImageBean = album.getAlbumImages();
                    System.out.println("albumBean : " + albumBean );
                    if(arrImageBean!=null && !arrImageBean.isEmpty()) {
                        for(ImageBean imageBean : arrImageBean ){
                            System.out.println("imageBean : " + imageBean );
                        }
                    }

                    ImageRequest imageRequest = new ImageRequest();
                    imageRequest.setUrl("http://lorempixel.com/1200/800/sports/");
                    imageRequest.setType("URL");
                    imageRequest.setAlbumId(albumBean.getId());

                    Image image = imgurRestClient.getImage(imageRequest);
                    ImageBean imageBean = image.imageUpload();

                    System.out.println("imageBean : " + imageBean );



                    //Setting an image as Favorite
                    ImageRequest imageFavoriteRequest = new ImageRequest();
                    imageFavoriteRequest.setId(imageBean.getDeletehash());

                    Image favoriteImage = imgurRestClient.getImage(imageFavoriteRequest);
                    boolean isSuccessFavorite = favoriteImage.favoriteAnImage();
                    if(isSuccessFavorite){
                        System.out.println("Image successfully favotired ");
                    } else {
                        System.out.println("favotired of Image failed.");

                    }

                }
            }
            ImageRequest imageDeleteRequest = new ImageRequest();
            // Delete an image
            try{
                String imageID = "trwe";
                imageDeleteRequest.setId( imageID );

                Image imageDeleteImage = imgurRestClient.getImage(imageDeleteRequest);
                boolean isSucces = imageDeleteImage.deleteImage();
                if(isSucces){
                    System.out.println("successfully deleted : " + imageID );
                } else {
                    System.out.println("failed deleting : " + imageID );
                }
            } catch (ImgurRestException e){
                System.out.println("message : " + e.getErrorMessage() );
            }


            ImgurRestRequest anonyImgurRestRequest = new ImgurRestRequest();
            anonyImgurRestRequest.setClientId("8cd5f7001304bc5");

            ImgurRestClient anonImgurRestClient = new ImgurRestClient(anonyImgurRestRequest);



            AlbumRequest albumRequest = new AlbumRequest();
            albumRequest.setTitle("Anonymous Title : " + (new Date()) );
            Album anonAlbum = anonImgurRestClient.getAlbum( albumRequest );

            AlbumBean anonymousAlbumBean = anonAlbum.createAlbum();
            System.out.println("anonymousAlbumBean : " + anonymousAlbumBean );

            ArrayList<String> arrImageId = new ArrayList<String>();
            for(int i = 0; i < 0; i++){
                ImageRequest imageRequest = new ImageRequest();
                imageRequest.setUrl("http://lorempixel.com/1200/800/nightlife/");
                imageRequest.setType("URL");
                imageRequest.setAlbumId( anonymousAlbumBean.getDeletehash() );

                Image anonymousImage = anonImgurRestClient.getImage(imageRequest);

                ImageBean anonymousImageBean = anonymousImage.imageUpload();

                System.out.println("Anonymous imageBean : " + anonymousImageBean );

                arrImageId.add( anonymousImageBean.getId());
            }

            // Base64 image
            {
                File file = new File("/home/kensen/Pictures/bride1.jpg");
                int length = Long.valueOf(file.length()).intValue();
                byte[] byteArray = new byte[length];

                //System.out.println("base64String " + base64String );

                String base64String = "";
                try {
                    base64String = Base64.encode( FileUtils.readFileToByteArray(file) );
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (IOException e ){
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                if(base64String!=null && !"".equalsIgnoreCase(base64String)){
                    // Base64 image
                    ImageRequest imageB64Request = new ImageRequest();
                    imageB64Request.setBase64( base64String );
                    imageB64Request.setType("base64");
                    imageB64Request.setAlbumId( anonymousAlbumBean.getDeletehash() );

                    Image anonymousB64Image = anonImgurRestClient.getImage(imageB64Request);

                    ImageBean anonymousB64ImageBean = anonymousB64Image.imageUpload();
                    System.out.println("Anonymous Base64 imageBean : " + anonymousB64ImageBean);


                    // Updating Image information (Use delete Hash for anonymous image)
                    ImageRequest imageUpdateInfoRequest = new ImageRequest();
                    imageUpdateInfoRequest.setId( anonymousB64ImageBean.getDeletehash() );
                    imageUpdateInfoRequest.setTitle( "Bat For Lashes : Glass" );
                    imageUpdateInfoRequest.setDescription( "Whether it ius a big game or not. simply carve out an apple. " );

                    Image anonymousUpdateImage = anonImgurRestClient.getImage(imageUpdateInfoRequest);
                    boolean isSuccessUpdate = anonymousUpdateImage.updateImageInformation();
                    if(isSuccessUpdate){
                        System.out.println("Image successfully updated ");
                    } else {
                        System.out.println("Update of Image failed.");
                    }
                }

            }


            // Upload Image using Binary File
                ImageRequest imageB64Request = new ImageRequest();
                imageB64Request.setFile( "/home/kensen/Pictures/Groom1.jpg" );
                imageB64Request.setType("file");
                imageB64Request.setAlbumId( anonymousAlbumBean.getDeletehash() );

                Image anonymousB64Image = anonImgurRestClient.getImage(imageB64Request);
                ImageBean anonymousB64ImageBean = anonymousB64Image.imageUpload();

                System.out.println("Image Bean for delete : " + anonymousB64ImageBean.getId()  );
                ImageRequest imageAnonDeleteRequest = new ImageRequest();
                imageAnonDeleteRequest.setId( anonymousB64ImageBean.getDeletehash() );

                // Deleteing anonymous File
                Image imageAnonDeleteImage = anonImgurRestClient.getImage(imageAnonDeleteRequest);
                boolean isAnonDelSucces = imageAnonDeleteImage.deleteImage();
                if(isAnonDelSucces){
                    System.out.println("successfully deleted anonymous image"  );
                } else {
                    System.out.println("failed deleting anonymous image" );
                }
        } catch (ImgurRestException e){
            System.out.println("Error Message " + e.getErrorMessage() + " Code : " + e.getErrorCode() );

            e.printStackTrace();
        }
    }

    public void readExciff(){

    }
}
