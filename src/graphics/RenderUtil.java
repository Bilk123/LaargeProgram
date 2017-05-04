package graphics;

import com.sun.org.apache.regexp.internal.RE;
import math.Vector2F;
import math.Vector3F;

import java.awt.*;

import static core.screens.Screen.g2d;
import static math.MathUtil.*;

/**
 * Created by Blake on 4/23/2017.
 */
public class RenderUtil {
    public static void drawLineVector(Vector2F vec) {
        Vector2F o = Renderer.project(Vector2F.ZERO);
        Vector2F p = Renderer.project(vec);
        if (!vec.isProjectZLessThanZero()) {
            g2d.drawLine((int) o.getX(), (int) o.getY(), (int) p.getX(), (int) p.getY());
            drawArrowHead(vec);
        }
    }//draws the vector vec from <0, 0> on the screen

    public static void drawLineVector(Vector2F vec, Vector2F translate) {
        Vector2F o = Renderer.project(translate);
        Vector2F p = Renderer.project(vec.add(translate));
        if (!vec.isProjectZLessThanZero()) {
            g2d.drawLine((int) o.getX(), (int) o.getY(), (int) p.getX(), (int) p.getY());
            drawArrowHead(vec.add(translate), translate);
        }
    }//draws the vector (vec+translate) from translate

    public static void drawLineVector(Vector3F vec) {
        Vector2F p = Renderer.project(vec);
        if (!vec.isProjectZLessThanZero()) {
            g2d.drawLine((int) Renderer.project(Vector3F.ZERO).getX(), (int) Renderer.project(Vector3F.ZERO).getY(), (int) p.getX(), (int) p.getY());
            g2d.setColor(Color.WHITE);
            g2d.fillRect((int) p.x - 2, (int) p.y - 2, 4, 4);
        }
    }

    public static void drawLineVector(Vector3F vec, Vector3F translate) {
        Vector2F o = Renderer.project(translate);
        Vector2F p = Renderer.project(vec.add(translate));
        if (!vec.isProjectZLessThanZero()) {
            g2d.drawLine((int) o.getX(), (int) o.getY(), (int) p.getX(), (int) p.getY());
            g2d.fillRect((int) p.x - 2, (int) p.y - 2, 4, 4);
        }
    }//draws the vector (vec+translate) from translate

    private static void drawArrowHead(Vector2F vec) {
        Vector2F a1 = new Vector2F((float) vec.length() / 3f, 0);
        Vector2F l1, l2, p;
        l1 = Renderer.project(a1.rotate(vec.getTheta() - 210).add(vec));
        l2 = Renderer.project(a1.rotate(vec.getTheta() - 150).add(vec));
        p = Renderer.project(vec);
        g2d.drawLine((int) l1.getX(), (int) l1.getY(), (int) p.getX(), (int) p.getY());
        g2d.drawLine((int) l2.getX(), (int) l2.getY(), (int) p.getX(), (int) p.getY());
    }//used to indicate the direction of a vector


    private static void drawArrowHead(Vector2F vec, Vector2F origin) {
        Vector2F a1 = new Vector2F((float) vec.sub(origin).length() / 3f, 0);
        Vector2F l1, l2, p;
        l1 = Renderer.project(a1.rotate(vec.sub(origin).getTheta() - 210).add(vec));
        l2 = Renderer.project(a1.rotate(vec.sub(origin).getTheta() - 150).add(vec));
        p = Renderer.project(vec);
        g2d.drawLine((int) l1.getX(), (int) l1.getY(), (int) p.getX(), (int) p.getY());
        g2d.drawLine((int) l2.getX(), (int) l2.getY(), (int) p.getX(), (int) p.getY());
    }//used to indicate the direction of a vector

    public static void drawArc(float radius, Vector2F centre, float theta) {
        Vector2F temp = Renderer.project(centre);
        Vector2F temp1 = centre.add(new Vector2F(Math.abs(radius), 0));
        float size = 2 * (temp1.x - temp.x);
        g2d.drawArc((int) (temp.x - size / 2), (int) (temp.y - size / 2), (int) size, (int) size, 0, (int) theta);
    }

    public static void drawStringInSpace(String text, Vector2F loc, float size) {
        loc = Renderer.project(loc);
        Vector2F t1 = Renderer.project(new Vector2F(0, size));
        int d = (int) t1.sub(Renderer.project(Vector2F.ZERO)).y;
        if (!loc.isProjectZLessThanZero()) {
            g2d.setFont(new Font("Impact", Font.PLAIN, -d));
            int width = g2d.getFontMetrics().stringWidth(text);
            g2d.drawString(text, (int) (loc.getX() - width / 2.0f), (int) loc.getY() - (d / 2.0f));
        }
    }//draws a string at a projected vector

    public static void drawStringInSpace(String text, Vector3F loc) {
        Vector2F temp = Renderer.project(loc);
        Vector2F t1 = Renderer.project(new Vector2F(0, 1));
        int size = (int) t1.sub(Vector2F.ZERO).y;
        if (!loc.isProjectZLessThanZero()) {
            g2d.setFont(new Font("Impact", Font.PLAIN, size));
            g2d.drawString(text, (int) temp.getX(), (int) temp.getY());
        }
    }//draws a string at a projected vector

    public static void drawStringOnScreen(String text, Vector2F loc) {
        g2d.drawString(text, (int) loc.getX(), (int) loc.getY());
    }//draws a string at a screen co-ordinate

    public static void drawLine(Vector3F vec1, Vector3F vec2) {
        Vector2F temp = Renderer.project(vec1);
        Vector2F temp2 = Renderer.project(vec2);
        if (vec1.isProjectZLessThanZero() || vec2.isProjectZLessThanZero()) {
            return;
        }
        g2d.drawLine((int) temp.getX(), (int) temp.getY(), (int) temp2.getX(), (int) temp2.getY());
    }//draws a line between two points

    public static void drawConnectedVectors(Vector3F... vecs) {
        drawLineVector(vecs[0], Vector3F.ZERO);
        Vector3F translate = Vector3F.ZERO;
        for (int i = 1; i < vecs.length; i++) {
            translate = translate.add(vecs[i - 1]);
            drawLineVector(vecs[i], translate);
        }
    }

    public static void drawConnectedVectors(Vector2F... vecs) {
        drawLineVector(vecs[0], Vector2F.ZERO);
        Vector2F translate = Vector2F.ZERO;
        for (int i = 1; i < vecs.length; i++) {
            translate = translate.add(vecs[i - 1]);
            drawLineVector(vecs[i], translate);
        }
    }

    public static void drawLine(Vector2F vec1, Vector2F vec2) {
        vec1 = Renderer.project(vec1);
        vec2 = Renderer.project(vec2);
        if (!vec1.isProjectZLessThanZero() || !vec2.isProjectZLessThanZero())
            g2d.drawLine((int) vec1.x, (int) vec1.y, (int) vec2.x, (int) vec2.y);
    }//draws a line between two points

    public static void drawRect(Vector2F c1, Vector2F c2) {
        Vector2F c3 = new Vector2F(c1.x, c2.y);
        Vector2F c4 = new Vector2F(c2.x, c1.y);
        drawLine(c1, c3);
        drawLine(c3, c2);
        drawLine(c2, c4);
        drawLine(c4, c1);
    }

    public static void drawCircle(float radius, Vector2F centre, int resolution) {
        Vector2F temp = new Vector2F();
        Vector2F temp1 = new Vector2F();
        for (int i = 0; i < resolution; i++) {
            float x = centre.x + radius * cosf(i * 360 / resolution);
            float y = centre.y + radius * sinf(i * 360 / resolution);
            float x1 = centre.x + radius * cosf(((i + 1) % 360) * 360 / resolution);
            float y1 = centre.y + radius * sinf(((i + 1) % 360) * 360 / resolution);
            temp.set(x, y);
            temp1.set(x1, y1);
            drawLine(temp, temp1);
        }
    }


    public static void fillCircle(float radius, Vector3F centre, int resolution) {
        int[] xps = new int[resolution];
        int[] yps = new int[resolution];
        Vector3F temp = new Vector3F();
        Vector2F temp1;
        for (int i = 0; i < resolution; i++) {
            float x = (centre.x + radius * (cosf(i * 360.0f / resolution)));
            float y = (centre.y + radius * (sinf(i * 360.0f / resolution)));
            temp1 = Renderer.project(temp.set(x, y, centre.z));
            xps[i] = (int) temp1.x;
            yps[i] = (int) temp1.y;
        }
        if (!Renderer.project(centre).isProjectZLessThanZero())
            g2d.fillPolygon(xps, yps, resolution);
    }

    public static void fillCircle(float radius, Vector2F centre, int resolution) {
        int[] xps = new int[resolution];
        int[] yps = new int[resolution];
        Vector2F temp = new Vector2F();
        Vector2F temp1;
        for (int i = 0; i < resolution; i++) {
            float x = (centre.x + radius * (cosf(i * 360.0f / resolution)));
            float y = (centre.y + radius * (sinf(i * 360.0f / resolution)));
            temp1 = Renderer.project(temp.set(x, y));
            xps[i] = (int) temp1.x;
            yps[i] = (int) temp1.y;
        }
        if (!Renderer.project(centre).isProjectZLessThanZero())
            g2d.fillPolygon(xps, yps, resolution);
    }

    public static void drawPolygon(Vector2F... vecs) {
        for (int i = 0; i < vecs.length; i++) {
            drawLine(vecs[i], vecs[i % vecs.length]);
        }
    }

    public static void fillPolygon(Vector2F... vecs) {
        int[] xps = new int[vecs.length];
        int[] yps = new int[vecs.length];
        Vector2F temp;
        for (int i = 0; i < vecs.length; i++) {
            temp = Renderer.project(vecs[i]);
            xps[i] = (int) temp.x;
            yps[i] = (int) temp.y;
        }
        g2d.fillPolygon(xps, yps, vecs.length);
    }

    public static void fillEllipse(Vector3F centre, float width, float height) {
        Vector2F temp1 = Renderer.project(new Vector2F(width, height));
        Vector2F temp2 = Renderer.project(Vector2F.ZERO);
        int w = (int)Math.abs(temp1.x-temp2.x);
        int h = (int)Math.abs(temp1.y-temp2.y);
        temp2 = Renderer.project(centre);
        g2d.fillOval((int)(temp2.x+w/2),(int)(temp2.y+h/2),w,h);
    }
}
