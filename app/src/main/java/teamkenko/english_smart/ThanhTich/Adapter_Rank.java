package teamkenko.english_smart.ThanhTich;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.R;

import static teamkenko.english_smart.Big_Data.DuLieu.name;


public class Adapter_Rank extends BaseAdapter {
    Context context;
    ArrayList<User> arrayList;
    Rank_Demo rank;
    public Adapter_Rank(Context context, ArrayList<User> arrayList, Rank_Demo rank)
    {
        this.context = context;
       this.arrayList= arrayList;
        this.rank =rank;
    }

    @Override
    public int getCount() {
     return  2;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {

            return arrayList.size();

    }

    @Override
    public View getView(final int position, final View view, ViewGroup viewGroup) {
        final View rowView;

            LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = layoutInflater.inflate(R.layout.adapter_rank,viewGroup,false);
            CircleImageView imageView = rowView.findViewById(R.id.img_rank);
            rowView.findViewById(R.id.loading_rank_item).setVisibility(View.VISIBLE);


                Picasso.with(context).load(arrayList.get(position).getPhoto()).into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        rowView.findViewById(R.id.loading_rank_item).setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });



            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rank.User_detail(position);
                }
            });


            // Conntect View
            ImageView image_medal =   rowView.findViewById(R.id.medal_rank);
            TextViewFonts name_rank = rowView.findViewById(R.id.name_rank);
            TextViewFonts score_rank = rowView.findViewById(R.id.score_rank);

            // Tuong Tu Khi Click Ten Se Xem Thong Tin Chi Tiet
            name_rank.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //   rank.User_detail(id[position]);
                }
            });
            score_rank.setText("Score: " + arrayList.get(position).getScore());
            CircleImageView img_school = rowView.findViewById(R.id.nameschool_rank);
            img_school.setImageResource(R.drawable.logo_iuh);



            switch (position) {
                case 0:
                    image_medal.setBackgroundResource(R.drawable.top1_medal);
                    break;
                case 1:
                    image_medal.setBackgroundResource(R.drawable.top2_medal);
                    break;
                case 2:
                    image_medal.setBackgroundResource(R.drawable.top3_medal);
                    break;
                default:
                    break;

            }

                name_rank.setText(arrayList.get(position).getName());
                score_rank.setText(arrayList.get(position).getScore());





        return rowView;


    }




}


