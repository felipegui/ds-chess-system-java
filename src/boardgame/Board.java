package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: There must be at least 1 row and 1 column!");
		}

		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("This position does not exist on the board!");
		}
		
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position does not exist on the board!");
		}
		
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		// From here onwards the piece is no longer null and receives a position
		piece.position = position;
	}

	// Easier to test by row and column than by position (helper method)
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}

	// Does this position exist or not
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	// Is there a piece in this position
	public boolean thereIsAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("This position does not exist on the board!");
		}
		
		return piece(position) != null;
	}

}
