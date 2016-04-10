/******************************************************************************
 *  Compilation:  javac Turtle.java
 *  Execution:    java Turtle
 *
 *  Data type for turtle graphics using standard draw.
 *
 ******************************************************************************/
/**
* Modificado para su uso en CC3001
**/
import java.awt.Color;

public class Turtle {
    private double x, y;     // turtle is at (x, y)
    private double angle;    // facing this many degrees counterclockwise from the x-axis
    private boolean drawing;

    // start at (x0, y0), facing a0 degrees counterclockwise from the x-axis
    public Turtle(double x0, double y0, double a0, int w, int h){
        x = x0;
        y = y0;
        angle = a0;
        StdDraw.create(w,h);
        setXscale(0,w);
        setYscale(0,h);
        setPenDown();
    }

    // rotate orientation delta degrees counterclockwise
    public void turnLeft(double delta) {
        angle += delta;
    }

    public void turnRight(double delta) {
        angle -= delta;
    }

    // move forward the given amount, with the pen down
    public void goForward(double step) {
        double oldx = x;
        double oldy = y;
        x += step * Math.cos(Math.toRadians(angle));
        y += step * Math.sin(Math.toRadians(angle));
        if(drawing)
            StdDraw.line(oldx, oldy, x, y);
    }

    // pause t milliseconds
    public void pause(int t) {
        StdDraw.show(t);
    }

    public void setPenUp(){
        drawing = false;
    }

    public void setPenDown(){
        drawing = true;
    }

    public void setPenColor(Color color) {
        StdDraw.setPenColor(color);
    }

    public void setPenRadius(double radius) {
        StdDraw.setPenRadius(radius);
    }

    public void setCanvasSize(int width, int height) {
        StdDraw.setCanvasSize(width, height);
    }

    public void setXscale(double min, double max) {
        StdDraw.setXscale(min, max);
    }

    public void setYscale(double min, double max) {
        StdDraw.setYscale(min, max);
    }


    // sample client for testing
    public static void main(String[] args) {
        double x0 = 240.0;
        double y0 = 160.0;
        double a0 = 60.0;
        double step = 60;
        Turtle turtle  = new Turtle(x0, y0, a0, 480,320);
        turtle.setPenDown();
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
        turtle.goForward(step);
        turtle.turnLeft(120.0);
    }

}