package nz.ac.aut.dms.android.dms_lab6_part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startButtonOnClick(View view){
        System.out.println("[APP LOG: the game start button has been pushed]");
        startActivity(new Intent(this,GuessGame.class));
    }
}
