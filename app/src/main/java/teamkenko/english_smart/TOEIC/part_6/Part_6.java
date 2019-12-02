package teamkenko.english_smart.TOEIC.part_6;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import teamkenko.english_smart.R;
import teamkenko.english_smart.TOEIC.Menu_Toeic.Toeic_Full;

public class Part_6 extends AppCompatActivity {
    int score = 0;
    int type;
    int pos_pager=0;
    private Handler handler = new Handler();
    ViewPager viewPager;
    public   boolean check;
    SeekBar seekBar;
    Button but_submit,but_op;
    TextView text_ques;
    int number;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_6);
        lottie    = findViewById(R.id.lot_write_p4);
        but_submit =  findViewById(R.id.but_submit_p4);
        but_op   =  findViewById(R.id.but_option_p4);
        text_ques.setText("Question: "+1);



    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.show();
        if(dialog.getWindow()!=null)
        {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.setContentView(R.layout.item_dialog_back);
        Button but_yes = dialog.findViewById(R.id.but_yes_back);
        but_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
                startActivity(new Intent(Part_6.this,Toeic_Full.class));
            }
        });
    }
}

