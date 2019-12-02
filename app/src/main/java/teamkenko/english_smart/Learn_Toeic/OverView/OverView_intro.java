package teamkenko.english_smart.Learn_Toeic.OverView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import teamkenko.english_smart.R;

public class OverView_intro extends AppCompatActivity {
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view_intro);
        pager = findViewById(R.id.overview_intro);
    }
}
