package teamkenko.english_smart.game_choose.game_bat_chu;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;



import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.R;

class GridView_Banphim extends BaseAdapter{
    Context context;
    char[] kitu;
   Game_batchu activityGame11;


    int dem=0;
    boolean check=false;

    public GridView_Banphim(Context context, char[] kitu,Game_batchu activityGame11) {
        this.context = context;
        this.kitu = kitu;
        this.activityGame11 = activityGame11;

    }

    @Override
    public int getCount() {
        return  kitu.length;
    }

    @Override
    public Object getItem(int position) {
        return  kitu[position];
    }

    @Override
    public long getItemId(int position) {
        return  kitu.length;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        final Button button ;
        if(convertView==null)
        {
            button = new Button(context);
            button.setLayoutParams(new GridView.LayoutParams(90,90));
            button.setBackground(activityGame11.getResources().getDrawable(R.drawable.square_button));
            button.setTextColor(Color.BLACK);
            button.setTextSize(27f);
            button.setPadding(5,5,5,5);
            button.setText(kitu[position]+"");

        }else {
            button= (Button)convertView;}
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                char s = button.getText().charAt(0);
                int check=0;
                for(int i=0;i<activityGame11.answer.length;i++)
                {
                    if(s==activityGame11.answer[i])
                    {
                        check=1;
                        Commom.submit_answer[i]=true;
                        button.setVisibility(View.INVISIBLE);
                        GridViewAnswer adapteranswer = new GridViewAnswer(Commom.submit_answer, context,activityGame11);
                        activityGame11.gridView_answer.setAdapter(adapteranswer);
                        adapteranswer.notifyDataSetChanged();
                        activityGame11.nextnext();

                    }else
                    {

                    }
                }
                if(check==0)
                {
                    Toasty.error(context,"Wrong!",1000).show();
                    dem++;
                    button.setVisibility(View.INVISIBLE);
                    if(dem==3)
                    {
                        activityGame11.thangTeodibui();
                    }
                }else
                {
                    button.setText("");
                }
            }
        });

        // Commom.submit_answer = new char[activityGame11.dodai_answer[stt]];
      /*  button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityGame11.soundPool.play(activityGame11.id_click,10,10,1,0,1);

                char compare = kitu[position].charAt(0);
                dem = 0;
                activityGame11.solansai = 0 ;
                for (int i = 0; i < activityGame11.answer.length; i++) {
                    // Gắn các từ đó vào trong đáp án
                    if (compare == activityGame11.kitu_correct[i]) {
                        check = true;
                        Commom.submit_answer[i] = compare;



                    }
                    else {
                        int dodai= activityGame11.dodai_answer[activityGame11.kiemtra.get(activityGame11.stt)];
                        activityGame11.solansai+=1;
                        if(activityGame11.solansai==dodai)
                        {
                            activityGame11.soundPool.play(activityGame11.id_thatbai,10,10,1,0,1);
                            activityGame11.socausai += 1 ;
                            Toasty.error(activityGame11,"Sai Rồi", Toast.LENGTH_SHORT).show();
                            if(  activityGame11.socausai==5)
                            {
                                activityGame11.kiemtrasolansai();
                            }
                        }

                    }
                }

                GridViewAnswer adapteranswer = new GridViewAnswer(Commom.submit_answer, context,activityGame11);
                activityGame11.gridView_answer.setAdapter(adapteranswer);
                adapteranswer.notifyDataSetChanged();
                activityGame11.nextnext();



            }}

        );*/

        return  button;

    }
}