package math;

/**
 * Created by Blake on 4/17/2017.
 */
public class Matrix3F {
    private float mat[];

    public Matrix3F(float diagonalFill) {
        mat = new float[9];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (x == y) {
                    setElement(x, y, diagonalFill);
                } else {
                    setElement(x, y, 0);
                }
            }
        }
    }

    public Matrix3F(float[] mat) {
        this.mat = mat;
    }

    public static Matrix4F identity() {
        return new Matrix4F(1);
    }

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
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
                element[i] = getElement(i, 0) * v.x + getElement(i, 1) * v.y + getElement(i, 2) * v.z;
            }
        }
        vec.set(element[0], element[1], element[2]);
        return vec;
    }
}
