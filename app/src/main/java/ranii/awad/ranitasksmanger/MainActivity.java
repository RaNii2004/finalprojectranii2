package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
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
}