package core.questions.onlineTut4;

import core.System2D;
import core.mechanics2D.CoupleMoment2D;
import core.mechanics2D.ForceVector2F;
import core.mechanics2D.PositionVector2F;
import graphics.shapes.Circle;
import math.Vector2F;

import static math.MathUtil.cosf;
import static math.MathUtil.sinf;

/**
 * Created by Blake on 4/23/2017.
 */
public class Q1 extends System2D {
    public Q1(){
        super();
        Circle c =new Circle(0.3f, Vector2F.ZERO);
        shapes.add(c);
        ForceVector2F F1 = new ForceVector2F(300,30,new Vector2F(0,0.3f),0.7f);
        ForceVector2F F2 = new ForceVector2F(111.34f,15,new Vector2F(0.3f*sinf(30),-0.3f*cosf(30)),0.7f);
        CoupleMoment2D m1 = new CoupleMoment2D(new PositionVector2F(0,0.6f,0),F1, new PositionVector2F(0,-0.3f,0));
        Vector2F v1 = new Vector2F(0.3f*sinf(30),-0.3f*cosf(30));
        Vector2F v2 = new Vector2F(-0.3f*cosf(30),0.3f*sinf(30));
        Vector2F res = v1.sub(v2);
        System.out.println(res);
        PositionVector2F p =new PositionVector2F(res.x, res.y, 0);
        CoupleMoment2D m2 = new CoupleMoment2D(p,F2,v2);
        moments.add(m1);
        moments.add(m2);
        System.out.println(m1.getMoment().add(m2.getMoment()));
    }
}
