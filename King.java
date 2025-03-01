import java.util.*;

public class King extends Piece {
    public King (int x, int y, boolean isWhite) {
        super(x, y, isWhite);
    }
    
    public boolean move (int x, int y, Chessboard board) {
        if (!checkMove(x, y, board)) {
            return false;
        }
        this.pair = new Coordinate(x, y);
        board.update();
        return true;
    }
    
    private ArrayList<Coordinate> possibleMove (Piece[][] board) {
        ArrayList<Coordinate> temp = new ArrayList<>();
        final int originalX = pair.getX();
        final int originalY = pair.getY();
        final boolean upValid = originalY < 8;
        final boolean downValid = originalY > 1;
        final boolean leftValid = originalX > 1;
        final boolean rightValid = originalX < 8;

        int newX, newY;
        
        // straight up
        if (upValid) {
            newX = originalX;
            newY = originalY + 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // straight right
        if (rightValid) {
            newX = originalX + 1;
            newY = originalY;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // straight down
        if (downValid) {
            newX = originalX;
            newY = originalY - 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // straight left
        if (leftValid) {
            newX = originalX - 1;
            newY = originalY;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // up left
        if (leftValid && upValid) {
            newX = originalX - 1;
            newY = originalY + 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // up right
        if (rightValid && upValid) {
            newX = originalX + 1;
            newY = originalY + 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // down right
        if (rightValid && downValid) {
            newX = originalX + 1;
            newY = originalY - 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        // down left
        if (leftValid && downValid) {
            newX = originalX - 1;
            newY = originalY - 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX, newY));
            }
        }
        
        return temp;
    }

    private boolean evalSpot (Piece[][] board, int x, int y) {
        if (board[Chessboard.convert(x)][Chessboard.convert(y)] != null) {
            return !this.isSameTeam(board[Chessboard.convert(x)][Chessboard.convert(y)]);
        } else {
            return true;
        }
    }

    private boolean checkMove (int newX, int newY, Chessboard board) {
        possibleSquares = possibleMove(board.getBoard());
        return validMove (newX, newY, board);
    }
}