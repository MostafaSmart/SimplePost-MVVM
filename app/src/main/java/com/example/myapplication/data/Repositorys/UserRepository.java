package com.example.myapplication.data.Repositorys;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.data.Models.User;
import com.example.myapplication.data.Preferences.UserPreferences;
import com.example.myapplication.data.ResponseClass.LoginResponse;
import com.example.myapplication.data.Retrofit.ApiClient;
import com.example.myapplication.data.Retrofit.AuthApi;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private UserPreferences userPreferences;
    private AuthApi api;

    public UserRepository(Context context) {
        this.userPreferences = new UserPreferences(context);
        this.api = ApiClient.getClient().create(AuthApi.class);
    }

    public LiveData<LoginResponse> login(String email, String password) {
        MutableLiveData<LoginResponse> loginLiveData = new MutableLiveData<>();

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);

        Call<LoginResponse> call = api.loginUser(requestBody);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // حفظ بيانات المستخدم بعد تسجيل الدخول
                    userPreferences.saveUser(response.body().getUser());
                    loginLiveData.setValue(response.body());
                } else {
                    Log.d("API_RESPONSE", response.toString());
                    loginLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                loginLiveData.setValue(null);
            }
        });

        return loginLiveData;
    }


    public LiveData<LoginResponse> signUp(String name,String email, String password) {
        MutableLiveData<LoginResponse> loginLiveData = new MutableLiveData<>();

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("email", email);
        requestBody.put("password", password);

        Log.d("data_request" ,requestBody.toString());

        Call<LoginResponse> call = api.signUpUser(requestBody);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    userPreferences.saveUser(response.body().getUser());
                    loginLiveData.setValue(response.body());
                    Log.d("API_RESPONSE", response.toString());

                    Log.d("API_RESPONSE22", response.body().getMessage());

                } else {
                    Log.d("API_RESPONSE", response.toString());
                    loginLiveData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("API_ERROR", t.getMessage());
                loginLiveData.setValue(null);
            }
        });

        return loginLiveData;
    }
    public void saveUser(User user) {
        userPreferences.saveUser(user);
    }

    public boolean isLoggedIn() {
        return userPreferences.isLoggedIn();
    }

    public void logout() {
        userPreferences.logout();
    }
}

