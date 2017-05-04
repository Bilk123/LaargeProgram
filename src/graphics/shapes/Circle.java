package graphics.shapes;

import graphics.RenderUtil;
import graphics.shapes.Shape;
import math.Vector2F;

/**
 * Created by Blake on 4/23/2017.
 */
public class Circle extends Shape {
    private float radius;
    private Vector2F centre;

    public Circle(float radius, Vector2F centre) {
        this.radius = radius;
        this.centre = centre;
    }

    public void draw(){
      RenderUtil.drawCircle(radius, centre,15);
    }
}
