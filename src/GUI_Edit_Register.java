import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Edit_Register extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    public GUI_Edit_Register(){
        frame = new JFrame("Edit Register Menu");
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

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}