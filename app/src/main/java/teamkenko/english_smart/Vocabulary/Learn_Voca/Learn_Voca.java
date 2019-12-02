package teamkenko.english_smart.Vocabulary.Learn_Voca;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import teamkenko.english_smart.R;

public class Learn_Voca extends AppCompatActivity {
    ViewPager viewPager;
    String[] list_words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn__voca);
        viewPager = findViewById(R.id.viewpager_learn_voca);
        list_words = new String[10];
        for(int i=0;i<10;i++)
        {
            list_words[i]=Data_Words.Words[Data_Words.key][i];
        }
      //  Adapter_Content adapter_content = new Adapter_Content(this,list_words);
    }
}
