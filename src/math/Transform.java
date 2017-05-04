package math;

/**
 * Created by Blake on 5/3/2017.
 */
public class Transform {
    private Vector3F translation;
    private Vector3F rotation;
    private Vector3F scale;

    public Transform() {
        translation = new Vector3F();
        rotation = new Vector3F(0,0,0);
        scale = new Vector3F(1, 1, 1);
    }

    public Matrix4F getTransformation() {
        Matrix4F translateMat = new Matrix4F().initTranslation(translation.getX(), translation.getY(), translation.getZ());
        Matrix4F rotateMat = new Matrix4F().initRotation(rotation.getX(), rotation.getY(), rotation.getZ());
        Matrix4F scaleMat = new Matrix4F().initScale(scale.getX(), scale.getY(), scale.getZ());
        return translateMat.mul(rotateMat.mul(scaleMat));
    }

    public Vector3F getTranslation() {
        return translation;
    }

    public Vector3F getRotation() {
        return rotation;
    }

    public Vector3F getScale() {
        return scale;
    }

    public void setTranslation(Vector3F translation) {
        this.translation = translation;
    }

    public void setTranslation(float x, float y, float z) {
        this.translation = new Vector3F(x, y, z);
    }

    public void setRotation(Vector3F rotation) {
        this.rotation = rotation;
    }

    public void setRotation(float x, float y, float z) {
        this.rotation.set(x, y, z);
    }

    public void setScale(Vector3F scale) {
        this.scale = scale;
    }

    public void setScale(float x, float y, float z) {
        this.scale = new Vector3F(x, y, z);
    }

    public void translate(Vector3F translation) {
        this.translation = this.translation.add(translation);
    }

    public void translate(float x, float y, float z) {
        this.translation = this.translation.add(new Vector3F(x, y, z));
    }

    public void rotate(float x, float y, float z) {
        this.rotation = rotation.add(new Vector3F(x, y, z));
    }

    public void rotate(Vector3F rotate) {
        this.rotation = rotation.add(rotate);
    }

    public void scale(float x, float y, float z) {
        this.scale = this.scale.add(new Vector3F(x, y, z));
    }

    public void scale(Vector3F scale) {
        this.scale = this.scale.add(scale);
    }

}
