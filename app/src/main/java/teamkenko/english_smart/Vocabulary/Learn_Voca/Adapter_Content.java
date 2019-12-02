package teamkenko.english_smart.Vocabulary.Learn_Voca;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.airbnb.lottie.animation.content.Content;

import teamkenko.english_smart.R;

public class Adapter_Content extends PagerAdapter {
    Context context;
    String[] words;
    String[] audio;
    String[] des;

    public Adapter_Content(Context context, String[] words, String[] audio, String[] des) {
        this.context = context;
        this.words = words;
        this.audio = audio;
        this.des = des;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
     //   return super.instantiateItem(container, position);
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(position==0)
        {
            view = layoutInflater.inflate(R.layout.item_listview_cova, (ViewGroup) container, false);
            ListView list_words = view.findViewById(R.id.listviewlearnvoca);

        }else
        {
            view = layoutInflater.inflate(R.layout.item_content_voca, (ViewGroup) container, false);
        }
        ((ViewPager) container).addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
