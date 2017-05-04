package core.mechanics2D;

import core.mechanics3D.ForceVector3F;
import graphics.RenderUtil;
import math.TriangleRH;
import math.Vector2F;

import java.awt.*;

import static core.screens.Screen.g2d;
import static math.MathUtil.*;

/**
 * Created by Blake on 4/23/2017.
 */
public class ForceVector2F extends Vector2F {
    private Vector2F translate;
    private float length, theta;
    private int quad;
    private float drawLength;

    public ForceVector2F(float length, float theta, Vector2F origin, float drawLength) {
        this.x = (float) (cos(theta));
        this.y = (float) (sin(theta));
        this.translate =origin;
        this.length = length;
        this.theta =theta%360;
        if(theta>=0&&theta<90)quad=0;
        else if(theta>=90&&theta<180)quad=1;
        else if(theta>=180&&theta<270)quad=2;
        else if(theta>=270&&theta<360)quad=3;
        this.drawLength = drawLength;
    }

    public ForceVector2F(float length, TriangleRH angleDef, Vector2F origin, float drawLength) {
        this.x = (angleDef.cos());
        this.y = (angleDef.sin());
        this.translate =origin;
        this.length = length;
        this.theta =angleDef.theta();
        if(theta>=0&&theta<90)quad=0;
        else if(theta>=90&&theta<180)quad=1;
        else if(theta>=180&&theta<270)quad=2;
        else if(theta>=270&&theta<360)quad=3;
        this.drawLength= drawLength;
    }

    public Vector2F getComponents(){
        int cx=1, cy=1, alpha=0;
        if(quad==1){
            cx=-1;
            alpha=90;
        }
        if(quad==2){
            cx=-1;
            cy=-1;
            alpha=180;
        }
        if(quad==3){
            cy=-1;
            alpha=270;
        }
        return new Vector2F((float)(cx*length*cos(theta-alpha)),(float)(cy*length*sin(theta-alpha)));
    }

    public void setTranslate(Vector2F translate) {
        this.translate = translate;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void draw(){
        g2d.setColor(Color.red);
        RenderUtil.drawLineVector(this, translate);
        g2d.setColor(Color.white);
        RenderUtil.drawStringInSpace((int)length+"N", this.add(translate),0.1f);
    }

    public float getDrawLength() {
        return drawLength;
    }


}
