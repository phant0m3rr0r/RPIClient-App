package com.example.rpiclient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/screenoff")
    Call<Void> executeScreenOff(@Body HashMap<String, String> map);

    @POST("/screenon")
    Call<Void> executeScreenOn(@Body HashMap<String, String> map);

    @POST("/screen10")
    Call<Void> executeScreen10(@Body HashMap<String, String> map);

    @POST("/screen20")
    Call<Void> executeScreen20(@Body HashMap<String, String> map);

    @POST("/screen30")
    Call<Void> executeScreen30(@Body HashMap<String, String> map);

    @POST("/screen40")
    Call<Void> executeScreen40(@Body HashMap<String, String> map);

    @POST("/screen50")
    Call<Void> executeScreen50(@Body HashMap<String, String> map);

    @POST("/screen60")
    Call<Void> executeScreen60(@Body HashMap<String, String> map);

    @POST("/screen70")
    Call<Void> executeScreen70(@Body HashMap<String, String> map);

    @POST("/screen80")
    Call<Void> executeScreen80(@Body HashMap<String, String> map);

    @POST("/screen90")
    Call<Void> executeScreen90(@Body HashMap<String, String> map);

    @POST("/screen100")
    Call<Void> executeScreen100(@Body HashMap<String, String> map);
}
