package teamkenko.english_smart.Register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.ArrayList;

import teamkenko.english_smart.R;


public class Adapter_Career extends BaseAdapter {
    ArrayList<Career> arrayList;
    Context context;

    public Adapter_Career(ArrayList<Career> arrayList, Context context) {
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
         view = layoutInflater.inflate(R.layout.spinner_career,null);
        TextView textView =(TextView)view.findViewById(R.id.adapter_career);
        textView.setText(arrayList.get(i).carrer);
        return view;
    }
}
