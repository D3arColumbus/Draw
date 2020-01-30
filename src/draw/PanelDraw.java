package draw;

import javax.swing.*;
import java.awt.*;

public class PanelDraw extends JPanel {

    private FigureManagement figures = new FigureManagement();
    private InFigure currentFigure = new InFigure();
    private boolean moving = false;
    private int oldX;
    private int oldY;

    //Sets size and creates mouseListener
    PanelDraw(){
        setMinimumSize(new Dimension(500,500));
        setPreferredSize(new Dimension(500,500));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
    }

    //draws all figure
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(currentFigure.getFigure() != null){
            currentFigure.getFigure().draw(g);
        }
        figures.draw(g);

    }

    private void formMouseDragged(java.awt.event.MouseEvent evt) {
        if(moving){
            //old figure is being moved
            if(currentFigure.getPoint() != null){
                currentFigure.getPoint().move(evt.getX(), evt.getY(), oldX, oldY);
                currentFigure.getFigure().setP3();
            }else{
                currentFigure.getFigure().move(evt.getX(), evt.getY(), oldX, oldY);
            }
            oldX = evt.getX();
            oldY = evt.getY();
        }else{
            //new figure is moved
            currentFigure.getFigure().setP2(evt.getX(), evt.getY());
        }
        repaint();
    }

    private void formMousePressed(java.awt.event.MouseEvent evt){
        currentFigure = figures.inFigure(evt.getX(), evt.getY());
        if(currentFigure != null){
            //old figure will be moved
            moving = true;
            oldX = evt.getX();
            oldY = evt.getY();
        }else{
            //a new figure is created
            moving = false;
            currentFigure = new InFigure();
            //1 = line
            //2 = circle
            //3 = rectangle
            switch (Main.selectedFigure){
                case 1:
                    currentFigure.setFigure(new Line(evt.getX(), evt.getY()));
                    break;
                case 2:
                    currentFigure.setFigure(new Circle(evt.getX(), evt.getY()));
                    break;
                case 3:
                    currentFigure.setFigure(new Rectangle(evt.getX(), evt.getY()));
                    break;
                default:
                    break;
            }
        }
        repaint();
    }

    private void formMouseReleased(java.awt.event.MouseEvent evt){
        currentFigure.getFigure().rearrange();
        if(!moving){
            //new figure is added to figure-list
            figures.add(currentFigure.getFigure());
            moving = false;
        }
        repaint();
    }


}
