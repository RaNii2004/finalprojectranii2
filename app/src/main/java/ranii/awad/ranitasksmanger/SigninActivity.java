package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SigninActivity extends AppCompatActivity {
    private TextInputEditText etemail,etpassword;
    private Button btnsignin,btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        etemail=findViewById(R.id.edtEmail);
        etpassword=findViewById(R.id.etPassword);
        btnsignin=findViewById(R.id.btnSignin);
        btnsignup=findViewById(R.id.btnSignUp);
    }
}