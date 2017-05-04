package graphics.shapes;


import graphics.ResourceLoader;
import math.Vector3F;

/**
 * Created by Blake on 2/27/2017.
 */
public class Sphere extends Mesh {

    public Sphere(){
        super();
        Mesh temp = ResourceLoader.loadMesh("sphere.obj");
        vertices = new Vector3F[temp.vertices.length];
        for(int i =0;i<vertices.length;i++){
            vertices[i] = temp.vertices[i].mul(0.5f);
        }

        indices = temp.indices;
        size = indices.length;
        transformed = new Vector3F[vertices.length];
        update();
    }
}
