package teamkenko.english_smart.Vocabulary;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import teamkenko.english_smart.R;

public class Voca_Speaking extends AppCompatActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 100;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    RecyclerView recyclerView ;
    Adapter_Recycle_Voca dapter;
    int img[]={R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko,
            R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko,R.drawable.icon_kenko};
    String words[]={"Hello","Hello","Hello","Hello","Hello","Hello","Hello","Hello","Hello","Hello"};
    String mains[]={"Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào","Xin Chào"};
    String descriptions[]={"Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào."
    ,"Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào.","Dùng khi bạn muốn nói xin chào."
    ,"Dùng khi bạn muốn nói xin chào."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voca__speaking);
        sharedPreferences = getSharedPreferences("mydata123", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        checkPermission();



        // init
        recyclerView = (RecyclerView) findViewById(R.id.list_voca_speaking);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dapter = new Adapter_Recycle_Voca(this,img,mains,words,descriptions);

        LayoutAnimationController controller =null;
        controller = AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_from_right);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setAdapter(dapter);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();



    }
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }


}
