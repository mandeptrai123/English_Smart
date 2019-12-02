package teamkenko.english_smart.Solo_Words;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import de.hdodenhof.circleimageview.CircleImageView;
import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;
import teamkenko.english_smart.menu.Menu_English;

public class TranDau extends AppCompatActivity {
    private String[][] cauhoi={{"Language","Replace","Adjust","Distinctive"},{"Renew","Similar","Surface","Morality"},
            {"Cloud","Promise","Tolerant","Pragmatic"},{"Graphic","Scientist","Emulator","Vegetarian"},
            {"Register","Religion","Precede","Mortgage"} ,{"Donate","Lease","Estate","Enormous"}};
    private  int [][] correct={{2,0,3,1},{3,1,0,2},
            {3,0,1,2},{3,1,2,0},
            {1,0,2,3},{3,0,1,2}};

    private String[][] traloi={{"Thay Thế","Đặc Biệt","Ngôn Ngữ","Điều Chỉnh"},{"Bề Mặt","Tương Đồng","Đạo Đức","Làm Mới"},
            {"Lời Hứa","Khoan Dung","Thực Dụng","Đám Mây"},{"Ăn Chay","Nhà Khoa Học","Giả Lập","Đồ Họa"},
            {"Tôn Giáo","Đăng Ký","Đứng Trước","Thế Chấp"}, {"Cho Thuê","Bất Động Sản","To Lớn","Tặng"}};
    private int vitri_cauhoi;
    String photo1,photo2;
    SeekBar seek;
    CountDownTimer countDownTimer;
    TextView text1_get,text2_get,text3_get,text4_get,text1_choo,text2_choo,text3_choo,text4_choo;
    String word_choose="";
    String word_ans ="";
    TextView ans;
    int count=0;
    public int dem=7;
    String turns ="";
    private boolean set_users = true;
    private boolean thread = false;
    private CountDownTimer count_next;
    private String UI ="";
    public static String nguoichoi1="";
    public static String nguoichoi2="";
    DatabaseReference firebaseDatabase;
    public static boolean have_turn = true;
    public static boolean have_ui = true;
    public String turn_user;
    public static boolean have = true;
    public static boolean stop_count_next=true;
    public  static int UI_curent;
    private static String thachdo="";
    private static int score1 ;
    private static int score2;
    private static int current_score_1=-1;
    private static int current_score_2=-1;
    public int stt =0;
    int type_ans;
    TextView text_score_1,text_score_2;
    CountDownTimer mm;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran_dau);
        // set Firebase Path .
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Game").child(Game.game);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        // get UI.
        update_UI();
    }
    private void set_user() {
        // set first .
        if(set_users)
        {
            // firt turn.
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.item_set_user);

            CircleImageView img_1 = progressDialog.findViewById(R.id.set_img_1);
            CircleImageView img_2 = progressDialog.findViewById(R.id.set_img_2);

            // set image
            Picasso.with(getApplicationContext()).load(photo1).into(img_1, new Callback() {
                @Override
                public void onSuccess() {
                     progressDialog.findViewById(R.id.loading_nguoichoi_1).setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError() {
                    Toasty.warning(getApplicationContext(),"Loading Image Failed").show();

                }
            });

            Picasso.with(getApplicationContext()).load(photo2).into(img_1, new Callback() {
                @Override
                public void onSuccess() {
                    progressDialog.findViewById(R.id.loading_nguoichoi_2).setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError() {
                    Toasty.warning(getApplicationContext(),"Loading Image Failed").show();

                }
            });



            TextViewFonts name_1     = progressDialog.findViewById(R.id.set_name_1);
            TextViewFonts name_2     = progressDialog.findViewById(R.id.set_name_2);
            if(Game.user==1)
            {
                name_1.setText(nguoichoi2);
                name_2.setText(nguoichoi1);


            }else {


                name_1.setText(nguoichoi1);
                name_2.setText(nguoichoi2);
            }
            img_1.setX(1000f);
            img_2.setX(-1000f);

            ViewCompat.animate(img_1).translationX(0f).setDuration(1000).start();
            ViewCompat.animate(img_2).translationX(0f).setDuration(1000).start();
            ViewCompat.animate(name_1).translationX(0f).setDuration(1000).start();
            ViewCompat.animate(name_2).translationX(0f).setDuration(1000).start();
            CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    progressDialog.dismiss();
                    set_users=false;
                    UI_suitable();

                }
            };
            countDownTimer.start();
        }
    }
    private void update_score()
    {
        if(current_score_1!=score1)
        {
            if(current_score_1>score1)
            {
                // Lose
                if(Game.user==1)
                {
                    current_score_1 = score1;
                    dialog_result("Lose.",2);

                }else// Win
                {
                    dialog_result("Win.",2);
                    current_score_1 = score1;
                }
            }else
            {
                if(Game.user==2)
                {
                    dialog_result("Lose.",1);
                    current_score_1 = score1;

                }else// Win
                {
                    dialog_result("Win.",1);
                    current_score_1 = score1;
                }
            }


        }

    }

    private void dialog_result(String s,int win) {
        final ProgressDialog pg_result = new ProgressDialog(this);
        pg_result.show();
        if (pg_result.getWindow() != null) {
            pg_result.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        }

        pg_result.setContentView(R.layout.item_result);
        final TextView text_score = (TextView) pg_result.findViewById(R.id.dialog_score);
        TextView text_result = (TextView) pg_result.findViewById(R.id.dialog_result);
        final Button but_cancel = (Button) pg_result.findViewById(R.id.result_cancel);
        final Button but_next   = (Button) pg_result.findViewById(R.id.result_next);
        dem=5;
        but_next.setText("Tiếp("+dem+")");
        but_next.setClickable(false);
        but_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pg_result.dismiss();
                firebaseDatabase.child("Exit").setValue("1");
                startActivity(new Intent(TranDau.this,Menu_English.class));
                Toast.makeText(getApplicationContext(),"Bạn Vừa Thoát Trận",Toast.LENGTH_SHORT).show();
                finish();
                onDestroy();
            }
        });


        pg_result.setCancelable(false);
        text_score.setX(1000f);
        text_result.setScaleY(0f);
        text_result.setScaleX(0f);
        if(Game.user==win)
        {
            text_result.setText("You Win");
        }else
        {
            text_result.setText("You Lose");
        }
        if(Game.user==1)
        {
            text_score.setText("My Score: "+score1);
        }else
        {
            text_score.setText("My Score: "+score2);
        }
        stop_count_next=true;
            AnimatorSet animation_dialog = new AnimatorSet();
            animation_dialog.setDuration(2500);
        animation_dialog.playTogether(
                ObjectAnimator.ofFloat(text_result,"ScaleX",0f,1f),
                ObjectAnimator.ofFloat(text_result,"ScaleY",0f,1f)
        );
        animation_dialog.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ViewCompat.animate(text_score).translationX(0f).setDuration(1000).start();

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        animation_dialog.start();
        count_next = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                dem-=1;
                but_next.setText("Tiếp("+dem+")");
            }

            @Override
            public void onFinish() {
                dem=5;
                pg_result.dismiss();
                Log.d("ACCEPT","0");
                trans_UI();
            }
        };
        count_next.start();


    }



    private void submit_score(){

        if(word_ans.equals(traloi[stt][correct[stt][vitri_cauhoi]]))
        // if answer correct.
        {
            Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
            if(Game.user==1)
            {
                if(thachdo.equals("1") || thachdo.equals("2"))
                {
                    score1+=2;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                    score2-=2;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                }else
                {
                    score1+=1;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                    score2-=1;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                }

            }
            else
            {
                score2+=1;
                firebaseDatabase.child("user2").child("Score").setValue(score2);
                score1-=1;
                firebaseDatabase.child("user1").child("Score").setValue(score1);
            }

            // if answer wrong.
        }else
        {
            Toast.makeText(getApplicationContext(),word_ans+" "+traloi[stt][correct[stt][vitri_cauhoi]],Toast.LENGTH_SHORT).show();

            if(Game.user==1)
            {
                if(thachdo.equals("1") || thachdo.equals("2"))
                {
                    score1-=2;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                    score2+=2;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                }else
                {
                    score1-=1;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                    score2+=1;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                }

            }else
            {
                if(thachdo.equals("1") || thachdo.equals("2"))
                {
                    score2-=2;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                    score1+=2;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                }else
                {
                    score2-=1;
                    firebaseDatabase.child("user2").child("Score").setValue(score2);
                    score1+=1;
                    firebaseDatabase.child("user1").child("Score").setValue(score1);
                }

            }

        }
    }


    private void update_UI() {
        // update UI consecutive.
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot data : dataSnapshot.getChildren())
                {
                    if(data.getKey().equals("Type_Ans"))
                    {
                        type_ans= Integer.parseInt(data.getValue().toString());
                    }

                    if(data.getKey().equals("STT"))
                    {
                        stt = Integer.parseInt(data.getValue().toString());
                    }
                    if(data.getKey().equals("Vitri"))
                    {
                        vitri_cauhoi = Integer.parseInt(data.getValue().toString());
                    }
                    if(data.getKey().equals("TD"))
                    {
                        thachdo= data.getValue().toString();
                    }
                    if(data.getKey().equals("Question"))
                    {
                        word_choose = data.getValue().toString();
                    }
                    if(data.getKey().equals("Turns"))
                    {
                        turn_user = data.getValue().toString();
                    }

                    if(data.getKey().equals("UI"))
                    {
                        UI =data.getValue().toString();
                        UI_suitable();
                    }

                    if(data.getKey().equals("user1"))
                    {
                        nguoichoi1= data.child("usernames").getValue().toString();
                        score1    = Integer.parseInt(data.child("Score").getValue().toString());
                        photo1    = data.child("photo1").getValue().toString();
                        if(current_score_1==-1)
                        {
                            current_score_1 = score1;
                        }




                    }
                    if(data.getKey().equals("user2"))
                    {
                        nguoichoi2 = data.child("usernames").getValue().toString();
                        score2     = Integer.parseInt(data.child("Score").getValue().toString());
                        photo2     = data.child("photo2").getValue().toString();
                        if(current_score_2==-1)
                        {
                            current_score_2 = score2;
                        }
                        update_score();
                        set_user();
                    }
                    if(data.getKey().equals("Exit") && data.getValue().equals("1"))
                    {
                        DatabaseReference dele = firebaseDatabase;
                        dele.removeValue();
                        startActivity(new Intent(TranDau.this,Menu_English.class));
                        finish();

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @SuppressLint("ResourceType")
    private void user_2() {
        // prevent consecutive update.
        if(UI_curent!=2 || !thachdo.equals("")) {
            UI_curent = 2;
            thread=false;
            // set Layout for UI 2.
            setContentView(R.layout.choose_answer);
            ans = (TextView) findViewById(R.id.question);
            switch (type_ans)
            {
                case 1:
                    ans.setTextColor(Color.parseColor("#110000"));
                    break;
                case 2:
                    ans.setTextColor(Color.parseColor("#00FF66"));
                    break;
                case 3:
                    ans.setTextColor(Color.parseColor("#3399FF"));
                    break;
                case 4:
                    ans.setTextColor(Color.parseColor("#FF0000"));
                    break;
                default:
                    ans.setTextColor(Color.parseColor("#110000"));
                    break;
            }
            TextView name_1 = findViewById(R.id.name_user_1);
            TextView name_2 = findViewById(R.id.name_user_2);
            CircleImageView img_user = findViewById(R.id.img_user_2_choo);
            CircleImageView img_user_rival = findViewById(R.id.img_user_1_choo);
            Picasso.with(getApplicationContext()).load(firebaseUser.getPhotoUrl()).into(img_user);



            findViewById(R.id.seek_bar_1_choo).setVisibility(View.VISIBLE);
            findViewById(R.id.seek_bar_2_choo).setVisibility(View.VISIBLE);

            if(!word_choose.equals(""))
            {
                ans.setText(word_choose);
            }
            text1_choo = (TextView) findViewById(R.id.text_1_choo);
            text2_choo = (TextView) findViewById(R.id.text_2_choo);
            text3_choo = (TextView) findViewById(R.id.text_3_choo);
            text4_choo = (TextView) findViewById(R.id.text_4_choo);


            text1_choo.setText(traloi[stt][0]);
            text2_choo.setText(traloi[stt][1]);
            text3_choo.setText(traloi[stt][2]);
            text4_choo.setText(traloi[stt][3]);
            text_score_1 = (TextView) findViewById(R.id.score_choo_1);
            text_score_2 = (TextView) findViewById(R.id.score_choo_2);


            // set content .

            if (turn_user.equals("1") && thachdo.equals("")) {
                if (Game.user == 1) {
                    turns = "Đoán Nghĩa Hoặc Thách Đố";
                    seek = (SeekBar) findViewById(R.id.seek_bar_2_choo);
                    findViewById(R.id.seek_bar_1_choo).setVisibility(View.INVISIBLE);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    text_score_1.setText("Score :"+score2);
                    text_score_2.setText("Score :"+score1);
                    name_1.setText(nguoichoi2);
                    name_2.setText(nguoichoi1);
                } else {
                    turns = "";
                    findViewById(R.id.pass).setVisibility(View.INVISIBLE);
                    findViewById(R.id.seek_bar_2_choo).setVisibility(View.INVISIBLE);
                    seek = (SeekBar) findViewById(R.id.seek_bar_1_choo);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    ans.setEnabled(false);
                    text1_choo.setEnabled(false);
                    text2_choo.setEnabled(false);
                    text3_choo.setEnabled(false);
                    text4_choo.setEnabled(false);
                    text_score_1.setText("Score :"+score1);
                    text_score_2.setText("Score :"+score2);
                    name_1.setText(nguoichoi1);
                    name_2.setText(nguoichoi2);
                }
                // Both
                text1_choo.setScaleX(0);
                text1_choo.setScaleY(0);

                text2_choo.setScaleX(0);
                text2_choo.setScaleY(0);

                text3_choo.setScaleX(0);
                text3_choo.setScaleY(0);

                text4_choo.setScaleX(0);
                text4_choo.setScaleY(0);

                ans.setScaleX(0);
                ans.setScaleY(0);
                ans.setText(word_choose);
                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(700);
                animatorSet.playTogether(
                        ObjectAnimator.ofFloat(text1_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text1_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleY", 0, 1f)
                );
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        next();

                    }
                });
                animatorSet.start();

            } else if(turn_user.equals("2") && thachdo.equals("")) {
                if (Game.user == 2) {
                    ans = (TextView) findViewById(R.id.question);
                    text1_choo = (TextView) findViewById(R.id.text_1_choo);
                    text2_choo = (TextView) findViewById(R.id.text_2_choo);
                    text3_choo = (TextView) findViewById(R.id.text_3_choo);
                    text4_choo = (TextView) findViewById(R.id.text_4_choo);
                    // set answers
                    turns = "Đoán Nghĩa Hoặc Thách Đố";
                    seek = (SeekBar) findViewById(R.id.seek_bar_2_choo);
                    findViewById(R.id.seek_bar_1_choo).setVisibility(View.INVISIBLE);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    text_score_1.setText("Score :"+score1);
                    text_score_2.setText("Score :"+score2);
                    name_1.setText(nguoichoi1);
                    name_2.setText(nguoichoi2);
                } else {
                    findViewById(R.id.pass).setVisibility(View.INVISIBLE);
                    turns = "Đợi Đối Thủ Đoán Nghĩa.";
                    findViewById(R.id.seek_bar_2_choo).setVisibility(View.INVISIBLE);
                    seek = (SeekBar) findViewById(R.id.seek_bar_1_choo);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    ans.setEnabled(false);
                    text1_choo.setEnabled(false);
                    text2_choo.setEnabled(false);
                    text3_choo.setEnabled(false);
                    text4_choo.setEnabled(false);
                    text_score_1.setText("Score :"+score2);
                    text_score_2.setText("Score :"+score1);
                    name_1.setText(nguoichoi2);
                    name_2.setText(nguoichoi1);
                }

                // set first Scale
                text1_choo.setScaleX(0);
                text1_choo.setScaleY(0);

                text2_choo.setScaleX(0);
                text2_choo.setScaleY(0);

                text3_choo.setScaleX(0);
                text3_choo.setScaleY(0);

                text4_choo.setScaleX(0);
                text4_choo.setScaleY(0);

                ans.setScaleX(0);
                ans.setScaleY(0);
                ans.setText(word_choose);


                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(700);
                animatorSet.playTogether(
                        // set second Scale.
                        ObjectAnimator.ofFloat(text1_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text1_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleY", 0, 1f)
                );
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        next();
                        count = 0;
                    }
                });
                animatorSet.start();
            } else if(!thachdo.equals(""))
            {
                findViewById(R.id.pass).setVisibility(View.INVISIBLE);
                if(thachdo.equals("1"))
                {
                    if(Game.user==1)
                    {
                        turns="Thách Đố Thành Công";
                        thachdo="";
                        firebaseDatabase.child("TD").setValue("");
                        seek = (SeekBar) findViewById(R.id.seek_bar_1_choo);
                        findViewById(R.id.seek_bar_2_choo).setVisibility(View.INVISIBLE);
                        seek.setMax(40000);
                        count=0;
                        seek.setProgress(count);
                        text_score_1.setText("Score :"+score2);
                        text_score_2.setText("Score :"+score1);
                        name_1.setText(nguoichoi2);
                        name_2.setText(nguoichoi1);

                    }else
                    {
                        turns="Bạn Bị Thách Đố";
                        thachdo="";
                        firebaseDatabase.child("TD").setValue("");
                        seek = (SeekBar) findViewById(R.id.seek_bar_2_choo);
                        findViewById(R.id.seek_bar_1_choo).setVisibility(View.INVISIBLE);
                        seek.setMax(40000);
                        count=0;
                        seek.setProgress(count);
                        text_score_1.setText("Score :"+score1);
                        text_score_2.setText("Score :"+score2);
                        name_1.setText(nguoichoi1);
                        name_2.setText(nguoichoi2);
                    }
                }else
                {
                    if(Game.user==2)
                    {
                        turns="Thách Đố Thành Công";
                        thachdo="";
                        firebaseDatabase.child("TD").setValue("");
                        seek = (SeekBar) findViewById(R.id.seek_bar_2_choo);
                        findViewById(R.id.seek_bar_1_choo).setVisibility(View.INVISIBLE);
                        seek.setMax(40000);
                        count=0;
                        seek.setProgress(count);
                        text_score_1.setText("Score :"+score1);
                        text_score_2.setText("Score :"+score2);
                        name_1.setText(nguoichoi1);
                        name_2.setText(nguoichoi2);

                    }else
                    {
                        turns="Bạn Bị Thách Đố";
                        thachdo="";
                        firebaseDatabase.child("TD").setValue("");
                        seek = (SeekBar) findViewById(R.id.seek_bar_2_choo);
                        findViewById(R.id.seek_bar_1_choo).setVisibility(View.INVISIBLE);
                        seek.setMax(40000);
                        count=0;
                        seek.setProgress(count);
                        text_score_1.setText("Score :"+score2);
                        text_score_2.setText("Score :"+score1);
                        name_1.setText(nguoichoi2);
                        name_2.setText(nguoichoi1);
                    }
                }
                // both
                // set first postion.
                text1_choo.setScaleX(0);
                text1_choo.setScaleY(0);

                text2_choo.setScaleX(0);
                text2_choo.setScaleY(0);

                text3_choo.setScaleX(0);
                text3_choo.setScaleY(0);

                text4_choo.setScaleX(0);
                text4_choo.setScaleY(0);

                ans.setScaleX(0);
                ans.setScaleY(0);
                ans.setText(word_choose);


                final AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(700);
                animatorSet.playTogether(
                        // set second Scale.
                        ObjectAnimator.ofFloat(text1_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text1_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text2_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text3_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(text4_choo, "scaleY", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleX", 0, 1f),
                        ObjectAnimator.ofFloat(ans, "scaleY", 0, 1f)
                );
                animatorSet.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        next();
                        count = 0;
                    }
                });
                animatorSet.start();


            }
        }

    }


    private void trans_UI() {

        switch (UI)
        {

            case "1":
                if(have_ui)
                {
                    firebaseDatabase.child("UI").setValue("2");
                    have_ui=false;
                }
                break;
            case "2":
                if(have_ui)
                {
                    firebaseDatabase.child("UI").setValue("1");
                    have_ui=false;
                }
                break;
        }


    }
    private void trans_Turn() {
        if(have_turn)
        {
            if(turn_user.equals("1"))
            {
                firebaseDatabase.child("Turns").setValue("2");
                have_turn=false;
            }
            else
            {
                firebaseDatabase.child("Turns").setValue("1");
                have_turn=false;
            }

        }



    }
    private void have_question() {

        firebaseDatabase.child("Question").setValue(word_choose);
    }

    private void UI_suitable()
    {
        if(set_users==false)
        {
            switch (UI)
            {
                case "1":
                    user_1();
                    break;
                case "2":
                    user_2();
                    break;

            }
        }
        // set first .


    }


    private void user_1() {
        if(UI_curent!=1)
        {
            UI_curent=1;
            thread=false;
            // both.
            setContentView(R.layout.get_question);
            TextView name_1 = findViewById(R.id.name_user_1_get);
            TextView name_2 = findViewById(R.id.name_user_2_get);
            CircleImageView img_user = findViewById(R.id.img_user_2_get);
            CircleImageView img_user_rival = findViewById(R.id.img_user_1_get);
            Picasso.with(getApplicationContext()).load(firebaseUser.getPhotoUrl()).into(img_user);


            final TextView text_loading = findViewById(R.id.text_wait_get);
            text_loading.setX(-500f);

            text_score_1   = findViewById(R.id.score_get_1);
            text_score_2  =  findViewById(R.id.score_get_2);

            text1_get = findViewById(R.id.text_1);
            text2_get = findViewById(R.id.text_2);
            text3_get = findViewById(R.id.text_3);
            text4_get = findViewById(R.id.text_4);

            text1_get.setText(cauhoi[stt][0]);
            text2_get.setText(cauhoi[stt][1]);
            text3_get.setText(cauhoi[stt][2]);
            text4_get.setText(cauhoi[stt][3]);
            if(Game.user==1)
            {
                name_1.setText(nguoichoi2);
                name_2.setText(nguoichoi1);

                text_score_1.setText("Score :"+score2);
                text_score_2.setText("Score :"+score1);
                if(turn_user.equals("1"))
                {
                    seek = (SeekBar)findViewById(R.id.seek_bar_2_get);
                    findViewById(R.id.seek_bar_1_get).setVisibility(View.INVISIBLE);
                    turns="Đến Lượt Bạn Đố";
                    seek.setMax(40000);
                    count = 0;
                    text_loading.setVisibility(View.INVISIBLE);
                    seek.setProgress(count);
                }else
                {
                    text1_get.setEnabled(false);
                    text2_get.setEnabled(false);
                    text3_get.setEnabled(false);
                    text4_get.setEnabled(false);
                    seek = (SeekBar)findViewById(R.id.seek_bar_1_get);
                    findViewById(R.id.seek_bar_2_get).setVisibility(View.INVISIBLE);
                    ViewCompat.animate(text_loading).translationX(0f).setDuration(1000).start();
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    turns="";
                }


            }else
            {
                name_1.setText(nguoichoi1);
                name_2.setText(nguoichoi2);

                text_score_1.setText("Score :"+score1);
                text_score_2.setText("Score :"+score2);
                if(turn_user.equals("2"))
                {
                    seek = (SeekBar)findViewById(R.id.seek_bar_2_get);
                    findViewById(R.id.seek_bar_1_get).setVisibility(View.INVISIBLE);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    turns="Đến Lượt Bạn Đố";
                    text_loading.setVisibility(View.INVISIBLE);

                }else
                {
                    text1_get.setEnabled(false);
                    text2_get.setEnabled(false);
                    text3_get.setEnabled(false);
                    text4_get.setEnabled(false);
                    seek = (SeekBar)findViewById(R.id.seek_bar_1_get);
                    findViewById(R.id.seek_bar_2_get).setVisibility(View.INVISIBLE);
                    seek.setMax(40000);
                    count = 0;
                    seek.setProgress(count);
                    turns="";
                }
            }



            // set first position
            findViewById(R.id.card_1_get).setScaleX(0);
            findViewById(R.id.card_1_get).setScaleY(0);
            findViewById(R.id.card_2_get).setScaleX(0);
            findViewById(R.id.card_2_get).setScaleY(0);
            findViewById(R.id.card_3_get).setScaleX(0);
            findViewById(R.id.card_3_get).setScaleY(0);
            findViewById(R.id.card_4_get).setScaleX(0);
            findViewById(R.id.card_4_get).setScaleY(0);

            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(700);
            animatorSet.playTogether(
                    // set Scale view
                    ObjectAnimator.ofFloat(findViewById(R.id.card_1_get),"scaleX",0,1f),
                    ObjectAnimator.ofFloat(findViewById(R.id.card_1_get),"scaleY",0,1f),
                    ObjectAnimator.ofFloat(findViewById(R.id.card_2_get),"scaleX",0,1f),
                    ObjectAnimator.ofFloat(findViewById(R.id.card_2_get),"scaleY",0,1f),
                    ObjectAnimator.ofFloat( findViewById(R.id.card_3_get),"scaleX",0,1f),
                    ObjectAnimator.ofFloat( findViewById(R.id.card_3_get),"scaleY",0,1f),
                    ObjectAnimator.ofFloat( findViewById(R.id.card_4_get),"scaleX",0,1f),
                    ObjectAnimator.ofFloat( findViewById(R.id.card_4_get),"scaleY",0,1f)
            );
            animatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    next();
                    ViewCompat.animate(text_loading).translationX(0f).setDuration(1000).start();
                    // seek bar count time.
                    count=0;
//                    count_down_seek = new CountDownTimer(40000,1000) {
//                        @Override
//                        public void onTick(long millisUntilFinished) {
//                            count+=1000;
//                            seek.setProgress(count);
//                            if(count>=30000)
//                            {
//                                // new
//                              early_over_time();
//
//                            }
//                            if(count>=seek.getMax())
//                            {
//                                trans_UI();
//                                count=0;
//                                end_count_down2();
//                            }
//
//                        }
//
//                        @Override
//                        public void onFinish() {
//                            count=0;
//                            end_count_down2();
//                        }
//                    };
//                    count_down_seek.start();




                }
            });
            animatorSet.start();
        }


    }

    public  void get_a(View view)
    {

        thread=false;
        word_choose = text1_get.getText().toString();
        firebaseDatabase.child("Vitri").setValue(0);
        firebaseDatabase.child("Type_Ans").setValue(1);
        have_question();
        have_turn=true;
        trans_Turn();
        have_ui=true;
        trans_UI();
        count=0;
    }



    public  void get_b(View view)
    {
        thread=false;
        word_choose = text2_get.getText().toString();
        firebaseDatabase.child("Vitri").setValue(1);
        firebaseDatabase.child("Type_Ans").setValue(2);
        have_question();
        have_turn=true;
        trans_Turn();
        have_ui=true;
        trans_UI();
        count=0;
    }



    public  void get_c(View view)
    {
        thread=false;
        word_choose = text3_get.getText().toString();
        firebaseDatabase.child("Vitri").setValue(2);
        firebaseDatabase.child("Type_Ans").setValue(3);
        have_question();
        have_turn=true;
        trans_Turn();
        have_ui=true;
        trans_UI();
        count=0;
    }
    public  void get_d(View view)
    {
        thread=false;
        word_choose = text4_get.getText().toString();
        firebaseDatabase.child("Vitri").setValue(3);
        firebaseDatabase.child("Type_Ans").setValue(4);
        have_question();
        have_turn=true;
        trans_Turn();
        have_ui=true;
        trans_UI();
        count=0;


    }
    public  void pass(View view)
    {

        if(Game.user==1)
        {
            firebaseDatabase.child("TD").setValue("1");
        }else
        {
            firebaseDatabase.child("TD").setValue("2");
        }
        firebaseDatabase.child("Score").setValue("2");
        thread=false;
    }

    public  void choo_a(View view)
    {
        have_ui=true;
        word_ans=text1_choo.getText().toString();
        submit_score();
        thread=false;
        firebaseDatabase.child("STT").setValue(stt+1);
        count=0;
    }

    public  void choo_b(View view)
    {
        have_ui=true;
        word_ans=text2_choo.getText().toString();
        submit_score();
        thread=false;
        firebaseDatabase.child("STT").setValue(stt+1);
        count=0;
    }
    public  void choo_c(View view)
    {
        have_ui=true;
        word_ans=text3_choo.getText().toString();
        submit_score();
        thread=false;
        firebaseDatabase.child("STT").setValue(stt+1);
        count=0;
    }
    public  void choo_d(View view)
    {
        have_ui=true;
        word_ans=text4_choo.getText().toString();
        submit_score();
        thread = false;
        firebaseDatabase.child("STT").setValue(stt+1);
        count=0;
    }
    private void next() {
        final ProgressDialog pd = new ProgressDialog(TranDau.this);
        if (turns.equals(""))
        {

        }else
        {
            pd.show();
            // condition
            if (pd.getWindow() != null) {
                pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            pd.setContentView(R.layout.item_dialog);
            TextView your_text = (TextView) pd.findViewById(R.id.your_turn);
            your_text.setX(-1000f);
            ViewCompat.animate(your_text).translationX(0).setDuration(500).start();
            your_text.setText(turns);
            pd.setIndeterminate(false);
            pd.setCancelable(true);
        }

        countDownTimer = new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(pd.isShowing()) {
                    pd.dismiss();
                }
                count=0;
                thread = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (thread)
                        {
                            count+=1000;
                            seek.setProgress(count);
                            if(count>=40000)
                            {
                                //   trans_UI();
                                count=0;
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }


                    }
                }).start();





            }
        };
        countDownTimer.start();




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
                firebaseDatabase.child("Exit").setValue("1");
                startActivity(new Intent(TranDau.this,Menu_English.class));
            }
        });
    }



}

