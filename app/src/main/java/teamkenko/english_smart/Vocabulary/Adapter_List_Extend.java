package teamkenko.english_smart.Vocabulary;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

import teamkenko.english_smart.R;

public class Adapter_List_Extend extends BaseAdapter {
    Context context;
    String ex[];
     TextToSpeech textToSpeech;
    public Adapter_List_Extend(Context context, String[] ex) {
        this.context = context;
        this.ex = ex;
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }

            }
        });
    }

    @Override
    public int getCount() {
        return ex.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return ex.length;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.item_words_extend,parent,false);
        final TextView text_ex = (TextView)view.findViewById(R.id.item_extend);
        text_ex.setText(ex[position]);
       ImageView img_sound = (ImageView)view.findViewById(R.id.item_sound_ex);
        img_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String toSpeak = text_ex.getText().toString();
                Toast.makeText(context, toSpeak,Toast.LENGTH_SHORT).show();
                HashMap<String, String> onlineSpeech = new HashMap<>();
                onlineSpeech.put(TextToSpeech.Engine.KEY_FEATURE_NETWORK_SYNTHESIS, "true");
                textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, onlineSpeech);
            }
        });

        return view;
    }

}
