package twoup.tokoop4t.com;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.gbuttons.GoogleSignInButton;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private Button masuk;
    private EditText signinuser, signinpass;
    private FirebaseAuth auth;

    SignInClient oneTapClient;
    BeginSignInRequest signUpRequest;
    private static final int REQ_ONE_TAP = 2;  // Can be any integer unique to the Activity.
    private boolean showOneTapUI = true;
    GoogleSignInButton googleBtn;
    TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_sign_in);

        auth = FirebaseAuth.getInstance();
        masuk = (Button) findViewById(R.id.btn_masuk);
        signinuser = (EditText) findViewById(R.id.etUSER);
        signinpass = (EditText) findViewById(R.id.etPASS);
        forgotPassword = (TextView) findViewById(R.id.forgot_password);


        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = signinuser.getText().toString();
                String pass = signinpass.getText().toString();

                if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!pass.isEmpty()) {
                        auth.signInWithEmailAndPassword(email, pass)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(SignInActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignInActivity.this,MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(SignInActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    } else {
                        signinpass.setError("Silahkan isi password");
                    }
                } else if(email.isEmpty()){
                    signinuser.setError("Silahkan isi email");
                } else {
                    signinuser.setError("Email salah");
                }

            }
        });

        googleBtn = findViewById(R.id.googleBtn);
        oneTapClient = Identity.getSignInClient(this);
        signUpRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        // Your server's client ID, not your Android client ID.
                        .setServerClientId(getString(R.string.web_client_id))
                        // Show all accounts on the device.
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();

        ActivityResultLauncher<IntentSenderRequest> activityResultLauncher1 =
                registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==Activity.RESULT_OK){
                            Intent data = result.getData();
                            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                            try {
                                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(result.getData());
                                String idToken = credential.getGoogleIdToken();
                                if (idToken !=  null) {
                                    String email = credential.getId();
                                    Toast.makeText(getApplicationContext(), "Berhasil masuk dengan email: "+email, Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }
                            } catch (ApiException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            googleBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    oneTapClient.beginSignIn(signUpRequest)
                            .addOnSuccessListener(SignInActivity.this, new OnSuccessListener<BeginSignInResult>() {
                                @Override
                                public void onSuccess(BeginSignInResult result) {
                                    IntentSenderRequest intentSenderRequest =
                                            new IntentSenderRequest.Builder(result.getPendingIntent().getIntentSender()).build();
                                    activityResultLauncher1.launch(intentSenderRequest);
                                }
                            })
                            .addOnFailureListener(SignInActivity.this, new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    // No Google Accounts found. Just continue presenting the signed-out UI.
                                    Log.d("TAG" , e.getLocalizedMessage());
                                }
                            });
                }
            });

            forgotPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignInActivity.this);
                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_forgot, null);
                    EditText emailBox = dialogView.findViewById(R.id.emailBoxFP);

                    builder.setView(dialogView);
                    AlertDialog dialog = builder.create();

                    dialogView.findViewById(R.id.btnResetFP).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String userEmail = emailBox.getText().toString();

                            if (TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                                Toast.makeText(SignInActivity.this, "Masukkan email yang terdaftar", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(SignInActivity.this, "Cek email", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }else {
                                        Toast.makeText(SignInActivity.this, "Ada yang salah, silahkan masukkan alamat email yang benar", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    });
                    dialogView.findViewById(R.id.btnCancelFP).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    if (dialog.getWindow() != null){
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    }
                    dialog.show();
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