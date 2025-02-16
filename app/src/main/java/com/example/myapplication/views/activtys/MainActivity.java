package com.example.myapplication.views.activtys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MVVM.ViewModel.PostViewModel;
import com.example.myapplication.R;
import com.example.myapplication.adapters.PostAdabter;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout main;
    private ImageButton btnStar;
    private ImageButton btnMail;
    private LinearLayout hederPost;
    private RecyclerView rcView;
    private PostAdabter postAdabter;
    private com.google.android.material.bottomnavigation.BottomNavigationView bottom_navigation;
    private PostViewModel postViewModel ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getAllPosts();

        implmnt();
        rcView.setLayoutManager(new LinearLayoutManager(this));

        setResponseListionr();

        bottom_navigation.setOnItemSelectedListener(menuItem -> {

            if(menuItem.getItemId() == R.id.nav_home){

            }

            if(menuItem.getItemId() == R.id.nav_add_post){

                Intent intent = new Intent(this, AddPostActivity.class);
                startActivity(intent);
            }
            if(menuItem.getItemId() == R.id.nav_activity){

            }
            if(menuItem.getItemId() == R.id.nav_account){

            }
            return false;
        });



    }

    void setResponseListionr(){
        postViewModel.getPostsResponse().observe(this, postResponse -> {
            if (postResponse != null && postResponse.isSuccess()) {
                postAdabter = new PostAdabter(postResponse.getPosts());

                rcView.setAdapter(postAdabter);


                Toast.makeText(this, "تم إرسال المنشور بنجاح!", Toast.LENGTH_SHORT).show();
            } else {


                Toast.makeText(this, "فشل في إرسال المنشور", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void implmnt() {

        main = findViewById(R.id.main);
        btnStar = findViewById(R.id.btnStar);
        btnMail = findViewById(R.id.btnMail);
        hederPost = findViewById(R.id.hederPost);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        rcView = findViewById(R.id.rcView);


    }
}