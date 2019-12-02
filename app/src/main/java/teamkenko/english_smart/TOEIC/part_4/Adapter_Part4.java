package teamkenko.english_smart.TOEIC.part_4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;

import teamkenko.english_smart.R;

public class Adapter_Part4 extends PagerAdapter{
    Context context;
    int type;
    int pos;
    String[] texts={"How Are U ?","What Yours Name ?","What Are U Doing ?"};
    public Adapter_Part4(Context context, int type) {
        this.context = context;
        this.type = type;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.expandable_listview_p4,container,false);
        ExpandableListView listView = view.findViewById(R.id.expand_listview_p4);
        Adapter_Item_Part4 adapter_item_part4 = new Adapter_Item_Part4(context,texts);
        listView.setAdapter(adapter_item_part4);
        listView.deferNotifyDataSetChanged();

        ((ViewPager) container).addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
