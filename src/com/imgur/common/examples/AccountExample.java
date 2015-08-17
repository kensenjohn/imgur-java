package com.imgur.common.examples;

import com.imgur.request.AccountRequest;
import com.imgur.sdk.ImgurRestClient;
import com.imgur.sdk.ImgurRestException;
import com.imgur.sdk.ImgurRestRequest;
import com.imgur.sdk.api.Account;

import java.util.ArrayList;

/**
 * Created by root on 10/28/14.
 */
public class AccountExample {

    public static void main(String[] args) {
        try {
            ImgurRestRequest imgurRestRequest = new ImgurRestRequest();
            imgurRestRequest.setAcceptToken("20dbdee4fdc10a610d3e05503f3123ac06f643e4");

            ImgurRestClient imgurRestClient = new ImgurRestClient(imgurRestRequest);

            AccountRequest accountRequest = new AccountRequest();
            Account account = imgurRestClient.getAccount(accountRequest);
            ArrayList<String> albumId = account.getAlbumIds();
            account.getAlbumCount();

            accountRequest.setShowNewNotifications( false );
            account.getReplies();

        } catch (ImgurRestException e) {
            System.out.println("Error Message " + e.getErrorMessage() + " Code : " + e.getErrorCode());

            e.printStackTrace();
        }
    }
}
