package teamkenko.english_smart.Event;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import teamkenko.english_smart.R;

public class Event_Main extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_rate,container,false);
//            ListView list_event = (ListView) view.findViewById(R.id.list_event);
//            ProgressDialog progressDialog = new ProgressDialog(getContext());
//            progressDialog.show();
//            if (progressDialog.getWindow() != null) {
//                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            }
//            progressDialog.setContentView(R.layout.item_rate);

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
