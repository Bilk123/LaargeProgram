package core.circuits;

import core.Direction;
import graphics.RenderUtil;
import math.Vector2F;

import java.awt.*;

import static core.screens.Screen.g2d;

/**
 * Created by Blake on 4/27/2017.
 */
public class IndependentVoltageSource extends CircuitComponent {
    private double voltage;
    private String label;
    private Vector2F positiveTerminal, negativeTerminal;
    private Vector2F mid;
    private Direction direction;

    public IndependentVoltageSource(String label, Vector2F mid, Direction direction) {
        negativeTerminal = mid.add(direction.getDirection().mul(-0.15f));
        positiveTerminal = mid.add(direction.getDirection().mul(0.15f));
        this.direction = direction;
        this.mid = mid;
        this.label = label;
    }

    @Override
    public void draw() {
        g2d.setColor(Color.CYAN);
        RenderUtil.drawCircle(0.2f, mid,15);
        RenderUtil.drawLine(positiveTerminal,mid.add(direction.getDirection().div(2)));
        RenderUtil.drawLine(negativeTerminal,mid.sub(direction.getDirection().div(2)));
        g2d.setColor(Color.WHITE);
        RenderUtil.drawLine(positiveTerminal.sub(new Vector2F(0.05f, 0)), positiveTerminal.add(new Vector2F(0.05f, 0)));
        RenderUtil.drawLine(positiveTerminal.sub(new Vector2F(0, 0.05f)), positiveTerminal.add(new Vector2F(0, 0.05f)));
        RenderUtil.drawLine(negativeTerminal.sub(new Vector2F(0.05f, 0)), negativeTerminal.add(new Vector2F(0.05f, 0)));
        g2d.setColor(Color.white);
        RenderUtil.drawStringInSpace(label, mid, 0.1f);
    }


    public Vector2F getPositiveTerminal() {
        return positiveTerminal.add(direction.getDirection().mul(0.05f));
    }

    public Vector2F getNegativeTerminal() {
        return negativeTerminal.add(direction.getDirection().mul(-0.05f));
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }
}
