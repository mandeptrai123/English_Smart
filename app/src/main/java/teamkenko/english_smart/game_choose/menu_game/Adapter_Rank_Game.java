package teamkenko.english_smart.game_choose.menu_game;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.Logo_School;

public class Adapter_Rank_Game extends BaseAdapter {
    Context context;
    String name[];
    String id[];
    int score[];
    int top[];
    String truong[];
    String uri[];
    Rank_Game rank;

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
    public Adapter_Rank_Game(Context context,String name[],String id[],int score[],int top[], String truong[],String uri[],Rank_Game rank)
    {
        this.context = context;
        this.name = name;
        this.id = id;
        this.score = score;
        this.top = top;
        this.truong =truong;
        this.uri = uri;
        this.rank =rank;
    }

    @Override
    public int getCount() {
        if(name.length<=20)
        {
            return name.length;
        }else
        {
            return 20;
        }
    }

    @Override
    public Object getItem(int i) {
        return name[i];
    }

    @Override
    public long getItemId(int i) {
        if(name.length<=20)
        {
            return name.length;
        }else
        {
            return 20;
        }
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.adapter_rank,viewGroup,false);
        CircleImageView imageView = (CircleImageView) rowView.findViewById(R.id.img_rank);
        if (uri[position].isEmpty())
        {

        }else
        {
            Picasso.with(context).load(uri[position]).into(imageView);
        }
        // Goi Ham De Xem Thong Tin Khi Click Vao Avatar Tren BXH.
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    rank.User_detail(position);
            }
        });


        // Conntect View
        ImageView image_medal = (ImageView) rowView.findViewById(R.id.medal_rank);
        TextView name_rank = (TextView) rowView.findViewById(R.id.name_rank);
        TextView score_rank = (TextView) rowView.findViewById(R.id.score_rank);



        name_rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rank.User_detail(id[position]);
            }
        });
        score_rank.setText("Star: " + score[position]);
        ImageView img = (ImageView) rowView.findViewById(R.id.nameschool_rank);
        for(int i=0;i<arr.length;i++)
        {
            if(truong[position].equals(arr[i]))
            {
                Picasso.with(context).load(Logo_School.school_img[i]).into(img);
                break;
            }
        }



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
        if(name[position]==null)
        {
            name_rank.setText("Chưa Có");
            score_rank.setText(".......");
        }else {
            name_rank.setText(name[position]);
        }
        return rowView;


    }



}
