package graphics.shapes;

import graphics.RenderUtil;
import graphics.shapes.Shape;
import math.Vector2F;

/**
 * Created by Blake on 4/23/2017.
 */
public class Rectangle extends Shape {
    private Vector2F c1, c2;
    public Rectangle(Vector2F c1, Vector2F c2){
        this.c1 = new Vector2F(Math.min(c1.x,c2.x), Math.min(c1.y,c2.y));
        this.c2 = new Vector2F(Math.max(c1.x,c2.x), Math.max(c1.y,c2.y));
        System.out.println(this.c1+" : "+this.c2);
    }
    public void draw(){
        RenderUtil.drawRect(c1,c2);

    }
}
