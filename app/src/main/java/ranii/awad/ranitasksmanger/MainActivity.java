package ranii.awad.ranitasksmanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import raniawad.myapplication.MyData.MyTask;
import raniawad.myapplication.MyData.MyTaskAdapter;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private FloatingActionButton fabtn;
    private SearchView svSearchTask;
    private ListView LstvAllTasks;
    private MyTaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabtn=findViewById(R.id.fabtn);
        svSearchTask=findViewById(R.id.svSearchTask);
        LstvAllTasks=findViewById(R.id.LstvAllTasks);
        taskAdapter=new MyTaskAdapter(this,R.layout.task_item_layout);
        //read 3;set adapter to listview(connect the data to listview)
        LstvAllTasks.setAdapter(taskAdapter);

        fabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddTaskActivity.class));
            }
        });
    }
    //read 4:


    @Override
    protected void onResume() {
        super.onResume();

        readDataFromFireBase("");
    }
    //read 5:

    /**
     * read tasks from firebase and fill the adapter data structure
     *
     * @param s
     */

    private void readDataFromFireBase(String s)
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        String uid = FirebaseAuth.getInstance().getUid();//current user id
        reference.child("mytasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    // 1.build menu xml
    //2.add menu to current activity
    public boolean onCreateOptionsMenu(Menu menu)
    {
       getMenuInflater().inflate(R.menu.main_menu,menu);
         return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.itmsettings)
        {
            Intent i=new Intent(getApplicationContext(),SettingsActivity.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.itmhistory)
        {
            Intent i=new Intent(getApplicationContext(),HistoryActivity.class);
            startActivity(i);
        }
        if(item.getItemId()==R.id.itmsignout)
        {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Are You Sure");
            builder.setCancelable(true);
            builder.setPositiveButton("Yes",this);
            builder.setNegativeButton("No",this);
            AlertDialog dialog=builder.create();
            dialog.show();


        }
        return true;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if(which==dialogInterface.BUTTON_POSITIVE);
        {
            Toast.makeText(getApplicationContext(), "loging out", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();

            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.signOut();
            finish();//to close current activity
        }
        if(which==dialogInterface.BUTTON_NEGATIVE);
        {
            Toast.makeText(getApplicationContext(), "loging out canceled", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        }

    }

    private void readTasksFromFireBase(String s)
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        String uid=FirebaseAuth.getInstance().getUid();//current user id

        reference.child("mytasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                taskAdapter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    MyTask task=d.getValue(MyTask.class);
                    taskAdapter.add(task);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}