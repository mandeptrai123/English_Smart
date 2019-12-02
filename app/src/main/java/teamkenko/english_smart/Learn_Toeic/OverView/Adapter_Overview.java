package teamkenko.english_smart.Learn_Toeic.OverView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import teamkenko.english_smart.R;

public class Adapter_Overview extends android.support.v4.view.PagerAdapter  {
    String texts[];
    Context context;
    int hinhanh[];


    public Adapter_Overview(Context context, int[] img, String[][] ans , int type) {




    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

         LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View view = layoutInflater.inflate(R.layout.item_introduce,container,false);



        ((ViewPager) container).addView(view);
        return view;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }

}

