package core.questions.onlineTut4;

import core.System3D;
import core.mechanics2D.PositionVector2F;
import core.mechanics3D.CoupleMoment3D;
import core.mechanics3D.ForceVector3F;
import core.mechanics3D.Moment3D;
import core.mechanics3D.PositionVector3F;
import math.Vector3F;

import static math.MathUtil.addAll;
import static math.MathUtil.cosf;
import static math.MathUtil.sinf;

/**
 * Created by Blake on 4/23/2017.
 */
public class Q3 extends System3D {
    public Q3() {
        super();
        PositionVector3F OA, AB, BC;
        float d = 0.4276f;
        OA = new PositionVector3F(0.35f, 0, 0, 0);
        AB = new PositionVector3F(0, -d * cosf(30), d * sinf(30), 0);
        BC = new PositionVector3F(0.25f, 0, 0, 0);
        structure.add(OA);
        structure.add(AB);
        structure.add(BC);
        ForceVector3F F1 = new ForceVector3F(0, 0, 35, 35, addAll(false, OA, AB), 0.15f);
        ForceVector3F F2 = new ForceVector3F(50, 0, 0, 50, addAll(false, OA), 0.15f);

        Vector3F p1 = addAll(true, OA);
        System.out.println(" - ");
        Vector3F p2 = addAll(true, OA, AB);
        Vector3F r = p2.sub(p1);
        Vector3F temp = new Vector3F(F1.x, F1.y, F1.z);
        temp.normalise();
        System.out.println();
        System.out.println("r: " + r);
        System.out.println("F: " + temp.mul(F1.getLength()));
        System.out.println();
        System.out.println("M1 =");
        Moment3D m1 = new CoupleMoment3D(new PositionVector3F(r.x, r.y, r.z, 0), F1, p1);
        moments.add(m1);
        System.out.println();
        p1 = addAll(true, OA, AB, BC);
        System.out.println(" - ");
        p2 = addAll(true,OA);
        r = p2.sub(p1);
        temp = new Vector3F(F2.x, F2.y, F2.z);
        temp.normalise();
        System.out.println("r: " + r);
        System.out.println("F: " + temp.mul(F2.getLength()));
        System.out.println();
        System.out.println("M2 =");

        Moment3D m2 = new CoupleMoment3D(new PositionVector3F(r.x, r.y, r.z, 0), F2, p1);
        moments.add(m2);

        System.out.println(m1.getMoment().add(m2.getMoment()).length());
        update();
    }
}
