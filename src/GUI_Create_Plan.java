import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI_Create_Plan extends JPanel implements ActionListener {
    private JFrame frame;
    JButton ManualRegButton;
    JButton FileRegButton;
    JTextArea MiniDisplay;
    JComboBox ShapeSelect;
    JComboBox SortSelect;
    JLabel selectReg;
    JLabel selectSort;
    JLabel selectShape;
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
        String[] ShapeItems = { "Rows", "U Shape"};
        ShapeSelect = new JComboBox(ShapeItems);
        ShapeSelect.setBounds(10,120,150,20);
        ShapeSelect.addActionListener(this);
        ShapeSelect.setVisible(false);

        String[] SortItems = { "Unchanged", "Register Order", "Boy-Girl-Boy Order"};
        SortSelect = new JComboBox(SortItems);
        SortSelect.setBounds(10,200,150,20);
        SortSelect.addActionListener(this);
        SortSelect.setVisible(false);


        SaveSettings = new JButton("Create");
        SaveSettings.setBounds(10, 280, 120,70);
        SaveSettings.addActionListener(this);
        SaveSettings.setVisible(false);

        frame.add(SortSelect);
        frame.add(ShapeSelect);
        frame.add(SaveSettings);
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
            setButtonsVisible(true);
            ManualRegButton.setVisible(false);
            FileRegButton.setVisible(true);
        }
        else if (e.getActionCommand().equals("File Reg")) {
            currentReg = 2;
            UpdateView();
            setButtonsVisible(true);
            FileRegButton.setVisible(false);
            ManualRegButton.setVisible(true);
        }else if(e.getActionCommand().equals("Create")){
            if(ShapeSelect.getSelectedIndex() == 0){
                Row_shape newRow()
            }
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

    public void setButtonsVisible(boolean para){
        ShapeSelect.setVisible(para);
        SortSelect.setVisible(para);
        SaveSettings.setVisible(para);
    }
}
