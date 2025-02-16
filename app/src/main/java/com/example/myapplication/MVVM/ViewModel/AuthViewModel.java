package com.example.myapplication.MVVM.ViewModel;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Models.User;
import com.example.myapplication.data.Preferences.UserPreferences;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.data.ResponseClass.LoginResponse;
import com.example.myapplication.data.Retrofit.ApiClient;
import com.example.myapplication.data.Retrofit.AuthApi;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AuthViewModel extends ViewModel {
    private MutableLiveData<LoginResponse> loginResponse;
    private UserRepository userRepository;


    private MutableLiveData<LoginResponse> signResponse;

    public AuthViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loginResponse = new MutableLiveData<>();
        this.signResponse = new MutableLiveData<>();
    }

    public boolean isLoggedIn() {
        return userRepository.isLoggedIn();
    }

    public void login(String email, String password) {
        userRepository.login(email, password).observeForever(response -> loginResponse.setValue(response));
    }

    public void signUp(String name,String email, String password) {
        userRepository.signUp(name,email, password).observeForever(response -> signResponse.setValue(response));
    }
    public LiveData<LoginResponse> getLoginResponse() {
        return loginResponse;
    }
    public LiveData<LoginResponse> getSignResponse() {
        return signResponse;
    }

}



