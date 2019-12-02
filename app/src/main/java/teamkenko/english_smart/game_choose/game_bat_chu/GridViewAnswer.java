package teamkenko.english_smart.game_choose.game_bat_chu;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import teamkenko.english_smart.R;


class GridViewAnswer extends BaseAdapter{
    boolean[] answerchar;
    Context context;
    Game_batchu activityGame11;
    public GridViewAnswer(boolean[] answerchar, Context context,Game_batchu activityGame11) {
        this.answerchar = answerchar;
        this.context = context;
        this.activityGame11 = activityGame11;


    }

    @Override

    public int getCount() {
        return activityGame11.dodai_answer[activityGame11.kiemtra.get(activityGame11.stt)];
    }

    @Override
    public Object getItem(int position) {
        return answerchar[position];
    }

    @Override
    public long getItemId(int i) {
        return answerchar.length;
    }

    @Override
    public View getView(final int vitri, View view, ViewGroup viewGroup) {
        final Button button;
        // Creat new Button
        if (view == null) {
            button = new Button(context);
            button.setPadding(5, 5, 5, 5);
            button.setLayoutParams(new GridView.LayoutParams(80, 80));
            int[] a={R.drawable.blue_button, R.drawable.green_button,R.drawable.red_button,R.drawable.red_button,R.drawable.orange_button};
            button.setBackground(activityGame11.getResources().getDrawable(R.drawable.blue_button));
            if(activityGame11.check)
            {
                button.setBackground(activityGame11.getResources().getDrawable(R.drawable.red_button));
            }
            //button.setBackgroundColor(Color.DKGRAY);
            button.setTextColor(Color.BLACK);
            button.setTextSize(25);

                if(Commom.submit_answer[vitri])
                {
                    button.setText(String.valueOf(activityGame11.answer[vitri]));
                }





        } else {
            button = (Button) view;

        }

        return button;
    }
}