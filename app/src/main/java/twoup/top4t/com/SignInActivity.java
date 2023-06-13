package twoup.top4t.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import twoup.top4t.com.ui.dashboard.DashboardFragment;
import twoup.top4t.com.ui.dashboard.DashboardViewModel;

public class SignInActivity extends AppCompatActivity {
    Button masuk;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_sign_in);
        masuk = (Button) findViewById(R.id.btn_masuk);
        user = (EditText) findViewById(R.id.etUSER);
        pass = (EditText) findViewById(R.id.etPASS);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getText().toString().trim().length() == 0) {
                    user.setError("masukan username");
                } else if( pass.getText().toString().trim().length() == 0) {
                    pass.setError("masukan password");
                } else {
                    startActivity(new Intent(SignInActivity.this,MainActivity.class));
                }
            }
        });
    }

    public void daftarSekarang(View view){
        startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
    }

    public void back1(View view){
        onBackPressed();
    }

}