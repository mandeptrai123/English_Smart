package teamkenko.english_smart.TOEIC.part_2;

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

public class Adapter_Part2 extends PagerAdapter{
    Context context;
    int type;
    boolean end;

    public Adapter_Part2(Context context, int type, boolean end) {
        this.context = context;
        this.type = type;
        this.end = end;
    }

    @Override
    public int getCount() {
        return 30;
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
        if(type==0 || type==2)
        {


            view = layoutInflater.inflate(R.layout.item_part_2, container, false);
            final TextView text_question = view.findViewById(R.id.item_text_part2);
//            final TextView text_count_part2 = view.findViewById(R.id.item_text_part2);
//            final LottieAnimationView donghocat = view.findViewById(R.id.donghocat_part2);
            // neu audio ket thuc. user chon dap an trong 5 giay .
//            if(end)
//            {
//                text_question.setVisibility(View.INVISIBLE);
//                donghocat.setVisibility(View.VISIBLE);
//                donghocat.playAnimation();
//                text_count_part2.setVisibility(View.VISIBLE);
//            }else
//            {
//                text_question.setVisibility(View.VISIBLE);
//                donghocat.setVisibility(View.INVISIBLE);
//            }


            RadioGroup radioGroup = view.findViewById(R.id.group_but_part2);



            final RadioButton but_1 = view.findViewById(R.id.part2_but1);
            final RadioButton but_2 = view.findViewById(R.id.part2_but2);
            final RadioButton but_3 = view.findViewById(R.id.part2_but3);
            switch (Choosed_Part2.choose[position])
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

            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RadioButton radio_check = group.findViewById(checkedId);
                    switch (radio_check.getText().toString())
                    {
                        case "A":
                                Choosed_Part2.choose[position]=1;
                                Choosed_Part2.ans[position]= Choosed_Part2.note_ans[position][0];
                            break;

                        case "B":
                                Choosed_Part2.choose[position]=2;
                            Choosed_Part2.ans[position]= Choosed_Part2.note_ans[position][1];
                            break;

                        case "C":
                                Choosed_Part2.choose[position]=3;
                            Choosed_Part2.ans[position]= Choosed_Part2.note_ans[position][2];
                            break;

                        default:

                            break;


                    }
                    radio_check.setChecked(true);
                    if(type==2)
                    {
                          text_question.setText(Choosed_Part2.question[position]);
                          text_question.setBackgroundResource(R.drawable.bg_round_rect);
                           LottieAnimationView lotti_wrong = view.findViewById(R.id.lottie_wrong_p2_op);
                           LottieAnimationView lotti_correct = view.findViewById(R.id.lottie_correct_p2_op);
                            but_1.setText(Choosed_Part2.note_ans[position][0]);
                            but_2.setText(Choosed_Part2.note_ans[position][1]);
                            but_3.setText(Choosed_Part2.note_ans[position][2]);
                           if(Choosed_Part2.ans[position].equals(Choosed_Part2.correct[position]))
                           {
                              lotti_correct.setVisibility(View.VISIBLE);
                              if(Choosed_Part2.note_ans[position][0].equals(Choosed_Part2.correct[position]))
                              {
                                  but_1.setBackgroundResource(R.drawable.bg_correct);
                              }else if(Choosed_Part2.note_ans[position][1].equals(Choosed_Part2.correct[position]))
                              {
                                  but_2.setBackgroundResource(R.drawable.bg_correct);
                              }else if(Choosed_Part2.note_ans[position][2].equals(Choosed_Part2.correct[position]))
                              {
                                  but_3.setBackgroundResource(R.drawable.bg_correct);
                              }
                           }else
                           {
                               lotti_wrong.setVisibility(View.VISIBLE);
                               if(Choosed_Part2.choose[position]==1)
                               {
                                   but_1.setBackgroundResource(R.drawable.bg_wrong);
                               }else if(Choosed_Part2.choose[position]==2)
                               {
                                   but_2.setBackgroundResource(R.drawable.bg_wrong);
                               }else if(Choosed_Part2.choose[position]==3)
                               {
                                   but_3.setBackgroundResource(R.drawable.bg_wrong);
                               }

                               if(Choosed_Part2.note_ans[position][0].equals(Choosed_Part2.correct[position]))
                               {
                                   but_1.setBackgroundResource(R.drawable.bg_incorrect);
                               }else if(Choosed_Part2.note_ans[position][1].equals(Choosed_Part2.correct[position]))
                               {
                                   but_2.setBackgroundResource(R.drawable.bg_incorrect);
                               }else if(Choosed_Part2.note_ans[position][2].equals(Choosed_Part2.correct[position]))
                               {
                                   but_3.setBackgroundResource(R.drawable.bg_incorrect);
                               }

                           }
                    }


                }
            });
            but_1.setText("A");
            but_2.setText("B");
            but_3.setText("C");


        }else
        {
            view = layoutInflater.inflate(R.layout.item_part_2_complete, container, false);
            TextView ques = view.findViewById(R.id.question_part2_complete);
            RadioGroup radioGroup = view.findViewById(R.id.group_but_part2_complete);
            RadioButton but1      = view.findViewById(R.id.part2_but1_complete);
            RadioButton but2      = view.findViewById(R.id.part2_but2_complete);
            RadioButton but3      = view.findViewById(R.id.part2_but3_complete);
            LottieAnimationView correct = view.findViewById(R.id.lottie_correct_part2);
            LottieAnimationView wrong   = view.findViewById(R.id.lottie_wrong_part2);
            but1.setText(Choosed_Part2.note_ans[position][0]);
            but2.setText(Choosed_Part2.note_ans[position][1]);
            but3.setText(Choosed_Part2.note_ans[position][2]);
            ques.setText(Choosed_Part2.question[position]);
            if(Choosed_Part2.ans[position].equals(Choosed_Part2.correct[position]))
            {
               wrong.setVisibility(View.INVISIBLE);
               if(but1.getText().equals(Choosed_Part2.correct[position]))
               {
                   but1.setBackgroundResource(R.drawable.bg_correct);
               }else if(but2.getText().equals(Choosed_Part2.correct[position]))
               {
                   but2.setBackgroundResource(R.drawable.bg_correct);
               }else if(but3.getText().equals(Choosed_Part2.correct[position]))
               {
                   but3.setBackgroundResource(R.drawable.bg_correct);
               }
            }else
            {
                correct.setVisibility(View.INVISIBLE);
                if(Choosed_Part2.ans[position].equals(but1.getText()))
                {
                    but1.setBackgroundResource(R.drawable.bg_wrong);
                }else if(Choosed_Part2.ans[position].equals(but2.getText()))
                {
                    but2.setBackgroundResource(R.drawable.bg_wrong);
                }else if(Choosed_Part2.ans[position].equals(but3.getText()))
                {
                    but3.setBackgroundResource(R.drawable.bg_wrong);
                }


                if(Choosed_Part2.note_ans[position][0].equals(Choosed_Part2.correct[position]))
                {
                    but1.setBackgroundResource(R.drawable.bg_incorrect);
                }else if(Choosed_Part2.note_ans[position][1].equals(Choosed_Part2.correct[position]))
                {
                    but2.setBackgroundResource(R.drawable.bg_incorrect);
                }else if(Choosed_Part2.note_ans[position][2].equals(Choosed_Part2.correct[position]))
                {
                    but3.setBackgroundResource(R.drawable.bg_incorrect);
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
