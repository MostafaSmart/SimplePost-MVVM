package com.example.myapplication.MVVM.ViewModel;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Models.Post;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.data.ResponseClass.ApiResponse;
import com.example.myapplication.data.ResponseClass.LoginResponse;
import com.example.myapplication.data.ResponseClass.PostResponse;
import com.example.myapplication.data.Retrofit.AddPostApi;
import com.example.myapplication.data.Retrofit.ApiClient;
import com.example.myapplication.helpers.FileUtil;
import com.example.myapplication.helpers.FileUtils;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    private MutableLiveData<ApiResponse> apiResponse  = new MutableLiveData<>();
    private MutableLiveData<PostResponse> postResponse  = new MutableLiveData<>();

    public PostViewModel() {

    }

    private static final String TAG = "PostUploader";

    public  void uploadPost(String token, String tital,String desc,File img_file) {
        AddPostApi apiService = ApiClient.getClient().create(AddPostApi.class);

        RequestBody titleBody = RequestBody.create(MediaType.parse("text/plain"), tital);
        RequestBody descrBody = RequestBody.create(MediaType.parse("text/plain"), desc);
        MultipartBody.Part imagePart = null;

        if (img_file != null) {

            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), img_file);
            imagePart = MultipartBody.Part.createFormData("image", img_file.getName(), requestFile);
        }

        Call<ApiResponse> call = apiService.uploadPost("Bearer " + token, titleBody, descrBody, imagePart);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "Success: " + response.body().getMessage());
                    apiResponse.setValue(response.body());

                } else {
                    Log.e(TAG, "Error: " + response.message());
                    apiResponse.setValue(null);

                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.e(TAG, "Request Failed: " + t.getMessage());
                apiResponse.setValue(null);

            }
        });
    }


    public void getAllPosts(){
        AddPostApi apiService = ApiClient.getClient().create(AddPostApi.class);

        Call<PostResponse> call = apiService.getAllPosts();
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "Success: " + response.message());
                    postResponse.setValue(response.body());
                }
                else{
                    postResponse.setValue(null);
                    Log.d(TAG, "Success: " + response.message());

                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                postResponse.setValue(null);
                Log.d(TAG, "Success: " + t.getMessage());
            }
        });
    }



    public LiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    public LiveData<PostResponse> getPostsResponse() {
        return postResponse;
    }

}
