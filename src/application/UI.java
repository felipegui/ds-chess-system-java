package application;

import chess.ChessPiece;

//UI: User Interface
public class UI {

	// Method responsible for printing the chess board
	public static void printBoard(ChessPiece[][] pieces) {

		// i: rows from 8 to 1
		for (int i = 0; i < pieces.length; i++) {

			System.out.print((8 - i) + " ");

			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e f g h");
	}

	// Print a single piece
	private static void printPiece(ChessPiece piece) {

		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
