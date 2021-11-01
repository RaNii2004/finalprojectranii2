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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    private FloatingActionButton fabtn;
    private SearchView svSearchTask;
    private ListView LstvAllTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabtn=findViewById(R.id.fabtn);
        svSearchTask=findViewById(R.id.svSearchTask);
        LstvAllTasks=findViewById(R.id.LstvAllTasks);
    }

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
            finish();//to close current activity
        }
        if(which==dialogInterface.BUTTON_NEGATIVE);
        {
            Toast.makeText(getApplicationContext(), "loging out canceled", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        }

    }
}