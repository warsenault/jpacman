package nl.tudelft.jpacman.game;

import nl.tudelft.jpacman.PacmanStateException;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;

import java.util.List;

/**
 * A game with one player and a single level.
 *
 * @author Jeroen Roosen 
 */
public class SinglePlayerGame extends Game {

    /**
     * The player of this game.
     */
    private final Player player;

    /**
     * The level of this game.
     */
    private final Level level;

    /**
     * Create a new single player game for the provided level and player.
     *
     * @param player
     *            The player.
     * @param level
     *            The level.
     * @param pointCalculator
     *            The way to calculate points upon collisions.
     */
    protected SinglePlayerGame(Player player, Level level, PointCalculator pointCalculator) {
        super(pointCalculator);

        if (player == null) throw new PacmanStateException("'player' should not be null.");
        if (level == null) throw new PacmanStateException("'level' should not be null.");

        this.player = player;
        this.level = level;
        this.level.registerPlayer(player);
    }

    @Override
    public List<Player> getPlayers() {
        return List.of(player);
    }

    @Override
    public Level getLevel() {
        return level;
    }
}
