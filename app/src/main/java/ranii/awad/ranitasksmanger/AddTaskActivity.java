package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class AddTaskActivity extends AppCompatActivity {
    private TextInputEditText etTitle,etSubject;
    private Spinner spnimportant;
    private SeekBar skbNecessity;
    private ImageView imgvLogo;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etTitle=findViewById(R.id.etTitle);
        etSubject=findViewById(R.id.etSubject);
        spnimportant=findViewById(R.id.spnimportant);
        skbNecessity=findViewById(R.id.skbNecessity);
        imgvLogo=findViewById(R.id.imgvLogo);
        btnSave=findViewById(R.id.btnSave);
    }
}