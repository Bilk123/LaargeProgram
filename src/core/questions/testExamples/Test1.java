package core.questions.testExamples;

import core.Direction;
import core.circuits.Circuit;
import core.circuits.CircuitComponent;
import core.circuits.IndependentVoltageSource;
import core.circuits.Node;
import math.Vector2F;

import static core.circuits.CircuitComponent.getLocationOnCircuit;


/**
 * Created by Blake on 4/25/2017.
 */
public class Test1 extends Circuit {

    public Test1() {
        super();
        IndependentVoltageSource v1 = new IndependentVoltageSource("V1", getLocationOnCircuit(0,1), Direction.NORTH);
        Node a = new Node(getLocationOnCircuit(0,0),"a");
        a.add(v1);
        nodes.add(a);
    }
}
