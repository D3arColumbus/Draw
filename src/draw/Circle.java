package draw;

import java.awt.*;

public class Circle extends Figure {

    public Circle(Point p1, Point p2) {
        super(p1, p2);
    }

    public Circle(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g){
        super.draw(g);
        g.drawOval(p1.getX()-getRadius(),p1.getY() - getRadius(),getRadius()*2,getRadius()*2);
    }

    @Override
    public InFigure inFigure(int x, int y) {
        if(p1.inPoint(x,y) != null){
            return new InFigure(this, p1);
        }else if(p2.inPoint(x,y) != null){
            return new InFigure(this, p2);
        }
        if(radius(x, y) < getRadius())
            return new InFigure(this, null);
        return null;
    }

    private int radius(int x, int y){
        int dx = x - p1.getX();
        int dy = y - p1.getY();
        return (int) Math.sqrt(dx*dx+dy*dy);
    }

    private int getRadius(){
        return radius(p2.getX(), p2.getY());

    }


}
