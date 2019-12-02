package teamkenko.english_smart.menu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;


import de.hdodenhof.circleimageview.CircleImageView;
import devlight.io.library.ntb.NavigationTabBar;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.Login.Login_Main;
import teamkenko.english_smart.Profile.USER_UPDATE;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Check_Connection;


public class Menu_English extends AppCompatActivity {
    ViewPager viewPager;
    CircleImageView img ;
    TextView text_name;
    RelativeLayout relativeLayout;
    LottieAnimationView lottie_setting;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__english);
        viewPager =  findViewById(R.id.viewpager_main);
        img  = findViewById(R.id.user_show_main);
        text_name = findViewById(R.id.name_show_main);
        relativeLayout = findViewById(R.id.relative_user_main);
        lottie_setting = findViewById(R.id.setting_main);
        firebaseAuth = FirebaseAuth.getInstance();


        findViewById(R.id.pro_load_img_show).setVisibility(View.VISIBLE);
          // chua update lan nao.

              Picasso.with(getApplicationContext()).load("https://firebasestorage.googleapis.com/v0/b/smart-english-5b37c.appspot.com/o/profilepics%2Flogo.png?alt=media&token=f2e0e238-bba0-467c-9e35-d9188cc5a0f1").into(img, new Callback() {
                  @Override
                  public void onSuccess() {
                      findViewById(R.id.pro_load_img_show).setVisibility(View.GONE);
                  }

                  @Override
                  public void onError() {
                      Toasty.warning(getApplicationContext(),"Loading Image Failed").show();

                  }
              });

              text_name.setText(firebaseAuth.getCurrentUser().getDisplayName());
              
               if (firebaseAuth.getCurrentUser().getPhotoUrl()!=null)
               {
                   Data_User.uri = String.valueOf(firebaseAuth.getCurrentUser().getPhotoUrl());
               }

        relativeLayout.setX(500f);
        ViewCompat.animate(relativeLayout).translationX(0f).setDuration(700).start();
        init_main();
        getData();
        lottie_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Menu_English.this);
                dialog.show();
                dialog.setContentView(R.layout.item_option_setting);
                if(dialog.getWindow()!=null)
                {
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                dialog.setCancelable(true);
                TextView profile = dialog.findViewById(R.id.edit_profile);
                TextView sign_out = dialog.findViewById(R.id.sign_out_op);
                sign_out.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        firebaseAuth.signOut();
                        startActivity(new Intent(Menu_English.this,Login_Main.class));
                    }
                });
                profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        finish();
                        startActivity(new Intent(Menu_English.this,USER_UPDATE.class));
                    }
                });

            }
        });






    }



    private void init_main() {

        final String[] colors = getResources().getStringArray(R.array.default_preview);
        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizon);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_user),
                        Color.parseColor(colors[0]))
                 //       .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Profile")
                        .badgeTitle("New")
                        .build()
        );
     /*  models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book),
                        Color.parseColor(colors[1]))
              //         .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Vocabulary")
                        .badgeTitle("New")
                        .build()
        );*/
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book),
                        Color.parseColor(colors[2]))
                 //       .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("English")
                        .badgeTitle("New")
                        .build()
        );

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book),
                        Color.parseColor(colors[2]))
                        //       .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Event")
                        .badgeTitle("New")
                        .build()
        );


     /*   models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book),
                        Color.parseColor(colors[3]))
                   //     .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Video")
                        .badgeTitle("New")
                        .build()
        );*/
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book),
                        Color.parseColor(colors[4]))
                  //      .selectedIcon(getResources().getDrawable(R.drawable.ic_sixth))
                        .title("Rank")
                        .badgeTitle("New")
                        .build()
        );




        navigationTabBar.setModels(models);
        FragmentManager manager = getSupportFragmentManager();
        teamkenko.english_smart.menu.PagerAdapter pagerAdapter = new teamkenko.english_smart.menu.PagerAdapter(manager);
        viewPager.setAdapter(pagerAdapter);




      navigationTabBar.setViewPager(viewPager, 1);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(final int position) {
                update_rank();
                navigationTabBar.getModels().get(position).hideBadge();
                viewPager.addOnPageChangeListener((ViewPager.OnPageChangeListener) new NavigationTabBar(getApplicationContext()).getOnTabBarSelectedIndexListener());

            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
    }

    private void update_rank() {

    }


    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.duongdandulieu, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null)
                {
                    DuLieu.id_user = new String[response.length()];
                    DuLieu.name = new String[response.length()];
                    DuLieu.star = new int[response.length()];
                    DuLieu.score_word = new int[response.length()];
                    DuLieu.name_school = new String[response.length()];
                    DuLieu.uri      = new String[response.length()];
                    for(int i=0;i<response.length();i++)
                    {
                        try {

                            JSONObject jsonObject = response.getJSONObject(i);
                            DuLieu.stt            = jsonObject.getInt("stt");
                            DuLieu.id_user[i]=jsonObject.getString("user_id");
                            DuLieu.name[i] = jsonObject.getString("name");
                            DuLieu.star[i]  = jsonObject.getInt("star");
                            DuLieu.score_word[i] = jsonObject.getInt("score_word");
                            DuLieu.name_school[i]=jsonObject.getString("name_school");
                            DuLieu.uri[i]         = jsonObject.getString("Uri");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Check_Connection.Show_Toast(getApplicationContext(),""+error);
                Log.d("Errorrr",error+"");
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Clear(getApplicationContext());

    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.show();
        if(dialog.getWindow()!=null)
        {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.setContentView(R.layout.item_dialog_back);
        Button but_yes = dialog.findViewById(R.id.but_yes_back);
        Button but_no = dialog.findViewById(R.id.but_no_back);
        but_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                Clear(getApplicationContext());
                onDestroy();
                System.exit(0);
            }
        });
        but_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


    }


    private void Clear(Context context) {
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        // The directory is now empty so delete it
        return dir.delete();
    }
}