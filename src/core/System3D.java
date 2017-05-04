package core;

import core.mechanics2D.PositionVector2F;
import core.mechanics3D.Moment3D;
import core.mechanics3D.PositionVector3F;
import graphics.RenderUtil;

import java.awt.*;
import java.util.ArrayList;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/23/2017.
 */
public class System3D {
    protected ArrayList<Moment3D> moments;
    protected ArrayList<PositionVector3F> structure;
    private PositionVector3F vec[];
    public System3D(){
        moments = new ArrayList<>();
        structure = new ArrayList<>();

    }
    public void update(){
        vec = new PositionVector3F[structure.size()];
        structure.toArray(vec);
    }
    public void draw(){
        g2d.setColor(Color.orange);
        RenderUtil.drawConnectedVectors(vec);
        for(Moment3D moment:moments){
            moment.draw();
        }
    }
}
