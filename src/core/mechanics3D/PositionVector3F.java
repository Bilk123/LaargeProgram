package core.mechanics3D;

import graphics.RenderUtil;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class PositionVector3F extends Vector3F{
    private int scale;
    public PositionVector3F(float x, float y, float z, int scale){
        this.x=(float)(x*Math.pow(10,scale));
        this.y=(float)(y*Math.pow(10,scale));
        this.z=(float)(z*Math.pow(10,scale));
        this.scale=scale;
    }

    public PositionVector3F(Vector3F v, int scale) {
        x=v.x;
        y=v.y;
        z=v.z;
        this.scale=scale;
    }

    public void set(Vector3F vec){
        this.x=vec.x;
        this.y=vec.y;
        this.z=vec.z;
    }
    public void draw(){
        g2d.setColor(Color.green);
        RenderUtil.drawLineVector(this);
    }
}
