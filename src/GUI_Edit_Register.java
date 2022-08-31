import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Edit_Register extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    JTextArea big;
    JButton ManualRegButton;
    JButton FileRegButton;

    JButton SaveRegButton;
    JTextField SaveFileNameField;

    JButton AddPupilButton;
    JTextField AddPupilButtonDetails;

    JButton SetPupilButton;
    JTextField SetPupilButtonDetails;


    public GUI_Edit_Register(){
        frame = new JFrame("Edit Register Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);

        //GUI_Add_Register.ManualEntryReg.SaveRegister(GUI_Add_Register.ManualEntryReg.fileName);

        big = new JTextArea(30, 33 );
        big.setBounds(500, 10,250,550);
        big.setEditable(false);

        if(GUI_Add_Register.ManualEntryReg != null) {
            ManualRegButton = new JButton(GUI_Add_Register.ManualEntryReg.fileName);
            ManualRegButton.setBounds(10, 40, 150, 50);
            ManualRegButton.addActionListener(this);
            frame.add(ManualRegButton);

        }
        if (GUI_Add_Register.FileEntryReg != null) {
            FileRegButton = new JButton(GUI_Add_Register.FileEntryReg.fileName);
            FileRegButton.setBounds(170, 40, 150, 50);
            FileRegButton.addActionListener(this);
            frame.add(FileRegButton);
        }




        frame.add(big);
        frame.setResizable(true);
        frame.setSize(800,600);
        frame.getContentPane().add(this);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GUI_Add_Register.ManualEntryReg.fileName)) {
            big.setText("");
            String TempFN;
            String TempLN;
            String TempSex;
            for (int x = 0; x < GUI_Add_Register.ManualEntryReg.getSize(); x++) {
                TempFN = GUI_Add_Register.ManualEntryReg.getPupil(x).getFirstName();
                TempLN = GUI_Add_Register.ManualEntryReg.getPupil(x).getLastName();
                if (GUI_Add_Register.ManualEntryReg.getPupil(x).getSex()) {
                    TempSex = "g";
                } else {
                    TempSex = "b";
                }
                big.append(TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            big.repaint();
        } else if (e.getActionCommand().equals(GUI_Add_Register.FileEntryReg.fileName)) {
            big.setText("");
            String TempFN;
            String TempLN;
            String TempSex;
            for (int x = 0; x < GUI_Add_Register.FileEntryReg.getSize(); x++) {
                TempFN = GUI_Add_Register.FileEntryReg.getPupil(x).getFirstName();
                TempLN = GUI_Add_Register.FileEntryReg.getPupil(x).getLastName();
                if (GUI_Add_Register.FileEntryReg.getPupil(x).getSex()) {
                    TempSex = "g";
                } else {
                    TempSex = "b";
                }
                big.append(TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            big.repaint();
        }
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
            System.out.println("insert");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}