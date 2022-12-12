import javax.swing.*;
import java.awt.*;

public class GUI_Grid_Display extends JPanel {
    private JFrame frame;
    Row_shape rowToDisplay;
    U_shape uToDisplay;
    String planName;
    public GUI_Grid_Display(Row_shape rowToDisplay, String nameOfPlan){
        this.rowToDisplay = rowToDisplay;
        planName = nameOfPlan;
        frame = new JFrame(planName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        frame.setResizable(true);
        frame.setSize(800,600);

        frame.setLayout(new GridLayout(rowToDisplay.getXdimension(),rowToDisplay.getYdimension(),0,50));

        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
    public GUI_Grid_Display(U_shape uToDisplay, String nameOfPlan){
        this.uToDisplay = uToDisplay;
        planName = nameOfPlan;
        frame = new JFrame(planName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        frame.setResizable(true);
        frame.setSize(800,600);


        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
}
