package dk.ninjabear.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BoardActivity extends AppCompatActivity {
    // fields
    private int gamemode;
    private Board board;
    private ComputerPlayer computerPlayer;
    // logical attributes
    private boolean turnX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        board = new Board();
        turnX = true;

        //get gametype
        Intent intent = getIntent();
        gamemode = intent.getIntExtra(MainActivity.EXTRA_MESSAGE, MainActivity.PVP);
        if (gamemode == MainActivity.PVE)
            computerPlayer = new ComputerPlayer(Board.O);
        else if (gamemode == MainActivity.EVP)
            computerPlayer = new ComputerPlayer(Board.X);

        //draw the playing area
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_board);
        // todo: draw the board
        //layout.addView(textView);


        // if the computer is X it should start
        if (gamemode == MainActivity.EVP) {
            computerTurn();
            turnX = !turnX;
        }
    }

    public void onPlay(View view) {
        //TODO: get move
        int x = 0;
        int y = 0;
        // place the players brick
        board.placeBrick(x, y,(turnX? Board.X : Board.O));

        // check if the game is over
        if (gameOver()) return;

        // if playing against a computer, it gets it turn, else it is the other players turn
        if (gamemode != MainActivity.PVP) {
            computerTurn();
            // check if the game is over
            if (gameOver()) return;
        } else
            turnX = !turnX;

    }

    private boolean gameOver() {
        int winner = board.winnerFound();

        if (winner == Board.X)
            return true;//TODO: show winner
        if (winner == Board.O)
            return true;//TODO: show winner

        if (!board.emptyTilesLeft())
            return true;//TODO:show draw
        return false;
    }

    private void computerTurn() {
        computerPlayer.takeTurn(board);
    }
}
