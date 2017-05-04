package math;

import static math.MathUtil.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class Vector2F {
    public float x, y;
    public static final Vector2F ZERO = new Vector2F(0,0);
    public boolean projectZLessThanZero=false;
    public Vector2F(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2F() {
        this.x = x;
        this.y = y;
    }

    public Vector2F add(Vector2F vec) {
        return new Vector2F(x + vec.x, y + vec.y);
    }

    public Vector2F sub(Vector2F vec) {
        return new Vector2F(x - vec.x, y - vec.y);
    }

    public Vector2F mul(float scl) {
        return new Vector2F(x * scl, y * scl);
    }

    public Vector2F div(float scl) {
        return new Vector2F(x / scl, y / scl);
    }

    public float dot(Vector2F vec) {
        return x * vec.x + y * vec.y;
    }

    public Vector3F cross(Vector2F vec) {

        return new Vector3F(0, 0, x * vec.y - y * vec.x);
    }

    public Vector2F rotate(float deg) {
        return new Vector2F(x * cosf(deg) - y * sinf(deg), x * sinf(deg) + y * cosf(deg));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Vector2F set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2F set(Vector2F vec) {
        this.x=vec.x;
        this.y=vec.y;
        return this;
    }

    public Vector2F normalise() {
        double length = length();
        this.x /= length;
        this.y /= length;
        return this;
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public float getTheta() {
        float deg = (float) Math.toDegrees(MathUtil.arctan(y / x));
        return (x < 0) ? deg + 180 : deg;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isProjectZLessThanZero() {
        return projectZLessThanZero;
    }

    public Vector3F toVector3F() {
        return new Vector3F(x,y,0);
    }
}
