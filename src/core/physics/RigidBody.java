package core.physics;

import core.Time;
import core.mechanics3D.ForceVector3F;
import graphics.shapes.Mesh;
import math.Vector3F;

/**
 * Created by Blake on 5/3/2017.
 */
public class RigidBody {
    private Mesh mesh;
    private Vector3F displacement;
    private Vector3F velocity;
    private Vector3F acceleration;
    private Vector3F com;
    private Vector3F moment;
    private Vector3F resultantForce;
    private float mass;
    private boolean groundCollision;

    public RigidBody(float mass, Vector3F displacement, Vector3F velocity, Vector3F acceleration, Mesh mesh) {
        this.displacement = displacement;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.mass = mass;
        resultantForce = new ForceVector3F(0,0,-1f,9.81f,com,1f);
        this.mesh = mesh;
    }

    public void draw() {
        mesh.draw();

    }

    public void update() {
        getResForce();
        acceleration = resultantForce.div(mass);
        velocity = velocity.add(acceleration.mul((float) Time.getDeltaTime()));
        displacement = displacement.add(velocity.mul((float) Time.getDeltaTime()));
        mesh.setTranslation(displacement);
        mesh.update();
    }

    public void getResForce() {
        resultantForce.set(0,0,0);
        Vector3F temp = new Vector3F();
        resultantForce=resultantForce.add(temp.set(0,mass*-9.81f,0));
        if(groundCollision)resultantForce=resultantForce.add(temp.set(0,-resultantForce.y,0));

    }

    public Mesh getMesh() {
        return mesh;
    }


}
