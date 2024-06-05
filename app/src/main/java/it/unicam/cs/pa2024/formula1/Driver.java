package it.unicam.cs.pa2024.formula1;

/**
 * This interface represents a driver in the race.
 */
public interface Driver {
    /**
     * Moves the driver based on the current track state.
     *
     * @param track the track on which the driver moves
     */
    void move(Track track);

    /**
     * Returns the current position of the driver.
     *
     * @return the position
     */
    Position getPosition();

    /**
     * Returns the name of the driver.
     *
     * @return the name
     */
    String getName();
}

