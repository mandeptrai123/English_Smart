package teamkenko.english_smart.Training;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import teamkenko.english_smart.R;

public class Training_OverView extends AppCompatActivity {
    Adapter_Train adapter_train;
    ListView listView;
    String text[]={"Reading","Listening","Speaking"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training__over_view);



    }
}
