package core.mechanics3D;

import graphics.RenderUtil;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class CoupleMoment3D extends Moment3D {
    private Vector3F translate;
    public CoupleMoment3D(PositionVector3F r, ForceVector3F F, Vector3F translate) {
        super(r, F);
        this.translate =translate;
    }

    public void draw(){
        g2d.setColor(Color.green);
        RenderUtil.drawLineVector(r, translate);
        Vector3F temp = new Vector3F(F.x,F.y,F.z).normalise().mul(F.getDrawLength());
        g2d.setColor(Color.red);
        RenderUtil.drawLineVector(temp,translate.add(r));
        RenderUtil.drawLineVector(temp.mul(-1),translate);
        g2d.setColor(Color.blue);
        Vector3F temp1 = new Vector3F(moment.x, moment.y, moment.z).normalise();
        RenderUtil.drawLineVector(temp1,new Vector3F(translate.x, translate.y, translate.z).add(r.div(2)));
    }
}
