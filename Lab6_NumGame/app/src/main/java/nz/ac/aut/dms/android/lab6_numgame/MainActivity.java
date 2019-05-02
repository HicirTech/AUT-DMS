package nz.ac.aut.dms.android.lab6_numgame;

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
    public void btnPlayOnClick(View view) {
        startActivity(new Intent(this, GameActivity.class));
    }

}
