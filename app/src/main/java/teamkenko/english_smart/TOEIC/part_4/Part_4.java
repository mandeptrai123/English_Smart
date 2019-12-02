package teamkenko.english_smart.TOEIC.part_4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;
import teamkenko.english_smart.TOEIC.Menu_Toeic.Toeic_Full;


public class Part_4 extends AppCompatActivity {
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
        setContentView(R.layout.activity_part4);
        viewPager = findViewById(R.id.viewpager_part4);
        lottie    = findViewById(R.id.lot_write_p4);
        but_submit =  findViewById(R.id.but_submit_p4);
        but_op   =  findViewById(R.id.but_option_p4);
        text_ques.setText("Question: "+1);
        type=0;
        Adapter_Part4 adapter_part4 = new Adapter_Part4(this,type);
        viewPager.setAdapter(adapter_part4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                pos_pager = i;
                check=false;
                seekBar.setProgress(0);
                check=false;
                number = viewPager.getCurrentItem()+1;
                text_ques.setText("Question: "+number);
                lottie.playAnimation();

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


        but_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog(Part_4.this);
                dialog.setCancelable(false);
                dialog.show();
                if(dialog.getWindow()!=null)
                {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.setContentView(R.layout.item_option);
                TextView but_op_1 = dialog.findViewById(R.id.but_op_one);
                TextView but_op_2 = dialog.findViewById(R.id.but_op_two);
                but_op_1.setX(-500f);
                but_op_2.setX(500f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(
                        ObjectAnimator.ofFloat(but_op_1,"translationX",0f),
                        ObjectAnimator.ofFloat(but_op_2,"translationX",0f)
                );
                animatorSet.setDuration(600);
                animatorSet.start();


                but_op_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Adapter_Part4 adapter = new Adapter_Part4(getApplicationContext(),2);
                        viewPager.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        viewPager.setCurrentItem(pos_pager);
                    }
                });
                but_op_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Adapter_Part4 adapter = new Adapter_Part4(getApplicationContext(),0);
                        viewPager.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        viewPager.setCurrentItem(pos_pager);

                    }
                });

            }
        });


        but_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int dem=0;
                for (int i=0;i<12;i++)
                {
                    if(Choosed_Part4.ans[i]!=null)
                    {
                        dem++;
                    }else
                    {
                        Toasty.error(getApplicationContext(),"Bạn Chưa Hoàn Thành Hết.",Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(i);
                        break;
                    }
                }
                if(dem==12)
                {
                    final ProgressDialog progressDialog = new ProgressDialog(Part_4.this);

                    progressDialog.show();
                    progressDialog.setCancelable(false);
                    if (progressDialog.getWindow() != null) {
                        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    }
                    progressDialog.setContentView(R.layout.dialog_marked);
                    Button but_next = progressDialog.findViewById(R.id.but_next_marked);
                    Button show_ans = progressDialog.findViewById(R.id.but_show_ans);
                    TextView text_score = progressDialog.findViewById(R.id.dialog_score_marked);
                    for(int i=0;i<10;i++)
                    {
                        if(Choosed_Part4.correct1[i].equals(Choosed_Part4.ans[i]))
                        {
                            score++;
                        }


                    }
                    text_score.setText("Bạn Làm Đúng: "+score+"/10");
                    but_next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            startActivity(new Intent(Part_4.this,Toeic_Full.class));
                        }
                    });

                    show_ans.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            progressDialog.dismiss();
                            Adapter_Part4 adapter = new Adapter_Part4(getApplicationContext(),1);
                            viewPager.setAdapter(adapter);
                            viewPager.setCurrentItem(0);
                            text_ques.setText("Question: "+1);
                        }
                    });


                }




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
        but_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
                startActivity(new Intent(Part_4.this,Toeic_Full.class));
            }
        });
    }
}
