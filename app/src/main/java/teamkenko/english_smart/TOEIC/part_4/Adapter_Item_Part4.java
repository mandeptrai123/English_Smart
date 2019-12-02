package teamkenko.english_smart.TOEIC.part_4;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import teamkenko.english_smart.R;

public class Adapter_Item_Part4  extends BaseExpandableListAdapter {
    private TextView text_ques;
    Context context;
    String [] ques ;

    public Adapter_Item_Part4(Context context, String[] ques) {
        this.context = context;
        this.ques = ques;
    }

    @Override
    public int getGroupCount() {
        return ques.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ques[childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_click_choose_p4,parent,false);
        text_ques = view.findViewById(R.id.item_question_part4_1);
        text_ques.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        text_ques.setText(Choosed_Part4.question1[groupPosition]);

        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_expend,parent,false);
        final TextView ans1 = view.findViewById(R.id.ans_choosed_4_1);
        final TextView ans2 = view.findViewById(R.id.ans_choosed_4_2);
        final TextView ans3 = view.findViewById(R.id.ans_choosed_4_3);
        final TextView ans4 = view.findViewById(R.id.ans_choosed_4_4);

        ans1.setText(Choosed_Part4.note_ans1[groupPosition][0]);
        ans2.setText(Choosed_Part4.note_ans1[groupPosition][1]);
        ans3.setText(Choosed_Part4.note_ans1[groupPosition][2]);
        ans4.setText(Choosed_Part4.note_ans1[groupPosition][3]);

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
