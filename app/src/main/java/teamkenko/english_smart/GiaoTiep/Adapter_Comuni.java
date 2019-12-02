package teamkenko.english_smart.GiaoTiep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import teamkenko.english_smart.R;


public class Adapter_Comuni extends BaseAdapter {
    Context context;
    int img[];
    String title[];

    public Adapter_Comuni(Context context, int[] img, String[] title) {
        this.context = context;
        this.img = img;
        this.title = title;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return img[position];
    }

    @Override
    public long getItemId(int position) {
        return img.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_giaotiep,parent,false);
        ImageView hinhanh = (ImageView) view.findViewById(R.id.img_communication);
        TextView title_text    =(TextView)view.findViewById(R.id.title_communication);
        hinhanh.setBackgroundResource(img[position]);
        title_text.setText(title[position]);
        return  view;
    }
}
