package draw;

public class InFigure {

    private Figure figure;
    private Point point;

    public InFigure(){
        figure = null;
        point = null;
    }

    public InFigure(Figure f, Point o){
        figure = f;
        point = o;
    }

    public Figure getFigure() {
        return figure;
    }

    public Point getPoint() {
        return point;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public void setPoint(Point point) {
        this.point = point;
    }


}
