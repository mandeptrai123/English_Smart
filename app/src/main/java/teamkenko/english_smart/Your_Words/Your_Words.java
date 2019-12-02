package teamkenko.english_smart.Your_Words;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import teamkenko.english_smart.R;
import teamkenko.english_smart.menu.Adapter_MyWords;

public class Your_Words extends AppCompatActivity {
    private DatabaseReference firebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    ListView listView;
    Button but_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your__words);
        final ArrayList<Word> arrayList;
        listView = findViewById(R.id.listview_mywords);
        but_test = findViewById(R.id.test_button_yourword);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();



       Data_YourWord.arrayList = new ArrayList<>();
        firebaseDatabase.child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 Data_YourWord.arrayList.clear();
               for(DataSnapshot data: dataSnapshot.getChildren())
               {
                       Word w = data.getValue(Word.class);
                       Data_YourWord.arrayList.add(w);
               }
                Adapter_MyWords adapter_myWord = new Adapter_MyWords(getApplicationContext(),Data_YourWord.arrayList);
               listView.setAdapter(adapter_myWord);
               adapter_myWord.notifyDataSetChanged();


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        but_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
