package teamkenko.english_smart.Vocabulary;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import teamkenko.english_smart.R;

public class Adapter_Gird_Voca extends BaseAdapter {
    Context context;
    String [] word;
    String [] main;
    String [] uri;
    MediaPlayer mediaPlayer;
    Calendar_day day;
    public Adapter_Gird_Voca(Context context, String[] word, String[] main, String[] uri, Calendar_day day){
        this.context=context;
       this.word = word;
       this.main = main;
       this.uri = uri;
       this.day = day;

    }
    @Override
    public int getCount() {
       return word.length;
    }

    @Override
    public Object getItem(int i) {
        return word[i];
    }

    @Override
    public long getItemId(int i) {
        return word.length;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.gridview_voca,viewGroup,false);
        TextView text_word = (TextView) rowView.findViewById(R.id.word_voca_adapter);
        TextView text_main = (TextView) rowView.findViewById(R.id.name_voca_adapter);
        ImageView micro =(ImageView)rowView.findViewById(R.id.micro_voca);
        final ImageView img_sound = (ImageView)rowView.findViewById(R.id.sound_voca_adapter);
        text_word.setText(word[position].toUpperCase());
        text_main.setText(main[position].toUpperCase());
        micro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                day.connect_micro(position);
            }
        });
        img_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_sound.setBackgroundResource(R.drawable.sound_blue_2);
                mediaPlayer = MediaPlayer.create(context,Uri.parse(uri[position]));
                mediaPlayer.start();
            }
        });
         return  rowView;
    }
}
