package teamkenko.english_smart.Word_Contest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Collections;

import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;
import teamkenko.english_smart.game_choose.menu_game.Menu_Game;
import teamkenko.english_smart.menu.Menu_English;

public class
Word_online extends AppCompatActivity {
    TextView text_c1,text_c2,text_c3,text_c4;
    ArrayList<Integer> arrayList;
    TextViewFonts text_cau,text_score;
    TextViewFonts text_question;
    ArrayList<Integer> arr_4;
   LottieAnimationView time;
    int score =0;
    int stt=0;
    int count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_online);
        text_cau = findViewById(R.id.question_word_contest);
        text_question =  findViewById(R.id.img_word_contest);
        time = findViewById(R.id.time_words);
        text_c1      =(TextView) findViewById(R.id.c1_word_online);
        text_c2      =(TextView) findViewById(R.id.c2_word_online);
        text_c3      =(TextView) findViewById(R.id.c3_word_online);
        text_c4      =(TextView) findViewById(R.id.c4_word_online);
        text_score =findViewById(R.id.score_word_online);
        text_score.setText("Score : "+score);
        arrayList = new ArrayList<>();
        if(Box_Question.question==null)
        {
            Toasty.info(getApplicationContext(),"Không Có Kết Nối INTERNET !",1000).show();
            Intent intent = new Intent(Word_online.this,Menu_English.class);
            startActivity(intent);
            finish();
        }else
        {
            for (int i=0;i<Box_Question.question.length;i++)
            {
                arrayList.add(i);
                Collections.shuffle(arrayList);

            }
            update();
        }

    }


    public  void c1_word_online(View view)
    {
        if(text_c1.getText().equals(Box_Question.main[arrayList.get(stt)].toUpperCase()))
        {
            Toasty.info(getApplicationContext(),"Correct !",1000).show();
            score++;
            text_score.setText("Score : "+score);
        }

        huybo();

    }
    public  void c2_word_online(View view)
    {
        if(text_c2.getText().equals(Box_Question.main[arrayList.get(stt)].toUpperCase()))
        {
            Toasty.info(getApplicationContext(),"Correct !",1000).show();
            score++;
            text_score.setText("Score : "+score);
        }
        huybo();

    }
    public  void c3_word_online(View view)
    {
        if(text_c3.getText().equals(Box_Question.main[arrayList.get(stt)].toUpperCase()))
        {
            Toasty.info(getApplicationContext(),"Correct !",1000).show();
            score++;
            text_score.setText("Score : "+score);
        }

        huybo();

    }
    public  void c4_word_online(View view)
    {
        if(text_c4.getText().equals(Box_Question.main[arrayList.get(stt)].toUpperCase()))
        {
            Toasty.info(getApplicationContext(),"Correct !",1000).show();
            score++;
            text_score.setText("Score : "+score);
        }

        huybo();

    }

    private void update() {
        // star animation
       time.playAnimation();
        time.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                huybo();
            }
        });


        text_cau.setText("Question: "+count);
        text_question.setText("What is main of "+Box_Question.question[arrayList.get(stt)].toUpperCase()+" ?");

        String[] answer={"a","b","c","d"};
        arr_4 = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            arr_4.add(i);
            Collections.shuffle(arr_4);
        }

        text_c1.setText(answer[arr_4.get(0)].toUpperCase());
        text_c2.setText(answer[arr_4.get(1)].toUpperCase());
        text_c3.setText(answer[arr_4.get(2)].toUpperCase());
        text_c4.setText(answer[arr_4.get(3)].toUpperCase());

    }

    private void huybo() {
        stt++;
        count++;
        update();

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
        Button but_no = dialog.findViewById(R.id.but_no_back);
        but_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
                startActivity(new Intent(Word_online.this,Menu_Game.class));
            }
        });
        but_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
