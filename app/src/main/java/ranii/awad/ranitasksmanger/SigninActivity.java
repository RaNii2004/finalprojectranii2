package ranii.awad.ranitasksmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate()
    {
        boolean isOK=true;
        String email=etemail.getText().toString();
        String password=etpassword.getText().toString();
        String btnin=btnsignin.getText().toString();
        String btnup=btnsignup.getText().toString();
        if (email.length()==0)
        {
            etemail.setError("enter email");
            isOK=false;
        }
        if (password.length()<8)
        {
            etpassword.setError("at least 8 chars");
            isOK=false;
        }
        if (isOK)
        {
            Signingin(email,password);
        }


    }

    private void Signingin(String email, String password)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Sign in Approved", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else
                    Toast.makeText(getApplicationContext(), "Sign in eror"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}