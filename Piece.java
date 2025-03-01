import java.util.*;
public class Piece {
    protected Coordinate pair;
    protected ArrayList<Coordinate> possibleSquares;
    protected boolean isWhite;
    
    public Piece (int x, int y, boolean isWhite) {
        this.pair = new Coordinate(x, y);
        this.isWhite = isWhite;
    }
    
    public boolean move (int x, int y, Chessboard board) {
        if (!validMove(x, y, board)) {
            return false;
        }
        this.pair = new Coordinate(x, y);
        
        return true;
    }
    
    public Coordinate getCoords() {
        return this.pair;
    }
    
    public boolean getIsWhite() {
        return isWhite;
    }
    
    public boolean validMove (int newX, int newY, Chessboard board) {
        Coordinate proposedMove = new Coordinate(newX, newY);
        for (Coordinate possibleMove : possibleSquares) {
            if (proposedMove.equals(possibleMove)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isSameTeam (Piece comparison) {
        return isWhite == comparison.getIsWhite();
    }
}

class Coordinate {
    private int x;
    private int y;
    
    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX () {
        return x;
    }
    
    public int getY () {
        return y;
    }
    
    public boolean equals(Coordinate coords) {
        return (x == coords.getX()) && (y == coords.getY());
    }
}