package draw;

import java.awt.*;

public class Line extends Figure {

    Point p3;
    public String name = "Line";

    public Line(Point p1, Point p2) {
        super(p1, p2);
        p3 = new Point(p1.getX(), p1.getY());
    }

    public Line(int x, int y) {
        super(x, y);
        p3 = new Point(x,y);
    }

    @Override
    public void setP2(int x, int y){
        p3 = new Point(x, y);
        super.setP2(x, y);
        setP3();
    }


    @Override
    public void setP3(){
        if(p1.getX() > p2.getX())
            p3.setX(p2.getX() + ((p1.getX() - p2.getX())/2));
        else
            p3.setX(p1.getX() + ((p2.getX() - p1.getX())/2));
        if(p1.getY() > p2.getY())
            p3.setY(p2.getY() + ((p1.getY() - p2.getY())/2));
        else
            p3.setY(p1.getY() + ((p2.getY() - p1.getY())/2));
    }
    public void draw(Graphics g){
        super.draw(g);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        p3.draw(g);
    }

    public InFigure inFigure(int x, int y){
        if(p1.inPoint(x,y) != null){
            return new InFigure(this, p1);
        }else if(p2.inPoint(x,y) != null){
            return new InFigure(this, p2);
        }
        if(p3.inPoint(x, y) != null)
            return new InFigure(this, null);
        return null;
    }

    @Override
    public void move(int x, int y, int oldX, int oldY) {
        super.move(x, y, oldX, oldY);
        p3.move(x, y, oldX, oldY);

    }





}
