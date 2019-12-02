package teamkenko.english_smart.Vocabulary;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;




import java.util.ArrayList;
import java.util.Locale;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.DuLieu_Voca;
import teamkenko.english_smart.Learn.Menu_learn;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Word_Contest.Box_Question;


public class Calendar_day extends AppCompatActivity {
    ListView list_tuvung;
 Adapter_Gird_Voca adapter_gird_voca;
 private static final int REQ_CODE_SPEECH_INPUT = 100;
 public int posi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_day);
        list_tuvung = (ListView) findViewById(R.id.gridview_voca_day) ;
        load_dulieu();
        adapter_gird_voca = new Adapter_Gird_Voca(this, Box_Question.question,  Box_Question.main,  Box_Question.sound,this);
        list_tuvung.setAdapter(adapter_gird_voca);
        list_tuvung.deferNotifyDataSetChanged();


    }

    private void load_dulieu() {

    }
    public  void connect_micro(int vitri)
    {
        posi=vitri;
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en-US");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech Slow Please!");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    public void dialog_choose(){

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    if(result.get(0).toUpperCase().equals(DuLieu_Voca.word[posi].toUpperCase()))
                    {

                        try{
                              Toasty.info(this,"Very Good!",1000);
                        }catch (Exception e)
                        {
                            Toasty.info(this,e+"",1000);
                        }

                    }else
                    {
                        Toasty.info(this,"Speak Again!",1000);
                        try{
                             Toasty.info(this,"Speak Again!",1000);
                        }catch (Exception e)
                        {
                            Toasty.info(this,e+"",1000);
                        }
                    }
                }
                break;
            }

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Calendar_day.this, Menu_learn.class);
        startActivity(intent);
        finish();

    }
}
