package core;

import java.util.ArrayList;

/**
 * Created by Blake on 2/26/2017.
 */
public class Util {
    public static String[] removeEmptyStrings(String[] data){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0;i<data.length;i++){
            if(!data[i].equals("")){
                result.add(data[i]);
            }
        }
        String[]res = new String[result.size()];
        result.toArray(res);
        return res;
    }

    public static int[] toIntArray(Integer[] indexData) {
        int[]res = new int[indexData.length];
        for(int i =0;i<indexData.length;i++){
            res[i] = indexData[i].intValue();
        }
        return res;
    }
}
