package graphics;

import com.sun.org.apache.regexp.internal.RE;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class Model {
    private int width, length, height;
    private int[][][] buffer;

    public Model(int width, int length, int height) {
        buffer = new int[width][height][length];
        this.width = width;
        this.height = height;
        this.length = length;

    }


    public void render(Graphics2D g2d) {
        Vector3F temp = new Vector3F();
        Vector2F drawPos;
        g2d.setColor(Color.white);
        for (int z = 0; z < length; z++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    temp.set(x - width / 2.0f, y - height / 2.0f, z - length / 2.0f);
                    drawPos = Renderer.project(temp);
                    g2d.fillRect((int) drawPos.x, (int) drawPos.y, 2, 2);
                }
            }
        }
    }
}
