package com.example.damo.djg;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Damo on 01-02-2017.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("/useracc.php")
    Call<ResponseBody> signUp(@Field("name") String name, @Field("area") String area, @Field("contact") String contact, @Field("dob") String dob, @Field("age") String age, @Field("adharnumber") String adharnumber, @Field("password") String password, @Field("address") String address,@Field("token") String token);

    // first paste here
    //first paste
    @FormUrlEncoded
    @POST("/fcm/sendMultiplePush.php")
    Call<ResponseBody> sendChat(
                                @Field("title") String title,
                                @Field("message") String message,
                                @Field("adharnumber") String adharnumber
    );

    @FormUrlEncoded
    @POST("/fcm/sendPushAll.php")
    Call<ResponseBody> sendChatAll(
            @Field("title") String title,
            @Field("message") String message
    );


    @POST("/userdetails.php")
    Call<List<ExResponse>> getData();
}
