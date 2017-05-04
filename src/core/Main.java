package core;

import core.screens.MainScreen;

import javax.swing.*;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 * Created by Blake on 4/17/2017.
 */
public class Main implements Runnable{
    private Thread thread;
    private boolean running = false;
    private JFrame frame;
    public static final String TITLE = "Voxel Editor 2.0";
    public static final int WIDTH = 1280;
    public static final int HEIGHT = (int)(WIDTH*9.0/16.0);
    public static MainScreen editor;
    public static DecimalFormat df = new DecimalFormat("#.###");
    public Main(){
        editor = new MainScreen(WIDTH, HEIGHT);
        initFrame();
    }

    private void initFrame(){
        frame = new JFrame(TITLE);
        frame.setResizable(false);
        frame.add(editor);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main().start();
    }

    public synchronized void start(){
        thread  = new Thread(this, TITLE);
        running = true;
        thread.start();
    }

    public void stop(){
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render(){
        editor.repaint();
    }

    public void update(){
        editor.update();
        Input.update();
    }

    @Override
    public void run() {
        long lastTime = Time.getTime();
        final double ns = Time.SECOND / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        editor.requestFocus();
        while (running) {
            long now = Time.getTime();
            delta += (now - lastTime) / ns;
            Time.setDeltaTime(delta / 60.0);
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
                updates++;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(TITLE + " | " + updates + " ups, " + frames + " fps");
                frames = 0;
                updates = 0;
            }
        }
        stop();
    }

    public static InputStream getResource(String fileName) {
        if (!ClassLoader.getSystemResourceAsStream(fileName).equals("null")) {
            System.out.println("resource loaded: " + fileName);
        } else {
            System.out.println("resource: " + fileName + " could not be found");
        }
        return ClassLoader.getSystemResourceAsStream(fileName);
    }

}
