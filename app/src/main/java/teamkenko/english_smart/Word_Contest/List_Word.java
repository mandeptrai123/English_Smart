package teamkenko.english_smart.Word_Contest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import teamkenko.english_smart.R;


public class List_Word extends AppCompatActivity {
 RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__word);
       recycler = (RecyclerView) findViewById(R.id.recycler_words);
       recycler.setLayoutManager(new LinearLayoutManager(this));
       Create_animation();
    }

    private void Create_animation() {
        SimpleAdapter simpleAdapter = new SimpleAdapter();
        LayoutAnimationController controller =null;
        controller = AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_from_right);
        recycler.setLayoutAnimation(controller);
        recycler.setAdapter(simpleAdapter);
        recycler.getAdapter().notifyDataSetChanged();
        recycler.scheduleLayoutAnimation();
    }

    public void go_to_word_on()
    {
        Intent intent = new Intent(getApplicationContext(),Word_online.class);
        startActivity(intent);
    }
}
