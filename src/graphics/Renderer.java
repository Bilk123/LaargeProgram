package graphics;

import core.Input;
import core.Main;
import core.Time;
import math.Matrix4F;
import math.Vector2F;
import math.Vector3F;

import static java.awt.event.KeyEvent.*;
import static math.MathUtil.*;

/**
 * Created by Blake on 4/17/2017.
 */
public class Renderer {
    public static float rotateX = 180, rotateY = 0, rotateZ = 0, zoom = 100;
    public static Vector3F translation = new Vector3F(0, -20, 10);

    public static Vector2F project(Vector3F vec) {
        Matrix4F rotateMat = new Matrix4F().initRotation(rotateY, rotateX, rotateZ);
        Matrix4F translateMat = new Matrix4F().initTranslation(translation.x, translation.y, translation.z);
        Vector3F temp = rotateMat.mul(translateMat.mul(vec));
        if (temp.z >= 0) {
            vec.projectZLessThanZero = true;
        } else {
            vec.projectZLessThanZero = false;
        }
        return new Vector2F((float) (temp.x * zoom / (temp.z) * sec(85) + Main.WIDTH / 2), (float) (temp.y * zoom / (temp.z) * sec(85) + Main.HEIGHT / 2));
    }

    public static Vector2F project(Vector2F vec) {
        Matrix4F rotateMat = new Matrix4F().initRotation(rotateY, rotateX, rotateZ);
        Matrix4F translateMat = new Matrix4F().initTranslation(translation.x, translation.y, translation.z);
        Vector3F temp = rotateMat.mul(translateMat.mul(new Vector3F(vec.x, vec.y, 0)));
        if (temp.z >= 0) {
            vec.projectZLessThanZero = true;
        } else {
            vec.projectZLessThanZero = false;
        }
        return new Vector2F((float) (temp.x * zoom / (temp.z) * sec(85) + Main.WIDTH / 2), (float) (temp.y * zoom / (temp.z) * sec(85) + Main.HEIGHT / 2));
    }

    public static void update() {
        if (Input.getKey(VK_RIGHT)) rotateX += 1;
        if (Input.getKey(VK_LEFT)) rotateX -= 1;
        if (Input.getKey(VK_UP)) rotateY += 1;
        if (Input.getKey(VK_DOWN)) rotateY -= 1;
        if (Input.getKey(VK_Q)) rotateZ -= 1;
        if (Input.getKey(VK_E)) rotateZ += 1;

        if (Input.getKey(VK_W))
            translation = translation.add(new Vector3F(0, 0, 2).mul((float) Time.getDeltaTime()).rotateY(-rotateX));
        if (Input.getKey(VK_S))
            translation = translation.add(new Vector3F(0, 0, -2).mul((float) Time.getDeltaTime()).rotateY(-rotateX));
        if (Input.getKey(VK_D))
            translation = translation.add(new Vector3F(2, 0, 0).mul((float) Time.getDeltaTime()).rotateY(-rotateX));
        if (Input.getKey(VK_A))
            translation = translation.add(new Vector3F(-2, 0, 0).mul((float) Time.getDeltaTime()).rotateY(-rotateX));

        if (Input.getKey(VK_SPACE))
            translation = translation.add(new Vector3F(0, -2, 0).mul((float) Time.getDeltaTime()));
        if (Input.getKey(VK_C))
            translation = translation.add(new Vector3F(0, 2, 0).mul((float) Time.getDeltaTime()));

        if (Input.getKeyDown(VK_R)) {
            translation.set(0, 0, -10);
            rotateX = 0;
            rotateY = 0;
            rotateZ = 0;
        }

    }
}
