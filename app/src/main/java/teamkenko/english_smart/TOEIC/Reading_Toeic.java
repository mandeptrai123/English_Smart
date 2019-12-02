package teamkenko.english_smart.TOEIC;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import teamkenko.english_smart.Learn.Menu_learn;
import teamkenko.english_smart.R;

public class Reading_Toeic extends AppCompatActivity {
    ViewPager viewPager;
    LottieAnimationView sound;
    int hour,minute,second = 0;
    TextView text_time;
    int time= 5400;
    Handler handler;
    private static final int MESS_UPDATE = 100;

String text [] = {"In this tutorial, you will learn how to implement a viewpager gallery of images and texts in your Android application. ViewPager allows the user to flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts. o flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts o flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts o flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts o flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts",
"In this tutorial, you will learn how to implement a viewpager gallery of images and texts in your Android application. ViewPager allows the user to flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts.",
"In this tutorial, you will learn how to implement a viewpager gallery of images and texts in your Android application. ViewPager allows the user to flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts.",
"In this tutorial, you will learn how to implement a viewpager gallery of images and texts in your Android application. ViewPager allows the user to flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts.",
"In this tutorial, you will learn how to implement a viewpager gallery of images and texts in your Android application. ViewPager allows the user to flip left and right through pages of data. We will create a viewpager and on flip left or right will show different images and texts."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading__toeic);
        viewPager = (ViewPager) findViewById(R.id.view_pager_toeic);
        sound     = (LottieAnimationView) findViewById(R.id.sound_read_toeic);
        text_time = (TextView) findViewById(R.id.text_time_read);
        sound.playAnimation();
      //  Adapter_Pager adapter_pager = new Adapter_Pager(this,img,text);
        handler = new Handler();
       // viewPager.setAdapter(adapter_pager);

        CountDownTimer countDownTimer = new CountDownTimer(3600000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time-=1;
                hour = time/3600;
                minute = (time%3600)/60;
                second = time - hour*3600 - minute*60;
                text_time.setText(String.format("%02d:%02d:%02d",hour,minute,second));
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();


//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.show();
//        if (progressDialog.getWindow() != null) {
//            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        progressDialog.setContentView(R.layout.dialog_tutorial_swipe);
//        progressDialog.setCancelable(true);
//        Button but_ok = progressDialog.findViewById(R.id.but_oke_swipe);
//        but_ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressDialog.dismiss();
//            }
//        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent(Reading_Toeic.this,Menu_learn.class));
        finish();
    }
}
