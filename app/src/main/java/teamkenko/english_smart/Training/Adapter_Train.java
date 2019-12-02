package teamkenko.english_smart.Training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import de.hdodenhof.circleimageview.CircleImageView;
import teamkenko.english_smart.R;

public class Adapter_Train extends BaseAdapter {
    Context context;
    int img[];
    String article[];
    Training_OverView train;

    public Adapter_Train(Context context, int[] img, String[] article, Training_OverView train) {
        this.context = context;
        this.img = img;
        this.article = article;
        this.train = train;
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.adapter_training,parent,false);
        CircleImageView photo = (CircleImageView)view.findViewById(R.id.sample_img);
        TextView        tex   = (TextView)view.findViewById(R.id.sample_text);
        photo.setImageResource(img[position]);
        tex.setText(article[position]);
        return view;
    }
}
