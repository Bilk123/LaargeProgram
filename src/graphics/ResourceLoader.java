package graphics;


import core.Main;
import core.Util;
import graphics.shapes.Mesh;
import math.Vector3F;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Created by Blake on 2/26/2017.
 */
public class ResourceLoader {

    public static Mesh loadMesh(String fileName){
        String [] splitArray = fileName.split("\\.");
        for(int i =0;i<splitArray.length;i++){
            System.out.println(splitArray[i]);
        }
        String ext= splitArray[splitArray.length-1];
        if(!ext.equals("obj")){
            System.err.println("Error: file format not supported for mesh data: "+ ext);
            new Exception().printStackTrace();
            System.exit(1);
        }
        ArrayList<Integer> indices=new ArrayList<>();
        ArrayList<Vector3F> vertices= new ArrayList<>();
        BufferedReader br;
        try {
            String line = "";
            br = new BufferedReader(new InputStreamReader(Main.getResource(fileName)));
            while((line = br.readLine())!=null){
                String [] tokens = line.split(" ");
                tokens = Util.removeEmptyStrings(tokens);
                if(tokens.length ==0||tokens[0].equals("#")){
                    continue;
                }else if(tokens[0].equals("v")){
                    vertices.add(new Vector3F(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]),Float.valueOf(tokens[3])));
                }else if(tokens[0].equals("f")){
                    for(int i = 1;i<4;i++)
                    indices.add(Integer.parseInt(tokens[i])-1);
                }
            }
            Vector3F [] vertexData = new Vector3F[vertices.size()];
            vertexData = vertices.toArray(vertexData);
            Integer[] indexData = new Integer[indices.size()];
            indexData = indices.toArray(indexData);
            Mesh res = new Mesh(vertexData, Util.toIntArray(indexData));
            return res;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
