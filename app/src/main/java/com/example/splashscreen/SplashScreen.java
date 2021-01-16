package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    int progress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //remove title bar
         //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //remove notification bar
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progressbarid);

        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
               startapps();
            }
        });
        thread.start();
    }
    public void dowork(){
        for (progress = 10; progress<=100; progress=progress+5) {

            try {

                Thread.sleep(500);
                progressBar.setProgress(progress);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void startapps(){
        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
       startActivity(intent);
       finish();
    }
}
