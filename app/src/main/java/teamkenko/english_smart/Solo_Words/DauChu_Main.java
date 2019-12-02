package teamkenko.english_smart.Solo_Words;



import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.R;
import teamkenko.english_smart.Solo_Words.Account_User;
import teamkenko.english_smart.Solo_Words.Game;
import teamkenko.english_smart.Solo_Words.TranDau;
import teamkenko.english_smart.ThanhTich.Logo_School;

public class DauChu_Main extends Fragment {

    private DatabaseReference firebaseDatabase;
    public static String game = "";
    DatabaseReference firebaseDatabase_room, firebaseDatabase_game;
    private boolean have_room,clicked,start_game,endgame;
    ProgressDialog pd_timtran;
    Button but_start_game;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_user,container,false);
        // set true
        have_room = true;
        clicked = true;
        start_game = true;
        endgame = true;
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseDatabase_room = firebaseDatabase.child("Room");
        firebaseDatabase_game = firebaseDatabase.child("Game");

        but_start_game = view.findViewById(R.id.button_td);

        but_start_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true;
                firebaseDatabase_room.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(Data_User.uri==null)
                        {
                            Toasty.warning(getContext(),"Provide Your Photo",Toast.LENGTH_SHORT).show();
                            clicked=false;
                        }
                        if(have_room && clicked)
                        {

                            for (DataSnapshot post : dataSnapshot.getChildren()) {
                                if (post.getValue().equals("1")) {
                                    Toast.makeText(getContext(), "Tìm Thấy Trận", Toast.LENGTH_SHORT).show();
                                    have_room = false;
                                    clicked = false;
                                    Game.user = 2;
                                    Game.game = post.getKey();
                                    firebaseDatabase_room.child(post.getKey()).setValue("2");
                                    Account_User account = new Account_User(Data_User.name_user, Data_User.uri.toString());
                                    // set user2 for game
                                    firebaseDatabase_game.child(post.getKey()).child("user2").setValue(account);
                                    firebaseDatabase_game.child(post.getKey()).child("user2").child("photo2").setValue(Data_User.uri.toString());
                                    firebaseDatabase_game.child(post.getKey()).child("user2").child("Score").setValue(Data_User.score_user);
                                    DatabaseReference remove = FirebaseDatabase.getInstance().getReference("Room").child(post.getKey());
                                    remove.removeValue();
                                    firebaseDatabase_room.removeEventListener(this);
                                    startActivity(new Intent(getContext(), TranDau.class));
                                    break;
                                }
                            }
                        }
                        if (have_room && clicked && start_game ) {
                            clicked = false;
                            have_room = false;
                            Game.user = 1;
                            show();
                            game = firebaseDatabase_game.push().getKey();
                            // push id_game for Room.
                            firebaseDatabase_room.child(game).setValue("1");
                            Game.game = game;
                              Account_User account = new Account_User(Data_User.name_user,Data_User.uri.toString());
                            // set user1 for game.
                            firebaseDatabase_game.child(game).child("STT").setValue(0);
                            firebaseDatabase_game.child(game).child("Vitri").setValue(0);
                            firebaseDatabase_game.child(game).child("TD").setValue("");
                            firebaseDatabase_game.child(game).child("Question").setValue("");
                            firebaseDatabase_game.child(game).child("user1").setValue(account);
                            firebaseDatabase_game.child(game).child("UI").setValue("1");
                            firebaseDatabase_game.child(game).child("Turns").setValue("1");
                            firebaseDatabase_game.child(game).child("user1").child("photo1").setValue(Data_User.uri.toString());
                            firebaseDatabase_game.child(game).child("user1").child("Score").setValue(Data_User.score_user);
                            firebaseDatabase_game.child(game).addValueEventListener( new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    if(endgame) {
                                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                                            if (data.getKey().equals("user2")) {
                                                pd_timtran.dismiss();
                                                start_game = false;
                                                endgame = false;
                                                startActivity(new Intent(getContext(), TranDau.class));
                                                firebaseDatabase_game.removeEventListener(this);

                                            }
                                        }
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });



//        YoYo.with(Techniques.RubberBand)
//                .duration(1200)
//                .repeat(1)
//                .playOn(but_start_game);





        return view;
    }

    private void show() {
        pd_timtran = new ProgressDialog(getContext());
        pd_timtran.show();
        if (pd_timtran.getWindow() != null)
        {
            pd_timtran.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        pd_timtran.setContentView(R.layout.item_timtran);
        TextView text_timtran = (TextView) pd_timtran.findViewById(R.id.timtran_text);
        Button button = pd_timtran.findViewById(R.id.item_cancel_timtran);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dele_room = FirebaseDatabase.getInstance().getReference("Room").child(game);
                dele_room.removeValue();
                //
                DatabaseReference dele_user = FirebaseDatabase.getInstance().getReference("Game").child(game);
                dele_user.removeValue();
                //
                Toast.makeText(getContext(),"Huy Tim Tran",Toast.LENGTH_SHORT).show();
                //
                have_room = true;
                pd_timtran.dismiss();
            }
        });
        YoYo.with(Techniques.RubberBand)
                .duration(2000)
                .repeat(10)
                .playOn(text_timtran);
        pd_timtran.setCancelable(false);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
