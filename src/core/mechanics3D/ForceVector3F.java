package core.mechanics3D;

import core.mechanics2D.ForceVector2F;
import graphics.RenderUtil;
import math.Matrix4F;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class ForceVector3F extends Vector3F{
    public float length, drawLength;
    private Vector3F translate;
    public ForceVector3F(float x, float y, float z, float length, Vector3F translate, float drawLength) {
        this.length = length;
        this.translate = translate;
        this.drawLength=drawLength;
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public void draw(){
        Vector3F temp = new Vector3F(x,y,z).normalise().mul(drawLength);
        g2d.setColor(Color.red);
        RenderUtil.drawLineVector(temp,translate);
        g2d.setColor(Color.white);
        RenderUtil.drawStringInSpace(this.toString(),temp);

    }

    public float getDrawLength() {
        return drawLength;
    }

    public float getLength() {
        return length;
    }
}
