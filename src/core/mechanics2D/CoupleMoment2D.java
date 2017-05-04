package core.mechanics2D;

import graphics.RenderUtil;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class CoupleMoment2D extends Moment2D{
    private Vector2F translate;
    public CoupleMoment2D(PositionVector2F d, ForceVector2F F, Vector2F translate){
        super(d,F);
        this.translate =translate;

    }

    public void draw(){
        g2d.setColor(Color.green);
        RenderUtil.drawLineVector(r, translate);
        Vector2F temp = new Vector2F(F.x,F.y).normalise().mul(F.getDrawLength());
        g2d.setColor(Color.red);
        RenderUtil.drawLineVector(temp,translate.add(r));
        RenderUtil.drawLineVector(temp.mul(-1),translate);
        g2d.setColor(Color.blue);
        Vector3F temp1 = new Vector3F(moment.x, moment.y, moment.z).normalise();
        RenderUtil.drawLineVector(temp1,new Vector3F(translate.x+r.x/2, translate.y+r.y/2, 0));
    }


}
