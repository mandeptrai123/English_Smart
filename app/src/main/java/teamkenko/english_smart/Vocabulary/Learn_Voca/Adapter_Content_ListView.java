package teamkenko.english_smart.Vocabulary.Learn_Voca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.airbnb.lottie.LottieAnimationView;

import ec.dina.btefonts.TextViewFonts;
import teamkenko.english_smart.R;

public class Adapter_Content_ListView extends BaseAdapter {
    Context context;
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = layoutInflater.inflate(R.layout.item_detail_word,parent,false);
        LottieAnimationView mic = view.findViewById(R.id.micro_detail_voca);
        TextViewFonts name_words = view.findViewById(R.id.item_name_voca);
        TextViewFonts des_content= view.findViewById(R.id.content_des_voca);

        return view;
    }
}
