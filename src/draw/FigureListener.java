package draw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FigureListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evt) {
        Main.RadioButtonCircleActionPerformed(evt);
    }
}
