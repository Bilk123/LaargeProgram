package core.circuits;

import core.screens.MainScreen;
import graphics.RenderUtil;
import math.Vector2F;

import java.util.ArrayList;

/**
 * Created by Blake on 4/27/2017.
 */
public class Circuit {
    protected ArrayList<Node> nodes;
    public Circuit(){
        nodes = new ArrayList<>();
        MainScreen.disableAxis();
    }

    public void draw(){
        for(int y=0;y<10;y++){
            for(int x =0;x<11;x++){
                RenderUtil.fillCircle(0.01f,new Vector2F(x-5,y-5).div(2),5);
            }
        }
        for(Node node:nodes){
            node.draw();
        }
    }
}
