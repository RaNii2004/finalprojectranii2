package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

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
    }
}