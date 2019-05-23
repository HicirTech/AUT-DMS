package com.example.week6e2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EndGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);
    }

    public void onYesClick(View view){
        Toast.makeText(this.getApplicationContext(),"user click on yes button, game start again",Toast.LENGTH_LONG).show();
        Intent passStart = new Intent(this,MainActivity.class);
        startActivity(passStart);
        finish();
    }
    public void onNoClick(View view){
        Toast.makeText(this.getApplicationContext(),"user click on no button, game ended",Toast.LENGTH_LONG).show();
        finish();
    }
}
