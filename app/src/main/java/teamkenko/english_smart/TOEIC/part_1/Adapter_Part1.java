package teamkenko.english_smart.TOEIC.part_1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.squareup.picasso.Picasso;

import teamkenko.english_smart.R;

public class Adapter_Part1 extends android.support.v4.view.PagerAdapter  {
    boolean check = true;
    Context context;
    int img[];
    String ans[][];
    int type;

    public Adapter_Part1(Context context, int[] img, String[][] ans , int type) {
        this.context = context;
        this.img = img;
        this.ans = ans;
        this.type= type;



    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view;
        if (type == 0 || type==2) {
            view = layoutInflater.inflate(R.layout.item_part_1, container, false);
            ImageView img_question = view.findViewById(R.id.item_img_part1);
            RadioGroup radioGroup = view.findViewById(R.id.group_but_part1);


            final RadioButton but_1 = view.findViewById(R.id.part1_but1);
            final RadioButton but_2 = view.findViewById(R.id.part1_but2);
            final RadioButton but_3 = view.findViewById(R.id.part1_but3);
            final RadioButton but_4 = view.findViewById(R.id.part1_but4);
            switch (Choosed_Part1.choose[position])
            {
                case 1:
                    but_1.setChecked(true);
                    break;
                case 2:
                    but_2.setChecked(true);
                    break;
                case 3:
                    but_3.setChecked(true);
                    break;
                case 4:
                    but_4.setChecked(true);
                    break;
                    default:
                        break;
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    switch (radio_check.getText().toString())
                    {
                        case "A":
                            Choosed_Part1.choose[position]=1;
                            Choosed_Part1.ans[position] = Choosed_Part1.note_ans[position][0];
                            break;
                        case "B":
                            Choosed_Part1.choose[position]=2;
                            Choosed_Part1.ans[position] = Choosed_Part1.note_ans[position][1];
                            break;
                        case "C":
                            Choosed_Part1.choose[position]=3;
                            Choosed_Part1.ans[position] = Choosed_Part1.note_ans[position][2];
                            break;
                        case "D":
                            Choosed_Part1.choose[position]=4;
                            Choosed_Part1.ans[position] = Choosed_Part1.note_ans[position][3];
                            break;


                    }
                    radio_check.setChecked(true);
                    if(type==2)
                    {
                        LottieAnimationView lotti_wrong = view.findViewById(R.id.lottie_wrong_p1_op);
                        LottieAnimationView lotti_correct = view.findViewById(R.id.lottie_correct_p1_op);
                        but_1.setText(Choosed_Part1.note_ans[position][0]);
                        but_2.setText(Choosed_Part1.note_ans[position][1]);
                        but_3.setText(Choosed_Part1.note_ans[position][2]);
                        but_4.setText(Choosed_Part1.note_ans[position][3]);
                        if(Choosed_Part1.ans[position].equals(Choosed_Part1.correct[position]))
                        {
                            lotti_correct.setVisibility(View.VISIBLE);
                            if(Choosed_Part1.note_ans[position][0].equals(Choosed_Part1.correct[position]))
                            {
                                but_1.setBackgroundResource(R.drawable.bg_correct);
                            }else if(Choosed_Part1.note_ans[position][1].equals(Choosed_Part1.correct[position]))
                            {
                                but_2.setBackgroundResource(R.drawable.bg_correct);
                            }else if(Choosed_Part1.note_ans[position][2].equals(Choosed_Part1.correct[position]))
                            {
                                but_3.setBackgroundResource(R.drawable.bg_correct);
                            }
                            else if(Choosed_Part1.note_ans[position][3].equals(Choosed_Part1.correct[position]))
                            {
                                but_4.setBackgroundResource(R.drawable.bg_correct);
                            }
                        }else
                        {
                            lotti_wrong.setVisibility(View.VISIBLE);
                            if(Choosed_Part1.choose[position]==1)
                            {
                                but_1.setBackgroundResource(R.drawable.bg_wrong);
                            }else if(Choosed_Part1.choose[position]==2)
                            {
                                but_2.setBackgroundResource(R.drawable.bg_wrong);
                            }else if(Choosed_Part1.choose[position]==3)
                            {
                                but_3.setBackgroundResource(R.drawable.bg_wrong);
                            }
                            else if(Choosed_Part1.choose[position]==4)
                            {
                                but_4.setBackgroundResource(R.drawable.bg_wrong);
                            }




                            if(Choosed_Part1.note_ans[position][0].equals(Choosed_Part1.correct[position]))
                            {
                                but_1.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(Choosed_Part1.note_ans[position][1].equals(Choosed_Part1.correct[position]))
                            {
                                but_2.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(Choosed_Part1.note_ans[position][2].equals(Choosed_Part1.correct[position]))
                            {
                                but_3.setBackgroundResource(R.drawable.bg_incorrect);
                            }
                            else if(Choosed_Part1.note_ans[position][3].equals(Choosed_Part1.correct[position]))
                            {
                                but_4.setBackgroundResource(R.drawable.bg_incorrect);
                            }

                        }
                    }

                }
            });
            but_1.setText("A");
            but_2.setText("B");
            but_3.setText("C");
            but_4.setText("D");


            if(Choosed_Part1.Uri[position]!=null)
            {
                view.findViewById(R.id.loading_part1).setVisibility(View.VISIBLE);

                Picasso.with(context)
                        .load(Choosed_Part1.Uri[position]).resize(320,160)
                        .into(img_question, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {
                                view.findViewById(R.id.loading_part1).setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError() {

                            }
                        });
            //    Picasso.with(context).load(Choosed_Part1.Uri[position]).resize(320,160).into(img_question);
            }



        } else {
            view = layoutInflater.inflate(R.layout.item_part_1_complete, container, false);
            ImageView img_question = view.findViewById(R.id.item_img_part1_complete);
            RadioGroup radioGroup = view.findViewById(R.id.group_but_part1_complete);
            LottieAnimationView lottie_wrong  = view.findViewById(R.id.lottie_wrong_p1);
            LottieAnimationView lottie_correct= view.findViewById(R.id.lottie_correct_p1);

            RadioButton but_1 = view.findViewById(R.id.part1_but1_complete);
            RadioButton but_2 = view.findViewById(R.id.part1_but2_complete);
            RadioButton but_3 = view.findViewById(R.id.part1_but3_complete);
            RadioButton but_4 = view.findViewById(R.id.part1_but4_complete);
            but_1.setText(Choosed_Part1.note_ans[position][0]);
            but_2.setText(Choosed_Part1.note_ans[position][1]);
            but_3.setText(Choosed_Part1.note_ans[position][2]);
            but_4.setText(Choosed_Part1.note_ans[position][3]);

            if(Choosed_Part1.Uri[position]!=null)
            {
                view.findViewById(R.id.loading_part1).setVisibility(View.VISIBLE);
                Picasso.with(context)
                        .load(Choosed_Part1.Uri[position]).resize(320,160)
                        .into(img_question, new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {
                                view.findViewById(R.id.loading_part1).setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onError() {

                            }
                        });
            }
            if(Choosed_Part1.correct[position].equals(Choosed_Part1.ans[position]))
            {

                lottie_wrong.setVisibility(View.INVISIBLE);
                lottie_correct.playAnimation();

                // neu dung.
                if      (but_1.getText().equals(Choosed_Part1.correct[position])) {
                    but_1.setBackgroundResource(R.drawable.bg_correct);

                }
                else if (but_2.getText().equals(Choosed_Part1.correct[position])) {
                    but_2.setBackgroundResource(R.drawable.bg_correct);
                }
                else if (but_3.getText().equals(Choosed_Part1.correct[position]))
                {
                    but_3.setBackgroundResource(R.drawable.bg_correct);
                }
                else if (but_4.getText().equals(Choosed_Part1.correct[position]))
                {
                    but_4.setBackgroundResource(R.drawable.bg_correct);
                }
            }else
            {
                lottie_correct.setVisibility(View.INVISIBLE);
                lottie_wrong.playAnimation();
                // neu sai
                    if      (Choosed_Part1.choose[position]==1) {
                        but_1.setBackgroundResource(R.drawable.bg_wrong);

                    }
                    else if (Choosed_Part1.choose[position]==2) {
                        but_2.setBackgroundResource(R.drawable.bg_wrong);
                    }
                    else if (Choosed_Part1.choose[position]==3)
                    {
                        but_3.setBackgroundResource(R.drawable.bg_wrong);
                    }
                    else if (Choosed_Part1.choose[position]==4)
                    {
                        but_4.setBackgroundResource(R.drawable.bg_wrong);
                    }


                    if (Choosed_Part1.note_ans[position][0].equals(Choosed_Part1.correct[position]))
                    {
                        but_1.setBackgroundResource(R.drawable.bg_incorrect);
                    }
                    else if (Choosed_Part1.note_ans[position][1].equals(Choosed_Part1.correct[position]))
                    {
                        but_2.setBackgroundResource(R.drawable.bg_incorrect);
                    }
                    else if (Choosed_Part1.note_ans[position][2].equals(Choosed_Part1.correct[position]))
                    {
                        but_3.setBackgroundResource(R.drawable.bg_incorrect);
                    }
                    else if (Choosed_Part1.note_ans[position][3].equals(Choosed_Part1.correct[position]))
                    {
                        but_4.setBackgroundResource(R.drawable.bg_incorrect);
                    }



            }


        }












        ((ViewPager) container).addView(view);
        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}


