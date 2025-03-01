import java.util.*;

public class Pawn extends Piece {
    private boolean hasMoved;
    
    public Pawn (int x, int y, boolean isWhite) {
        super(x, y, isWhite);
        hasMoved = false;
    }
    
    public boolean move (int x, int y, Chessboard board) {
        if (!checkMove(x, y, board)) {
            return false;
        }
        this.pair = new Coordinate(x, y);
        board.update();
        hasMoved = true;
        return true;
    }

    private ArrayList<Coordinate> possibleMove (Piece[][] board) {
        ArrayList<Coordinate> temp = new ArrayList<>();

        int forwards = 0;
        if (isWhite) {
            forwards = 1; 
        } else {
            forwards = -1;
        }
        
        // first move
        if (!hasMoved && board[Chessboard.convert(pair.getX())][Chessboard.convert(pair.getY() + (forwards * 2))] == null) {
            temp.add(new Coordinate(pair.getX(), pair.getY() + (forwards * 2)));
        }

        // checks straight ahead
        if (board[Chessboard.convert(pair.getX())][Chessboard.convert(pair.getY() + forwards)] == null)
        {
            temp.add(new Coordinate(pair.getX(), pair.getY() + forwards));
        }

        // checks left front - if not out of bounds & theres a piece
        if (pair.getX() > 1 && 
        board[Chessboard.convert(pair.getX() - 1)][Chessboard.convert(pair.getY() + forwards)] != null) {
            if (!board[Chessboard.convert(pair.getX() - 1)][Chessboard.convert(pair.getY() + forwards)].isSameTeam(this))
            {
                temp.add(new Coordinate(pair.getX() - 1, pair.getY() + forwards));
            }
        }
        // checks right front - if not out of bounds & theres a piece
        if (pair.getX() < 8 && 
        board[Chessboard.convert(pair.getX() + 1)][Chessboard.convert(pair.getY() + forwards)] != null) {
            if (!board[Chessboard.convert(pair.getX() + 1)][Chessboard.convert(pair.getY() + forwards)].isSameTeam(this))
            {
                temp.add(new Coordinate(pair.getX() + 1, pair.getY() + forwards));
            }
        }
        return temp;
    }

    private boolean checkMove (int newX, int newY, Chessboard board) {
        possibleSquares = possibleMove(board.getBoard());
        return validMove(newX, newY, board);
    }
}