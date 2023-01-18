import javax.swing.*;
import java.awt.*;

public class GUI_Grid_Display extends JPanel {
    private JFrame frame;
    JButton[][] buttons;
    JButton[] displayButtons;
    Row_shape rowToDisplay;
    U_shape uToDisplay;
    String planName;
    public GUI_Grid_Display(Row_shape rowToDisplay){
        this.rowToDisplay = rowToDisplay;
        frame = new JFrame(planName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        frame.setResizable(true);
        frame.setSize(800,600);


        frame.setLayout(new GridLayout(0,rowToDisplay.getYdimension(),0,0));

        buttons = new JButton[rowToDisplay.getXdimension()][rowToDisplay.getYdimension()];

        displayButtons = new JButton[rowToDisplay.getXdimension() * rowToDisplay.getYdimension()];
        String tempText;
        int counter1D = 0;
        for (int x = 0; x < rowToDisplay.getXdimension(); x++) {
                for (int y = 0 ; y < rowToDisplay.getYdimension() ; y++) {
                    tempText = rowToDisplay.grid[x][y].getFirstName();
                    displayButtons[counter1D] = new JButton(tempText);
                    displayButtons[counter1D].setVisible(true);
                    counter1D++;
            }
        }

        for (int i = 0; i< rowToDisplay.getXdimension() * rowToDisplay.getYdimension() ; i++) {
            frame.add(displayButtons[i]);
        }
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
    public GUI_Grid_Display(U_shape uToDisplay){
        this.uToDisplay = uToDisplay;
        frame = new JFrame(planName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        frame.setResizable(true);
        frame.setSize(800,600);

        frame.setLayout(new GridLayout(0 , uToDisplay.getXdimension() , 10, 10));

        buttons = new JButton[uToDisplay.getYdimension()][uToDisplay.getXdimension()];

        displayButtons = new JButton[uToDisplay.getYdimension() * uToDisplay.getXdimension()];

        String tempText;
        int counter1D = 0;
        for (int x = 0; x < uToDisplay.getYdimension(); x++) {
            for (int y = 0 ; y < uToDisplay.getXdimension() ; y++) {
                tempText = uToDisplay.grid[y][x].getFirstName();
                displayButtons[counter1D] = new JButton(tempText);
                displayButtons[counter1D].setVisible(true);
                counter1D++;
            }
        }
        for (int i = 0; i< uToDisplay.getXdimension() *uToDisplay.getYdimension() ; i++) {
            frame.add(displayButtons[i]);
        }
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
}
