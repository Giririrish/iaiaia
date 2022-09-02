import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI_Create_Plan extends JPanel implements ActionListener {
    private JFrame frame;
    JButton ManualRegButton;
    JButton FileRegButton;


    public GUI_Create_Plan(){
        frame = new JFrame("Create Plan Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);

        if(GUI_Add_Register.ManualEntryReg != null) {
            ManualRegButton = new JButton("Manually Input Reg");
            ManualRegButton.setBounds(10, 40, 150, 50);
            ManualRegButton.addActionListener(this);
            frame.add(ManualRegButton);

        }
        if (GUI_Add_Register.FileEntryReg != null) {
            FileRegButton = new JButton("File Loaded Reg");
            FileRegButton.setBounds(170, 40, 150, 50);
            FileRegButton.addActionListener(this);
            frame.add(FileRegButton);
        }


        frame.setResizable(true);
        frame.setSize(800,400);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

    }
}
