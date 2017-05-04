package core.mechanics2D;

import core.Main;
import graphics.RenderUtil;
import math.Vector2F;
import math.Vector3F;

/**
 * Created by Blake on 4/23/2017.
 */
public class Moment2D {
    protected Vector3F moment;
    protected float momentL;
    protected PositionVector2F r;
    protected ForceVector2F F;

    public Moment2D(PositionVector2F r, ForceVector2F F){
        this.r=r;
        this.F=F;
        Vector2F temp = F.getComponents();
        moment = r.cross(temp);
        momentL = moment.z;
        System.out.println("rx * Fy - ry * Fx");
        System.out.println("= "+ Main.df.format(r.x)+" * " +Main.df.format(temp.y)+" - "+Main.df.format(r.y)+" * "+Main.df.format(temp.x));
        System.out.println("= "+ (r.x * temp.y - r.y * temp.x));
        if(momentL>0){
            System.out.println("= "+momentL+" CCW");
        }else{
            System.out.println("= "+Math.abs(momentL)+" CW");
        }
        System.out.println();
    }

    public void draw(){
        RenderUtil.drawLineVector(moment);
    }

    public Vector3F getMoment() {
        return moment;
    }

}
