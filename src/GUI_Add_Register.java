import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Add_Register extends JPanel implements ActionListener {
    private JFrame frame;
    public GUI_Add_Register(){
        frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);
        frame.setResizable(true);
        frame.setSize(800,400);
        frame.getContentPane().add(this);
        frame.setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {
    }
    }

