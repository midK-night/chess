import java.util.*;

public class Rook extends Piece {
    public Rook (int x, int y, boolean isWhite) {
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
        
        // vert up
        int upwardsIterator = originalY + 1;
        while (upwardsIterator < 9 && 
        board[Chessboard.convert(originalX)][Chessboard.convert(upwardsIterator)] == null)
        {
            temp.add(new Coordinate(originalX, upwardsIterator));
            upwardsIterator++;
        }
        //if stopped due to piece, add that piece
        if (upwardsIterator < 9 && 
        !board[Chessboard.convert(originalX)][Chessboard.convert(upwardsIterator)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX, upwardsIterator));
        }
        
        // vert down
        int downwardsIterator = originalY - 1;
        while (downwardsIterator > 0 && 
        board[Chessboard.convert(originalX)][Chessboard.convert(downwardsIterator)] == null)
        {
            temp.add(new Coordinate(originalX, downwardsIterator));
            downwardsIterator--;
        }
        //if stopped due to piece, add that piece
        if (downwardsIterator > 0 && 
        !board[Chessboard.convert(originalX)][Chessboard.convert(downwardsIterator)].isSameTeam(this)) {
            temp.add(new Coordinate(originalX, downwardsIterator));
        }
        
        // right
        int rightIterator = originalX + 1;
        while (rightIterator < 9 && 
        board[Chessboard.convert(rightIterator)][Chessboard.convert(originalY)] == null)
        {
            temp.add(new Coordinate(rightIterator, originalY));
            upwardsIterator++;
        }
        //if stopped due to piece, add that piece
        if (rightIterator < 9 && 
        !board[Chessboard.convert(rightIterator)][Chessboard.convert(originalY)].isSameTeam(this)) {
            temp.add(new Coordinate(rightIterator, originalY));
        }

        // left
        int leftIterator = originalX - 1;
        while (leftIterator > 0 && 
        board[Chessboard.convert(leftIterator)][Chessboard.convert(originalY)] == null)
        {
            temp.add(new Coordinate(leftIterator, originalY));
            leftIterator--;
        }
        //if stopped due to piece, add that piece
        if (leftIterator > 0 && 
        !board[Chessboard.convert(leftIterator)][Chessboard.convert(originalY)].isSameTeam(this)) {
            temp.add(new Coordinate(leftIterator, originalY));
        }
        
        return temp;
    }
    
    private boolean checkMove (int newX, int newY, Chessboard board) {
        possibleSquares = possibleMove(board.getBoard());
        return validMove (newX, newY, board);
    }
}