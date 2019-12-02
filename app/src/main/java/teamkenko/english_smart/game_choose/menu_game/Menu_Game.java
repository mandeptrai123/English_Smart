package teamkenko.english_smart.game_choose.menu_game;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Big_Data.Score_User;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Check_Connection;
import teamkenko.english_smart.game_choose.game_bat_chu.Game_batchu;
import teamkenko.english_smart.game_choose.game_dap_trung.Game_DapTrung;
import teamkenko.english_smart.game_choose.game_music.Game_Music;
import teamkenko.english_smart.menu.Menu_English;


public class Menu_Game extends AppCompatActivity {
    private  static final int stream_type = AudioManager.STREAM_MUSIC;
    SoundPool soundPool;
            AudioManager audioManager;
    int music_nhap;
    float current_music,max_music;
    ImageView img_batchu,img_music,img_daptrung,img_xepxe;
    TextViewFonts text1,text2,text3,text4;
   CountDownTimer countDownTimer;
   TextViewFonts rank_game;
   TextView my_star;
    int score_sum;
    String name,school,nganh,sdt,crush,nienkhoa,uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__game);
        img_daptrung = (ImageView) findViewById(R.id.img_choose_game_1);
        img_music = (ImageView) findViewById(R.id.img_choose_game_2);
        img_batchu =(ImageView)findViewById(R.id.img_choose_game_3);
        text1 = findViewById(R.id.text_choose_game_1);
        rank_game= findViewById(R.id.rank_game);
        text2 =findViewById(R.id.text_choose_game_2);
        text3 = findViewById(R.id.text_choose_game_3);





        put_Data();
        get_Data();




        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        current_music = audioManager.getStreamVolume(stream_type);
        max_music =  audioManager.getStreamMaxVolume(stream_type);
        this.setVolumeControlStream(stream_type);
        soundPool = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
        music_nhap = soundPool.load(this,R.raw.but_music_nhap,1);




    }
   public void bxh_game(View view)
   {
       Intent intent = new Intent(Menu_Game.this,Rank_Game.class);
       startActivity(intent);
       finish();
   }
    private void put_Data() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.duongdandulieu_update, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("user_id",String.valueOf(Data_User.id));
                hashMap.put("star", String.valueOf(score_sum));
                hashMap.put("name", name);
                hashMap.put("sdt",sdt);
                hashMap.put("score", String.valueOf(Score_User.score));
                hashMap.put("score_word", String.valueOf(Score_User.score_word));
                hashMap.put("score_listen", String.valueOf(Score_User.score_listen));
                hashMap.put("score_spell", String.valueOf(Score_User.score_spell));
                hashMap.put("nienkhoa", nienkhoa);
                hashMap.put("khoa",nganh);
                hashMap.put("name_school",school);
                hashMap.put("Uri",uri);
                hashMap.put("crush",crush);
                return hashMap;

            }
        };
        requestQueue.add(stringRequest);
    }

    private void get_Data() {
        if(Check_Connection.haveNetworkConnection(getApplicationContext()))
        {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    if(response!=null)
                    {
                        DuLieu.id_user = new String[response.length()];
                        DuLieu.name = new String[response.length()];
                        DuLieu.sdt = new int[response.length()];
                        DuLieu.score = new int[response.length()];
                        DuLieu.star = new int[response.length()];
                        DuLieu.score_word = new int[response.length()];
                        DuLieu.score_listen = new int[response.length()];
                        DuLieu.score_spell = new int[response.length()];
                        DuLieu.name_school = new String[response.length()];
                        DuLieu.uri= new String[response.length()];
                        DuLieu.khoa = new String[response.length()];
                        DuLieu.nienkhoa = new int[response.length()];

                        for(int i=0;i<response.length();i++)
                        {
                            try {

                                JSONObject jsonObject = response.getJSONObject(i);
                                DuLieu.id_user[i]=jsonObject.getString("user_id");
                                DuLieu.name[i] = jsonObject.getString("name");
                                DuLieu.star[i]=jsonObject.getInt("star");
                                DuLieu.sdt[i]  = jsonObject.getInt("sdt");
                                DuLieu.score[i] = jsonObject.getInt("score");
                                DuLieu.star[i] = jsonObject.getInt("star");
                                DuLieu.score_word[i] = jsonObject.getInt("score_word");
                                DuLieu.score_listen[i] = jsonObject.getInt("score_listen");
                                DuLieu.score_spell[i] = jsonObject.getInt("score_spell");
                                DuLieu.khoa[i]=jsonObject.getString("khoa");
                                DuLieu.name_school[i] = jsonObject.getString("name_school");
                                DuLieu.uri[i]= jsonObject.getString("uri");
                                DuLieu.nienkhoa[i] = jsonObject.getInt("nienkhoa");

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                 //   Check_Connection.Show_Toast(getApplicationContext(),error.toString());
                }
            });
            requestQueue.add(jsonArrayRequest);

        }else {
            Check_Connection.Show_Toast(getApplicationContext(),"Bạn Hãy Kiểm Tra Kết Nối");
            finish();
        }
    }

    public void onClick1(View view) {
        soundPool.play(music_nhap,10,10f,1,0,1);
        Intent intent = new Intent(Menu_Game.this,Game_DapTrung.class);
        startActivity(intent);
        finish();
    }

    public void onClick2(View view) {

        soundPool.play(music_nhap,10,10f,1,0,1);
        Intent intent = new Intent(Menu_Game.this,Game_Music.class);
        startActivity(intent);
        finish();
    }

    public void onClick3(View view) {

        soundPool.play(music_nhap,10,10f,1,0,1);
        Intent intent = new Intent(Menu_Game.this,Game_batchu.class);
        startActivity(intent);
        finish();
    }


    public void onClick4(View view) {
        soundPool.play(music_nhap,10,10f,1,0,1);
      //  Intent intent = new Intent(Menu_Game.this,Game_xepxe.class);
     //   startActivity(intent);
       // finish();
    }


    @Override
    public void onBackPressed() {
        soundPool.play(music_nhap,10,10f,1,0,1);
        Intent intent = new Intent(Menu_Game.this, Menu_English.class);
        startActivity(intent);
        finish();
    }
}
