package math;

import graphics.RenderUtil;
import math.Vector2F;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static core.screens.Screen.g2d;
import static math.MathUtil.*;

/**
 * Created by Blake on 4/28/2017.
 */
public class ChaosGame {
    private Vector2F[] points;
    private ArrayList<Vector2F> randoms;
    private Random random;
    private int noIterations;

    public ChaosGame(int size, int noIterrations) {
        points = new Vector2F[size];
        random=new Random();
        for (int i = 0; i < size; i++) {
            float x = 2f * cosf(i * 360 / size - 0);
            float y = 2f * sinf(i * 360 / size-0);
            points[i] = new Vector2F(x, y);
        }
        randoms = new ArrayList<>();
        this.noIterations = noIterrations;
        randoms.add((points[0].add(points[1])).div(2));

    }

    public Vector2F getNextVector(Vector2F previousVec) {
        return (previousVec.add(points[random.nextInt(points.length)])).div(points.length-1);
    }
    private int i =0;
    public void update() {
        if (randoms.size() <= noIterations) {
            randoms.add(getNextVector(randoms.get(i)));
            i++;
        }
    }

    public void draw() {
        g2d.setColor(Color.ORANGE);
        for (int i = 0; i < points.length; i++)
            RenderUtil.fillCircle(0.03f, points[i], 12);
        g2d.setColor(Color.WHITE);
        for (int i =0;i<randoms.size();i++) {
            RenderUtil.fillCircle(0.01f, randoms.get(i), 4);
        }

    }
}
