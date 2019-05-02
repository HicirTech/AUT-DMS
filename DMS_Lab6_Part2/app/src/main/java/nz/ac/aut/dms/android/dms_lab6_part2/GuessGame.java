package nz.ac.aut.dms.android.dms_lab6_part2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GuessGame extends Activity {

    EditText userInput;
    Button userGuessButton;
    int theAnswer;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.userInput =  findViewById(R.id.GuessInput);
        this.userGuessButton = findViewById(R.id.GuessButton);
        this.theAnswer = new Random().nextInt(99)+1;
//        if(this.userGuessButton!=null)
//        {
//            this.userGuessButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        }else{
//            Toast.makeText(this,"TOO HIGH",Toast.LENGTH_LONG).show();
//        }
    }


    public void userOnGuess(){

    }
    private boolean compairUserGuess(){
        try{
            String input = this.userInput.getText().toString();
            int numberInput = Integer.parseInt(input);
            if(numberInput>this.theAnswer){
                Toast.makeText(this,"TOO HIGH",Toast.LENGTH_LONG).show();
                return false;
            }else if(numberInput<this.theAnswer){
                Toast.makeText(this,"TOO LOW",Toast.LENGTH_LONG).show();
                return false;
            }else{
                Toast.makeText(this,"RIGHT ANSWER",Toast.LENGTH_LONG).show();
                return true;
            }
        }catch (NumberFormatException e){
            return false;
    }
}
}
