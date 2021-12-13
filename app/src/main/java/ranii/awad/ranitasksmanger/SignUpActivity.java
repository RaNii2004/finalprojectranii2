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

public class SignUpActivity extends AppCompatActivity {
    private TextInputEditText edittemail,edittpassword,etfirstName,etLastName,etPhoneNumber;
    private Button btnSignUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edittemail=findViewById(R.id.edittemail);
        edittpassword=findViewById(R.id.edittpassword);
        etfirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etPhoneNumber=findViewById(R.id.etPhoneNumber);
        btnSignUp=findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {
        boolean isOk=true;
        String email = edittemail.getText().toString();
        String password = edittpassword.getText().toString();
        String fname = etfirstName.getText().toString();
        String lname = etLastName.getText().toString();
        String phone = etPhoneNumber.getText().toString();
        String btn=btnSignUp.getText().toString();

        if (email.length() < 5 || email.indexOf('@') <= 0) {

            edittemail.setError("worng email syntax");
            isOk=false;
        }
        if (password.length()<8)
        {
            edittpassword.setError("at least 8 chars");
            isOk=false;
        }
        if (fname.length()==0||lname.length()==0)
        {
            etfirstName.setError("must enter firstname");
            etLastName.setError("must enter lastname");
            isOk=false;
        }
        if (phone.length()<10)
        {
            etPhoneNumber.setError("phone number eror");
            isOk=false;
        }
        if (isOk)//isOK==true
        {
            createAccount(email,password);
        }
    }

    private void createAccount(String email, String password)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance();
             //request                                       //wait for response
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            //response handler
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()==true)
                {
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else
                {
                    //dialog
                    Toast.makeText(getApplicationContext(), "eror create account"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    
                }
            }

        });
    }
}