package com.broooapps.progressviewmanager;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.broooapps.progressmanager.main.ProgressManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressManager progressManager = ProgressManager.of(this);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        final ProgressBar progressBar2 = findViewById(R.id.progressBar2);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3);

        progressManager.addProgressView(progressBar);
        progressManager.addProgressView(progressBar2);
        progressManager.addProgressView(progressBar3);

        progressManager.hideAllProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressManager.showAllProgress();
                    }
                });
            }
        }, 4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressManager.hideProgress(progressBar2);
                    }
                });
            }
        }, 8000);
    }
}
