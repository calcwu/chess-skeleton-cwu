package chess;


import java.util.Map;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import com.gs.collections.api.block.predicate.Predicate2;
import com.gs.collections.api.map.MutableMap;
import com.gs.collections.impl.factory.Maps;

/**
 * Class that represents the current state of the game.  Basically, what pieces are in which positions on the
 * board.
 */
public class GameState {

    /**
     * The current player
     */
    private Player currentPlayer = Player.White;

    /**
     * A map of board positions to pieces at that position
     */
    private Map<Position, Piece> positionToPieceMap;

    /**
     * Create the game state.
     */
    public GameState() {
        positionToPieceMap = Maps.mutable.of();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Call to initialize the game state into the starting positions
     */
    public void reset() {
        // White Pieces
        placePiece(new Rook(Player.White), Positions.at("a1"));
        placePiece(new Knight(Player.White), Positions.at("b1"));
        placePiece(new Bishop(Player.White), Positions.at("c1"));
        placePiece(new Queen(Player.White), Positions.at("d1"));
        placePiece(new King(Player.White), Positions.at("e1"));
        placePiece(new Bishop(Player.White), Positions.at("f1"));
        placePiece(new Knight(Player.White), Positions.at("g1"));
        placePiece(new Rook(Player.White), Positions.at("h1"));
        placePiece(new Pawn(Player.White), Positions.at("a2"));
        placePiece(new Pawn(Player.White), Positions.at("b2"));
        placePiece(new Pawn(Player.White), Positions.at("c2"));
        placePiece(new Pawn(Player.White), Positions.at("d2"));
        placePiece(new Pawn(Player.White), Positions.at("e2"));
        placePiece(new Pawn(Player.White), Positions.at("f2"));
        placePiece(new Pawn(Player.White), Positions.at("g2"));
        placePiece(new Pawn(Player.White), Positions.at("h2"));

        // Black Pieces
        placePiece(new Rook(Player.Black), Positions.at("a8"));
        placePiece(new Knight(Player.Black), Positions.at("b8"));
        placePiece(new Bishop(Player.Black), Positions.at("c8"));
        placePiece(new Queen(Player.Black), Positions.at("d8"));
        placePiece(new King(Player.Black), Positions.at("e8"));
        placePiece(new Bishop(Player.Black), Positions.at("f8"));
        placePiece(new Knight(Player.Black), Positions.at("g8"));
        placePiece(new Rook(Player.Black), Positions.at("h8"));
        placePiece(new Pawn(Player.Black), Positions.at("a7"));
        placePiece(new Pawn(Player.Black), Positions.at("b7"));
        placePiece(new Pawn(Player.Black), Positions.at("c7"));
        placePiece(new Pawn(Player.Black), Positions.at("d7"));
        placePiece(new Pawn(Player.Black), Positions.at("e7"));
        placePiece(new Pawn(Player.Black), Positions.at("f7"));
        placePiece(new Pawn(Player.Black), Positions.at("g7"));
        placePiece(new Pawn(Player.Black), Positions.at("h7"));
    }

    /**
     * @return all pieces of current player
     */
    public Map<Position, Piece> getCurrentPlayerPositions() {
        return getAllPositions(getCurrentPlayer());
    }

    /**
     * @param player
     * @return all pieces of the player
     */
    public Map<Position, Piece> getAllPositions(final Player player) {
        return ((MutableMap<Position, Piece>) positionToPieceMap).select(new Predicate2<Position, Piece>() {
            @Override
            public boolean accept(Position position, Piece piece) {
                return piece.getOwner().equals(player);
            }
        });
    }

    /**
     * Get the piece at the position specified by the String
     * @param colrow The string indication of position; i.e. "d5"
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(String colrow) {
        Position position = Positions.at(colrow);
        return getPieceAt(position);
    }

    /**
     * Get the piece at a given position on the board
     * @param position The position to inquire about.
     * @return The piece at that position, or null if it does not exist.
     */
    public Piece getPieceAt(Position position) {
        return positionToPieceMap.get(position);
    }

    /**
     * Check if a piece can move to this position
     * @param position
     * @return boolean
     */
    public boolean isValidMove(Position position) {
        return Positions.isValid(position) && getPieceAt(position) == null;
    }

    /**
     * check if a position is occupied by opponent
     * @param position
     * @return
     */
    public boolean isOccupiedByOpponent(Position position) {
        Piece piece = getPieceAt(position);
        return piece != null && !piece.getOwner().equals(getCurrentPlayer());
    }

    /**
     * isValid or isOccupiedByOpponent
     *
     * @param position
     * @return
     */
    public boolean isValidMoveOrOccupiedByOpponent(Position position) {
        return isValidMove(position) || isOccupiedByOpponent(position);
    }

    /**
     * Method to place a piece at a given position
     * @param piece The piece to place
     * @param position The position
     */
    public void placePiece(Piece piece, Position position) {
        positionToPieceMap.put(position, piece);
    }

    /**
     * Move from one place to the other.
     * @param piece
     * @param from
     * @param to
     */
    public void move(Piece piece, Position from, Position to) {
        positionToPieceMap.remove(from);
        placePiece(piece, to);
    }
}
