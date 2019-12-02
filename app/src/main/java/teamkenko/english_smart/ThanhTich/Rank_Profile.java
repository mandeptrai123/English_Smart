package teamkenko.english_smart.ThanhTich;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import teamkenko.english_smart.R;


public class Rank_Profile extends AppCompatActivity {
    ImageView profile;
    TextView nganh,nienkhoa,note,score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank__profile);
        profile = (ImageView) findViewById(R.id.pro_rank_img);
        nganh = (TextView) findViewById(R.id.pro_rank_nganh);
        score =(TextView) findViewById(R.id.pro_rank_score);
        nienkhoa =(TextView) findViewById(R.id.pro_rank_khoa);
        note =(TextView) findViewById(R.id.pro_rank_note);
    }
}
