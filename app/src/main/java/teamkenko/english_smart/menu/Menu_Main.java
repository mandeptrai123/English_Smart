package teamkenko.english_smart.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.airbnb.lottie.LottieAnimationView;


import teamkenko.english_smart.Learn.Menu_learn;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Your_Words.Your_Words;
import teamkenko.english_smart.game_choose.menu_game.Menu_Game;

public class Menu_Main  extends Fragment {
    LottieAnimationView pos1,pos2,pos3;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_trangchu,container,false);
        pos1 = view.findViewById(R.id.poster_1);
        pos2  = view.findViewById(R.id.poster_2);
        pos3 = view.findViewById(R.id.poster_3);


        pos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Menu_learn.class));
            }
        });
        pos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Your_Words.class));
            }
        });

        pos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),Menu_Game.class));
            }
        });
        return  view;
    }



}
