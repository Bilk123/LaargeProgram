package core;

/**
 * Created by Blake on 4/17/2017.
 */
public class Time {
    public static final int SECOND = 1000000000;
    private static double deltaTime = 0;

    public static long getTime() {
        return System.nanoTime();
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static void setDeltaTime(double deltaTime) {
        Time.deltaTime = deltaTime;
        //System.out.println("engineEditor.Time.setDeltaTime: " + deltaTime);
    }
}
