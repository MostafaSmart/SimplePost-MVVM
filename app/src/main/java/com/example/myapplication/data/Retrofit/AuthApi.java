package com.example.myapplication.data.Retrofit;

import com.example.myapplication.data.Models.User;
import com.example.myapplication.data.ResponseClass.LoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {
    @POST("back_endone/auth/login.php")
    Call<LoginResponse> loginUser(@Body Map<String, String> requestBody);


    @POST("back_endone/auth/sginup.php")
    Call<LoginResponse> signUpUser(@Body Map<String, String> requestBody);
}

