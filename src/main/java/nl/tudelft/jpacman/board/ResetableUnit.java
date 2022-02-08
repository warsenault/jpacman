package nl.tudelft.jpacman.board;

public abstract class ResetableUnit extends Unit {


    /**
     * Initial square position of the Ghost.
     */
    private Square initialSquare;

    @Override
    public void occupy(Square target) {
        if (initialSquare == null) {
            initialSquare = target;
        }
        super.occupy(target);
    }


    /**
     * Resets the position of the unit to its initial position.
     */
    public void resetPosition() {
        occupy(initialSquare);
    }
}
