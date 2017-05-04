package core;

import core.mechanics2D.Moment2D;
import graphics.shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class System2D {

    protected ArrayList<Moment2D> moments;
    protected ArrayList<Shape> shapes;

    public System2D() {
        moments = new ArrayList<>();
        shapes = new ArrayList<>();

    }

    public void draw() {
        g2d.setColor(Color.CYAN);
        for (Shape shape : shapes) {
            shape.draw();
        }
        for (Moment2D moment : moments) {
            moment.draw();
        }
    }
}
