package teamkenko.english_smart.game_choose.game_dap_trung;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.media.SoundPool;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;


import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Solo_Words.Game;


class GridviewAdapter_daptrung extends RecyclerView.Adapter<GridviewAdapter_daptrung.SimpleViewHolder_Adapter> {
   public Context context;
     public String[] text;
    public Game_DapTrung game;
    public  SoundPool soundPool ;

  int music_nhap,music_wrong;




    public GridviewAdapter_daptrung(Context context, String[] text, Game_DapTrung activityGame4, SoundPool soundPool) {
        this.context = context;
        this.text = text;
        this.game = activityGame4;
        this.soundPool = soundPool;
        music_nhap= soundPool.load(activityGame4,R.raw.but_music_bongbong,1);
        music_wrong=soundPool.load(activityGame4,R.raw.audio_wrong,1);


    }


    @NonNull
    @Override
    public SimpleViewHolder_Adapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_daptrung, viewGroup, false);
        return new SimpleViewHolder_Adapter(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final SimpleViewHolder_Adapter simpleViewHolder, final int i) {
        simpleViewHolder.text_egg.setText(text[i]);
        simpleViewHolder.text_egg.setVisibility(View.VISIBLE);
        simpleViewHolder.text_egg.setScaleX(0f);
        simpleViewHolder.text_egg.setScaleY(0f);
        simpleViewHolder.egg.setSpeed(2.5f);
        ViewCompat.animate(simpleViewHolder.egg).scaleX(1f).setDuration(500).start();
        ViewCompat.animate(simpleViewHolder.egg).scaleY(1f).setDuration(500).start();
        simpleViewHolder.egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.solanfree>0) {
                        Game_DapTrung_Data.count_open+=1;
                        switch (Game_DapTrung_Data.count_open)
                        {
                                 case 3:
                                Game_DapTrung_Data.count+=1;
                                game.set_adapter();
                                    break;
                                case 5:
                                Game_DapTrung_Data.count+=1;
                                    game.set_adapter();
                                    break;
                                default:
                                    break;

                        }
                        soundPool.play(music_nhap,10f,10f,1,0,1);
                        simpleViewHolder.egg.playAnimation();
                        simpleViewHolder.egg.addAnimatorListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                simpleViewHolder.text_egg.setVisibility(View.VISIBLE);
                                simpleViewHolder.text_egg.setScaleX(0f);
                                simpleViewHolder.text_egg.setScaleY(0f);
                                ViewCompat.animate(simpleViewHolder.text_egg).scaleX(1f).setDuration(500).start();
                                ViewCompat.animate(simpleViewHolder.text_egg).scaleY(1f).setDuration(500).start();
                                simpleViewHolder.egg.setVisibility(View.INVISIBLE);
                                game.but_start.setClickable(true);

                            }
                        });




                         game.solanfree -= 1;
                    soundPool.play(music_nhap,10f,10f,1,0,1);
                      }
                      else
                      {
                        soundPool.play(music_wrong,10f,10f,1,0,1);

                      }
            }
        });

    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    public static class SimpleViewHolder_Adapter extends RecyclerView.ViewHolder {
         TextViewFonts text_egg;
         LottieAnimationView egg;

        public SimpleViewHolder_Adapter(@NonNull View itemView) {
            super(itemView);
              text_egg =itemView.findViewById(R.id.text_eggs);
              egg    =itemView.findViewById(R.id.lottie_egg);

                }


        }


}