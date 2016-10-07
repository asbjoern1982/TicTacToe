package dk.ninjabear.tictactoe;

/**
 * Created by ninja on 10/7/16.
 */

public class Board {
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int O = 2;
    int[][] tiles;

    public Board() {
        tiles = new int[3][3];
    }

    public boolean placeBrick(int x, int y, int player) {
        if (tiles[x][y] != EMPTY)
            return false;
        tiles[x][y] = player;
        return true;
    }

    public int getTileAt(int x, int y) {
        return tiles[x][y];
    }

    public boolean equals(int[][] board) {
        for (int x  = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (tiles[x][y] != board[x][y])
                    return false;
        return true;
    }

    public int winnerFound() {
        // run through all lines for each player
        for (int p = 1; p <= 2; p++) {
            for (int x = 0; x < 3; x++) // vertical |
                if (tiles[x][0] == p && tiles[x][1] == p && tiles[x][2] == p)
                    return p;
            for (int y = 0; y < 3; y++) // horizontal -
                if (tiles[0][y] == p && tiles[1][y] == p && tiles[2][y] == p)
                    return p;
            if (tiles[0][0] == p && tiles[1][1] == p && tiles[2][2] == p)  // cross \
                return p;
            if (tiles[2][0] == p && tiles[1][1] == p && tiles[0][2] == p) // cross /
                return p;
        }
        // no winner found
        return 0;
    }

    public boolean emptyTilesLeft() {
        // test if there are any empty tiles left
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (tiles[x][y] == EMPTY)
                    return true;
        // else the board is filled
        return false;
    }
}
