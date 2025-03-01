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
        
        // straight up
        if (upValid && 
        !board[Chessboard.convert(originalX)][Chessboard.convert(originalY + 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX, originalY + 1));
        }
        
        // straight right
        if (rightValid &&
        !board[Chessboard.convert(originalX + 1)][Chessboard.convert(originalY)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX + 1, originalY));
        }
        
        // straight down
        if (downValid && 
        !board[Chessboard.convert(originalX)][Chessboard.convert(originalY - 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX, originalY - 1));
        }
        
        // straight left
        if (leftValid &&
        !board[Chessboard.convert(originalX - 1)][Chessboard.convert(originalY)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX - 1, originalY));
        }
        
        // up left
        if (leftValid && upValid &&
        !board[Chessboard.convert(originalX - 1)][Chessboard.convert(originalY + 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX - 1, originalY + 1));
        }
        
        // up right
        if (rightValid && upValid &&
        !board[Chessboard.convert(originalX + 1)][Chessboard.convert(originalY + 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX + 1, originalY + 1));
        }
        
        // down right
        if (rightValid && downValid &&
        !board[Chessboard.convert(originalX + 1)][Chessboard.convert(originalY - 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX + 1, originalY - 1));
        }
        
        // down left
        if (leftValid && downValid &&
        !board[Chessboard.convert(originalX - 1)][Chessboard.convert(originalY - 1)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX - 1, originalY - 1));
        }
        
        return temp;
    }
    
    private boolean checkMove (int newX, int newY, Chessboard board) {
        possibleSquares = possibleMove(board.getBoard());
        return validMove (newX, newY, board);
    }
}