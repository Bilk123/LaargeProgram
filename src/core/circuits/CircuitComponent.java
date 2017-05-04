package core.circuits;

import math.Vector2F;

/**
 * Created by Blake on 4/27/2017.
 */
public abstract class CircuitComponent {

    public abstract void draw();

    public static Vector2F getLocationOnCircuit(int x, int y){
        return new Vector2F(x-5,y-5).div(2);
    }
}
