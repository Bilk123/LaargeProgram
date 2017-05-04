package math;

import static math.MathUtil.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class Matrix4F {
    private float mat[];
    public Matrix4F() {
        mat = new float[16];
    }
    
    public Matrix4F(float diagonalFill) {
        mat = new float[16];
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (x == y) {
                    setElement(x, y, diagonalFill);
                } else {
                    setElement(x, y, 0);
                }
            }
        }
    }

    public Matrix4F(float[] mat) {
        this.mat = mat;
    }

    public Matrix4F intiIdentity() {
        setElement(0, 0, 1);setElement(0, 1, 0);setElement(0, 2, 0);setElement(0, 3, 0);
        setElement(1, 0, 0);setElement(1, 1, 1);setElement(1, 2, 0);setElement(1, 3, 0);
        setElement(2, 0, 0);setElement(2, 1, 0);setElement(2, 2, 1);setElement(2, 3, 0);
        setElement(3, 0, 0);setElement(3, 1, 0);setElement(3, 2, 0);setElement(3, 3, 1);
        return this;
    }
    public Matrix4F initTranslation(float x, float y, float z) {
        setElement(0, 0, 1);setElement(0, 1, 0);setElement(0, 2, 0);setElement(0, 3, x);
        setElement(1, 0, 0);setElement(1, 1, 1);setElement(1, 2, 0);setElement(1, 3, y);
        setElement(2, 0, 0);setElement(2, 1, 0);setElement(2, 2, 1);setElement(2, 3, z);
        setElement(3, 0, 0);setElement(3, 1, 0);setElement(3, 2, 0);setElement(3, 3, 1);
        return this;
    }

    public Matrix4F initRotation(float x, float y, float z) {
        Matrix4F rx = new Matrix4F();
        Matrix4F ry = new Matrix4F();
        Matrix4F rz = new Matrix4F();


        rz.setElement(0, 0,  (float) cos(z));rz.setElement(0, 1,  (float)-sin(z));rz.setElement(0, 2,  0);         rz.setElement(0, 3,  0);
        rz.setElement(1, 0,  (float) sin(z));rz.setElement(1, 1,  (float) cos(z));rz.setElement(1, 2,  0);         rz.setElement(1, 3,  0);
        rz.setElement(2, 0,  0);             rz.setElement(2, 1,  0);             rz.setElement(2, 2,  1);         rz.setElement(2, 3,  0);
        rz.setElement(3, 0,  0);             rz.setElement(3, 1,  0);             rz.setElement(3, 2,  0);         rz.setElement(3, 3,  1);
        
        rx.setElement(0, 0,  1);             rx.setElement(0, 1,  0);             rx.setElement(0, 2,  0);             rx.setElement(0, 3,  0);
        rx.setElement(1, 0,  0);             rx.setElement(1, 1,  (float) cos(x));rx.setElement(1, 2,  (float)-sin(x));rx.setElement(1, 3,  0);
        rx.setElement(2, 0,  0);             rx.setElement(2, 1,  (float) sin(x));rx.setElement(2, 2,  (float) cos(x));rx.setElement(2, 3,  0);
        rx.setElement(3, 0,  0);             rx.setElement(3, 1,  0);             rx.setElement(3, 2,  0);             rx.setElement(3, 3,  1);
        
        ry.setElement(0, 0,  (float) cos(y));ry.setElement(0, 1,  0);ry.setElement(0, 2,  (float)-sin(y)); ry.setElement(0, 3,  0);
        ry.setElement(1, 0,  0);             ry.setElement(1, 1,  1);ry.setElement(1, 2,  0);              ry.setElement(1, 3,  0);
        ry.setElement(2, 0,  (float) sin(y));ry.setElement(2, 1,  0);ry.setElement(2, 2,  (float) cos(y)); ry.setElement(2, 3,  0);
        ry.setElement(3, 0,  0);             ry.setElement(3, 1,  0);ry.setElement(3, 2,  0);              ry.setElement(3, 3,  1);

        mat = rz.mul(ry.mul(rx)).getMat();
        return this;
    }
    public Matrix4F initScale(float x, float y, float z) {
        setElement(0, 0,  x);setElement(0, 1,  0);setElement(0, 2,  0);setElement(0, 3,  0);
        setElement(1, 0,  0);setElement(1, 1,  y);setElement(1, 2,  0);setElement(1, 3,  0);
        setElement(2, 0,  0);setElement(2, 1,  0);setElement(2, 2,  z);setElement(2, 3,  0);
        setElement(3, 0,  0);setElement(3, 1,  0);setElement(3, 2,  0);setElement(3, 3,  1);
        return this;
    }
    public float[] getMat(){return mat;}
    
    public void setElement(int x, int y, float val) {
        if (x >= 0 && x < 4 && y >= 0 && y < 4) {
            mat[x + y * 4] = val;
        } else {
            System.out.println("invalid element of matrix referenced");
        }
    }

    public float getElement(int x, int y) {
        if (x >= 0 && x < 4 && y >= 0 && y < 4) {
            return mat[x + y * 4];
        } else {
            System.out.println("invalid element of matrix referenced");
            return 0;
        }
    }

    @Override
    public String toString() {
        String matrix = "[";
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                matrix += getElement(x, y);
                if (x < 3) {
                    matrix += ", ";
                } else {
                    matrix += "]\n";
                }
            }
        }
        return matrix;
    }

    public Matrix4F mul(Matrix4F m) {
        Matrix4F result = new Matrix4F(0);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                float sum = 0;
                for (int i = 0; i < 4; i++) {
                    sum += getElement(i, y) * m.getElement(x, i);
                }
                result.setElement(x, y, sum);
            }
        }
        return result;
    }

    public Vector3F mul(Vector3F v) {
        Vector3F vec = new Vector3F();
        float element[] = new float[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                element[i] = getElement(i, 0) * v.x + getElement(i, 1) * v.y + getElement(i, 2) * v.z + getElement(i, 3);
            }
        }
        vec.set(element[0], element[1], element[2]);
        return vec;
    }
}
