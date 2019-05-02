package nz.ac.aut.dms.android.lab6_numgame;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nz.ac.aut.dms.android.lab6_numgame.R;

public class GameActivity extends Activity {
    // Declaring class level variables
    private Button btnLeft, btnRight;
    private TextView scoresText, messageText;
    private int scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        btnLeft = (Button)findViewById(R.id.leftButton);
        btnRight = (Button) findViewById(R.id.rightButton);
        scoresText = (TextView) findViewById(R.id.textScores);
        messageText = (TextView) findViewById(R.id.textMessage);
        scores = 0;
        generateNumbers();
    }

    private boolean isLeftNumberBigger(){
        int leftNumber = Integer.parseInt(String.valueOf(btnLeft.getText()));
        int rightNumber = Integer.parseInt(String.valueOf(btnRight.getText()));
        if (leftNumber > rightNumber)
            return true;
        else
            return false;
    }

    private boolean isRightNumberBigger(){
        int leftNumber = Integer.parseInt(String.valueOf(btnLeft.getText()));
        int rightNumber = Integer.parseInt(String.valueOf(btnRight.getText()));
        if (leftNumber < rightNumber)
            return true;
        else
            return false;
    }

    private void generateNumbers(){
        int leftNumber = (int) (Math.random()*1000);
        int rightNumber = (int) (Math.random()*1000);
        while(leftNumber == rightNumber){
            leftNumber = (int) (Math.random()*1000);
            rightNumber = (int) (Math.random()*1000);
        }
        btnLeft.setText(String.valueOf(leftNumber));
        btnRight.setText(String.valueOf(rightNumber));
    }

    public void rightButtonClicked(View view) {
        if(isRightNumberBigger()){
            scores += 5;
            messageText.setText("Great Work");
            messageText.setTextColor(android.graphics.Color.BLUE);
        }
        else{
            scores -= 5;
            messageText.setText("Wrong Answer! concentrate");
            messageText.setTextColor(android.graphics.Color.RED);
        }
        scoresText.setText("Scores: " + scores);
        generateNumbers();
    }

    public void leftButtonClicked(View view) {
        if(isLeftNumberBigger()){
            scores += 5;
            messageText.setText("Great Work");
            messageText.setTextColor(android.graphics.Color.BLUE);
        }
        else{
            scores -= 5;
            messageText.setText("Wrong Answer! concentrate");
            messageText.setTextColor(android.graphics.Color.RED);
        }
        scoresText.setText("Scores: " + scores);
        generateNumbers();
    }
}
