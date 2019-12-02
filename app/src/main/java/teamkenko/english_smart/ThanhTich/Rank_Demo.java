package teamkenko.english_smart.ThanhTich;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import de.hdodenhof.circleimageview.CircleImageView;
import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.Profile.User_detail;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Your_Words.Data_YourWord;
import teamkenko.english_smart.Your_Words.Word;

public class Rank_Demo extends Fragment {
    ListView listView;
    Adapter_Rank adapter;
   TextViewFonts text_consider;
    String temp ;
    String temp_2 ;
    String temp_3;
    String temp_4;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference firebaseDatabase;
    CardView cardView;
    ArrayList<User> arrayList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        View view;
        view = inflater.inflate(R.layout.activity_rank, container, false);


            listView = view.findViewById(R.id.list_rank);
            text_consider = view.findViewById(R.id.rank_consider);
            cardView = view.findViewById(R.id.title_rank);
            mAuth = FirebaseAuth.getInstance();
            firebaseUser = mAuth.getCurrentUser();

            firebaseDatabase = FirebaseDatabase.getInstance().getReference();
            //            for(int i=0;i<DuLieu.name.length;i++)
//            {
//                if(firebaseUser.getUid().equals(DuLieu.id_user[i]))
//                {
//                    Picasso.with(getContext()).load(DuLieu.uri[i]).resize(90, 90).centerCrop().into(your_photo);
//                }
//            }
            //



            firebaseDatabase.child("User").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      arrayList.clear();
                    for(DataSnapshot data: dataSnapshot.getChildren())
                    {
                        User user = data.getValue(User.class);
                        arrayList.add(user);
                        Toast.makeText(getContext(),user.getID(),Toast.LENGTH_SHORT).show();
                    }
                    if(arrayList.size() !=0)
                    {
                        adapter = new Adapter_Rank(getContext(),arrayList,Rank_Demo.this);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            // Sap xep giam? dan
            sortDESC();



         if (Check_Connection.haveNetworkConnection(getContext())) {
             for (int i = 0; i < arrayList.size(); i++) {
                 if (firebaseUser.getUid().equals(arrayList.get(i).getID())) {
                      int hang = i+1;
                       text_consider.setText("Thứ Hạng Hiện Tại: "+hang);
                 }
             }
         }

//            else
//        {
//           view = inflater.inflate(R.layout.item_norifi_erro, container, false);
//       }

        return view;
    }

    private void sortDESC() {

//            temp = Data_Users.arrayList.get(0).getScore();
//            temp_2 = String.valueOf(Integer.parseInt(Data_Users.arrayList.get(0).getName()));
//            temp_3 = String.valueOf(Integer.parseInt(Data_Users.arrayList.get(0).getSchool()));
//            temp_4 = String.valueOf(Integer.parseInt(Data_Users.arrayList.get(0).getPhoto()));
            // sort algorithm
            for (int i = 0 ; i < arrayList.size() - 1; i++) {
                for (int j = i + 1; j < arrayList.size(); j++) {
                    int k = Integer.parseInt(arrayList.get(i).getScore());
                    if (Integer.parseInt(arrayList.get(i).getScore()) <= Integer.parseInt(arrayList.get(j).getScore())) {

                        temp = arrayList.get(j).getScore();
                        arrayList.get(j).getScore().equals(arrayList.get(i).getScore());
                        arrayList.get(i).getScore().equals(temp);


                        temp_2=arrayList.get(j).getName();
                        arrayList.get(j).getName().equals(arrayList.get(i).getName());
                        arrayList.get(i).getName().equals(temp_2);

                        temp_3=arrayList.get(j).getSchool();
                        arrayList.get(j).getSchool().equals(arrayList.get(i).getSchool());
                        arrayList.get(i).getSchool().equals(temp_3);


                        temp_4=arrayList.get(j).getPhoto();
                        arrayList.get(j).getPhoto().equals(arrayList.get(i).getPhoto());
                        arrayList.get(i).getPhoto().equals(temp_4);

                    }
                }

        }

    }

    public void User_detail(int id)
    {
        ID_Tourist.id =DuLieu.id_user[id];
        Intent intent = new Intent(getContext(), User_detail.class);
        startActivity(intent);


    }
}
