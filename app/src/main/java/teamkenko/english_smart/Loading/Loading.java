package teamkenko.english_smart.Loading;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Check_Connection;
import teamkenko.english_smart.menu.Menu_English;
import teamkenko.english_smart.TOEIC.part_1.Choosed_Part1;
import teamkenko.english_smart.TOEIC.part_2.Choosed_Part2;
import teamkenko.english_smart.TOEIC.part_3.Choosed_Part3;
import teamkenko.english_smart.TOEIC.part_4.Choosed_Part4;
import teamkenko.english_smart.TOEIC.part_5.Choosed_Part5_T1;


public class Loading extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int count=0;
   //SeekBar progressBar;
   FirebaseAuth mAuth;
   LottieAnimationView animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
     // progressBar =(SeekBar)findViewById(R.id.pro_loading);
     //  progressBar.setMax(10000);
     //  progressBar.setProgress(count);
       animation = findViewById(R.id.animation_loading);
       animation.setSpeed(0.5f);

//       if(!animation.isAnimating())
//       {
//           Intent intent = new Intent(Loading.this,Menu_English.class);
//              startActivity(intent);
//               finish();
//
//       }
        mAuth = FirebaseAuth.getInstance();


        FirebaseUser firebaseUser = mAuth.getCurrentUser();
//        Data_User.uri=firebaseUser.getPhotoUrl().toString();
        Data_User.name_user = firebaseUser.getDisplayName();

        //get_data();
        get_data_part1();
        get_data_part3();
        get_data_part2();
        get_data_part4();
        get_data_part5_t1();
        countDownTimer = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                count+=1000;
             //   progressBar.setProgress(count);
            }

            @Override
            public void onFinish() {
                 //  progressBar.setProgress(10000);
                Intent intent = new Intent(Loading.this,Menu_English.class);
                startActivity(intent);
                finish();

            }
        };
        countDownTimer.start();




    }




    private void setup_account() {

        final FirebaseUser firebaseUser = mAuth.getCurrentUser();
        Data_User.id = firebaseUser.getUid();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Sever.duongdandulieu_insert, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toasty.success(getApplicationContext(),response,Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erro",error+"");
                Toasty.error(getApplicationContext(), error+"", 2000).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("user_id",firebaseUser.getUid());
                hashMap.put("name","Jack Hamper");
                hashMap.put("star", "100");
                hashMap.put("score_word", "30");
                hashMap.put("name_school", "Đại Học Công Nghiệp TP HCM");
                hashMap.put("Uri", "");
                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
        requestQueue.getCache().clear();

    }

    private void get_data() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    DuLieu.id_user = new String[response.length()];
                    DuLieu.name = new String[response.length()];
                    DuLieu.star = new int[response.length()];
                    DuLieu.score_word = new int[response.length()];
                    DuLieu.name_school = new String[response.length()];
                    DuLieu.uri     = new String[response.length()];


                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            DuLieu.stt = jsonObject.getInt("stt");
                            DuLieu.id_user[i] = jsonObject.getString("user_id");
                            DuLieu.name[i] = jsonObject.getString("name");
                            DuLieu.star[i] = jsonObject.getInt("star");
                            DuLieu.score_word[i] = jsonObject.getInt("score_word");
                            DuLieu.name_school[i] = jsonObject.getString("name_school");
                            DuLieu.uri[i] = jsonObject.getString("Uri");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

               Check_Connection.Show_Toast(getApplicationContext(), "Lỗi Không Kết Nối Được Tới Sever");
            }
        });
        requestQueue.add(jsonArrayRequest);
    }



    private void get_data_part1() {

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_part1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    Choosed_Part1.correct = new String[response.length()];
                    Choosed_Part1.note_ans = new String[response.length()][4];
                    Choosed_Part1.Uri = new String[response.length()];
                    Choosed_Part1.Audio = new String[response.length()];
                    int stt;

                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            stt = jsonObject.getInt("stt");
                            Choosed_Part1.Audio[i] = jsonObject.getString("audio");
                            Choosed_Part1.note_ans[i][0] = jsonObject.getString("ans1");
                            Choosed_Part1.note_ans[i][1] = jsonObject.getString("ans2");
                            Choosed_Part1.note_ans[i][2] = jsonObject.getString("ans3");
                            Choosed_Part1.note_ans[i][3] = jsonObject.getString("ans4");
                            Choosed_Part1.correct[i] = jsonObject.getString("correct");
                            Choosed_Part1.Uri[i] = jsonObject.getString("image");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Check_Connection.Show_Toast(getApplicationContext(), error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
    private void get_data_part2() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_part2, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    Choosed_Part2.Audio = new String[response.length()];
                    Choosed_Part2.note_ans = new String[response.length()][3];
                    Choosed_Part2.correct  = new String[response.length()];
                    Choosed_Part2.question = new String[response.length()];

                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            Choosed_Part2.Audio[i]=jsonObject.getString("audio");
                            Choosed_Part2.question[i]=jsonObject.getString("question");
                            Choosed_Part2.note_ans[i][0]=jsonObject.getString("ans1");
                            Choosed_Part2.note_ans[i][1]=jsonObject.getString("ans2");
                            Choosed_Part2.note_ans[i][2]=jsonObject.getString("ans3");
                            Choosed_Part2.correct[i]=jsonObject.getString("correct");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Check_Connection.Show_Toast(getApplicationContext(), error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
    private void get_data_part3() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_part3, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    Choosed_Part3.audio = new String[response.length()];
                    Choosed_Part3.text = new String[response.length()];
                    Choosed_Part3.trans= new String[response.length()];
                    Choosed_Part3.note_ans1 = new String[response.length()][4];
                    Choosed_Part3.correct1  = new String[response.length()];
                    Choosed_Part3.question1 = new String[response.length()];

                    Choosed_Part3.note_ans2 = new String[response.length()][4];
                    Choosed_Part3.correct2 = new String[response.length()];
                    Choosed_Part3.question2 = new String[response.length()];

                    Choosed_Part3.note_ans3 = new String[response.length()][4];
                    Choosed_Part3.correct3 = new String[response.length()];
                    Choosed_Part3.question3 = new String[response.length()];


                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            Choosed_Part3.audio[i]=jsonObject.getString("audio");
                            Choosed_Part3.text[i]=jsonObject.getString("text");
                            Choosed_Part3.trans[i]=jsonObject.getString("trans");

                            Choosed_Part3.question1[i]=jsonObject.getString("ques1");
                            Choosed_Part3.note_ans1[i][0]=jsonObject.getString("q1_ans1");
                            Choosed_Part3.note_ans1[i][1]=jsonObject.getString("q1_ans2");
                            Choosed_Part3.note_ans1[i][2]=jsonObject.getString("q1_ans3");
                            Choosed_Part3.note_ans1[i][3]=jsonObject.getString("q1_ans4");
                            Choosed_Part3.correct1[i]=jsonObject.getString("q1_correct");

                            Choosed_Part3.question2[i]=jsonObject.getString("ques2");
                            Choosed_Part3.note_ans2[i][0]=jsonObject.getString("q2_ans1");
                            Choosed_Part3.note_ans2[i][1]=jsonObject.getString("q2_ans2");
                            Choosed_Part3.note_ans2[i][2]=jsonObject.getString("q2_ans3");
                            Choosed_Part3.note_ans2[i][3]=jsonObject.getString("q2_ans4");
                            Choosed_Part3.correct2[i]=jsonObject.getString("q2_correct");

                            Choosed_Part3.question3[i]=jsonObject.getString("ques3");
                            Choosed_Part3.note_ans3[i][0]=jsonObject.getString("q3_ans1");
                            Choosed_Part3.note_ans3[i][1]=jsonObject.getString("q3_ans2");
                            Choosed_Part3.note_ans3[i][2]=jsonObject.getString("q3_ans3");
                            Choosed_Part3.note_ans3[i][3]=jsonObject.getString("q3_ans4");
                            Choosed_Part3.correct3[i]=jsonObject.getString("q3_correct");

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             //   Check_Connection.Show_Toast(getApplicationContext(), error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);

    }


    private void get_data_part4() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_part4, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    Choosed_Part4.question1 = new String[response.length()];
                    Choosed_Part4.note_ans1 = new String[response.length()][4];
                    Choosed_Part4.correct1  = new String[response.length()];

                    Choosed_Part4.question2 = new String[response.length()];
                    Choosed_Part4.note_ans2 = new String[response.length()][4];
                    Choosed_Part4.correct2 = new String[response.length()];

                    Choosed_Part4.question3 = new String[response.length()];
                    Choosed_Part4.note_ans3 = new String[response.length()][4];
                    Choosed_Part4.correct3  = new String[response.length()];



                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);

                            Choosed_Part4.question1[i]=jsonObject.getString("ques1");
                            Choosed_Part4.note_ans1[i][0]=jsonObject.getString("q1_ans1");
                            Choosed_Part4.note_ans1[i][1]=jsonObject.getString("q1_ans2");
                            Choosed_Part4.note_ans1[i][2]=jsonObject.getString("q1_ans3");
                            Choosed_Part4.note_ans1[i][3]=jsonObject.getString("q1_ans4");
                            Choosed_Part4.correct1[i]    = jsonObject.getString("q1_correct");

                            Choosed_Part4.question2[i]=jsonObject.getString("ques2");
                            Choosed_Part4.note_ans2[i][0]=jsonObject.getString("q2_ans1");
                            Choosed_Part4.note_ans2[i][1]=jsonObject.getString("q2_ans2");
                            Choosed_Part4.note_ans2[i][2]=jsonObject.getString("q2_ans3");
                            Choosed_Part4.note_ans2[i][3]=jsonObject.getString("q2_ans4");
                            Choosed_Part4.correct2[i]    = jsonObject.getString("q2_correct");

                            Choosed_Part4.question3[i]=jsonObject.getString("ques3");
                            Choosed_Part4.note_ans3[i][0]=jsonObject.getString("q3_ans1");
                            Choosed_Part4.note_ans3[i][1]=jsonObject.getString("q3_ans2");
                            Choosed_Part4.note_ans3[i][2]=jsonObject.getString("q3_ans3");
                            Choosed_Part4.note_ans3[i][3]=jsonObject.getString("q3_ans4");
                            Choosed_Part4.correct3[i]    = jsonObject.getString("q3_correct");


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Excep",e+"");
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  Check_Connection.Show_Toast(getApplicationContext(), error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

    private void get_data_part5_t1() {

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu_part5_t1, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    Choosed_Part5_T1.text = new String[response.length()];
                    Choosed_Part5_T1.note_ans1 = new String[response.length()][4];
                    Choosed_Part5_T1.note_ans2 = new String[response.length()][4];
                    Choosed_Part5_T1.note_ans3 = new String[response.length()][4];
                    Choosed_Part5_T1.note_ans4 = new String[response.length()][4];
                    Choosed_Part5_T1.correct1 = new String[response.length()];
                    Choosed_Part5_T1.correct2 = new String[response.length()];
                    Choosed_Part5_T1.correct3 = new String[response.length()];
                    Choosed_Part5_T1.correct4 = new String[response.length()];
                    for (int i = 0; i < response.length(); i++) {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            Choosed_Part5_T1.stt = jsonObject.getInt("stt");
                            Choosed_Part5_T1.text[i]=jsonObject.getString("text");

                            Choosed_Part5_T1.note_ans1[i][0]=jsonObject.getString("ans1_1");
                            Choosed_Part5_T1.note_ans1[i][1]=jsonObject.getString("ans2_1");
                            Choosed_Part5_T1.note_ans1[i][2]=jsonObject.getString("ans3_1");
                            Choosed_Part5_T1.note_ans1[i][3]=jsonObject.getString("ans4_1");
                            Choosed_Part5_T1.correct1[i]    = jsonObject.getString("correct_1");

                            Choosed_Part5_T1.note_ans2[i][0]=jsonObject.getString("ans1_2");
                            Choosed_Part5_T1.note_ans2[i][1]=jsonObject.getString("ans2_2");
                            Choosed_Part5_T1.note_ans2[i][2]=jsonObject.getString("ans3_2");
                            Choosed_Part5_T1.note_ans2[i][3]=jsonObject.getString("ans4_2");
                            Choosed_Part5_T1.correct2[i]    = jsonObject.getString("correct_2");

                            Choosed_Part5_T1.note_ans3[i][0]=jsonObject.getString("ans1_3");
                            Choosed_Part5_T1.note_ans3[i][1]=jsonObject.getString("ans2_3");
                            Choosed_Part5_T1.note_ans3[i][2]=jsonObject.getString("ans3_3");
                            Choosed_Part5_T1.note_ans3[i][3]=jsonObject.getString("ans4_3");
                            Choosed_Part5_T1.correct3[i]    = jsonObject.getString("correct_3");

                            Choosed_Part5_T1.note_ans4[i][0]=jsonObject.getString("ans1_4");
                            Choosed_Part5_T1.note_ans4[i][1]=jsonObject.getString("ans2_4");
                            Choosed_Part5_T1.note_ans4[i][2]=jsonObject.getString("ans3_4");
                            Choosed_Part5_T1.note_ans4[i][3]=jsonObject.getString("ans4_4");
                            Choosed_Part5_T1.correct4[i]    = jsonObject.getString("correct_4");



                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //  Check_Connection.Show_Toast(getApplicationContext(), error.toString());
            }
        });

        requestQueue.add(jsonArrayRequest);
    }


    private void huybo() {
        countDownTimer.cancel();
    }
}
