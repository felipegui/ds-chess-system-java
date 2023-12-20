package chess;

import boardgame.Board;

public class ChessMatch {

	// A chess game must have a board
	private Board board;
	
	// The class that ha to know the size of the board is the class ChessMatch
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
	// Return an array of chess pieces corresponding to ChessMatch
	public ChessPiece[][] getPieces() {
		ChessPiece[][] auxMatrix = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i = 0; i < board.getRows(); i++) {
			
			for (int j = 0; j < board.getColumns(); j++) {
				auxMatrix[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return auxMatrix;
	}
}
