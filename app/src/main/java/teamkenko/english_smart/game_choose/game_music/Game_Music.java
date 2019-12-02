package teamkenko.english_smart.game_choose.game_music;

import android.animation.AnimatorSet;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import es.dmoral.toasty.Toasty;

import teamkenko.english_smart.R;
import teamkenko.english_smart.game_choose.menu_game.Menu_Game;


public class Game_Music extends AppCompatActivity {

    Button but1,but2,but3,but4;
    public static  int time_test = 30000;
    public static  int time_any = 1000;
    CountDownTimer countDownTimer ;
    AnimatorSet ani_background;
    int count = 30;
    String[] Correct={"Counting Star","Cheap Thrills","Castle On The Hill","Closer","The River","Attention",
            "Cold Water","Beauty And Beat",
            "Dont Let Me Down","Im Your",
            "Sugar","See You Again","Symphony","What Makes You Beautiful","Love Yourself","Locked Away","Maps",
            "Let Me Love You","What Do You Mean","One Thing","Pround Of You","Bad Things","Cant Stop Feeling","Dont Wanna Know",
            "I'm The One","More Than You Know","One Call Away","Paris","All We Know","Shape Of You","Rockabye",
            "Some Thing Just Like This","Stay","The Greatest","The Ocean","Titanium","Treat You Better","Viva La Vida",
            "We Dont Talk Anymore","What I've Done","Why Not Me","Alone","Beautiful In White","Let Her Go","My Love",
            "One Last Time"
            ,"Roar","Take Me To Your Heart","Until You","I Can Fly","Young","I Need Your Love","Reality",
            "Rude","Summer","Tonight Tonight","Burn","Call Me Maybe","Chandelier","Havana",
            "How To Love","I do","In The End","Just The Way You Are","Love Me Like You Do","Numb"
            ,"Scared To Be Lonely","Sorry","Stereo Hearts","The Lazy Song","Thunder",
            "Waiting For Love","You Belong With Me","Baby","All Falls Down","Legend Never Die","OutSide",
            "Like I Do","Bad Day","Cry On My Shoulder","Dusk Till Dawn","Heathens","It Ain't Me","Starving"
            ,"The Spectre","Seve","You&I","Live While We're Young","Sun Goes Down","Where Are U Now"
            ,"I Want You To Know","Beautiful Now","Lean On","Roses","Show Me Love","Are You With Me",
            "Next To Me","Rise","Darkside","Girls Like You","Ignite"};
    int stt = 0;
    int score=0;
    String[][] traloi={{"Counting Star","Closer","Cold Water","Attention"},//counting start
            {"Come On","Cheap Thrills","Castle On The Hill", "BaBy"}, // cheap thrill
            {"Castle On The Hill","Go Home","The Night","Locked Away"},//castle on the hill
            {"All We Know","Closer","Cold Water","Im Your"}, //closer
            {"Beauty And Beat","The River","Why Not Me","Im Your"},//despacito
            {"All We Know","Attention","Cold Water","Symphony"}, // Attention
            {"The Night","The Life","Cold Water","You Go"}, // cold water
            {"Cold Water","Beauty And Beat","Closer","Castle On The Hill"}, // beauty and beat
            {"Dont Let Me Down","Symphony","Locked Away","See You Again"}, //dont let me down
            {"Until You","Why Not Me","Cold Water","Im Your"}, //im your
            {"Sugar","Symphony","Animals","Oh Baby"},// sugar
            {"Dont Let Me Down","See You Again","All We Know","Symphony"},//see you again
            {"Symphony","Animals","Love Yourself","Maps"}, //symphony
            {"Locked Away","What Makes You Beautiful","What Do You Mean","One Thing"},//What make
            {"Maps","Love Yourself","Let Me Love You","Sugar"}, //Love yourself
            {"Locked Away","Closer","Until You","Symphony"}, // locked away
            {"Symphony","Maps","Closer","Sugar"} // maps
            ,{"Sorry","Beauty And Beat","Let Me Love You","What Do You Mean"}//let me love ou
            ,{"What Do You Mean","Sorry","Beauty and Beat","One Thing"},
            {"Shape Of You","One Thing","Until You","Sugar"},
            {"Pround Of You","Hello Hello","Waiting For","The Love"}
            ,{"My Mind","The Love","Bad Things","Cant Stop Feeling"}
            ,{"Give Away","Stay","All We Know","Cant Stop Feeling"}
            ,{"Dont Wanna Know","Until You","For You","What I've Done"}
            ,{"I'm The One","Sorry Baby","I love You","Animals"}
            ,{"Im The One","The Greatest","Higher","More Than You Know"},
            {"One Call Away","Call Away","Super Man","Call Baby"}
            ,{"Paris","Titanium","Stay","Treat You Better"}
            ,{"Closer","Young","All We Know","The Nights"}
            ,{"Waiting For Love","Love","Titanium","Shape Of You"}
            ,{"Surface","Alone","Rockabye","Wake Me Up"}
            ,{"Some Thing Just Like This","Closer","All We Know","The Nights"}
            ,{"Paris","Levels","Stay","Titanium"}
            ,{"The Greatest","The Ocean","For Love","Levels"}
            ,{"Rockabye","The Ocean","Stay","Higher"}
            ,{"Something","Levels","Titanium","Blue"}
            ,{"Treat You Better","Cold Water","For Me","Faded"}
            ,{"Stay","Waiting For Love","Cheap Thrills","Viva La Vida"},
            {"We Dont Talk Anymore","Im Your","All We Know","We Are One"},
            {"One Number","Higher","Closer","What I've Done"},
            {"Take Me To Your Heart","I Do","Let Her Go","Why Not Me"}
            ,{"Alone","Faded","The Spectre","The Love"},
            {"My Love","The Beautiful","Beautiful In White","Beautiful"},
            {"Blue","Let Her Go","I Do","Wake Me up"},
            {"The One","Love My Love","My Love","The Love"},
            {"The Love","One Last Time","The Night","Last Time"},
            {"Boy","Roar","The Roar","My Face"},
            {"The Boy","Take Me To Your Heart","Your Heart","Call Me"},
            {"The World","Until You","The Way","Feel The World"},
            {"Sun Night","The Sun","Enemy","I Can Fly"},
            {"New Young","Young","Where You Go","Make Me Young"},
            {"My Life","I Need","I Need Your Love","Your Love"},
            {"Ready","Reality","You Go","Go"},
            {"Marry","Rude","Magic","The Way"},
            {"The Love","The Summer","Love","Summer"},
            {"Sun Night","Tonight","The Night","Tonight Tonight"},
            {"The Fire","I Don't Know","Burn","Fire"},
            {"Call Me","Baby","Call Me Baby","Call Me Maybe"},
            {"Chandelier","The Night","The Fire","Lie"},
            {"Havana","Lalala","Nanana","Hanava"},
            {"Some Body","How To Love","The Love","Love"},
            {"Heart You Say","Some Thing","I do","The Love"},
            {"Numb","In The End","Finish","Boy Friend"},
            {"Just The Love","Just The Way","Just The Way You Are","Amazing"},
            {"Love Me","Love Me Like You Do","The Love","Like You Do"},
            {"Numb","In The End","Finish","Come"},
            {"Scared","The River","Scared To Be Lonely","Lonely"},
            {"Love Yourself","Sorry","Sorry Sorry","What Do You Mean"},
            {"Stereo","Radio","The Radio","Stereo Hearts"},
            {"The Lazy is Song","The Lazy","Just The Way You Are","The Lazy Song"},
            {"Funder","Under","Thunder","Lighting"},
            {"The End","Waiting For Love","For Love","Wait For"},
            {"You With Me","You Belong With Me","Looking For","With Me"},
            {"Baby","BaBy BaBy","My Mind","The Baby"},
            {"Whenever","All Falls Down","Where You Go","Falls Down"},
            {"The Legend","Your Life","Never","Legend Never Die"},
            {"The Power","Side To Side","OutSide","Power"},
            {"Like I Do","Baby","Like You","The Love"},
            {"Lie","Bad Day","The Way","The Life"},
            {"Cry On My Shoulder","My Shoulder","Cry On","Some One"},
            {"Dusk Till Dawn","The Love","Till Dawn","Baby"},
            {"Friends","Where You Go","Heathens","You Don't Know"},
            {"Stand For","It Ain't Me","It Me","Down"},
            {"See You","Hold Me","Starving","No Way"},
            {"My Life","Hold Me","The Life","The Spectre"},
            {"Seve","Feeling","Down Seve","The Seve"},
            {"You End Die","You&I","You And Die","You Die"},
            {"Let Go","Crazy","While Young","Live While We're Young"},
            {"Sun Go Down","Sun Goes Down","We Go","Some Go Down"},
            {"I Need You","I Want","I Want You","Where Are U Now"},
            {"I Want You Know","I Know","I Want You To Know","You Know"},
            {"Beautiful Night","Beautiful","Beautiful Now","The Nights"},
            {"Live On","Leon","Lean On","Living On"},
            {"Say You Love Me","Let We Go","Roses","We Go"},
            {"Beside","Show Me Love","The Love","Show Me"},
            {"You With Me","All You With Me","With Me","Are You With Me"},
            {"Alone","Next To Me","By Me","Rise"},
            {"Feeling","Rise","Girls","Rights"},
            {"Alone","Dark","Alive","Darkside"},
            {"Girls","I Need Girls","I Like Girls","Girls Like You"},
            {"Ignite","Rights","Alone","Lose"}};


    LottieAnimationView button_music;
    SoundPool soundPool;
    int solansai=0 ;
    MediaPlayer player;
    Random random_manhinh;
    ArrayList<Integer> array ;
    ArrayList<Integer> list ;
    public  int sound_piano;
   TextView text_score;
   // init effect for button.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__music);
        text_score = (TextView)findViewById(R.id.score_music);
        // init method
        init();
        background_null();
        capnhat();
        count=-1;
        countDownTimer = new CountDownTimer(time_test,time_any) {
            @Override
            public void onTick(long millisUntilFinished) {
                count++;

            }


            @Override
            public void onFinish() {
                background_null();
                count=0;

                stopmusic();
               Toasty.error(Game_Music.this,"Over Time", Toast.LENGTH_SHORT).show();
                solansai+=1;
                if(solansai==3) {


                }
                button_music.setEnabled(true);
                but1.setEnabled(false);
                but2.setEnabled(false);
                but3.setEnabled(false);
                but4.setEnabled(false);
                stt+=1 ;
                capnhat();
            }
        };


        // Set su kien

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopmusic();
                background_null();
                button_music.setEnabled(true);
                countDownTimer.cancel();
                count=-1;

                if(but1.getText().equals(Correct[list.get(stt)]))
                {
                    score +=1;
                    Toasty.success(Game_Music.this,"Good !", Toast.LENGTH_SHORT).show();
                    capnhat();
                    stt++;
                }else {
                    solansai+=1;
                    if(solansai==3)
                    {
                        thangTeodibui();
                    }
                    capnhat();
                   Toasty.error(Game_Music.this,"Lose !", Toast.LENGTH_SHORT).show();
                    stt++;
                }
                stopmusic();
                text_score.setText(score+" Star");
                text_score.setVisibility(View.VISIBLE);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                background_null();

                button_music.setEnabled(true);
                countDownTimer.cancel();
                count=-1;

                if(but2.getText().equals(Correct[list.get(stt)]))
                {
                    score +=1;
                    Toasty.success(Game_Music.this,"Good !", Toast.LENGTH_SHORT).show();
                    capnhat();
                    stt++;
                }else {
                    solansai+=1;
                    if(solansai==3)
                    {
                        thangTeodibui();

                    }
                    capnhat();
                   Toasty.error(Game_Music.this,"Lose !", Toast.LENGTH_SHORT).show();
                    stt++;
                }
                stopmusic();
                text_score.setText(score+" Star");
                text_score.setVisibility(View.VISIBLE);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background_null();
                button_music.setEnabled(true);
                countDownTimer.cancel();
                count=-1;

                if(but3.getText().equals(Correct[list.get(stt)]))
                {
                    score +=1;
                    Toasty.success(Game_Music.this,"Good !", Toast.LENGTH_SHORT).show();
                    capnhat();
                    stt++;

                }else {
                    solansai+=1;
                    if(solansai==3)
                    {
                        thangTeodibui();

                    }
                    capnhat();
                    Toasty.error(Game_Music.this,"Lose !", Toast.LENGTH_SHORT).show();
                    stt++;
                }
                stopmusic();
                text_score.setText(score+" Star");
                text_score.setVisibility(View.VISIBLE);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background_null();

                button_music.setEnabled(true);
                countDownTimer.cancel();
                count=-1;


                if(but4.getText().equals(Correct[list.get(stt)]))
                {
                    score +=1;
                    Toasty.success(Game_Music.this,"Good !", Toast.LENGTH_SHORT).show();
                    capnhat();
                    stt++;
                }else {
                    solansai+=1;
                    if(solansai==3)
                    {
                        thangTeodibui();
                    }
                    capnhat();
                    Toasty.error(Game_Music.this,"Lose !", Toast.LENGTH_SHORT).show();
                    stt++;
                }
                stopmusic();
                text_score.setText(score+" Star");
                text_score.setVisibility(View.VISIBLE);
            }
        });



        button_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_music.playAnimation();
                choose_song();
                text_score.setVisibility(View.INVISIBLE);
                random_manhinh = new Random();

                soundPool.play(sound_piano, 100, 100, 5, 0, 1);
               ani_background.start();
                but1.setEnabled(true);
                but2.setEnabled(true);
                but3.setEnabled(true);
                but4.setEnabled(true);
                update_text();


                button_music.setEnabled(false);
                count = 30;
                countDownTimer.start();


            }
        });



    }



    private void choose_song() {
        if (list.get(stt) == 0) {
            play("counting");
        }

        if (list.get(stt) == 1) {
            play("cheap");

        }
        if (list.get(stt) == 2) {
            play("castle_music");

        }
        if (list.get(stt) == 3) {
            play("closer");


        }
        if (list.get(stt) == 4) {
            play("theriver");

        }
        if (list.get(stt) == 5) {
            play("attention_music");
        }
        if (list.get(stt) == 6) {
            play("coldwater");

        }
        if (list.get(stt) == 7) {
            play("beautyandbeat");


        }
        if (list.get(stt) == 8) {
            play("dontletmedown");

        }
        if (list.get(stt) == 9) {

            play("im");
        }

        if (list.get(stt) == 10) {

            play("sugar");

        }

        if (list.get(stt) == 11) {

            play("seeyouagain");

        }
        if (list.get(stt) == 12) {
            play("symphony");


        }
        if (list.get(stt) == 13) {
            play("whatmakeyourbeautiful");


        }

        if (list.get(stt) == 14) {
            play("loveyourself");


        }
        if (list.get(stt) == 15) {
            play("lockedaway");

        }
        if (list.get(stt) == 16) {
            play("maps");


        }
        if (list.get(stt) == 17) {
            play("letmeloveyou");

        }
        if (list.get(stt) == 18) {
            play("whatdoyoumean");

        }
        if (list.get(stt) == 19) {
            play("onething");


        }
        if (list.get(stt) == 20) {
            play("proudofyou");


        }
        if (list.get(stt) == 21) {

            play("badthing");
        }
        if (list.get(stt) == 22) {
            play("cantstopfeeling");

        }
        if (list.get(stt) == 23) {
            play("dontwannaknow");

        }
        if (list.get(stt) == 24) {
            play("imtheone");


        }
        if (list.get(stt) == 25) {
            play("morethanyouknow");

        }
        if (list.get(stt) == 26) {

            play("onecallaway");
        }
        if (list.get(stt) == 27) {
            play("paris");

        }
        if (list.get(stt) == 28) {
            play("allweknow");


        }
        if (list.get(stt) == 29) {
            play("shapeofyou");
        }
        if (list.get(stt) == 30) {
            play("rockabye");
        }
        if (list.get(stt) == 31) {
            play("somethingjustlikethis");

        }
        if (list.get(stt) == 32) {
            play("stay");

        }
        if (list.get(stt) == 33) {
            play("thegreast");

        }
        if (list.get(stt) == 34) {
            play("theocean");
        }
        if (list.get(stt) == 35) {
            play("titanium");

        }
        if (list.get(stt) == 36) {
            play("treatyoubetter");
        }
        if (list.get(stt) == 37) {
            play("vivalavida");
        }
        if (list.get(stt) == 38) {
            play("wedonttalkanymore");


        }
        if (list.get(stt) == 39) {
            play("whatihavedone");
        }
        if (list.get(stt) == 40) {

            play("whynotme");
        }
        if (list.get(stt) == 41) {
            play("alonee");

        }
        if (list.get(stt) == 42) {
            play("beautifulinwhite");
        }
        if (list.get(stt) == 43) {
            play("lethergo");

        }
        if (list.get(stt) == 44) {
            play("mylove");

        }
        if (list.get(stt) == 45) {
            play("onelasttime");
        }
        if (list.get(stt) == 46) {
            play("roar");

        }
        if (list.get(stt) == 47) {
            play("takemetoyourheart");

        }
        if (list.get(stt) == 48) {
            play("untilyou");
        }

        if (list.get(stt) == 49) {
            play("icanfly");

        }
        if (list.get(stt) == 50) {
            play("young");

        }
        if (list.get(stt) == 51) {
            play("ineedyourlove");

        }
        if (list.get(stt) == 52) {
            play("reality");

        }
        if (list.get(stt) == 53) {
            play("rude_music");

        }
        if (list.get(stt) == 54) {
            play("summer");

        }
        if (list.get(stt) == 55) {
            play("tonighttonight");

        }
        if (list.get(stt) == 56) {
            play("burn");

        }
        if (list.get(stt) == 57) {
            play("callmemaybe");

        }
        if (list.get(stt) == 58) {
            play("chandelier");

        }
        if (list.get(stt) == 59) {
            play("havana");

        }
        if (list.get(stt) == 60) {
            play("howtolove");

        }
        if (list.get(stt) == 61) {
            play("ido");

        }
        if (list.get(stt) == 62) {
            play("intheend");

        }
        if (list.get(stt) == 63) {
            play("justthewayyouare");

        }
        if (list.get(stt) == 64) {
            play("lovemeikeyoudo");

        }
        if (list.get(stt) == 65) {
            play("numb");

        }
        if (list.get(stt) == 66) {
            play("scaredtobelonely");

        }
        if (list.get(stt) == 67) {
            play("sorry");

        }
        if (list.get(stt) == 68) {
            play("stereohearts");

        }
        if (list.get(stt) == 69) {
            play("thelazysong");

        }
        if (list.get(stt) == 70) {
            play("thunder");

        }
        if (list.get(stt) == 71) {
            play("waitingforlove");

        }
        if (list.get(stt) == 72) {
            play("youbelongwithme");

        }
        if (list.get(stt) == 73) {
            play("baby");

        }
        if (list.get(stt) == 74) {
            play("allfallsdown");

        }
        if (list.get(stt) == 75) {
            play("legendneverdie");

        }
        if (list.get(stt) == 76) {
            play("outside");

        }
        if (list.get(stt) == 77) {
            play("likeido");

        }
        if (list.get(stt) == 78) {
            play("badday");

        }
        if (list.get(stt) == 79) {
            play("cryonmyshoulder");

        }
        if (list.get(stt) == 80) {
            play("dusktilldawn");

        }
        if (list.get(stt) == 81) {
            play("heathens");

        }
        if (list.get(stt) == 82) {
            play("itaintme");

        }
        if (list.get(stt) == 83) {
            play("starving");

        }
        if (list.get(stt) == 84) {
            play("thespectre");

        }
        if (list.get(stt) == 85) {
            play("seve");

        }
        if (list.get(stt) == 86) {
            play("youi");

        }
        if (list.get(stt) == 87) {
            play("livewhile");

        }
        if (list.get(stt) == 88) {
            play("sungoesdown");

        }
        if (list.get(stt) == 89) {
            play("whereareunow");

        }
        if (list.get(stt) == 90) {
            play("iwantyoutoknow");

        }
        if (list.get(stt) == 91) {
            play("beautifulnow");

        }
        if (list.get(stt) == 92) {
            play("leanon");

        }
        if (list.get(stt) == 93) {
            play("roses");

        }
        if (list.get(stt) == 94) {
            play("showmelove");

        }
        if (list.get(stt) == 95) {
            play("areyouwithme");

        }
        if (list.get(stt) == 96) {
            play("nextome");

        }
        if (list.get(stt) == 97) {
            play("rise");

        }
        if (list.get(stt) == 98) {
            play("darkside");

        }
        if (list.get(stt) == 99) {
            play("girllikeyou");

        }
        if (list.get(stt) == 100) {
            play("ignite");

        }

    }




    private void background_null() {
        but1.setScaleX(0f);
        but1.setScaleY(0f);

        but2.setScaleX(0f);
        but2.setScaleY(0f);

        but3.setScaleX(0f);
        but3.setScaleY(0f);

        but4.setScaleX(0f);
        but4.setScaleY(0f);
    }


    private void init() {

        button_music = findViewById(R.id.button_music_start);

        but1 = (Button) findViewById(R.id.but1_music);
        but2 = (Button) findViewById(R.id.but2_music);
        but3 = (Button) findViewById(R.id.but3_music);
        but4 = (Button) findViewById(R.id.but4_music);

        but1.setScaleX(0f);
        but1.setScaleY(0f);

        but2.setScaleX(0f);
        but2.setScaleY(0f);

        but3.setScaleX(0f);
        but3.setScaleY(0f);

        but4.setScaleX(0f);
        but4.setScaleY(0f);



        list = new ArrayList<>();
        for(int i=0;i<Correct.length;i++)
        {
            list.add(i);
            Collections.shuffle(list);}
            soundPool = new SoundPool(10,AudioManager.STREAM_MUSIC,10);

            ani_background = new AnimatorSet();
            ani_background.setDuration(2000);
            ani_background.setStartDelay(0);


            sound_piano = soundPool.load(getApplicationContext(), R.raw.piano_start, 1);

            player = new MediaPlayer();
            player.setVolume(50,50);
    }
    private void thangTeodibui()
    {
        String title="";
        SharedPreferences sharedPreferences = getSharedPreferences("mydata123",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int high_score = sharedPreferences.getInt("Score_Music",0);
        if(high_score<score)
        {
            title="NEW RECORD";
            high_score=score;
            editor.putInt("Score_Music",high_score);
            editor.commit();
        }else
        {
            title="RESULT";
        }

    }
    private  void stopmusic()   {
        button_music.cancelAnimation();
        but1.setText("");
        but2.setText("");
        but3.setText("");
        but4.setText("");
        if(player.isPlaying()) {
            player.pause();
        }


    }


    private void capnhat() {

        if(stt==100)
        {
            thangTeodibui();

        }







    }

    public void update_text() {


        but1.setScaleX(0f);
        but1.setScaleY(0f);
        ViewCompat.animate(but1).scaleX(1f).scaleY(1f).setDuration(700).start();

        but2.setScaleX(0f);
        but2.setScaleY(0f);
        ViewCompat.animate(but2).scaleX(1f).scaleY(1f).setDuration(700).start();


        but3.setScaleX(0f);
        but3.setScaleY(0f);
        ViewCompat.animate(but3).scaleX(1f).scaleY(1f).setDuration(700).start();


        but4.setScaleX(0f);
        but4.setScaleY(0f);
        ViewCompat.animate(but4).scaleX(1f).scaleY(1f).setDuration(700).start();


        array = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            array.add(i);
            Collections.shuffle(array);
        }

            but1.setText(traloi[list.get(stt)][array.get(0)]);
            but2.setText(traloi[list.get(stt)][array.get(1)]);
            but3.setText(traloi[list.get(stt)][array.get(2)]);
            but4.setText(traloi[list.get(stt)][array.get(3)]);
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
                startActivity(new Intent(Game_Music.this,Menu_Game.class));
            }
        });
        but_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }



    private void play(String resourceID) {
        // play current song.
        player.reset();
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_ALARM);

            player = MediaPlayer.create(getApplicationContext(), Uri.parse("https://kenkostudio.000webhostapp.com/sever/sound_game_music/"+resourceID+".lite.mp3"));
        // player = MediaPlayer.create(Game_Music.this, Uri.parse("https://kenkostudio.000webhostapp.com/sever/sound_game_music/"+"youbelongwithme"+".mp3"));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            player.setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build());
        } else {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        }



        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toasty.success(Game_Music.this,"Lỗi",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Game_Music.this,Menu_Game.class);
                finish();
                startActivity(intent);
                return  true;
            }
        });
    }

    @Override
    protected void onPause() {
        button_music.setEnabled(true);
        countDownTimer.cancel();
        stopmusic();
        count=30;
        super.onPause();
        stt += 1;
        capnhat();

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }


    @Override
    protected void onStart() {
        super.onStart();

    }


}
