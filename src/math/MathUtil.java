package math;

/**
 * Created by Blake on 4/17/2017.
 */
public class MathUtil {
    public static double sin(float deg) {
        return Math.sin(Math.toRadians(deg));
    }

    public static double cos(float deg) {
        return Math.cos(Math.toRadians(deg));
    }

    public static double tan(float deg) {
        return Math.sin(Math.toRadians(deg));
    }

    public static double sec(float deg) {
        return 1 / cos(deg);
    }

    public static double csc(float deg) {
        return 1 / sin(deg);
    }

    public static double cot(float deg) {
        return 1 / tan(deg);
    }

    public static float sinf(float deg) {
        return (float) Math.sin(Math.toRadians(deg));
    }

    public static float cosf(float deg) {
        return (float) Math.cos(Math.toRadians(deg));
    }

    public static float tanf(float deg) {
        return (float) Math.sin(Math.toRadians(deg));
    }

    public static float secf(float deg) {
        return 1 / cosf(deg);
    }

    public static float cscf(float deg) {
        return 1 / sinf(deg);
    }

    public static float cotf(float deg) {
        return 1 / tanf(deg);
    }

    //inverse trigonometric functions
    public static float arctan(float theta) {
        return (float) (Math.atan(theta));
    }//arc-tangent returns in radians

    public static float arctan(float y, float x) {
        return (float) (Math.atan2(y, x));
    }//arc-tangent returns in radians

    public static float arcsin(float theta) {
        return (float) Math.asin(theta);
    }//arc-sine returns in radians

    public static float arccos(float theta) {
        return (float) Math.acos(theta);
    }//arc-cosine returns in radians

    public static Vector3F addAll(boolean log, Vector3F... vecs) {
        Vector3F temp = new Vector3F(0, 0, 0);
        for (int i = 0; i < vecs.length; i++) {
            temp = temp.add(vecs[i]);
            if(i!=vecs.length-1&&log)
            System.out.print(vecs[i]+" + ");
            else if(log){
                System.out.print(vecs[i]);
            }
        }
        if(log)
        System.out.println(" = "+temp);

        return temp;
    }

    public static Vector2F addAll(Vector2F... vecs) {
        Vector2F temp = new Vector2F(0, 0);
        for (int i = 0; i < vecs.length; i++) temp = temp.add(vecs[i]);
        return temp;
    }

    public static float clamp(float val, float min, float max){
        if(val<min)return min;
        else if(val>max)return max;
        else return val;
    }
}
