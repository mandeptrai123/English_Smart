package teamkenko.english_smart.GiaoTiep;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.tbuonomo.creativeviewpager.CreativeViewPager;
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import de.hdodenhof.circleimageview.CircleImageView;
import teamkenko.english_smart.R;
import teamkenko.english_smart.menu.Menu_English;


public class Menu_GiaoTiep extends AppCompatActivity {
    CreativeViewPager tech;
    int colors[]={R.color.red,R.color.yellow,R.color.green,R.color.pink,R.color.violeet,R.color.orange,R.color.blue2,R.color.blue,R.color.grey,R.color.black};
   //  int sets[]={R.drawable.tt1,R.drawable.tt2,R.drawable.tt3,R.drawable.tt4,R.drawable.tt5,R.drawable.tt6,R.drawable.tt7,R.drawable.tt8,R.drawable.tt9,R.drawable.tt10};
    int imgs[]={R.drawable.img_com1,R.drawable.img_com2,R.drawable.img_com3,R.drawable.img_com4,R.drawable.img_com5,R.drawable.img_com1,R.drawable.img_com2,R.drawable.img_com3,R.drawable.img_com4,R.drawable.img_com5};
    String titles[]={"Confession of a recovering micromanager","Why are blue whales so enormous ?","Me Too is a movement, not a moment",
    "Why shound you read Kurt Vonnegut ?","The story of Marvel's first queer Latina superhero","Confession of a recovering micromanager","Why are blue whales so enormous ?","Me Too is a movement, not a moment",
            "Why shound you read Kurt Vonnegut ?","The story of Marvel's first queer Latina superhero"};
    String dess[]={
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !",
            "Today, I will show the the world for you. ! Today, I will show the the world for you. !"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__giao_tiep);
      tech = (CreativeViewPager) findViewById(R.id.creative_name);
      tech.setCreativeViewPagerAdapter(new CreativePagerAdapter() {
          @SuppressLint("ResourceAsColor")
          @NotNull
          @Override
          public View instantiateHeaderItem(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup, int i) {
              View view = layoutInflater.inflate(R.layout.item_content_creative,viewGroup,false);
              ImageView img = (ImageView) view.findViewById(R.id.img_content_creative);
              TextView  title = (TextView) view.findViewById(R.id.title_content_creative);
              TextView  des = (TextView) view.findViewById(R.id.des_content_creative);
              img.setBackgroundResource(imgs[i]);

              des.setText(dess[i]);
              title.setText(titles[i]);
              title.setTextColor(getResources().getColor(colors[i]));

              return view;
          }

          @NotNull
          @Override
          public View instantiateContentItem(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup, int i) {
              View view = layoutInflater.inflate(R.layout.item_header_creative,viewGroup,false);
              CircleImageView icon = view.findViewById(R.id.header_creative);
            //  icon.setImageResource(sets[i]);
              return view;
          }

          @Override
          public int getCount() {
              return imgs.length;
          }

          @Override
          public boolean isUpdatingBackgroundColor() {
              return false;
          }

          @Nullable
          @Override
          public Bitmap requestBitmapAtPosition(int i) {
              return null;
          }
      });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu_GiaoTiep.this, Menu_English.class);
        startActivity(intent);
        finish();

    }

}
