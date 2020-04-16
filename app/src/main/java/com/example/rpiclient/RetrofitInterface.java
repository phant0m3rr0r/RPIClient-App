package com.example.rpiclient;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    //SCREEN PART
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


    //REMOTE PART
    @POST("/mute")
    Call<Void> executeRemoteMute(@Body HashMap<String, String> map);

    @POST("/power")
    Call<Void> executeRemotePower(@Body HashMap<String, String> map);

    @POST("/down")
    Call<Void> executeRemoteDown(@Body HashMap<String, String> map);

    @POST("/up")
    Call<Void> executeRemoteUp(@Body HashMap<String, String> map);

    @POST("/line1")
    Call<Void> executeRemoteLine1(@Body HashMap<String, String> map);

    @POST("/line2")
    Call<Void> executeRemoteLine2(@Body HashMap<String, String> map);

    @POST("/opt")
    Call<Void> executeRemoteOpt(@Body HashMap<String, String> map);

    @POST("/cox")
    Call<Void> executeRemoteCox(@Body HashMap<String, String> map);

    @POST("/bt")
    Call<Void> executeRemoteBT(@Body HashMap<String, String> map);

    @POST("/playpause")
    Call<Void> executeRemotePlayPause(@Body HashMap<String, String> map);

    @POST("/rewind")
    Call<Void> executeRemoteRewind(@Body HashMap<String, String> map);

    @POST("/forward")
    Call<Void> executeRemoteForward(@Body HashMap<String, String> map);

    //LED PART
    @POST("/spotify")
    Call<Void> executeLedSpotify(@Body HashMap<String, String> map);

    @POST("/off")
    Call<Void> executeLedSpotifyOff(@Body HashMap<String, String> map);
}
