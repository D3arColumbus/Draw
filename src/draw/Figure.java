package draw;

import java.awt.*;
import java.util.logging.Handler;
import java.util.logging.Logger;

public abstract class Figure {

    public Point p1, p2;
    public String name = "Figure";

    public Figure(Point p1, Point p2){
        setP1(p1);
        setP2(p2);
    }

    public Figure(int x, int y){
        setP1(x, y);
        setP2(x, y);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP1(int x, int y){
        p1 = new Point(x, y);
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP2(int x, int y){
        this.p2 = new Point(x, y);
    }

    public void draw(Graphics g){
        p1.draw(g);
        p2.draw(g);
    }

    public abstract InFigure inFigure(int x, int y);

    public void move(int x, int y, int oldX, int oldY){
        p1.move(x, y, oldX, oldY);
        p2.move(x, y, oldX, oldY);

    }

    public void rearrange(){
        
    }

    public void setP3(){

    }

    //For logging
    public void print(Logger logger){
        logger.info("P1: x " + p1.getX() + " y " + p1.getY() + "P2: x " + p2.getX() + " y " + p2.getY());
    }
}
