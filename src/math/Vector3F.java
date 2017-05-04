package math;

import static math.MathUtil.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class Vector3F {

    public static final Vector3F ZERO = new Vector3F(0,0,0);
    public float x, y, z;
    public boolean projectZLessThanZero = false;
    public Vector3F(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3F() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public boolean isProjectZLessThanZero() {
        return projectZLessThanZero;
    }

    public Vector3F add(Vector3F vec) {
        return new Vector3F(x + vec.x, y + vec.y, z + vec.z);
    }

    public Vector3F sub(Vector3F vec) {
        return new Vector3F(x - vec.x, y - vec.y, z - vec.z);
    }

    public Vector3F mul(float scl) {
        return new Vector3F(x * scl, y * scl, z * scl);
    }

    public Vector3F div(float scl) {
        return new Vector3F(x / scl, y / scl, z / scl);
    }

    public float dot(Vector3F vec) {
        return x * vec.x + y * vec.y + z + vec.z;
    }

    public Vector3F cross(Vector3F vec) {
        return new Vector3F(
                y * vec.z - z * vec.y,
                -(x * vec.z - z * vec.x),
                x * vec.y - y * vec.x
        );
    }

    public Vector3F rotateY(float theta){
        return new Vector3F((float) (x * MathUtil.cos(theta) - z * MathUtil.sin(theta)),y, (float) (z * MathUtil.cos(theta) + x * MathUtil.sin(theta)));
    }
    public Vector3F rotateX(float theta){
        return new Vector3F(x,(float) (y * MathUtil.cos(theta) - z * MathUtil.sin(theta)), (float) (z * MathUtil.cos(theta) + y * MathUtil.sin(theta)));
    }

    public Vector3F normalise() {
        double length = length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        return this;
    }

    public Vector3F set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
