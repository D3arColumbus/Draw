package draw;

import java.awt.*;
import java.util.ArrayList;


public final class FigureManagement {

    public ArrayList<Figure> list = new ArrayList<Figure>();

    public FigureManagement(){   }

    public void add(Figure f){
        list.add(f);
    }

    public void draw(Graphics g){
        for(Figure f : list){
            f.draw(g);
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
