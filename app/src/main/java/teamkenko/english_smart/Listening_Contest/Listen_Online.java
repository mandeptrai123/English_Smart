package teamkenko.english_smart.Listening_Contest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.Collections;

import teamkenko.english_smart.R;
import teamkenko.english_smart.Word_Contest.Box_Question;

public class Listen_Online extends AppCompatActivity {
    TextView ans1,ans2,ans3,ans4;
    ArrayList<Integer> arrayList;
    int stt=0;
    int count=1;
    MediaPlayer music;
    TextView text_count;
    SeekBar time;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen__online);
        ans1 = (TextView) findViewById(R.id.answer_a_listen_contest);
        ans2 = (TextView) findViewById(R.id.answer_b_listen_contest);
        ans3 = (TextView) findViewById(R.id.answer_c_listen_contest);
        ans4 = (TextView) findViewById(R.id.answer_d_listen_contest);
        time = (SeekBar) findViewById(R.id.seek_bar_listen);
        text_count =(TextView) findViewById(R.id.question_listen_contest);
        update();
        for(int i=0;i<Box_Question.sound.length;i++)
        {
            arrayList.add(i);
            Collections.shuffle(arrayList);
        }

    }

    private void update() {
        text_count.setText(count);
        start_music(arrayList.get(stt));
        time.setMax(15000);
        time.setProgress(count);
        countDownTimer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                count+=1000;
                time.setProgress(count);
            }

            @Override
            public void onFinish() {
                time.setProgress(15000);
               huybo();
            }
        };
        countDownTimer.start();

    }

    private void huybo() {
      countDownTimer.cancel();
        stt++;
        count++;
        update();

    }

    private void start_music(Integer integer) {
        music = new MediaPlayer();
        MediaPlayer.create(this,Uri.parse(Box_Question.sound[integer]));
        music.start();
    }
    public void tap_to_start(View view)
    {
       start_music(arrayList.get(stt));
    }
    public void  a_listen_contest(View view)
    {
        huybo();
    }
    public void  b_listen_contest(View view)
    {
        huybo();
    }
    public void  c_listen_contest(View view)
    {
        huybo();
    }
    public void  d_listen_contest(View view)
    {
        huybo();
    }
}
