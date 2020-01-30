package draw;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public final class FigureManagement {

    public ArrayList<Figure> list = new ArrayList<Figure>();

    public FigureManagement(){

    }

    public void add(Figure f){
        list.add(f);
    }

    public void draw(Graphics g){
        for(Figure f : list){
            f.draw(g);
        }
    }

    public void print(Logger logger){
        for(Figure f : list){
            f.print(logger);
        }
    }

    public InFigure inFigure(int x, int y){
        for(Figure f: list){
            if(f.inFigure(x, y) != null)
                return f.inFigure(x, y);
        }
        return null;
    }

}
