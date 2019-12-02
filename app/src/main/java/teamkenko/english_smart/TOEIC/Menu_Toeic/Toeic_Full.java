package teamkenko.english_smart.TOEIC.Menu_Toeic;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import teamkenko.english_smart.R;
import teamkenko.english_smart.TOEIC.part_1.Part_1;
import teamkenko.english_smart.TOEIC.part_2.Part_2;
import teamkenko.english_smart.TOEIC.part_3.Part_3;
import teamkenko.english_smart.TOEIC.part_4.Part_4;
import teamkenko.english_smart.TOEIC.part_5.Part_5;

public class Toeic_Full extends AppCompatActivity {
    Button part_1,part_2,part_3,part_4,part_5,part_6,part_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toeic__full);
        part_1 = findViewById(R.id.choose_part1);
        part_2 = findViewById(R.id.choose_part2);
        part_3 = findViewById(R.id.choose_part3);
        part_4 = findViewById(R.id.choose_part4);
        part_5 = findViewById(R.id.choose_part5);
        part_6 = findViewById(R.id.choose_part6);
        part_7 = findViewById(R.id.choose_part7);

        part_1.setX(-500f);
        part_2.setX(500f);
        part_3.setX(-500f);
        part_4.setX(500f);
        part_5.setX(-500f);
        part_6.setX(500f);
        part_7.setX(-500f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(part_1,"translationX",0f),
                ObjectAnimator.ofFloat(part_2,"translationX",0f),
                ObjectAnimator.ofFloat(part_3,"translationX",0f),
                ObjectAnimator.ofFloat(part_4,"translationX",0f),
                ObjectAnimator.ofFloat(part_5,"translationX",0f),
                ObjectAnimator.ofFloat(part_6,"translationX",0f),
                ObjectAnimator.ofFloat(part_7,"translationX",0f)
        );
        animatorSet.setDuration(800);
        animatorSet.start();






        part_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Toeic_Full.this,Part_1.class));
            }
        });
        part_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Toeic_Full.this,Part_2.class));
            }
        });

        part_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Toeic_Full.this,Part_3.class));
            }
        });
        part_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Toeic_Full.this,Part_4.class));
            }
        });
        part_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Toeic_Full.this,Part_5.class));
            }
        });
    }


    @Override
    public void onBackPressed() {
      startActivity(new Intent(Toeic_Full.this,Main_Toeic.class));
    }
}
