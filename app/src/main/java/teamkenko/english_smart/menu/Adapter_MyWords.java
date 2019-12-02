package teamkenko.english_smart.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Your_Words.Word;

public class Adapter_MyWords extends BaseAdapter {
    Context context;
    ArrayList<Word> arrayList;


    public Adapter_MyWords(Context context, ArrayList<Word> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.item_myword,parent,false);
        TextViewFonts name = v.findViewById(R.id.name_item_myword);
        name.setText(arrayList.get(position).getVoca().toUpperCase());

        return v;
    }
}
