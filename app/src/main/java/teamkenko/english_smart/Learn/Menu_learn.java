package teamkenko.english_smart.Learn;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Check_Connection;
import teamkenko.english_smart.Word_Contest.Box_Question;
import teamkenko.english_smart.menu.Menu_English;


public class Menu_learn extends AppCompatActivity {
 public RecyclerView recyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_learn);
     recyclerView = (RecyclerView) findViewById(R.id.recycler_learns);
     recyclerView.setLayoutManager(new LinearLayoutManager(this));
     Adapter_RecyclerView adapter_recyclerView = new Adapter_RecyclerView(this);
        LayoutAnimationController controller =null;
        controller = AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_from_right);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setAdapter(adapter_recyclerView);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
        get_Data();
    }

    private void get_Data() {
        if(Check_Connection.haveNetworkConnection(getApplicationContext()))
        {
            final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_voca, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if(response!=null)
                    {
                        Box_Question.stt = new int[response.length()];
                        Box_Question.priotiry=new int[response.length()];
                        Box_Question.question = new String[response.length()];
                        Box_Question.main = new String[response.length()];
                        Box_Question.sound = new String[response.length()];

                        for(int i=0;i<response.length();i++)
                        {
                            try {

                                JSONObject jsonObject123 = response.getJSONObject(i);
                                Box_Question.stt[i]   = jsonObject123.getInt("stt");
                                Box_Question.priotiry[i] = jsonObject123.getInt("priority");
                                Box_Question.question[i]=jsonObject123.getString("word");
                                Box_Question.main[i] = jsonObject123.getString("main");
                                Box_Question.sound[i]= jsonObject123.getString("sound");


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //Check_Connection.Show_Toast(getApplicationContext(),error.toString());
                }
            });
            requestQueue.add(jsonArrayRequest);

        }else {
            Check_Connection.Show_Toast(getApplicationContext(),"Bạn Hãy Kiểm Tra Kết Nối");
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu_learn.this, Menu_English.class);
        startActivity(intent);
        finish();

    }
}
