//package com.example.myapplication.data;
//
//
//import androidx.lifecycle.LiveData;
//        import androidx.lifecycle.MutableLiveData;
//        import androidx.lifecycle.ViewModel;
//        import retrofit2.Call;
//        import retrofit2.Callback;
//        import retrofit2.Response;
//
//public class AuthViewModel extends ViewModel {
//    private MutableLiveData<LoginResponse> loginResponse = new MutableLiveData<>();
//
//    public void login(String email, String password) {
//        AuthApi api = ApiClient.getClient().create(AuthApi.class);
//        Call<LoginResponse> call = api.loginUser(new User(email, password));
//
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    loginResponse.setValue(response.body());
//                } else {
//                    loginResponse.setValue(null);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                loginResponse.setValue(null);
//            }
//        });
//    }
//
//    public LiveData<LoginResponse> getLoginResponse() {
//        return loginResponse;
//    }
//}
//
//
//import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.Toast;
//        import androidx.annotation.NonNull;
//        import androidx.annotation.Nullable;
//        import androidx.fragment.app.Fragment;
//        import androidx.lifecycle.Observer;
//        import androidx.lifecycle.ViewModelProvider;
//
//public class LoginFragment extends Fragment {
//    private EditText inputEmail, inputPassword;
//    private Button btnLogin;
//    private AuthViewModel authViewModel;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_login, container, false);
//        implement(view);
//        return view;
//    }
//
//    private void implement(View view) {
//        inputEmail = view.findViewById(R.id.inpuEmailLoin);
//        inputPassword = view.findViewById(R.id.inputPasswordLoin);
//        btnLogin = view.findViewById(R.id.btnLogin);
//
//        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
//
//        btnLogin.setOnClickListener(v -> {
//            String email = inputEmail.getText().toString().trim();
//            String password = inputPassword.getText().toString().trim();
//
//            if (!email.isEmpty() && !password.isEmpty()) {
//                authViewModel.login(email, password);
//            } else {
//                Toast.makeText(getContext(), "الرجاء إدخال البريد الإلكتروني وكلمة المرور", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        authViewModel.getLoginResponse().observe(getViewLifecycleOwner(), new Observer<LoginResponse>() {
//            @Override
//            public void onChanged(LoginResponse response) {
//                if (response != null && response.isSuccess()) {
//                    Toast.makeText(getContext(), "تم تسجيل الدخول بنجاح!", Toast.LENGTH_SHORT).show();
//                    // انتقل إلى الصفحة التالية
//                } else {
//                    Toast.makeText(getContext(), "فشل تسجيل الدخول!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
