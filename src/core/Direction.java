package core;

import math.Vector2F;

/**
 * Created by Blake on 4/27/2017.
 */
public enum Direction {
    NORTH(new Vector2F(0, 1)),
    EAST(new Vector2F(1, 0)),
    SOUTH(new Vector2F(0, -1)),
    WEST(new Vector2F(-1, 0));

   private Vector2F direction;

    Direction(Vector2F direction) {
        this.direction = direction;
    }

    public Vector2F getDirection() {
        return direction;
    }
}
