package twoup.top4t.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    Button daftar;
    EditText usern, passw, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_sign_up);
        daftar = (Button) findViewById(R.id.btn_daftar);
        usern = (EditText) findViewById(R.id.etUSERd);
        passw = (EditText) findViewById(R.id.etPASSd);
        email = (EditText) findViewById(R.id.etEmaild);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usern.getText().toString().trim().length() == 0) {
                    usern.setError("masukan username");
                } else if( passw.getText().toString().trim().length() == 0) {
                    passw.setError("masukan password");
                } else if (email.getText().toString().trim().length() == 0) {
                    email.setError("masukan email");
                }else {
                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
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