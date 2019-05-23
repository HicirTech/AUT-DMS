package com.example.week6e2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view){
        Intent passToGameActivity = new Intent(this,GameActivity.class);
        startActivity(passToGameActivity);
        finish();
    }
}
