package teamkenko.english_smart.Register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;

import teamkenko.english_smart.R;


public class Adapter_School  extends BaseAdapter{
    ArrayList<School> arrayList;
    Context context;

    public Adapter_School(ArrayList<School> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.spinner_school,null);
        ImageView logo =(ImageView)view.findViewById(R.id.adapter_school);
        return  view;
    }
}
