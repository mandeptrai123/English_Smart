package teamkenko.english_smart.TOEIC.Menu_Toeic;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import teamkenko.english_smart.Learn.Menu_learn;
import teamkenko.english_smart.R;

public class Main_Toeic extends AppCompatActivity {
    Button b_skill,b_mini,b_full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__toeic);
        b_full = findViewById(R.id.toeic_full);
        b_mini = findViewById(R.id.toeic_mini);
        b_skill = findViewById(R.id.toeic_skill);
        b_full.setY(700f);
        b_mini.setX(500f);
        b_skill.setX(-500f);
        ViewCompat.animate(b_full).translationY(0f).setDuration(700).start();
        ViewCompat.animate(b_mini).translationX(0f).setDuration(700).start();
        ViewCompat.animate(b_skill).translationX(0f).setDuration(700).start();

    }
    public void event_full(View view)
    {
        ViewCompat.animate(b_skill).scaleX(0.8f).scaleY(0.7f).setDuration(400).start();
        startActivity(new Intent(Main_Toeic.this,Toeic_Full.class));
        finish();


    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(Main_Toeic.this,Menu_learn.class));
    }
}
