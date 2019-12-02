package teamkenko.english_smart.game_choose.game_dap_trung;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.airbnb.lottie.LottieAnimationView;

import ec.dina.btefonts.ButtonFonts;
import teamkenko.english_smart.R;

public class Game_DapTrung_Answer extends BaseAdapter {
    Context context;
    String text[];
    int count;
    int type;
    Game_DapTrung game;
    int pos;

    public Game_DapTrung_Answer(Context context, String[] text, int count, int type,Game_DapTrung game, int pos) {
        this.context = context;
        this.text = text;
        this.count = count;
        this.type = type;
        this.game = game;
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.answer_daptrung,parent,false);
        final ButtonFonts but = view.findViewById(R.id.item_but_answer_daptrung);
        LottieAnimationView lot_ans = view.findViewById(R.id.item_ani_question_dt);

        if(type==2)
        {
            lot_ans.setVisibility(View.INVISIBLE);
            but.setVisibility(View.VISIBLE);
            if(position%2==0)
            {
                but.setX(-1000f);
                ViewCompat.animate(but).translationX(0f).setDuration(700).setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                            but.setText(text[position]);
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                }).start();

            }else
            {
                but.setX(1000f);
                ViewCompat.animate(but).translationX(0f).setDuration(700).setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(View view) {

                    }

                    @Override
                    public void onAnimationEnd(View view) {
                        but.setText(text[position]);
                    }

                    @Override
                    public void onAnimationCancel(View view) {

                    }
                }).start();
            }
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    game.set_game(but);
                }
            });
        }else
        {
            lot_ans.playAnimation();
        }

        return  view;


    }
}
