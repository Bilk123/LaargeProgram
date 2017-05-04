package core.questions.onlineTut5;

import core.System2D;
import core.mechanics2D.ForceVector2F;
import core.mechanics2D.PositionVector2F;
import graphics.shapes.Rectangle;
import math.Vector2F;

import java.util.ArrayList;

/**
 * Created by Blake on 5/2/2017.
 */
public class Q1 extends System2D{
    private ArrayList<ForceVector2F> forces = new ArrayList<>();
    private ArrayList<PositionVector2F> positions = new ArrayList<>();
    public Q1(){
        super();
        Rectangle rect = new Rectangle(new Vector2F(0,0),new Vector2F(-18,-4));
        shapes.add(rect);
        ForceVector2F f1 =new ForceVector2F(2000,225,Vector2F.ZERO,1f);
        forces.add(f1);
        PositionVector2F a = new PositionVector2F(3,0,0);
        PositionVector2F b = new PositionVector2F(-7.5f,0,0);
        PositionVector2F c = new PositionVector2F(-10.5f,0,0);
        positions.add(a);
        positions.add(b);
        positions.add(c);
        ForceVector2F f2 = new ForceVector2F(2000,270,c.add(a),1f);
        forces.add(f2);
    }

    @Override
    public void draw() {
        super.draw();
        for(ForceVector2F f : forces){
            f.draw();
        }
        for(PositionVector2F p :positions){
            p.draw();
        }
    }
}
