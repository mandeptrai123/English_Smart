package teamkenko.english_smart.game_choose.game_dap_trung;

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

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;


import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;

import teamkenko.english_smart.Your_Words.Word;
import teamkenko.english_smart.game_choose.menu_game.Menu_Game;


public class Game_DapTrung extends AppCompatActivity {
    RecyclerView recyclerView;
    public int height;
    public  int width;
    String[] question_primary;
    TextViewFonts text_score;
    int score=0;
    int solanthua= 0 ;
    public  int stt=0;
    public  String current;
    public ArrayList<Integer> list;
    GridviewAdapter_daptrung adapter_recycler;
    CountDownTimer countDownTimer,count_next;
    public String [][]answer_button={{"Con Nai","Ô Nhiễm","Huyền Thoại","Ngôn Ngữ"},
            {"Con Báo","Sư Tử","Con Tê Giác","Nhà Triết Học"},
            {"Kinh Nghiệm","Cơ hội","Sự Tuyệt Chủng","Bình Chữa Cháy"},
            {"Nhà Sinh Học","Hóa Đơn","Thời Trang","Sự Hứng Thú"},
            {"Con Châu Chấu","Con Khỉ Đột","Mạnh mẽ","Lộng Lẫy"},
            {"Tốc Độ","Hấp Dẫn","Thơm Ngon","Tập Trung"},
            {"Hiệu Suất","Nhân Cách","Truy Vấn","Quan Điểm"},
            {"Văn Chương","Xả Rác","Tổng Thống","Bi Quan"},
            {"Khuyên Bảo","Lợi Thế","Địa Chỉ","Quảng Cáo"},
            {"Sự Giải Trí","Người Đam Mê","Môi Trường","Doanh Nghiệp"}
            ,{"Khinh Bỉ","Thiêu Đốt","Bọ Cạp","Bảng Điểm"},
            {"Sự Cho Phép","Sự Phát Triển","Đo Đạc","Hối Hả"},
            {"Bóng Rổ","Trình Diễn","Đấu Vật","Cá Sấu"},
            {"Bóng Chuyền","Tình Nguyện","Quan Trọng","Va Chạm"},
            {"Tinh Thần Đoàn Kết","Cải Thiện","Mất Lòng Tin","Hướng Dẫn Viên"},
            {"Đau Đầu","Trụ Sở","Chiều Cao","Viêm Gan"},
            {"Giới Thiệu","Ghi Lại","Công Đoàn","Biên Lai"},
            {"Bình Yên","Thời Kỳ Hòa Bình","Tháng Giêng","Biển Nóng"}
            ,{"Phân Phối","Dịch Bệnh","Phân Biệt Đối Xử","Đáng Tin Cậy"},
            {"Lĩnh Vực","Từ Thiện","Triết Học","Lừa Đảo"},
            {"Đối Diện","Cơ Hội","Phản Đối","Ý Kiến"}};

    public String[] correct = {"Ô Nhiễm","Con Tê Giác","Sự Tuyệt Chủng","Nhà Sinh Học","Con Khỉ Đột"
            ,"Hấp Dẫn","Nhân Cách","Văn Chương","Lợi Thế","Người Đam Mê","Bảng Điểm","Sự Phát Triển","Đấu Vật","Bóng Chuyền",
            "Tinh Thần Đoàn Kết","Trụ Sở","Công Đoàn","Thời Kỳ Hòa Bình","Phân Biệt Đối Xử","Triết Học","Cơ Hội"};
    String [] words ={"contaminate","rhinoceros","extinction","biologist","gorilla","fascinating"
            ,"personality","literature",
    "advantage","enthusiast","scoreboard","development","wrestling","volleyball","solidarity",
           "headquarters","federation","peacetime",
    "discriminate","philosopher","opportunity"};
    String [] vocabulary={"/ kənˈtamɪneɪt /","/rʌɪˈnɒs(ə)rəs/","/ ɪkˈstɪŋ(k)ʃə)n/","/ bʌɪˈɒlədʒɪst /","/ ɡəˈrɪlə /","/ˈFasɪneɪtɪŋ /","/ pəːsəˈnalɪti /",
    "/ ˈLɪt(ə)rətʃə/","/ ədˈvɑːntɪdʒ /","/ ɪnˈθjuːzɪast /","/ ˈSkɔːbɔːd /","/dɪˈvɛləpm(ə)nt/","/ˈrɛslɪŋ/","/ˈvɒlɪbɔːl/","/ˌsɒlɪˈdarɪti/","/hɛdˈkwɔːtəz/",
    "/fɛdəˈreɪʃ(ə)n/","/ˈpiːstʌɪm/","/dɪˈskrɪmɪneɪt/","/fɪˈlɒsəfə/","/ɒpəˈtjuːnɪti/"};

String[] questions={"Contaminate","Rhinoceros","Extinction","Biologist","Gorilla","Fascinating","Personality","Literature","Advantage","Enthusiast",
"Scoreboard","Development","Wrestling","Volleyball","Solidarity","Headquater","Federation","Peacetime","Discriminate","Philosopher","Opportunity"};
    public int[] count_lathinh={5,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,4,4,5,4,4};
    public  int solanfree;
    SoundPool soundPool;
    AudioManager audioManager;
    float current_music,max_music;
    private  static final int stream_type = AudioManager.STREAM_MUSIC;
    public int music_nhap;
    TextView text_show_answer,noti_result;
    LayoutAnimationController controller =null;
    ListView list_answer;
    public Button but_start;
    Game_DapTrung_Answer adapter_answer;
    int count=2;
    int type=1;
    public int pos_correct;
    MediaPlayer mediaPlayer;
    LottieAnimationView but_add;

    private DatabaseReference firebaseDatabase;
    private FirebaseAuth mAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_daptrung);

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        current_music = audioManager.getStreamVolume(stream_type);
        max_music =  audioManager.getStreamMaxVolume(stream_type);

        //
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();


        but_add  = findViewById(R.id.add_note_daptrung);
        this.setVolumeControlStream(stream_type);
        soundPool = new SoundPool(5,AudioManager.STREAM_MUSIC,1);
       // music_nhap = soundPool.load(this,R.raw.but_music_nhap,1);
        controller = AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_go_up);

        list = new ArrayList<>();
        for(int i =0;i<correct.length;i++){
            list.add(i);
            Collections.shuffle(list);

        }
        // init
        intit_view();

        // init for first game.
        current = correct[list.get(stt)];
        solanfree = count_lathinh[list.get(stt)];
        set_adapter();
        setbutton();
        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(getApplicationContext(),"Thêm Thành Công",Toast.LENGTH_SHORT).show();
                firebaseDatabase.child(firebaseUser.getUid()).child(words[list.get(stt)]).setValue( new Word(questions[list.get(stt)],correct[list.get(stt)],vocabulary[list.get(stt)],"Sound","Question"));
            }
        });




    }

    public void set_game(final Button but_r)
    {
        text_show_answer.setVisibility(View.VISIBLE);
        text_show_answer.setScaleX(0f);
        text_show_answer.setScaleY(0f);
        text_show_answer.setText(words[list.get(stt)]+" ("+vocabulary[list.get(stt)]+") "+"\n"+correct[list.get(stt)]);

        // animation for text_show
        ViewCompat.animate(text_show_answer).scaleX(1f).setDuration(100).start();
        ViewCompat.animate(text_show_answer).scaleY(1f).setDuration(100).start();
        noti_result.setVisibility(View.VISIBLE);
        check_result(but_r);
        but_add.setVisibility(View.VISIBLE);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), Uri.parse("https://ssl.gstatic.com/dictionary/static/sounds/oxford/"+words[list.get(stt)]+"--_gb_1.mp3?fbclid=IwAR1ROYgKLxni3gKG-miOSolThQFc8u8tvG8mIqsK4ku1qvwKsV_QalluJY8"));

        mediaPlayer.start();

        // count down to start new game.
        count_next = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {


            }
            @Override
            public void onFinish() {
                set_result();
                cancel_count_down();

            }
        };
        count_next.start();
    }

    private void intit_view()
    {

        but_start = findViewById(R.id.button_start_daptrung);
        list_answer = findViewById(R.id.list_answer_daptrung);
        noti_result = (TextView)findViewById(R.id.noti_result);
        text_show_answer = (TextView) findViewById(R.id.show_answer);
        set_screen();



        text_score =findViewById(R.id.text_score_daptrung);
    }

    private void set_screen()
    {
        findViewById(R.id.screen_choosen_daptrung).setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) findViewById(R.id.screen_choosen_daptrung);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        adapter_recycler = new GridviewAdapter_daptrung(Game_DapTrung.this,capnhat(),Game_DapTrung.this,soundPool);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setAdapter(adapter_recycler);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void set_result()
    {
            text_score.setText("Score: " + score);
            stt += 1;
            solanfree = count_lathinh[list.get(stt)];
            current = correct[stt];
            Game_DapTrung_Data.count=2;
            Game_DapTrung_Data.type=1;
            Game_DapTrung_Data.count_open=0;
            set_screen();
            set_adapter();



    }
    public void check_result(Button but) {
        if (but.getText().equals(correct[list.get(stt)])) {
            noti_result.setBackgroundColor(Color.parseColor("#33FF33"));
            noti_result.setText("Correct !");
            score += 1;
            text_score.setText("Score: " + score);
        } else {
            noti_result.setBackgroundColor(Color.parseColor("#FF0000"));
            noti_result.setText("Wrong Answer !");
            text_score.setText("Score: " + score);
            solanthua += 1;
            if (solanthua > 2) {
                thangTeodibui();
            }
        }
        ViewCompat.animate(noti_result).translationX(0f).setDuration(300).start();
    }

    public void set_adapter() {
        but_add.setVisibility(View.INVISIBLE);
        adapter_answer = new Game_DapTrung_Answer(this,answer_button[list.get(stt)],Game_DapTrung_Data.count,Game_DapTrung_Data.type,this,pos_correct);
        list_answer.setAdapter(adapter_answer);
        adapter_answer.notifyDataSetChanged();



    }
    public String[] capnhat() {
        setbutton();

            question_primary = new String[questions[list.get(stt)].length()];

            for (int i = 0; i < questions[list.get(stt)].length(); i++) {
                question_primary[i] = String.valueOf(questions[list.get(stt)].charAt(i));
            }


        return question_primary;
    }

    private void cancel_count_down() {
        count_next.cancel();
        noti_result.setVisibility(View.INVISIBLE);
    }

    private void thangTeodibui() {
        String title="";
        SharedPreferences sharedPreferences = getSharedPreferences("mydata123",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int high_score = sharedPreferences.getInt("Score_LatHinh",0);
        if(high_score<score)
        {
            title="NEW RECORD";
            high_score=score;
            editor.putInt("Score_LatHinh",high_score);
            editor.commit();
        }else
        {
            title="RESULT";
        }


    }






   public void setbutton() {

        text_show_answer.setVisibility(View.INVISIBLE);
        noti_result.setVisibility(View.INVISIBLE);
        noti_result.setX(-1000f);
        but_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.screen_choosen_daptrung).setVisibility(View.INVISIBLE);
                Game_DapTrung_Data.type=2;
                ArrayList<Integer> arrayList= new ArrayList();
              for(int i=0;i<Game_DapTrung_Data.count;i++)
              {
                  arrayList.add(i);
                  Collections.shuffle(arrayList);
              }

                but_start.setClickable(false);

                set_adapter();
            }
        });


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
                startActivity(new Intent(Game_DapTrung.this,Menu_Game.class));
            }
        });
        but_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

    }
}
