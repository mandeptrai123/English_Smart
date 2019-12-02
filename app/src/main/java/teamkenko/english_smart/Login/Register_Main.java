package teamkenko.english_smart.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Big_Data.Data_User;
import teamkenko.english_smart.Big_Data.Sever;
import teamkenko.english_smart.Loading.Loading;
import teamkenko.english_smart.R;
import teamkenko.english_smart.ThanhTich.User;
import teamkenko.english_smart.Your_Words.Word;

public class Register_Main extends AppCompatActivity {
    EditText edit_user,edit_pass,edit_pass_cofirm;
    private DatabaseReference firebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__main);
        edit_user = findViewById(R.id.edit_register_user);
        edit_pass = findViewById(R.id.edit_register_pass);
        edit_pass_cofirm = findViewById(R.id.edit_register_pass_verify);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
    }
    public void  button_to_login(View view)
    {
        finish();
        startActivity(new Intent(Register_Main.this,Login_Main.class));
    }

    public void sign_up_register(View view)
    {

        findViewById(R.id.progressbar_register).setVisibility(View.VISIBLE);
        String email = edit_user.getText().toString().trim();
        String password = edit_pass.getText().toString().trim();
        String password_cofirm = edit_pass_cofirm.getText().toString().trim();

        if(email.isEmpty())
        {
            findViewById(R.id.progressbar_register).setVisibility(View.INVISIBLE);
            edit_user.setError("Email is required");
            edit_user.requestFocus();
            return;
        }
        if(!password.equals(password_cofirm))
        {
            findViewById(R.id.progressbar_register).setVisibility(View.INVISIBLE);
            edit_pass_cofirm.setError("Wrong");
            edit_user.requestFocus();
            edit_pass.requestFocus();
            edit_pass_cofirm.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            findViewById(R.id.progressbar_register).setVisibility(View.INVISIBLE);
            edit_user.setError("Please Enter a valid email");
            edit_user.requestFocus();
            return;
        }
        if(password.length()<6)
        {
            findViewById(R.id.progressbar_register).setVisibility(View.INVISIBLE);
            edit_pass.setError("Password too short");
            edit_pass_cofirm.requestFocus();
            edit_pass.requestFocus();
            return;

        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register_Main.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                findViewById(R.id.progressbar_register).setVisibility(View.INVISIBLE);
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(), "User Register Succesfull", Toast.LENGTH_LONG).show();
                    setup_account();
                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException)
                    {
                        Toast.makeText(getApplicationContext(),"You are ready registered, Login Please",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }

            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Erro", e + "");
            }
        });

    }
    private void setup_account() {
      // Set up account with Firebase. save in Firebase

        firebaseUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        ArrayList<Word> arrayList = new ArrayList<>();
        firebaseDatabase.child("User").child(firebaseUser.getUid()).setValue(new User(firebaseUser.getUid(),"Chưa Có","Your Name","0","Word","0","https://firebasestorage.googleapis.com/v0/b/smart-english-5b37c.appspot.com/o/profilepics%2Flogo.png?alt=media&token=f2e0e238-bba0-467c-9e35-d9188cc5a0f1"));


        startActivity(new Intent(Register_Main.this,Loading.class));
        finish();






    }

}
