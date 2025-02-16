package com.example.myapplication.views.activtys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.Repositorys.UserRepository;
import com.example.myapplication.views.activtys.AuthActivity;


public class SpalshActivity extends AppCompatActivity {
    private View layout1, layout2;
    private FrameLayout mainContainer;
    private ImageView imgPhone;
    private RelativeLayout scrll;
    private ImageButton btn_next;
    private LinearLayout textMain;
    private RelativeLayout onboarding_scond_root_layout2;
    private UserRepository userRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.onboarding_scond_layout);
        setFullScreen(R.id.onboarding_scond_root_layout2);
        userRepository = new UserRepository(this);


        btn_next = findViewById(R.id.btn_next);

                btn_next.setOnClickListener(v -> {
            Toast.makeText(this,"dddddddd",Toast.LENGTH_SHORT);


            if(userRepository.isLoggedIn()){

                Intent intent = new Intent(this, SelectOptionsActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(this, AuthActivity.class);
                startActivity(intent);
            }



//            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


        });

//        layout2 = getLayoutInflater().inflate(R.layout.onboarding_scond_layout, mainContainer, false);


//        mainContainer = findViewById(R.id.main);


    }

//
//    @SuppressLint("MissingInflatedId")
//    private void switchLayout() {
//        setContentView(R.layout.onboarding_scond_layout);
//
//        setFullScreen(R.id.onboarding_scond_root_layout2);
//
//
////        setClickLisner();
//
//        layout2 = findViewById(R.id.onboarding_scond_root_layout2);
//
//        layout2.setTranslationX(-layout2.getWidth());
//
//
//        ObjectAnimator anim1 = ObjectAnimator.ofFloat(layout1, "translationX", 0, layout1.getWidth());
//        anim1.setDuration(500);
//
//        ObjectAnimator anim2 = ObjectAnimator.ofFloat(layout2, "translationX", -layout2.getWidth(), 0);
//        anim2.setDuration(500);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(anim1, anim2);
//        animatorSet.setInterpolator(new DecelerateInterpolator());
//        animatorSet.start();
//    }

//    private void animateLayoutChange() {
//
//        layout2.setTranslationX(-mainContainer.getWidth()); // بدء layout2 خارج الشاشة من اليسار
//        mainContainer.addView(layout2);
//
//        // تحريك layout1 إلى اليمين
//        ObjectAnimator animOut = ObjectAnimator.ofFloat(layout1, "translationX", 0, layout1.getWidth());
//        animOut.setDuration(500);
//
//        // تحريك layout2 من اليسار إلى موضعه
//        ObjectAnimator animIn = ObjectAnimator.ofFloat(layout2, "translationX", -layout2.getWidth(), 0);
//        animIn.setDuration(500);
//
//        // تشغيل الأنميشن معًا
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(animOut, animIn);
//        animatorSet.start();
//
//        // إزالة layout1 بعد انتهاء الأنميشن
//        animOut.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mainContainer.removeView(layout1);
//            }
//        });
//
//        btn_next = findViewById(R.id.btn_next);
//

//    }
    private void implmnt(){

    }



    private void setFullScreen(int idd){
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(idd), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}


//
//public class SpalshActivity extends AppCompatActivity {
//    private FrameLayout mainContainer;
//    private View layout1, layout2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_spalsh);
//
//        mainContainer = findViewById(R.id.main);
//
//        // تحميل layout1 داخل الـ FrameLayout
//        layout1 = getLayoutInflater().inflate(R.layout.layout1, mainContainer, false);
//        mainContainer.addView(layout1);
//
//        // تأخير 5 ثوانٍ ثم تنفيذ الأنميشن للتبديل إلى layout2
//        new Handler(Looper.getMainLooper()).postDelayed(this::animateLayoutChange, 5000);
//    }
//
//    private void animateLayoutChange() {
//
//        layout2.setTranslationX(-mainContainer.getWidth()); // بدء layout2 خارج الشاشة من اليسار
//        mainContainer.addView(layout2);
//
//        // تحريك layout1 إلى اليمين
//        ObjectAnimator animOut = ObjectAnimator.ofFloat(layout1, "translationX", 0, layout1.getWidth());
//        animOut.setDuration(500);
//
//        // تحريك layout2 من اليسار إلى موضعه
//        ObjectAnimator animIn = ObjectAnimator.ofFloat(layout2, "translationX", -layout2.getWidth(), 0);
//        animIn.setDuration(500);
//
//        // تشغيل الأنميشن معًا
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(animOut, animIn);
//        animatorSet.start();
//
//        // إزالة layout1 بعد انتهاء الأنميشن
//        animOut.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mainContainer.removeView(layout1);
//            }
//        });
//    }
//}
