package com.example.myapplication.views.activtys;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MVVM.ViewModel.PostViewModel;
import com.example.myapplication.R;
import com.example.myapplication.data.Models.User;
import com.example.myapplication.data.Preferences.UserPreferences;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.helpers.FileUtil;

import java.io.File;

public class AddPostActivity extends AppCompatActivity {
    private LinearLayout main;
    private EditText et_tital;
    private ImageButton btnAddImg;
    private EditText et_description;
    private android.widget.Button btnSubmit;
    private com.google.android.material.chip.Chip chip1;
    private com.google.android.material.chip.Chip chip2;
    private com.google.android.material.chip.Chip chip3;
    private com.google.android.material.chip.Chip chip4;
    private com.google.android.material.chip.Chip chip5;
    private com.google.android.material.chip.Chip chip8;
    private com.google.android.material.chip.Chip chip6;
    private com.google.android.material.chip.Chip chip7;
    private com.google.android.material.chip.Chip chip9;
    private com.google.android.material.chip.Chip chip10;
    private com.google.android.material.chip.Chip chip11;
    private com.google.android.material.chip.Chip chip12;
    private com.google.android.material.chip.Chip chip13;
    private com.google.android.material.chip.ChipGroup chip_parent_sections;

//    private ActivityResultLauncher<String> getContent;
ProgressDialog progressDialog ;

   private File compressedFile;

   private PostViewModel postViewModel ;
   private UserPreferences userPreferences ;
   private User user;


    ActivityResultLauncher<String> getContent = registerForActivityResult(new ActivityResultContracts.GetContent(), uri -> {

        if (uri != null){
            try {

                File originalFile = FileUtil.from(this, uri);
                originalFile.getName();


                compressedFile = FileUtil.compressImage(originalFile,this);
                Toast.makeText(this,"image selection !",Toast.LENGTH_SHORT);

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "خطأ أثناء معالجة الصورة", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this,"no selection !",Toast.LENGTH_SHORT);

        }

    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_post);
        imilmnt();

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        user =userPreferences.getUser();

        btnAddImg.setOnClickListener(v -> {
            getContent.launch("image/*");
        });



        btnSubmit.setOnClickListener(v -> {

            upludePost();

        });
        setResponseListionr();



    }

    private void upludePost() {


        progressDialog.setMessage("Please Waite ...");
        progressDialog.show();
        String tital = et_tital.getText().toString();
        String desc = et_description.getText().toString();


        postViewModel.uploadPost(user.getAcssesToken(),tital,desc,compressedFile);
    }


    void setResponseListionr(){
        postViewModel.getApiResponse().observe(this, apiResponse -> {
            if (apiResponse != null && apiResponse.isSuccess()) {
                progressDialog.dismiss();

                Toast.makeText(this, "تم إرسال المنشور بنجاح!", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.dismiss();

                Toast.makeText(this, "فشل في إرسال المنشور", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void imilmnt() {
        main = findViewById(R.id.main);
        chip1 = findViewById(R.id.chip1);
        chip2 = findViewById(R.id.chip2);
        chip3 = findViewById(R.id.chip3);
        chip4 = findViewById(R.id.chip4);
        chip5 = findViewById(R.id.chip5);
        chip8 = findViewById(R.id.chip8);
        chip6 = findViewById(R.id.chip6);
        chip7 = findViewById(R.id.chip7);
        chip9 = findViewById(R.id.chip9);
        chip10 = findViewById(R.id.chip10);
        chip11 = findViewById(R.id.chip11);
        chip12 = findViewById(R.id.chip12);
        chip13 = findViewById(R.id.chip13);
        et_tital = findViewById(R.id.et_tital);
        btnAddImg = findViewById(R.id.btnAddImg);
        btnSubmit = findViewById(R.id.btnSubmit);
        et_description = findViewById(R.id.et_description);
        chip_parent_sections = findViewById(R.id.chip_parent_sections);
        progressDialog=new  ProgressDialog(this);
        userPreferences =  new UserPreferences(this);
    }
}