import java.util.*;

public class Knight extends Piece {
    public Knight (int x, int y, boolean isWhite) {
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
        final boolean farUpValid = originalY < 7;
        final boolean closeUpValid = originalY < 8;
        final boolean farDownValid = originalY > 2;
        final boolean closeDownValid = originalY > 1;
        final boolean farLeftValid = originalX > 2;
        final boolean closeLeftValid = originalX > 1;
        final boolean farRightValid = originalX < 7;
        final boolean closeRightValid = originalX < 8;

        int newX, newY;
        
        // up left: -1, +2
        if (farUpValid && closeLeftValid) {
            newX = originalX - 1;
            newY = originalY + 2;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // up right: +1, +2
        if (farUpValid && closeRightValid) {
            newX = originalX + 1;
            newY = originalY + 2;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // right up: +2, +1
        if (farRightValid && closeUpValid) {
            newX = originalX + 2;
            newY = originalY + 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // right down: +2, -1
        if (farRightValid && closeDownValid) {
            newX = originalX + 2;
            newY = originalY - 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // down left: -1, -2
        if (farDownValid && closeLeftValid) {
            newX = originalX - 1;
            newY = originalY - 2;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // down right: +1, -2
        if (farDownValid && closeRightValid) {
            newX = originalX + 1;
            newY = originalY - 2;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }

        // left up: -2, +1
        if (farLeftValid && closeUpValid) {
            newX = originalX - 2;
            newY = originalY + 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
            }
        }
        
        // left down: -2, -1
        if (farLeftValid && closeDownValid) {
            newX = originalX - 2;
            newY = originalY - 1;

            if (evalSpot(board, newX, newY)) {
                temp.add(new Coordinate(newX,newY));
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