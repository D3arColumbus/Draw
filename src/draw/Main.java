package draw;

import javax.swing.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private JPanel panel1;
    public static int selectedFigure;
    public static ButtonGroup buttonGroupFigure;
    public static JRadioButtonMenuItem line;
    public static JRadioButtonMenuItem circle;
    public static JRadioButtonMenuItem rectangle;

    public static void main(String[] args) {
        //Logger
        Logger logger = Logger.getLogger("Logger");
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        JFrame frame = new JFrame("Main");
        //Menu
        //Init
        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");
        JMenu Figures = new JMenu("Figurs");
        line = new JRadioButtonMenuItem("Line");
        circle = new JRadioButtonMenuItem("Circle");
        rectangle = new JRadioButtonMenuItem("Rectangle");
        //Listener
        FigureListener listener = new FigureListener();
        line.addActionListener(listener);
        circle.addActionListener(listener);
        rectangle.addActionListener(listener);
        //ButtonGroup
        buttonGroupFigure = new ButtonGroup();
        buttonGroupFigure.add(line);
        buttonGroupFigure.add(circle);
        buttonGroupFigure.add(rectangle);
        //Post-Init
        Figures.add(line);
        Figures.add(circle);
        Figures.add(rectangle);
        menuBar.add(File);
        menuBar.add(Figures);
        frame.setJMenuBar(menuBar);

        frame.setContentPane(new PanelDraw());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //1 = Line
    //2 = Circle
    //3 = Rectangle
    public static void RadioButtonCircleActionPerformed(java.awt.event.ActionEvent evt){
        if(buttonGroupFigure.getSelection() == line.getModel()){
            selectedFigure = 1;
        }else if(buttonGroupFigure.getSelection() == circle.getModel()){
            selectedFigure = 2;
        }else if(buttonGroupFigure.getSelection() == rectangle.getModel()){
            selectedFigure = 3;
        }
    }


}
