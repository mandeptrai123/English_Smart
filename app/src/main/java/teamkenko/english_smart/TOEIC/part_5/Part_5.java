package teamkenko.english_smart.TOEIC.part_5;

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

public class Part_5 extends AppCompatActivity {
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
        setContentView(R.layout.activity_part_5);
        viewPager = findViewById(R.id.viewpager_part5);
        text_ques = findViewById(R.id.pos_ques_p5);
        lottie    = findViewById(R.id.lot_write_p5);
        but_submit =  findViewById(R.id.but_submit_p5);
        but_op   =  findViewById(R.id.but_option_p5);
        text_ques.setText("Question: "+1);
        type=0;
        Adapter_Part5 adapter_part5 = new Adapter_Part5(this,type);
        viewPager.setAdapter(adapter_part5);
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
                startActivity(new Intent(Part_5.this,Toeic_Full.class));
            }
        });
    }
}
