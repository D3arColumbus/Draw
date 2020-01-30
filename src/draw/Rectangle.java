package draw;

import java.awt.*;

public class Rectangle extends Figure {

    protected Point p3, p4;
    protected boolean movingp3p4 = false;

    public Rectangle(Point p1, Point p2) {
        super(p1, p2);
        p3 = p1;
        p4 = p1;
    }

    public Rectangle(int x, int y) {
        super(x, y);
        p3 = new Point(x, y);
        p4 = new Point(x, y);
    }

    public void rearrange(){

        int tmp = 0;
        if(p1.getX() > p3.getX()){
            tmp = p1.getX();
            p1.setX(p3.getX());
            p3.setX(tmp);
        }
        if(p1.getY() > p4.getY()){
            tmp = p1.getY();
            p1.setY(p4.getY());
            p4.setY(tmp);
        }
        if(p2.getX() < p4.getX()){
            tmp = p2.getX();
            p2.setX(p4.getX());
            p4.setX(tmp);
        }
        if(p2.getY() < p3.getY()){
            tmp = p2.getY();
            p2.setY(p3.getY());
            p3.setY(tmp);
        }
    }



    public void draw(Graphics g){
        if(movingp3p4){
            if(!p3.getX().equals(p2.getX()) || !p3.getY().equals(p1.getY())){
                p2.setX(p3.getX());
                p1.setY(p3.getY());
            }else if(!p4.getX().equals(p1.getX()) || !p4.getY().equals(p2.getY())){
                p1.setX(p4.getX());
                p2.setY(p4.getY());
            }
        }else{
            p3.setXY(p2.getX(), p1.getY());
            p4.setXY(p1.getX(), p2.getY());
        }

        if(p1.getX() < p2.getX()){ //p1 ist weiter links
            if(p1.getY() < p2.getY()){ //p1 ist weiter links und weiter oben
                g.drawRect(p1.getX(), p1.getY(), p2.getX()-p1.getX(), p2.getY()-p1.getY());
            } else { //p1 ist weiter links und niedriger
                g.drawRect(p1.getX(), p2.getY(), p2.getX()-p1.getX(), p1.getY()-p2.getY());
            }
        } else { //p2 ist weiter links
            if(p2.getY() < p1.getY()){//p2 ist weiter links und weiter oben
                g.drawRect(p2.getX(), p2.getY(), p1.getX()-p2.getX(), p1.getY()-p2.getY());
            } else { //p2 ist weiter links und niedriger
                g.drawRect(p2.getX(), p1.getY(), p1.getX()-p2.getX(), p2.getY()-p1.getY());
            }
        }
        super.draw(g);
        p3.draw(g);
        p4.draw(g);
    }


    @Override
    public InFigure inFigure(int x, int y) {
        if(p1.inPoint(x,y) != null){
            return new InFigure(this, p1);
        }else if(p2.inPoint(x,y) != null){
            return new InFigure(this, p2);
        }else if(p3.inPoint(x,y) != null){
            movingp3p4 = true;
            return new InFigure(this, p3);
        }else if(p4.inPoint(x,y) != null){
            movingp3p4 = true;
            return new InFigure(this, p4);
        }
        if(x > p1.getX() && x < p2.getX() ){
            if(y > p1.getY() && y < p2.getY()){
                return new InFigure(this, null);
            }
        }
        return null;
    }

    @Override
    public void move(int x, int y, int oldX, int oldY) {
        super.move(x, y, oldX, oldY);
       p3.move(x, y, oldX, oldY);
       p4.move(x, y, oldX, oldY);
    }


}
