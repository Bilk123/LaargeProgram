package graphics.shapes;

import math.Transform;
import math.Vector3F;

import static graphics.RenderUtil.drawLine;

/**
 * Created by Blake on 5/3/2017.
 */
public class Mesh {
    protected Transform transform;
    protected int size;
    protected int[] indices;
    protected Vector3F[] vertices;
    protected Vector3F[] transformed;
    public Mesh(Vector3F[] vertices, int[] indices){
        transform = new Transform();
        size = indices.length;
        this.vertices = vertices;
        this.indices = indices;
        transformed = new Vector3F[vertices.length];
        update();
    }

    public Mesh(){
        transform = new Transform();
    }

    public void draw(){
        for(int i =0;i<size-1;i+=3){
            drawLine(transformed[indices[i]],transformed[indices[i+1]]);
            drawLine(transformed[indices[i+1]],transformed[indices[i+2]]);
            drawLine(transformed[indices[i+2]],transformed[indices[i]]);
        }

    }

    public void rotate(float x, float y, float z){
        transform.rotate(x,y,z);
    }

    public void rotate(Vector3F rotate){
        transform.rotate(rotate);
    }

    public void scale(float x, float y, float z){
        transform.scale(x,y,z);
    }

    public void scale(Vector3F scale){
        transform.scale(scale);
    }

    public void translate(float x, float y, float z){
        transform.translate(x,y,z);
    }

    public void translate(Vector3F translation){
        transform.translate(translation);
    }

    public void setRotation(Vector3F rotate){
        transform.setRotation(rotate);
    }

    public void setRotation(float x, float y, float z){
        transform.setRotation(x,y,z);
    }

    public void setTranslation(Vector3F translation){
        transform.setTranslation(translation);
    }

    public void setTranslation(float x, float y, float z){
        transform.setTranslation(x,y,z);
    }

    public void setScale(float x, float y, float z){
        transform.setScale(x,y,z);
    }

    public void setScale(Vector3F scale){
        transform.setScale(scale);
    }

    public void update(){
        for(int i =0;i<vertices.length;i++){
            transformed[i] = transform.getTransformation().mul(vertices[i]);
        }
    }

}
