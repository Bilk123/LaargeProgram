package core.screens;

import core.Input;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blake on 4/17/2017.
 */
public abstract class Screen extends JPanel{
    public static Graphics2D g2d;
    public Screen(int width, int height){
            setPreferredSize(new Dimension(width, height));
            Input input = new Input();
            addKeyListener(input);
            addMouseListener(input);
            addMouseMotionListener(input);
            addMouseWheelListener(input);
    }

    public abstract void update();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    }
}
