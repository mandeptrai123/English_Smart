package teamkenko.english_smart.Profile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import de.hdodenhof.circleimageview.CircleImageView;
import ec.dina.btefonts.EditTextFonts;
import ec.dina.btefonts.TextViewFonts;
import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.DuLieu;
import teamkenko.english_smart.Big_Data.Score_User;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.R;
import teamkenko.english_smart.menu.Menu_English;

public class USER_UPDATE extends AppCompatActivity {
    CircleImageView photo;
    TextViewFonts text_school_up,text_majors_up;
    EditTextFonts name;
    private FirebaseAuth mAuth;
    private DatabaseReference firebaseDatabase;
    private static final int CHOOSER_IMAGE=123;
    private  FirebaseUser firebaseUser;
    String ProImageUrl;
    Uri uriImage;
    String name_auth;
    private Dialog progressDialog;
    String school="";

    String choose_school[] = {"Công Nghiệp TP HCM University",
            "Bách Khoa Univerity",
            "Công Nghệ TP HCM University",
            "Công Nghệ Thông Tin University",
            "Sư Phạm Kỹ Thuật University","Khoa Học Tự Nhiên University","Kinh Tế TP HCM University","Công Nghệ Thực Phẩm TP HCM University",
            "Ngoại Ngữ-Tin Học TP HCM","Nông Lâm University","Y Khoa Phạm Ngọc Thạch University","Bưu Chính Viễn Thông","Sài Gòn University",
            "Tôn Đức Thắng University","Kinh Tế-Luật University","Tài Chính-MarKeting University",
            "Luật TP HCM University","Giao Thông Vận Tải University","Y Dược TP HCM University","Kiến Trúc TP HCM University","Quốc Tế Hồng Bàng University",
            "Văn Lang University","Mở University","Mỹ Thuật University","Ngân Hàng University","Sư Phạm University"
    };
    String choose_majors[] = {"Công Nghệ Thông Tin", "Cơ Điện-Cơ Khí", "Quản Trị", "Xây Dựng- Kiến Trúc",
            "Thiết Kế Thời Trang", "Kinh Doanh", "Marketing", "Ngành Mới"};
    LottieAnimationView loading_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__update);
        photo = (CircleImageView) findViewById(R.id.update_pro_img);
        loading_photo = findViewById(R.id.loading_update_photo);
        name =  findViewById(R.id.your_name);
        text_school_up = findViewById(R.id.text_get_school_update);
        text_majors_up = findViewById(R.id.text_get_majors_update);
        text_school_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener_button_school();
            }
        });



        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        if(firebaseUser.getPhotoUrl()!=null )
        {
            Picasso.with(getApplicationContext()).load(firebaseUser.getPhotoUrl().toString()).into(photo, new Callback() {
                @Override
                public void onSuccess() {
                    loading_photo.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError() {

                }
            });
        }
        if(firebaseUser.getPhotoUrl() != null)
        {
            ProImageUrl = firebaseUser.getPhotoUrl().toString();
        }



        if(firebaseUser.getDisplayName()!=null)
        {
           name.setText(firebaseUser.getDisplayName());
           name_auth = firebaseUser.getDisplayName();
        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, choose_majors);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, choose_school);
        arrayAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

//        spin_majors.setAdapter(arrayAdapter);
//        spin_school.setAdapter(arrayAdapter2);

    }
    public  void take_photo(View view)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Profile Image"),CHOOSER_IMAGE);
    }

    public void update_profile(View view) {
        if(!name.getText().equals("") && firebaseUser.getDisplayName()!=null)
        {
            name_auth = name.getText().toString();
        }
// update Firebase
         progressDialog = new Dialog(this);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.item_loading);
        progressDialog.setCancelable(false);
        //update Sever
        Data_User.uri=ProImageUrl;
        UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                .setDisplayName(name.getText().toString())
                .setPhotoUri(Uri.parse(ProImageUrl))
                .build();
        firebaseUser.updateProfile(profile)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            update_sever();
                            startActivity(new Intent(USER_UPDATE.this,Menu_English.class));
                            progressDialog.dismiss();
                            finish();
                        }
                    }
                });

    }
    private void listener_button_school()
    {
        progressDialog = new Dialog(this);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.logo_op);
        progressDialog.setCancelable(true);
        TextViewFonts text_op1 = progressDialog.findViewById(R.id.choose_op1);
        TextViewFonts text_op2 = progressDialog.findViewById(R.id.choose_op2);
        text_op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.dismiss();
            }
        });
        text_op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.dismiss();
            }
        });
    }

    private void update_sever() {

        firebaseDatabase.child("User").child(firebaseUser.getUid()).child("Name").setValue(name.getText().toString());
        firebaseDatabase.child("User").child(firebaseUser.getUid()).child("School_Name").setValue(school);
        firebaseDatabase.child("User").child(firebaseUser.getUid()).child("Photo").setValue(ProImageUrl);



        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CHOOSER_IMAGE && resultCode == RESULT_OK && data!=null && data.getData()!=null)
        {
            uriImage =data.getData();
            progressDialog = new Dialog(this);
            progressDialog.show();
            if (progressDialog.getWindow() != null) {
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            progressDialog.setContentView(R.layout.item_loading);
            progressDialog.setCancelable(false);
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(this.getContentResolver(),uriImage);
                photo.setImageBitmap(bitmap);
                final StorageReference storageReference = FirebaseStorage.getInstance().getReference("profilepics/image"+System.currentTimeMillis()+".jpg");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] dulieu = baos.toByteArray();

                UploadTask uploadTask = storageReference.putBytes(dulieu);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                       storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                ProImageUrl = uri.toString();
                                progressDialog.dismiss();

                            }
                        });

                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(USER_UPDATE.this,Menu_English.class));
    }
}
