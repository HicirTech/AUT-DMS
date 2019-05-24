package com.example.week6e2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity {
    private EditText userInput;
    private int answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        userInput = findViewById(R.id.inputNumber);
        Random random = new Random();
        this.answer = random.nextInt(100);
    }

    public void onSubmitButtonClick(View view){
        if(userInput.getText().toString().length()>0) {
            int input = Integer.parseInt(userInput.getText().toString());

            String hit = (input < this.answer) ?
                    "too low , try again" : (input > this.answer) ?
                    "too high , try again" : "correct";


            Toast.makeText(this.getApplicationContext(), "answer is " + this.answer + ", your input is " + input + ", you answer is " + hit, Toast.LENGTH_LONG).show();

            if (hit == "correct") {
                Intent passEndGame = new Intent(this, EndGame.class);
                startActivity(passEndGame);
                finish();
            }
        }else {
            Toast.makeText(this.getApplicationContext(), "YOU NEED TO INPUT A NUMBER",Toast.LENGTH_LONG).show();
        }
    }
}
