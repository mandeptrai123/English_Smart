package teamkenko.english_smart.game_choose.menu_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Profile.User_detail;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Check_Connection;
import teamkenko.english_smart.ThanhTich.ID_Tourist;


public class Rank_Game extends AppCompatActivity {
    Adapter_Rank_Game adapter;
    int temp ;
    String temp_2 ;
    String temp_3;
    String temp_4;
    LottieAnimationView tt_rank_game;
    ListView lv_rank_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank__game);
        lv_rank_game =(ListView)findViewById(R.id.lv_rank_game);
        tt_rank_game = ( LottieAnimationView)findViewById(R.id.tt_rank_demo);

        sortDESC();
        adapter = new Adapter_Rank_Game(this,DuLieu.name,DuLieu.id_user,DuLieu.star,DuLieu.top,DuLieu.name_school,DuLieu.uri,this);
        lv_rank_game.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        if(Check_Connection.haveNetworkConnection(getApplicationContext()) && DuLieu.score.length>0 )
        {

            temp = DuLieu.score[0];
            temp_2 = DuLieu.name[0];
            temp_3 = DuLieu.name_school[0];
      //      temp_4 = DuLieu.uri[0];
            for(int i=0;i< DuLieu.name.length;i++)
            {
                if(Data_User.name_user.equals(DuLieu.name[i]))
                {
                    int a=i+1;
                    Toasty.info(getApplicationContext(),"Hiện Bạn Đang Ở Top: "+a, Toast.LENGTH_LONG).show();
                }
            }
        }
        else if(DuLieu.score==null)
        {
            Toasty.info(getApplicationContext(),"Kết Nối Internet Để Cập Nhật Bảng Xếp Hạng",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toasty.warning(getApplicationContext(),"Kiểm Tra Kết Nối Internet", Toast.LENGTH_LONG).show();

        }


    }
    public void User_detail(String id)
    {
        ID_Tourist.id = id;
        Intent intent = new Intent(Rank_Game.this, User_detail.class);
        startActivity(intent);
        finish();

    }
    private void sortDESC() {

        for (int i = 0 ; i < DuLieu.star.length - 1; i++) {
            for (int j = i + 1; j < DuLieu.star.length; j++) {
                if (DuLieu.star[i] < DuLieu.star[j]) {
                    temp = DuLieu.star[j];
                    DuLieu.star[j] = DuLieu.star[i];
                    DuLieu.star[i] = temp;


                    temp_2=DuLieu.name[j];
                    DuLieu.name[j]=DuLieu.name[i];
                    DuLieu.name[i]=temp_2;

                    temp_3=DuLieu.name_school[j];
                    DuLieu.name_school[j]=DuLieu.name_school[i];
                    DuLieu.name_school[i]=temp_3;


                    temp_4=DuLieu.uri[j];
                    DuLieu.uri[j]=DuLieu.uri[i];
                    DuLieu.uri[i]=temp_4;

                }
            }
        }
    }

    @Override
    public void onBackPressed() {
                finish();
                startActivity(new Intent(Rank_Game.this,Menu_Game.class));
    }
}