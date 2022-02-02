package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.PacmanStateException;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

/**
 * A key listener based on a set of keyCode-action pairs.
 *
 * @author Jeroen Roosen 
 */
class PacKeyListener implements KeyListener {

    /**
     * The mappings of keyCode to action.
     */
    private final Map<Integer, Action> mappings;

    /**
     * Create a new key listener based on a set of keyCode-action pairs.
     * @param keyMappings The mappings of keyCode to action.
     */
    PacKeyListener(Map<Integer, Action> keyMappings) {
        if (keyMappings == null) {
            throw new PacmanStateException("KeyMapping should not be null.");
        }
        this.mappings = keyMappings;
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event == null) {
            throw new PacmanStateException("Event should not be null.");
        }
        Action action = mappings.get(event.getKeyCode());
        if (action != null) {
            action.doAction();
        }
    }

    @Override
    public void keyTyped(KeyEvent event) {
        // do nothing
    }

    @Override
    public void keyReleased(KeyEvent event) {
        // do nothing
    }
}
