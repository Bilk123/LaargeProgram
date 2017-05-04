package graphics.shapes;

import math.Vector3F;

import static graphics.RenderUtil.drawLine;

/**
 * Created by Blake on 5/3/2017.
 */
public class Plane extends Mesh{
    private static int dim = 3;

    public Plane() {
        super();
        vertices = new Vector3F[dim * dim];
        indices = new int[0];
        transformed = new Vector3F[vertices.length];
        size = indices.length;
        for(int x =0;x<dim;x++){
            for(int z =0;z<dim;z++){
                vertices[z*dim+x] = new Vector3F((float)(x-(double)(dim-1)/2.0),0,(float)(z-(double)(dim-1)/2.0));
            }
        }

        update();
    }

    @Override
    public void draw() {
        // super.draw();
        for(int x =0;x<dim-1;x++){
            for(int z = 0;z<dim-1;z++){
                drawLine(transformed[(z)*dim+(x)],transformed[(z)*dim+(x+1)]);
                drawLine(transformed[(z+1)*dim+(x)],transformed[(z)*dim+(x+1)]);
                drawLine(transformed[(z+1)*dim+(x)],transformed[(z)*dim+(x)]);
                if(x == dim-2){
                    drawLine(transformed[(z)*dim+(x+1)],transformed[(z+1)*dim+(x+1)]);
                }
                if(z == dim-2){
                    drawLine(transformed[(z+1)*dim+(x)],transformed[(z+1)*dim+(x+1)]);
                }
            }
        }
    }

}
