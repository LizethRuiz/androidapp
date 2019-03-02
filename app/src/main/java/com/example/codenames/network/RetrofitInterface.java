package com.example.codenames.network;

import com.example.codenames.Clases.Room;
import com.example.codenames.Clases.User;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface RetrofitInterface {
    @POST("users")
    Observable<com.example.codenames.Clases.Response> register(@Body User user);

    @POST("rooms")
    Observable<com.example.codenames.Clases.Response> createroom(@Body Room room);

    @POST("authenticate")
    Observable<com.example.codenames.Clases.Response> login();

    @GET("users/{email}")
    Observable<User> getProfile(@Path("email") String email);

    @PUT("users/{email}")
    Observable<com.example.codenames.Clases.Response> changePassword(@Path("email") String email, @Body User user);

    @POST("users/{email}/password")
    Observable<com.example.codenames.Clases.Response> resetPasswordInit(@Path("email") String email);

    @POST("users/{email}/password")
    Observable<com.example.codenames.Clases.Response> resetPasswordFinish(@Path("email") String email, @Body User user);
}

