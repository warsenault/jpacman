package nl.tudelft.jpacman.board;


import nl.tudelft.jpacman.PacmanStateException;

/**
 * A top-down view of a matrix of {@link Square}s.
 *
 * @author Jeroen Roosen 
 */
public class Board {

    /**
     * The grid of squares with board[x][y] being the square at column x, row y.
     */
    private final Square[][] squares;

    /**
     * Creates a new board.
     *
     * @param grid
     *            The grid of squares with grid[x][y] being the square at column
     *            x, row y.
     */
    @SuppressWarnings("PMD.ArrayIsStoredDirectly")
    Board(Square[][] grid) {
        if (grid == null) throw new PacmanStateException("'grid' should not be null.");
        this.squares = grid;
        assert invariant() : "Initial grid cannot contain null squares";
    }

    /**
     * Whatever happens, the squares on the board can't be null.
     * @return false if any square on the board is null.
     */
    protected final boolean invariant() {
        for (Square[] row : squares) {
            for (Square square : row) {
                if (square == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Returns the number of columns.
     *
     * @return The width of this board.
     */
    public int getWidth() {
        return squares.length;
    }

    /**
     * Returns the number of rows.
     *
     * @return The height of this board.
     */
    public int getHeight() {
        return squares[0].length;
    }

    /**
     * Returns the square at the given <code>x,y</code> position.
     *
     * Precondition: The <code>(x, y)</code> coordinates are within the
     * width and height of the board.
     *
     * @param x
     *            The <code>x</code> position (column) of the requested square.
     * @param y
     *            The <code>y</code> position (row) of the requested square.
     * @return The square at the given <code>x,y</code> position (never null).
     */
    public Square squareAt(int x, int y) {
        if (!withinBorders(x, y)) throw new PacmanStateException("'x,y' not within borders.");
        Square result = squares[x][y];
        if (result == null) throw new PacmanStateException("'result' should not be null.");
        assert result != null : "Follows from invariant.";
        return result;
    }

    /**
     * Determines whether the given <code>x,y</code> position is on this board.
     *
     * @param x
     *            The <code>x</code> position (row) to test.
     * @param y
     *            The <code>y</code> position (column) to test.
     * @return <code>true</code> iff the position is on this board.
     */
    public boolean withinBorders(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }
}
