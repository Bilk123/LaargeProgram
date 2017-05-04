package math;

import static math.MathUtil.*;

/**
 * Created by Blake on 4/23/2017.
 */
public class TriangleRH {
    private float adj, opp, hyp;

    public TriangleRH(float adj, float opp, float hyp) {
        this.adj = adj;
        this.opp = opp;
        this.hyp = hyp;
    }

    public float sin() {
        return opp / hyp;
    }

    public float cos() {
        return adj / hyp;
    }

    public float tan() {
        return opp / adj;
    }

    public float theta() {
        float theta = (float)Math.toDegrees(arctan(Math.abs(opp), Math.abs(adj)));
        if (opp >= 0 && adj >= 0) return theta;
        if (opp >= 0 && adj < 0) return theta + 90;
        if (opp < 0 && adj < 0) return theta + 180;
        else return theta + 270;
    }

    public float getReducedTheta(){
        return (float)Math.toDegrees(arctan(Math.abs(opp), Math.abs(adj)));
    }

    public float getAdj() {
        return adj;
    }

    public float getHyp() {
        return hyp;
    }

    public float getOpp() {
        return opp;
    }
}
