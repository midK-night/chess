import java.util.*;

public class Bishop extends Piece {
    public Bishop (int x, int y, boolean isWhite) {
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

        // up Right
        int i = 1;
        boolean isConsecutive = true;
        while (isConsecutive && originalX + i < 9 && originalY + i < 9) {
            int tempX = originalX + i;
            int tempY = originalY + i;

            if (board[Chessboard.convert(tempX)][Chessboard.convert(tempY)] == null) {
                temp.add(new Coordinate(tempX, tempY));
                i++;
            } else {
                if (!board[Chessboard.convert(tempX)][Chessboard.convert(tempY)].isSameTeam(this)) {
                    temp.add(new Coordinate(tempX, tempY));
                }
                isConsecutive = false;
            }
        }
        
        // up Left
        i = 1;
        isConsecutive = true;
        while (isConsecutive && originalX - i > 0 && originalY + i < 9) {
            int tempX = originalX - i;
            int tempY = originalY + i;

            if (board[Chessboard.convert(tempX)][Chessboard.convert(tempY)] == null) {
                temp.add(new Coordinate(tempX, tempY));
                i++;
            } else {
                if (!board[Chessboard.convert(tempX)][Chessboard.convert(tempY)].isSameTeam(this)) {
                    temp.add(new Coordinate(tempX, tempY));
                }
                isConsecutive = false;
            }
        }

        // down Left
        i = 1;
        isConsecutive = true;
        while (isConsecutive && originalX - i > 0 && originalY - i > 0) {
            int tempX = originalX - i;
            int tempY = originalY - i;

            if (board[Chessboard.convert(tempX)][Chessboard.convert(tempY)] == null) {
                temp.add(new Coordinate(tempX, tempY));
                i++;
            } else {
                if (!board[Chessboard.convert(tempX)][Chessboard.convert(tempY)].isSameTeam(this)) {
                    temp.add(new Coordinate(tempX, tempY));
                }
                isConsecutive = false;
            }
        }
        
        // down Right
        i = 1;
        isConsecutive = true;
        while (isConsecutive && originalX + i < 9 && originalY - i > 0) {
            int tempX = originalX + i;
            int tempY = originalY - i;

            if (board[Chessboard.convert(tempX)][Chessboard.convert(tempY)] == null) {
                temp.add(new Coordinate(tempX, tempY));
                i++;
            } else {
                if (!board[Chessboard.convert(tempX)][Chessboard.convert(tempY)].isSameTeam(this)) {
                    temp.add(new Coordinate(tempX, tempY));
                }
                isConsecutive = false;
            }
        }

        return temp;
    }

    private boolean checkMove (int newX, int newY, Chessboard board) {
        possibleSquares = possibleMove(board.getBoard());
        return validMove (newX, newY, board);
    }
}