package teamkenko.english_smart.TOEIC.part_5;

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

import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.R;

public class Adapter_Part5 extends PagerAdapter {
    Context context;
    int type;
    int pos;
    String[] texts={"How Are U ?","What Yours Name ?","What Are U Doing ?"};
    public Adapter_Part5(Context context, int type) {
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
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_part_5,container,false);


        // split
        String des[]= Choosed_Part5_T1.text[position].split("@",-2);

        TextViewFonts question1 = view.findViewById(R.id.item_question_part5_1);
        RadioGroup group1       = view.findViewById(R.id.radiogroup_part5_1);

        TextViewFonts question2 = view.findViewById(R.id.item_question_part5_2);
        RadioGroup group2       = view.findViewById(R.id.radiogroup_part5_2);

        TextViewFonts question3 = view.findViewById(R.id.item_question_part5_3);
        RadioGroup group3       = view.findViewById(R.id.radiogroup_part5_3);

        TextViewFonts question4 = view.findViewById(R.id.item_question_part5_4);
        RadioGroup group4       = view.findViewById(R.id.radiogroup_part5_4);

        TextViewFonts question5 = view.findViewById(R.id.item_question_part5_5);

        question1.setText(des[0]);
        question2.setText(des[1]);
        question3.setText(des[2]);
        question4.setText(des[3]);
        question5.setText(des[4
                ]);


        final RadioButton but1       = view.findViewById(R.id.part5_but1);
        final RadioButton but2       = view.findViewById(R.id.part5_but2);
        final RadioButton but3       = view.findViewById(R.id.part5_but3);
        final RadioButton but4       = view.findViewById(R.id.part5_but4);
        final RadioButton but5       = view.findViewById(R.id.part5_but5);
        final RadioButton but6       = view.findViewById(R.id.part5_but6);
        final RadioButton but7       = view.findViewById(R.id.part5_but7);
        final RadioButton but8       = view.findViewById(R.id.part5_but8);
        final RadioButton but9       = view.findViewById(R.id.part5_but9);
        final RadioButton but10       = view.findViewById(R.id.part5_but10);
        final RadioButton but11       = view.findViewById(R.id.part5_but11);
        final RadioButton but12       = view.findViewById(R.id.part5_but12);
        final RadioButton but13       = view.findViewById(R.id.part5_but13);
        final RadioButton but14       = view.findViewById(R.id.part5_but14);
        final RadioButton but15       = view.findViewById(R.id.part5_but15);
        final RadioButton but16       = view.findViewById(R.id.part5_but16);

      //  question1.setText(Choosed_Part5_T1.text[position]);

        but1.setText(Choosed_Part5_T1.note_ans1[position][0]);
        but2.setText(Choosed_Part5_T1.note_ans1[position][1]);
        but3.setText(Choosed_Part5_T1.note_ans1[position][2]);
        but4.setText(Choosed_Part5_T1.note_ans1[position][3]);

        but5.setText(Choosed_Part5_T1.note_ans2[position][0]);
        but6.setText(Choosed_Part5_T1.note_ans2[position][1]);
        but7.setText(Choosed_Part5_T1.note_ans2[position][2]);
        but8.setText(Choosed_Part5_T1.note_ans2[position][3]);

        but9.setText(Choosed_Part5_T1.note_ans3[position][0]);
        but10.setText(Choosed_Part5_T1.note_ans3[position][1]);
        but11.setText(Choosed_Part5_T1.note_ans3[position][2]);
        but12.setText(Choosed_Part5_T1.note_ans3[position][3]);

        but13.setText(Choosed_Part5_T1.note_ans4[position][0]);
        but14.setText(Choosed_Part5_T1.note_ans4[position][1]);
        but15.setText(Choosed_Part5_T1.note_ans4[position][2]);
        but16.setText(Choosed_Part5_T1.note_ans4[position][3]);










        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_check = group.findViewById(checkedId);
                switch (checkedId) {
                    case R.id.part5_but1:
                        Choosed_Part5_T1.choose[position] = 1;
                        Choosed_Part5_T1.ans[position][0] = Choosed_Part5_T1.note_ans1[position][0];
                        break;

                    case R.id.part5_but2:
                        Choosed_Part5_T1.choose[position] = 2;
                        Choosed_Part5_T1.ans[position][0] = Choosed_Part5_T1.note_ans1[position][1];
                        break;

                    case R.id.part5_but3:
                        Choosed_Part5_T1.choose[position] = 3;
                        Choosed_Part5_T1.ans[position][0] = Choosed_Part5_T1.note_ans1[position][2];
                        break;
                    case R.id.part5_but4:
                        Choosed_Part5_T1.choose[position] = 4;
                        Choosed_Part5_T1.ans[position][0] = Choosed_Part5_T1.note_ans1[position][3];
                        break;

                    default:

                        break;
                   }

                }
        });


        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_check = group.findViewById(checkedId);
                switch (checkedId) {
                    case R.id.part5_but5:
                        Choosed_Part5_T1.choose[position] = 1;
                        Choosed_Part5_T1.ans[position][1] = Choosed_Part5_T1.note_ans2[position][0];
                        break;

                    case R.id.part5_but6:
                        Choosed_Part5_T1.choose[position] = 2;
                        Choosed_Part5_T1.ans[position][1] = Choosed_Part5_T1.note_ans2[position][1];
                        break;

                    case R.id.part5_but7:
                        Choosed_Part5_T1.choose[position] = 3;
                        Choosed_Part5_T1.ans[position][1] = Choosed_Part5_T1.note_ans2[position][2];
                        break;
                    case R.id.part5_but8:
                        Choosed_Part5_T1.choose[position] = 4;
                        Choosed_Part5_T1.ans[position][1] = Choosed_Part5_T1.note_ans2[position][3];
                        break;

                    default:

                        break;
                }

            }
        });



        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.part5_but9:
                        Choosed_Part5_T1.choose[position] = 1;
                        Choosed_Part5_T1.ans[position][2] = Choosed_Part5_T1.note_ans3[position][0];
                        break;

                    case R.id.part5_but10:
                        Choosed_Part5_T1.choose[position] = 2;
                        Choosed_Part5_T1.ans[position][2] = Choosed_Part5_T1.note_ans2[position][1];
                        break;

                    case R.id.part5_but11:
                        Choosed_Part5_T1.choose[position] = 3;
                        Choosed_Part5_T1.ans[position][2] = Choosed_Part5_T1.note_ans3[position][2];
                        break;
                    case R.id.part5_but12:
                        Choosed_Part5_T1.choose[position+2] = 4;
                        Choosed_Part5_T1.ans[position][2] = Choosed_Part5_T1.note_ans3[position][3];
                        break;

                    default:

                        break;
                }

            }
        });



        group4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_check = group.findViewById(checkedId);
                switch (checkedId) {
                    case R.id.part5_but13:
                        Choosed_Part5_T1.choose[position] = 1;
                        Choosed_Part5_T1.ans[position][3] = Choosed_Part5_T1.note_ans4[position][0];
                        break;

                    case R.id.part5_but14:
                        Choosed_Part5_T1.choose[position] = 2;
                        Choosed_Part5_T1.ans[position][3] = Choosed_Part5_T1.note_ans4[position][1];
                        break;

                    case R.id.part5_but15:
                        Choosed_Part5_T1.choose[position+3] = 3;
                        Choosed_Part5_T1.ans[position][3] = Choosed_Part5_T1.note_ans4[position][2];
                        break;
                    case R.id.part5_but16:
                        Choosed_Part5_T1.choose[position+3] = 4;
                        Choosed_Part5_T1.ans[position][3] = Choosed_Part5_T1.note_ans4[position][3];
                        break;

                    default:

                        break;
                }

            }
        });

        ((ViewPager) container).addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}

