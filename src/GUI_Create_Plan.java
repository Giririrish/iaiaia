import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI_Create_Plan extends JPanel implements ActionListener {
    private JFrame frame;
    JButton ManualRegButton;
    JButton FileRegButton;
    JTextArea MiniDisplay;
    JLabel selectReg;
    JLabel selectSort;
    JLabel selectShape;
    JRadioButton RegisterOrderCheck;
    JRadioButton BoyGirlBoyCheck;
    JRadioButton RowCheck;
    JRadioButton UCheck;
    JButton SaveSettings;
    int currentReg = 0;
    public GUI_Create_Plan(){
        frame = new JFrame("Create Plan Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);

        MiniDisplay = new JTextArea(30, 33 );
        MiniDisplay.setBounds(500, 10,250,550);
        MiniDisplay.setEditable(false);

        if(GUI_Add_Register.ManualEntryReg != null) {
            ManualRegButton = new JButton("Manually Reg");
            ManualRegButton.setBounds(10, 40, 150, 20);
            ManualRegButton.addActionListener(this);
            frame.add(ManualRegButton);

        }
        if (GUI_Add_Register.FileEntryReg != null) {
            FileRegButton = new JButton("File Reg");
            FileRegButton.setBounds(170, 40, 150, 20);
            FileRegButton.addActionListener(this);
            frame.add(FileRegButton);
        }
        //TODO Add Jlabels in between
        RowCheck = new JRadioButton("Row Shape");
        RowCheck.setBounds(10,120,150,20);
        RowCheck.setVisible(true);

        UCheck = new JRadioButton("'U' Shape");
        UCheck.setBounds(170,120,150,20);
        UCheck.setVisible(true);

        RegisterOrderCheck = new JRadioButton("Register Order");
        RegisterOrderCheck.setBounds(10,200,150,20);
        RegisterOrderCheck.setVisible(true);

        BoyGirlBoyCheck = new JRadioButton("Boy-Girl-Boy");
        BoyGirlBoyCheck.setBounds(170,200,150,20);
        BoyGirlBoyCheck.setVisible(true);

        frame.add(RowCheck);
        frame.add(UCheck);
        frame.add(RegisterOrderCheck);
        frame.add(BoyGirlBoyCheck);
        frame.add(MiniDisplay);
        frame.setResizable(true);
        frame.setSize(800,600);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Manually Reg")) {
            currentReg = 1;
            UpdateView();
        }
        else if (e.getActionCommand().equals("File Reg")) {
            currentReg = 2;
            UpdateView();
        }
    }
    public void UpdateView(){
        if(currentReg == 1 ){
            MiniDisplay.setText("");
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
                MiniDisplay.append(x + ". "+TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            MiniDisplay.repaint();
        }else if(currentReg == 2){
            MiniDisplay.setText("");
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
                MiniDisplay.append(x + ". "+TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            MiniDisplay.repaint();
        }
    }
}
