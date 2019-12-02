package teamkenko.english_smart.TOEIC.part_3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import teamkenko.english_smart.R;

public class Adapter_Part3 extends PagerAdapter {
    Context context;
    int type;
    public Adapter_Part3(Context context, int type) {
        this.context = context;
        this.type = type;
    }
    @Override
    public int getCount() {
        return 10;
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

        if (type == 0 || type == 2) {
            view = layoutInflater.inflate(R.layout.item_part_3, container, false);
            RadioGroup radiogr1 = view.findViewById(R.id.group_radio_p3_1);
            RadioGroup radiogr2 = view.findViewById(R.id.group_radio_p3_2);
            RadioGroup radiogr3 = view.findViewById(R.id.group_radio_p3_3);
            TextView question1 = view.findViewById(R.id.item_question1_part3);
            TextView question2 = view.findViewById(R.id.item_question2_part3);
            TextView question3 = view.findViewById(R.id.item_question3_part3);

            final RadioButton but1 = view.findViewById(R.id.part3_but1);
            final RadioButton but2= view.findViewById(R.id.part3_but2);
            final RadioButton but3 = view.findViewById(R.id.part3_but3);
            final RadioButton but4 = view.findViewById(R.id.part3_but4);
            final RadioButton but5 = view.findViewById(R.id.part3_but5);
            final RadioButton but6 = view.findViewById(R.id.part3_but6);
            final RadioButton but7 = view.findViewById(R.id.part3_but7);
            final RadioButton but8 = view.findViewById(R.id.part3_but8);
            final RadioButton but9 = view.findViewById(R.id.part3_but9);
            final RadioButton but10 = view.findViewById(R.id.part3_but10);
            final RadioButton but11= view.findViewById(R.id.part3_but11);
            final RadioButton but12 = view.findViewById(R.id.part3_but12);

            question1.setText(Choosed_Part3.question1[position]);
            question2.setText(Choosed_Part3.question2[position]);
            question3.setText(Choosed_Part3.question3[position]);

            but1.setText(Choosed_Part3.note_ans1[position][0]);
            but2.setText(Choosed_Part3.note_ans1[position][1]);
            but3.setText(Choosed_Part3.note_ans1[position][2]);
            but4.setText(Choosed_Part3.note_ans1[position][3]);

            but5.setText(Choosed_Part3.note_ans2[position][0]);
            but6.setText(Choosed_Part3.note_ans2[position][1]);
            but7.setText(Choosed_Part3.note_ans2[position][2]);
            but8.setText(Choosed_Part3.note_ans2[position][3]);

            but9.setText(Choosed_Part3.note_ans3[position][0]);
            but10.setText(Choosed_Part3.note_ans3[position][1]);
            but11.setText(Choosed_Part3.note_ans3[position][2]);
            but12.setText(Choosed_Part3.note_ans3[position][3]);



            final LottieAnimationView correct_1 = view.findViewById(R.id.lottie_correct_part3_1);
            final LottieAnimationView correct_2 = view.findViewById(R.id.lottie_correct_part3_2);
            final LottieAnimationView correct_3 = view.findViewById(R.id.lottie_correct_part3_3);
            final LottieAnimationView wrong_1 = view.findViewById(R.id.lottie_wrong_part3_1);
            final LottieAnimationView wrong_2 = view.findViewById(R.id.lottie_wrong_part3_2);
            final LottieAnimationView wrong_3 = view.findViewById(R.id.lottie_wrong_part3_3);
            radiogr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                   if(radio_check.getText().toString().equals(Choosed_Part3.correct1[position]))
                   {
                       Choosed_Part3.ans1[position]=radio_check.getText().toString();
                       if(type==2)
                       {
                           correct_1.setVisibility(View.VISIBLE);
                           radio_check.setBackgroundResource(R.drawable.bg_correct);
                       }

                   }else
                   {
                       Choosed_Part3.ans1[position]=radio_check.getText().toString();
                       if(type==2)
                       {
                           wrong_1.setVisibility(View.VISIBLE);
                           radio_check.setBackgroundResource(R.drawable.bg_wrong);
                           if(but1.getText().toString().equals(Choosed_Part3.correct1[position]))
                           {
                               but1.setBackgroundResource(R.drawable.bg_incorrect);
                           }else if(but2.getText().toString().equals(Choosed_Part3.correct1[position]))
                           {
                               but2.setBackgroundResource(R.drawable.bg_incorrect);
                           }else if (but3.getText().toString().equals(Choosed_Part3.correct1[position]))
                           {
                               but3.setBackgroundResource(R.drawable.bg_incorrect);
                           }else if (but4.getText().toString().equals(Choosed_Part3.correct1[position]))
                           {
                               but4.setBackgroundResource(R.drawable.bg_incorrect);
                           }
                       }
                   }

                }
            });
            radiogr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    if(radio_check.getText().toString().equals(Choosed_Part3.correct2[position]))
                    {
                        Choosed_Part3.ans2[position]=radio_check.getText().toString();
                        if(type==2)
                        {
                            correct_2.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_correct);
                        }

                    }else
                    {
                        Choosed_Part3.ans2[position]=radio_check.getText().toString();
                        if(type==2)
                        {
                            wrong_2.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_wrong);
                            if(but5.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but5.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(but6.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but6.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but7.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but7.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but8.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but8.setBackgroundResource(R.drawable.bg_incorrect);
                            }
                        }
                    }
                }
            });
            radiogr3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    if(radio_check.getText().toString().equals(Choosed_Part3.correct3[position]))
                    {
                        Choosed_Part3.ans3[position]=radio_check.getText().toString();
                        if(type==2)
                        {
                            correct_3.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_correct);
                        }

                    }else
                    {
                        Choosed_Part3.ans3[position]=radio_check.getText().toString();
                        if(type==2)
                        {
                            wrong_3.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_wrong);
                            if(but9.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but9.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(but10.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but10.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but11.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but11.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but12.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but12.setBackgroundResource(R.drawable.bg_incorrect);
                            }
                        }
                    }
                }
            });

        }else
        {
            view = layoutInflater.inflate(R.layout.item_part_3_complete, container, false);
            TextView text_turtorial = view.findViewById(R.id.text_turoial_part3);
            text_turtorial.setText(Choosed_Part3.text[position]);
            RadioGroup radiogr1 = view.findViewById(R.id.group_radio_p3_1_complete);
            RadioGroup radiogr2 = view.findViewById(R.id.group_radio_p3_2_complete);
            RadioGroup radiogr3 = view.findViewById(R.id.group_radio_p3_3_complete);
            TextView question1 = view.findViewById(R.id.item_question1_part3_complete);
            TextView question2 = view.findViewById(R.id.item_question2_part3_complete);
            TextView question3 = view.findViewById(R.id.item_question3_part3_complete);

            final RadioButton but1 = view.findViewById(R.id.part3_but1_complete);
            final RadioButton but2= view.findViewById(R.id.part3_but2_complete);
            final RadioButton but3 = view.findViewById(R.id.part3_but3_complete);
            final RadioButton but4 = view.findViewById(R.id.part3_but4_complete);
            final RadioButton but5 = view.findViewById(R.id.part3_but5_complete);
            final RadioButton but6 = view.findViewById(R.id.part3_but6_complete);
            final RadioButton but7 = view.findViewById(R.id.part3_but7_complete);
            final RadioButton but8 = view.findViewById(R.id.part3_but8_complete);
            final RadioButton but9 = view.findViewById(R.id.part3_but9_complete);
            final RadioButton but10 = view.findViewById(R.id.part3_but10_complete);
            final RadioButton but11= view.findViewById(R.id.part3_but11_complete);
            final RadioButton but12 = view.findViewById(R.id.part3_but12_complete);

            question1.setText(Choosed_Part3.question1[position]);
            question2.setText(Choosed_Part3.question2[position]);
            question3.setText(Choosed_Part3.question3[position]);

            but1.setText(Choosed_Part3.note_ans1[position][0]);
            but2.setText(Choosed_Part3.note_ans1[position][1]);
            but3.setText(Choosed_Part3.note_ans1[position][2]);
            but4.setText(Choosed_Part3.note_ans1[position][3]);

            but5.setText(Choosed_Part3.note_ans2[position][0]);
            but6.setText(Choosed_Part3.note_ans2[position][1]);
            but7.setText(Choosed_Part3.note_ans2[position][2]);
            but8.setText(Choosed_Part3.note_ans2[position][3]);

            but9.setText(Choosed_Part3.note_ans3[position][0]);
            but10.setText(Choosed_Part3.note_ans3[position][1]);
            but11.setText(Choosed_Part3.note_ans3[position][2]);
            but12.setText(Choosed_Part3.note_ans3[position][3]);



            final LottieAnimationView correct_1 = view.findViewById(R.id.lottie_correct_part3_1_complete);
            final LottieAnimationView correct_2 = view.findViewById(R.id.lottie_correct_part3_2_complete);
            final LottieAnimationView correct_3 = view.findViewById(R.id.lottie_correct_part3_3_complete);
            final LottieAnimationView wrong_1 = view.findViewById(R.id.lottie_wrong_part3_1_complete);
            final LottieAnimationView wrong_2 = view.findViewById(R.id.lottie_wrong_part3_2_complete);
            final LottieAnimationView wrong_3 = view.findViewById(R.id.lottie_wrong_part3_3_complete);
            radiogr1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    if(radio_check.getText().toString().equals(Choosed_Part3.correct1[position]))
                    {
                        Choosed_Part3.ans1[position]=radio_check.getText().toString();

                            correct_1.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_correct);


                    }else
                    {
                        Choosed_Part3.ans1[position]=radio_check.getText().toString();

                            wrong_1.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_wrong);
                            if(but1.getText().toString().equals(Choosed_Part3.correct1[position]))
                            {
                                but1.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(but2.getText().toString().equals(Choosed_Part3.correct1[position]))
                            {
                                but2.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but3.getText().toString().equals(Choosed_Part3.correct1[position]))
                            {
                                but3.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but4.getText().toString().equals(Choosed_Part3.correct1[position]))
                            {
                                but4.setBackgroundResource(R.drawable.bg_incorrect);
                            }

                    }

                }
            });
            radiogr2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    if(radio_check.getText().toString().equals(Choosed_Part3.correct2[position]))
                    {
                        Choosed_Part3.ans2[position]=radio_check.getText().toString();
                        if(type==2)
                        {
                            correct_2.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_correct);
                        }

                    }else
                    {
                        Choosed_Part3.ans2[position]=radio_check.getText().toString();

                            wrong_2.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_wrong);
                            if(but5.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but5.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(but6.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but6.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but7.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but7.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but8.getText().toString().equals(Choosed_Part3.correct2[position]))
                            {
                                but8.setBackgroundResource(R.drawable.bg_incorrect);
                            }

                    }
                }
            });
            radiogr3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    if(radio_check.getText().toString().equals(Choosed_Part3.correct3[position]))
                    {
                        Choosed_Part3.ans3[position]=radio_check.getText().toString();

                            correct_3.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_correct);


                    }else
                    {
                        Choosed_Part3.ans3[position]=radio_check.getText().toString();

                            wrong_3.setVisibility(View.VISIBLE);
                            radio_check.setBackgroundResource(R.drawable.bg_wrong);
                            if(but9.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but9.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if(but10.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but10.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but11.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but11.setBackgroundResource(R.drawable.bg_incorrect);
                            }else if (but12.getText().toString().equals(Choosed_Part3.correct3[position]))
                            {
                                but12.setBackgroundResource(R.drawable.bg_incorrect);
                            }
                        }

                }
            });

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

