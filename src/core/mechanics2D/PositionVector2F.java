package core.mechanics2D;

import graphics.RenderUtil;
import math.Vector2F;
import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class PositionVector2F extends Vector2F{
    private int scale;

    public PositionVector2F(float x, float y, int scale){
        this.x=(float)(x*Math.pow(10,scale));
        this.y=(float)(y*Math.pow(10,scale));
        this.scale=scale;
    }

    public PositionVector2F set(Vector2F vec){
        this.x=vec.x;
        this.y=vec.y;
        return this;
    }

    public void draw(){
        g2d.setColor(Color.green);
        RenderUtil.drawLineVector(this);
        g2d.setColor(Color.white);
        RenderUtil.drawStringInSpace(this.toString()+"m",this.div(3),0.1f);
    }
}
