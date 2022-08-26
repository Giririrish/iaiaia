import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI_Add_Register extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    JButton ManualEnter;
    JButton FileEnter;
    JTextField ManualEntry;
    JTextField FileName;
    JLabel EntryCounter;
    //text field for .txt file , text field to enter a pupil
    public GUI_Add_Register(){
        frame = new JFrame("Add Register Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);
        ManualEnter = new JButton("Manual Enter");
        ManualEnter.setBounds(10,10,150,50);
        ManualEnter.addActionListener(this);
        FileEnter = new JButton("File Enter");
        FileEnter.setBounds(10,80,150,50);
        FileEnter.addActionListener(this);
        frame.add(ManualEnter);
        frame.add(FileEnter);
        frame.setResizable(true);
        frame.setSize(800,400);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Manual Enter")){
            System.out.println("MANUAL ENTER");
            ManualEntry = new JTextField();
            ManualEntry.setBounds(170, 10, 150 , 50);
            frame.add(ManualEntry);
            frame.repaint();
        } else if(e.getActionCommand().equals("File Enter")) {
            System.out.println("FILE ENTER");
            FileName = new JTextField();
            FileName.setBounds(170, 80, 150 , 50);
            frame.add(FileName);
            frame.repaint();
        }
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

