package core.circuits;

import graphics.RenderUtil;
import math.Vector2F;

import java.awt.*;
import java.util.ArrayList;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/27/2017.
 */
public class Node{
    protected Vector2F node;
    protected String label;
    protected ArrayList<CircuitComponent> connectedComponents;
    public Node(Vector2F node, String label){
        this.label=label;
        this.node=node;
        connectedComponents=new ArrayList<>();
    }

    public void draw(){
        g2d.setColor(Color.ORANGE);
        RenderUtil.fillCircle(0.06f,node,10);
        g2d.setColor(Color.BLUE);
        RenderUtil.drawStringInSpace(label,node,0.1f);
        for(CircuitComponent c:connectedComponents){
            c.draw();
        }
    }

    public void add(CircuitComponent component) {
        connectedComponents.add(component);
    }
}
