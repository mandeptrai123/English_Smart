package teamkenko.english_smart.Login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebase_User_Current {
    public static FirebaseAuth mAuth;
    public static FirebaseUser firebaseUser = mAuth.getCurrentUser();
}
