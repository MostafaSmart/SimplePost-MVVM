package com.example.myapplication.views.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.MVVM.ModelFactory.AuthViewModelFactory;
import com.example.myapplication.R;
import com.example.myapplication.MVVM.ViewModel.AuthViewModel;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.data.ResponseClass.LoginResponse;
import com.example.myapplication.views.activtys.SelectOptionsActivity;


public class LoginFragment extends Fragment {

    private AuthViewModel authViewModel;

    private String mParam1;
    private String mParam2;
    private android.widget.Button btnLogin;
    private com.google.android.material.textfield.TextInputEditText inpuEmailLoin;
    private com.google.android.material.textfield.TextInputEditText inputPasswordLoin;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserRepository userRepository = new UserRepository(requireContext());
        AuthViewModelFactory factory = new AuthViewModelFactory(userRepository);
        authViewModel = new ViewModelProvider(this, factory).get(AuthViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        implemnt(view);
        btnLogin.setOnClickListener(v -> {
            doLogin();
        });

        setList();
        return view;
    }

    private void doLogin() {
        String email = inpuEmailLoin.getText().toString().trim();
        String password = inputPasswordLoin.getText().toString().trim();

        if (!email.isEmpty() && !password.isEmpty()) {
            authViewModel.login(email, password);
        } else {
            Toast.makeText(getContext(), "الرجاء إدخال البريد الإلكتروني وكلمة المرور", Toast.LENGTH_SHORT).show();
        }
    }


    private void setList(){
        Intent intent = new Intent(getContext(), SelectOptionsActivity.class);

        authViewModel.getLoginResponse().observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse response) {
                if (response != null && response.isSuccess()) {


                    getContext().startActivity(intent);

                } else {
                    Toast.makeText(getContext(), "فشل تسجيل الدخول!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void implemnt(View view) {
        btnLogin = view.findViewById(R.id.btnLogin);
        inpuEmailLoin = view.findViewById(R.id.inpuEmailLoin);
        inputPasswordLoin = view.findViewById(R.id.inputPasswordLoin);
    }


}