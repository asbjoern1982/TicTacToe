package dk.ninjabear.tictactoe;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by ninja on 10/7/16.
 * Hack to make a completly square box for the game-board
 */

public class SquareLayout extends LinearLayout {
    public SquareLayout(Context context) {
        super(context);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
