package dk.ninjabear.tictactoe;

import java.util.ArrayList;

/**
 * Created by ninja on 10/7/16.
 */

public class ComputerPlayer {
    private int player;

    public ComputerPlayer(int player) {
        this.player = player;
    }

    public void takeTurn(Board board) {
        int[] move = randomMove(board);
        board.placeBrick(move[0], move[1], player);
    }

    private int[] randomMove(Board b) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (b.getTileAt(x, y) == Board.EMPTY)
                    moves.add(new int[]{x,y});
        if (moves.isEmpty())
            return null;
        return moves.get((int)(Math.random() * moves.size()));
    }
}
