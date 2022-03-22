package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

public class HistoryActivity extends AppCompatActivity {
     private SearchView svSearch;
     private ListView lvHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        svSearch=findViewById(R.id.svSearch);
        lvHistory=findViewById(R.id.lvHistory);



    }
}


