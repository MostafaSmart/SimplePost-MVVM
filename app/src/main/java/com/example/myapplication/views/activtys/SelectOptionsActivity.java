package com.example.myapplication.views.activtys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.myapplication.R;

public class SelectOptionsActivity extends AppCompatActivity {
    private LinearLayout hedar;
    private TextView title_text;
    private TextView subtitle_text;
    private ImageButton back_button;
    private RelativeLayout main_layout;
    private android.widget.Button btnSkip;
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
    private com.google.android.material.chip.ChipGroup chip_flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_options);
        imelmnt();





        btnSkip.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });





    }

    private void imelmnt() {
        hedar = findViewById(R.id.hedar);
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
        btnSkip = findViewById(R.id.btnSkip);
        chip_flow = findViewById(R.id.chip_flow);
        title_text = findViewById(R.id.title_text);
        main_layout = findViewById(R.id.main_layout);
        back_button = findViewById(R.id.back_button);
        subtitle_text = findViewById(R.id.subtitle_text);
    }
}