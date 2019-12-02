package teamkenko.english_smart.TOEIC;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import teamkenko.english_smart.R;

public class Adapter_Pager extends PagerAdapter {

    Context context;
    int img[];
    String text[];

    public Adapter_Pager(Context context, int[] img, String[] text) {
        this.context = context;
        this.img = img;
        this.text = text;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

         return view == ((RelativeLayout) o);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_reading,container,false);
        ImageView hinhanh = (ImageView) view.findViewById(R.id.img_reading_toeic);
        TextView  noidung = (TextView)  view.findViewById(R.id.des_reading_toeic);
        final Button    but_open = (Button) view.findViewById(R.id.open_rect);
        final RelativeLayout rect_answer = (RelativeLayout) view.findViewById(R.id.rect_answer);
        rect_answer.setY(1000f);
        but_open.setTag("Open");
        but_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(but_open.getTag().equals("Open"))
                {
                //    but_open.setBackgroundResource(R.drawable.close_s);
                    but_open.setTag("Close");
                    ViewCompat.animate(rect_answer).translationY(0f).setDuration(500).start();
                }else
                {
                    ViewCompat.animate(rect_answer).translationY(1000f).setDuration(500).start();
                    but_open.setTag("Open");
                    //but_open.setBackgroundResource(R.drawable.open_s);
                }
            }
        });



        hinhanh.setImageResource(img[position]);
        noidung.setText(text[position]);



        ((ViewPager) container).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
