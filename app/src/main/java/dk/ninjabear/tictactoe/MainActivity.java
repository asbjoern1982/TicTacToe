package dk.ninjabear.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "dk.ninjabear.tictactoe";
    public final static int PVP = 0;
    public final static int PVE = 1;
    public final static int EVP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startPVP(View view) {
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PVP);
        startActivity(intent);
    }

    public void startPVC(View view) {
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PVE);
        startActivity(intent);
    }

    public void startCVP(View view) {
        Intent intent = new Intent(this, BoardActivity.class);
        intent.putExtra(EXTRA_MESSAGE, EVP);
        startActivity(intent);
    }
}
