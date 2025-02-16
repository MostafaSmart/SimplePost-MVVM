package com.example.myapplication.data.Models;

public class User {
    private int id ;
    private String name;
    private String email;
    private String password;
    private String acssesToken;

    public User(int id,String name,String email, String password,String acssesToken) {
        this.email = email;
        this.password = password;
        this.id = id;
       this.name = name;
       this.acssesToken = acssesToken;
    }

    public int getID() { return id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public  String getAcssesToken(){return acssesToken;}
}

//
//import retrofit2.Retrofit;
//        import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ApiClient {
//    private static final String BASE_URL = "http://10.0.2.2/"; // لـ localhost في المحاكي
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient() {
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return retrofit;
//    }
//}
//
//
//import retrofit2.Call;
//        import retrofit2.http.Body;
//        import retrofit2.http.POST;
//
//public interface AuthApi {
//    @POST("bac/login.php")
//    Call<LoginResponse> loginUser(@Body User user);
//}
