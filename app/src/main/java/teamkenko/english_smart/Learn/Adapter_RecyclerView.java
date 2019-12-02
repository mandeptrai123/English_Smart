package teamkenko.english_smart.Learn;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import de.hdodenhof.circleimageview.CircleImageView;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Vocabulary.Voca_Speaking;
import teamkenko.english_smart.Word_Contest.List_Word;
import teamkenko.english_smart.Word_Contest.Word_online;
import teamkenko.english_smart.TOEIC.Menu_Toeic.Main_Toeic;


public class Adapter_RecyclerView extends  RecyclerView.Adapter<Adapter_RecyclerView.SimpleViewHolder> {
    Menu_learn menu_learn;
    String names []={"Vocabulary","Communicate","Training","Toeic"};
    int    imgs []={R.drawable.contest_smart,R.drawable.contest_smart,R.drawable.contest_smart,R.drawable.contest_smart};


    public Adapter_RecyclerView(Menu_learn menu_learn) {
        this.menu_learn = menu_learn;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cyclerview_learn, viewGroup, false);


        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {

        simpleViewHolder.img.setBackgroundResource(imgs[i]);
        simpleViewHolder.name.setText(names[i]);


    }


        @Override
        public int getItemCount() {
            return names.length;
        }


    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView img;
        public TextView name;
        public Context context;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.item_img_learn);
            name = (TextView) itemView.findViewById(R.id.item_name_learn);
             context =itemView.getContext();
             img.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     final Intent intent;
                     switch (getAdapterPosition())
                     {
                             case 0:
                                 intent =  new Intent(context, Word_online.class);
                                 context.startActivity(intent);
                                 break;
                             case 1:
                                 intent =  new Intent(context, List_Word.class);
                                 context.startActivity(intent);
                                 break;
                             case 2:
                                 intent =  new Intent(context, Voca_Speaking.class);
                                 context.startActivity(intent);
                                 break;
                             case 3:
                                 intent =  new Intent(context, Main_Toeic.class);
                                 context.startActivity(intent);
                                 break;

                     }

                 }
             });
        }
    }
}

