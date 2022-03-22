package ranii.awad.ranitasksmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import raniawad.myapplication.MyData.MyTask;

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


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }

            private void validate()
            {
                boolean isOk=true;
                String title=etTitle.getText().toString();
                String subject=etSubject.getText().toString();
                String btn=btnSave.getText().toString();
                int progress=skbNecessity.getProgress();
                //String importance=spnimportant.getSelectedItem().toString();
                if (title.length()<4)
                {
                    etTitle.setError("title eror");
                    isOk=false;
                }
                if (subject.length()==0)
                {
                    etSubject.setError("enter a subject");
                    isOk=false;
                }
                if (isOk)
                {
                    MyTask  myTask=new MyTask();
                    myTask.setTitle(title);
                    myTask.setSubject(subject);


                    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    myTask.setOwmer(uid);


                    FirebaseDatabase db= FirebaseDatabase.getInstance();
                    DatabaseReference reference= db.getReference();
                    String key=reference.child(("mytasks")).push().getKey();
                    myTask.setKey(key);

                    reference.child("mytasks").child(key).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(), "add Successful", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(), "add not Successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }




            }
        });
    }
}