package com.example.myapplication.MVVM.ModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MVVM.ViewModel.AuthViewModel;
import com.example.myapplication.data.Repositorys.UserRepository;
public class AuthViewModelFactory implements ViewModelProvider.Factory {
    private final UserRepository userRepository;

    public AuthViewModelFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AuthViewModel.class)) {
            return (T) new AuthViewModel(userRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
