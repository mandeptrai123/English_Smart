package teamkenko.english_smart.Login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import es.dmoral.toasty.Toasty;
import teamkenko.english_smart.Loading.Loading;
import teamkenko.english_smart.R;

public class Login_Main extends AppCompatActivity {
    EditText edit_user,edit_pass;
    private FirebaseAuth mAuth;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // thiet lap hieu ung window.
        setupWindowAnimations();

        setContentView(R.layout.activity_login__main);




        edit_user = findViewById(R.id.edit_login_user);
        edit_pass = findViewById(R.id.edit_login_pass);
        mAuth = FirebaseAuth.getInstance();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);
    }
    public void sign_up(View view)
    {
        finish();
        startActivity(new Intent(Login_Main.this,Register_Main.class));
    }



    public void sign_in(View view)
    {
        findViewById(R.id.progressbar_login).setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(edit_user.getText().toString().trim(),edit_pass.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                findViewById(R.id.progressbar_login).setVisibility(View.INVISIBLE);
                if(task.isSuccessful())
                {
                    finish();
                    Intent intent = new Intent(Login_Main.this,Loading.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);

                }else
                {
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    edit_pass.requestFocus();
                    edit_user.requestFocus();
                    return;
                }
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null)
        {
            Toasty.info(getApplicationContext(),"WelCome to English Smart",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(Login_Main.this,Loading.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
}
