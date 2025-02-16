package com.example.myapplication.views.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.MVVM.ModelFactory.AuthViewModelFactory;
import com.example.myapplication.MVVM.ViewModel.AuthViewModel;
import com.example.myapplication.R;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.data.ResponseClass.LoginResponse;


public class SignUpFragment extends Fragment {
    private AuthViewModel authViewModel;

    private android.widget.Button btnSginUp;
    private com.google.android.material.textfield.TextInputEditText inpuNameSign;
    private com.google.android.material.textfield.TextInputEditText inpuEmailSign;
    private com.google.android.material.textfield.TextInputEditText inputPasswordSign;





    public SignUpFragment() {
        // Required empty public constructor
    }



    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);
        imelmnt(view);

        setList();

        btnSginUp.setOnClickListener(v -> {

            doSignUp(inpuNameSign.getText().toString().trim(),inpuEmailSign.getText().toString().trim(),inputPasswordSign.getText().toString().trim());


        });

        return view;

    }

    private void doSignUp(String name, String email, String password) {

        authViewModel.signUp(name,email, password);
    }


    private void setList(){
        authViewModel.getSignResponse().observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
            @Override
            public void onChanged(LoginResponse response) {
                if (response != null && response.isSuccess()) {



                } else {
                    Toast.makeText(getContext(), "فشل تسجيل حساب!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void imelmnt(View view) {
        btnSginUp = view.findViewById(R.id.btnSginUp);
        inpuNameSign = view.findViewById(R.id.inpuNameSign);
        inpuEmailSign = view.findViewById(R.id.inpuEmailSign);
        inputPasswordSign = view.findViewById(R.id.inputPasswordSign);
    }
}