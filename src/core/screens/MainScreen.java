package core.screens;

import core.Input;
import core.physics.RigidBody;
import graphics.*;
import graphics.shapes.Plane;
import graphics.shapes.Sphere;
import math.Vector3F;

import java.awt.*;

import static graphics.RenderUtil.*;
import static java.awt.event.KeyEvent.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class MainScreen extends Screen {
    Plane test = new Plane();
    RigidBody test1 = new RigidBody(10,new Vector3F(0,100f,0), new Vector3F(), new Vector3F(),new Sphere());
    private static boolean x = true, y = true, z = true;

    public MainScreen(int width, int height) {
        super(width, height);
        setBackground(new Color(55, 55, 55));
        test.scale(6f,6f,6f);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d.setFont(new Font("Impact",Font.PLAIN,32));
        //test.draw(g2d);
        g2d.setColor(Color.white);
        for (int i = 0; i < 20; i++) {
            if (x)
                drawLine(new Vector3F(i - 10, 0, 0), new Vector3F((i - 9), 0, 0));
            if (y)
                drawLine(new Vector3F(0, i - 10, 0), new Vector3F(0, (i - 9), 0));
            if (z)
                drawLine(new Vector3F(0, 0, i - 10), new Vector3F(0, 0, (i - 9)));
        }
        test.draw();
        test1.draw();



    }

    @Override
    public void update() {
        Renderer.update();
        if (Input.getKeyDown(VK_X)) x = !x;
        if (Input.getKeyDown(VK_Y)) y = !y;
        if (Input.getKeyDown(VK_Z)) z = !z;
       // game.update();
        test.update();
        test1.update();
    }
    public static void disableAxis(){
        x=false;
        y=false;
        z=false;
    }
}
