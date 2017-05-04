package core.questions.onlineTut4;

import core.System2D;
import core.mechanics2D.CoupleMoment2D;
import core.mechanics2D.ForceVector2F;
import core.mechanics2D.PositionVector2F;
import graphics.shapes.Rectangle;
import math.Vector2F;

/**
 * Created by Blake on 4/23/2017.
 */
public class Q2 extends System2D{
    public Q2(){
        super();
        Rectangle rect = new Rectangle(Vector2F.ZERO, new Vector2F(0.3f,0.3f));
        shapes.add(rect);

        ForceVector2F T = new ForceVector2F(120, -30, new Vector2F(0.3f,0.3f),0.1f);
        CoupleMoment2D m1 = new CoupleMoment2D(new PositionVector2F(0.3f,0.3f,0),T,Vector2F.ZERO);
        moments.add(m1);

        ForceVector2F P = new ForceVector2F(93.018f,15,new Vector2F(0.3f,0f),0.1f);
        CoupleMoment2D m2 = new CoupleMoment2D(new PositionVector2F(0.3f,-0.3f,0),P,new Vector2F(0,0.3f));
        moments.add(m2);
    }
}
