package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {
    private TextView tvText;
    private ToggleButton tglnBtn;
    private Button btnSignOut;
    private RadioGroup radGroup;
    private RadioButton radBtnDelete,radBtnCrossLine,radBtnMoveToEnd;
    private Switch swKeepHistory;
    private Button btnClearHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        tvText=findViewById(R.id.tvText);
        tglnBtn=findViewById(R.id.tglBtn);
        btnSignOut=findViewById(R.id.btnSignOut);
        radGroup=findViewById(R.id.radGroup);
        radBtnDelete=findViewById(R.id.radBtnDelete);
        radBtnCrossLine=findViewById(R.id.radBtnCrossLine);
        radBtnMoveToEnd=findViewById(R.id.radBtnMoveToEnd);
        swKeepHistory=findViewById(R.id.swKeepHistory);
        btnClearHistory=findViewById(R.id.btnClearHistory);
    }
}