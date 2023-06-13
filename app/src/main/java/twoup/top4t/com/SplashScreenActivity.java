package twoup.top4t.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        ImageView splashScreenLogo = findViewById(R.id.topat);
        TextView splashScreen = findViewById(R.id.koperasi);
        splashScreenLogo.startAnimation(fadeInAnimation);
        splashScreen.startAnimation(fadeInAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent MoveToIdentitasActivity = new Intent(SplashScreenActivity.this,IntroActivity.class);
                startActivity(MoveToIdentitasActivity);
                finish();
            }
        }, 2500);

    }
}