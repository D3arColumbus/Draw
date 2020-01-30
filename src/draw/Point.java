package draw;

import java.awt.*;

public class Point {

    private int x, y;
    private final int LENGTH = 5;

    public Point(int x, int y){
        setXY(x,y);
    }

    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void draw(Graphics g){
        g.fillRect(getX()-LENGTH, getY()-LENGTH, LENGTH*2, LENGTH*2);
        g.drawRect(getX()-LENGTH, getY()-LENGTH, LENGTH*2, LENGTH*2);

    }

    public void draw(Graphics g, Color color){
        g.setColor(color);
        g.fillRect(getX()-LENGTH, getY()-LENGTH, LENGTH*2, LENGTH*2);
        g.drawRect(getX()-LENGTH, getY()-LENGTH, LENGTH*2, LENGTH*2);

    }

    public Point inPoint(int x, int y){
        if(getX()-LENGTH < x && x < getX() + LENGTH * 2)
            if(getY() - LENGTH < y && y < getY() + LENGTH * 2)
                return this;
        return null;
    }

    public void move(int x, int y, int oldX, int oldY){
        setX(this.x + (x - oldX));
        setY(this.y + (y - oldY));
    }

    public void print(){
        System.out.println("x: " + x + " y: " + y);
    }

}
