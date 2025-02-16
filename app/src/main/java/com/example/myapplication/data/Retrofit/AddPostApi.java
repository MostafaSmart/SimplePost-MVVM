package com.example.myapplication.data.Retrofit;

import com.example.myapplication.data.ResponseClass.ApiResponse;
import com.example.myapplication.data.ResponseClass.PostResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AddPostApi {

    @Multipart
    @POST("back_endone/posts/add_post.php")
    Call<ApiResponse> uploadPost(
            @Header("Authorization") String token,
            @Part("title") RequestBody title,
            @Part("descr") RequestBody descr,
            @Part MultipartBody.Part image
    );


    @GET("back_endone/posts/get_post.php")
    Call<PostResponse> getAllPosts();


}
