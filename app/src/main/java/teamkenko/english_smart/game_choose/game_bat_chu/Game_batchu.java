package teamkenko.english_smart.game_choose.game_bat_chu;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;

import teamkenko.english_smart.game_choose.menu_game.Menu_Game;


public class Game_batchu extends AppCompatActivity {
    public GridView gridView_answer;
    public int solansai = 0 ;
    public  int socausai= 0 ;
    public GridView gridViewbanphim;
    ImageView imagequestion;
    public  boolean check= false ;
    MediaPlayer mediaPlayer;
    public  int id ;
    public SoundPool soundPool;
    int[] image_list = {};
    public char[] answer;
    public String correct_answer;
    public  int id_chienthang,id_thatbai;
    int count = 120;
    public ArrayList<Integer> kiemtra;
    public char[] kitu_correct;
    public char[] kitu_alphabet;
    public GridViewAnswer adapteranswer;
    public GridView_Banphim adapter_banphim;
    public  int soluot_mienphi = 3 ;
    int id_click;
    public String[] correct = {"leopard","parrot","biologist","globe","windsurfing","goalie","rhinoceros","basketball",
    "volleyball","badminton","appeal","appalled","soldier","tsunami","population","prohibit","vote","enterprises",
    "transportation","nation"};
    public  char[] kitu_question;
    public int dodai_answer[] = {7,6,9,5,11,6,10,10,10,9,6,8,7,7,10,8,4,11,14,6};
    String[] music={"leopard","parrot","biologist","globe","windsurfing","goalie","rhinoceros","basketball",
    "volleyball","badminton","appeal","appalled","soldier","tsunami","population","prohibit","vote","enterprise",
    "transportation","nation"};

    String alphabet = "qwertyuiopasdfghjklzxcvbnm";
    boolean create[]={};
    public int score = 0;
    int stt=0;
    MediaPlayer mediaPlayerground;
    TextViewFonts text_score ;
    ArrayList<Integer> arrayList;
    int vitri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_batchu);
        text_score =  findViewById(R.id.score_game1);
        mediaPlayer = new MediaPlayer();
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,1);
        id_chienthang = soundPool.load(this,R.raw.correct,1);
        id_thatbai = soundPool.load(this,R.raw.incorrect,1);
        id_click = soundPool.load(this,R.raw.click_button,1);
        kiemtra = new ArrayList<Integer>();
        for (int i = 0; i < image_list.length; i++) {
            kiemtra.add(i);
            Collections.shuffle(kiemtra);
        }

        mediaPlayerground = new MediaPlayer();
        mediaPlayerground = MediaPlayer.create(Game_batchu.this,R.raw.game_chinhthuc);
        mediaPlayerground.setVolume(1f,1f);
        mediaPlayerground.setLooping(true);
        mediaPlayerground.start();

        init();
        capnhat();
    }

    private void capnhat() {
        create = new boolean[26];
        for(int i=0;i<26;i++)
        {
            create[i]=false;
        }

        Random random = new Random();
        id = random.nextInt(5);
        soluot_mienphi = 3 ;

        imagequestion.setImageResource(image_list[kiemtra.get(stt)]);
        correct_answer = correct[kiemtra.get(stt)];

        answer = correct_answer.toCharArray();
        Commom.submit_answer = new boolean[answer.length];
        for (int i = 0; i < Commom.submit_answer.length; i++) {
            Commom.submit_answer[i] = false;
        }
                kitu_alphabet = alphabet.toCharArray();
        int length=0;
        for(int i=0;i<correct_answer.length();i++)
        {
            for(int j=0;j<26;j++)
            {
                if(answer[i]==kitu_alphabet[j] && create[j]==false)
                {
                   create[j]=true;
                   length++;
                }
            }
        }
        kitu_question=new char[length+4];
       arrayList = new ArrayList<>();
        for (int i=0;i<26;i++)
        {
            arrayList.add(i);
            Collections.shuffle(arrayList);
        }
         int k=0;
      for(int i=0;i<26;i++)
      {
          if(create[arrayList.get(i)]==false && k<=3)
          {
              create[arrayList.get(i)]=true;
              k++;
          }
      }
         vitri=0;
        for (int i=0;i<26;i++)
        {
            if(create[i])
            {
                kitu_question[vitri]=kitu_alphabet[i];
                vitri++;
            }
        }




        kitu_correct = correct_answer.toCharArray();
        Commom.submit_answer = new boolean[answer.length];
        adapter_banphim = new GridView_Banphim(Game_batchu.this, kitu_question, Game_batchu.this);
        adapteranswer = new GridViewAnswer(Commom.submit_answer, this, Game_batchu.this);
        gridViewbanphim.setAdapter(adapter_banphim);
        gridView_answer.setAdapter(adapteranswer);
        adapteranswer.notifyDataSetChanged();
        adapter_banphim.notifyDataSetChanged();

    }




    public  void nextnext() {

        if (score == 20) {
            mediaPlayerground.stop();

          thangTeodibui();
        }

        if (Commom.submit_answer == null) {

        } else {
            int length=0;
            for(int i=0;i<answer.length;i++)
            {
                if(Commom.submit_answer[i])
                {
                    length++;
                }
            }


            if (length==answer.length) {

                mediaPlayer = MediaPlayer.create(Game_batchu.this,Uri.parse("https://ssl.gstatic.com/dictionary/static/sounds/oxford/"+music[kiemtra.get(stt)]+"--_gb_1.mp3?fbclid=IwAR1ROYgKLxni3gKG-miOSolThQFc8u8tvG8mIqsK4ku1qvwKsV_QalluJY8"));
                mediaPlayer.start();
                Toasty.success(Game_batchu.this, "Correct!", Toast.LENGTH_SHORT).show();
                check = true;
                GridViewAnswer adapteranswer = new GridViewAnswer(Commom.submit_answer, this, Game_batchu.this);
                gridView_answer.setAdapter(adapteranswer);
                adapteranswer.notifyDataSetChanged();
                CountDownTimer countDownTimer = new CountDownTimer(2000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        score += 1;
                        text_score.setText(score+"");
                        stt += 1;
                        capnhat();
                        check = false;
                    }
                };
                countDownTimer.start();

            }


        }

    }

    public void thangTeodibui(){
        String title="";
        SharedPreferences sharedPreferences = getSharedPreferences("mydata123",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int high_score = sharedPreferences.getInt("Score_BatChu",0);
        if(high_score<score)
        {
            title="NEW RECORD";
            high_score=score;
            editor.putInt("Score_BatChu",high_score);
            editor.commit();
        }else
        {
            title="RESULT";
        }
        mediaPlayerground.stop();


    }
    private void init() {
        imagequestion = (ImageView) findViewById(R.id.imagequestion);
        gridView_answer=(GridView)findViewById(R.id.gridviewanswer);
        gridViewbanphim=(GridView)findViewById(R.id.gridviewbanphim);

    }
    private char[] setupnullist() {

        char result[] = new char[dodai_answer[kiemtra.get(stt)]];

        for(int i=0;i<dodai_answer[kiemtra.get(stt)];i++)
        {result[i] =' ';}
        return  result;
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
                startActivity(new Intent(Game_batchu.this,Menu_Game.class));
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

