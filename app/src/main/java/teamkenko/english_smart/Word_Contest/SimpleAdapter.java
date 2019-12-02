package teamkenko.english_smart.Word_Contest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import teamkenko.english_smart.R;

public class SimpleAdapter extends  RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder> {
    String names []={"Wildlife","Animal","Thunder","Science","Tower"};
    int    imgs []={};
    int   icons [] = {R.drawable.icon_goiy,R.drawable.icon_goiy,R.drawable.icon_goiy,R.drawable.icon_goiy,R.drawable.icon_goiy};

    public SimpleAdapter() {

    }


    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_words, viewGroup, false);


        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder simpleViewHolder, int i) {
       simpleViewHolder.img.setBackgroundResource(imgs[i]);
       simpleViewHolder.icon.setBackgroundResource(icons[i]);
       simpleViewHolder.name.setText(names[i]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView img;
        public TextView name;
        public ImageView icon;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
           img = (CircleImageView) itemView.findViewById(R.id.item_img_words);
           name = (TextView) itemView.findViewById(R.id.item_name_words);
           icon = (ImageView) itemView.findViewById(R.id.item_icon_words);
        }
    }
}

