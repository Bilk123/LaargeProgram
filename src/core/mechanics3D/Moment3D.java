package core.mechanics3D;


import core.Main;
import graphics.RenderUtil;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class Moment3D {
    protected ForceVector3F F;
    protected PositionVector3F r;
    protected Vector3F moment;


    public Moment3D(PositionVector3F r, ForceVector3F F){
        this.r=r;
        this.F=F;
        moment = r.cross(F);
        System.out.println("i * (ry * Fz - rz * Fy) - j * (rx * Fz - rz * Fx) + k * (rx * Fy - ry * Fx)");
        System.out.println("("+r.y+" * " +F.z+" - " +r.z+" * "+F.y+")i - "+"("+r.x+" * "+F.z+" - "+r.z+" * "+F.x+")j + ("+r.x+" * "+F.y+" - "+r.y+" * "+F.x+")k ");
        System.out.println(moment+"Nm");
    }

    public void draw(){
        Vector3F temp1 = new Vector3F(moment.x, moment.y, moment.z);
        temp1.normalise();
        g2d.setColor(Color.BLUE);
        RenderUtil.drawLineVector(temp1);
        RenderUtil.drawStringInSpace(moment.toString()+"Nm",temp1);
        r.draw();
    }

    public Vector3F getMoment() {
        return moment;
    }

    public static Vector3F addMoments(Moment3D...moment3DS){
        Vector3F res = new Vector3F();
        for(int i =0;i<moment3DS.length;i++){
            res = res.add(moment3DS[i].getMoment());
        }
        return res;
    }
}
