package twoup.tokoop4t.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button daftar;
    private EditText signupuser, signuppass, signupemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        daftar = findViewById(R.id.btn_daftar);
        signupuser = findViewById(R.id.etUSERd);
        signuppass = findViewById(R.id.etPASSd);
        signupemail = findViewById(R.id.etEmaild);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = signupuser.getText().toString().trim();
                String pass = signuppass.getText().toString().trim();
                String gmail = signupemail.getText().toString().trim();

                if (signupuser.getText().toString().trim().length() == 0) {
                    signupuser.setError("masukan username");
                } else if( signuppass.getText().toString().trim().length() == 0) {
                    signuppass.setError("masukan password");
                } else if (signupemail.getText().toString().trim().length() == 0) {
                    signupemail.setError("masukan email");
                }else {
                    auth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(SignUpActivity.this, "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                            } else {
                                Toast.makeText(SignUpActivity.this, "Daftar gagal" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });



    }

    public void masukSekarang(View view){
        startActivity(new Intent(SignUpActivity.this,SignInActivity.class));
    }
    public void back2(View view){
        onBackPressed();
    }
}