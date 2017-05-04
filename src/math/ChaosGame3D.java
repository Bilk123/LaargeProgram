package math;

import graphics.RenderUtil;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static core.screens.Screen.g2d;
import static math.MathUtil.clamp;
import static math.MathUtil.cosf;
import static math.MathUtil.sinf;

/**
 * Created by Blake on 4/28/2017.
 */
public class ChaosGame3D {
    private Vector3F[] points;
    private ArrayList<Vector3F> randoms;
    private Random random;
    private int noIterations;
    private int size =4;
    public ChaosGame3D(int noIterrations) {
        points = new Vector3F[size];
        random=new Random();
        points[0] = new Vector3F(0,1.0f,0);
        for(int i =1;i<size;i++){
            float x = cosf(i*360/(size-1)-150);
            float z = sinf(i*360/(size-1)-150);
            points[i] = new Vector3F(x,0,z);
        }
        randoms = new ArrayList<>();
        this.noIterations = noIterrations;
        randoms.add((points[0].add(points[1])).div(2f));

    }

    public Vector3F getNextVector(Vector3F previousVec) {
        return (previousVec.add(points[random.nextInt(points.length)])).div(2);
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
            g2d.setColor(new Color(clamp(randoms.get(i).x+0.3f,0f,1.0f),clamp(randoms.get(i).y+0.3f,0f,1.0f),clamp(randoms.get(i).z+0.3f,0f,1.0f)));
            RenderUtil.fillEllipse(randoms.get(i), 0.01f,0.01f);
        }

    }
}
