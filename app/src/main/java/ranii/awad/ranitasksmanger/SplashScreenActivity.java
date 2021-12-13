package ranii.awad.ranitasksmanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenActivity extends AppCompatActivity {
    private ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imgview=findViewById(R.id.imgView);
        Thread th=new Thread()
        {
            //thread 3
            public void run()
            {
                int i=3*1000;
                try{
                    sleep(i);
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    if (auth.getCurrentUser()!=null)
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    else
                        startActivity(new Intent(getApplicationContext(),SigninActivity.class));

                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        th.start();
    }
}