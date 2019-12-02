package teamkenko.english_smart.Profile;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.ID_Tourist;
import teamkenko.english_smart.ThanhTich.Logo_School;
import teamkenko.english_smart.menu.Menu_English;

public class User_detail extends AppCompatActivity {
    ImageView img,logo;
    TextView name,detail_majors,detail_achi,detail_phone,detail_school;
    String arr[]={"Công Nghiệp TP HCM University",
            "Bách Khoa Univerity",
            "Công Nghệ TP HCM University",
            "Công Nghệ Thông Tin University",
            "Sư Phạm Kỹ Thuật University","Khoa Học Tự Nhiên University","Kinh Tế TP HCM University","Công Nghệ Thực Phẩm TP HCM University",
            "Ngoại Ngữ-Tin Học TP HCM","Nông Lâm University","Y Khoa Phạm Ngọc Thạch University","Bưu Chính Viễn Thông","Sài Gòn University",
            "Tôn Đức Thắng University","Kinh Tế-Luật University","Tài Chính-MarKeting University",
            "Luật TP HCM University","Giao Thông Vận Tải University","Y Dược TP HCM University","Kiến Trúc TP HCM University","Quốc Tế Hồng Bàng University",
            "Văn Lang University","Mở University","Mỹ Thuật University","Ngân Hàng University","Sư Phạm University"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        img = (ImageView) findViewById(R.id.img_user_see);
        logo = (ImageView) findViewById(R.id.logo_user_see);
        name =(TextView) findViewById(R.id.name_user_see);
        detail_achi = (TextView)findViewById(R.id.detail_achievements);
        detail_majors=(TextView)findViewById(R.id.detail_majors);
        detail_phone = (TextView)findViewById(R.id.detail_phone);
        detail_school = (TextView)findViewById(R.id.detail_school);
        edit();

    }

    private void edit() {
        int vitri;

        for(int i=0;i<DuLieu.id_user.length;i++)
        {
            if(DuLieu.id_user[i]==ID_Tourist.id)
            {
                Picasso.with(this).load(DuLieu.uri[i]).into(img);
                name.setText(DuLieu.name[i].toUpperCase());
                detail_school.setText(DuLieu.name_school[i].toUpperCase());
                detail_majors.setText(DuLieu.khoa[i].toUpperCase());
                detail_phone.setText("You Can't See");
                detail_achi.setText("");
                for(int j = 0; j<Logo_School.school_img.length; j++)
                {
                    if(arr[j].equals(DuLieu.name_school[i]))
                    {
                        Picasso.with(this).load(Logo_School.school_img[j]).into(logo);
                        break;
                    }

                }
                break;
            }
        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(User_detail.this, Menu_English.class);
        startActivity(intent);
        finish();

    }
}
