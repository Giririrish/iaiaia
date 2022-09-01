import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Edit_Register extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    FileHandler fileHandler = new FileHandler();
    JTextArea big;
    JButton ManualRegButton;
    JButton FileRegButton;

    JButton SaveRegButton;
    JTextField SaveFileNameField;

    JButton AddPupilButton;
    JTextField AddPupilButtonDetails;

    JButton SetPupilButton;
    JTextField SetPupilButtonDetails;

    int currentReg = 0;
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

        SaveFileNameField = new JTextField("(Save File.txt)");
        SaveFileNameField.setBounds(10,120,200,50);
        SaveFileNameField.setVisible(false);

        SaveRegButton = new JButton("Save");
        SaveRegButton.setBounds(220,120,100,50);
        SaveRegButton.addActionListener(this);
        SaveRegButton.setVisible(false);

        AddPupilButtonDetails = new JTextField("FN,LN,Sex");
        AddPupilButtonDetails.setBounds(10,200,200,50);
        AddPupilButtonDetails.setVisible(false);

        AddPupilButton = new JButton("Add");
        AddPupilButton.setBounds(220,200,100,50);
        AddPupilButton.addActionListener(this);
        AddPupilButton.setVisible(false);

        SetPupilButtonDetails = new JTextField("Index,FN,LN,Sex");
        SetPupilButtonDetails.setBounds(10,280,200,50);
        SetPupilButtonDetails.setVisible(false);

        SetPupilButton = new JButton("Set");
        SetPupilButton.setBounds(220,280,100,50);
        SetPupilButton.addActionListener(this);
        SetPupilButton.setVisible(false);

        frame.add(big);
        frame.add(SaveFileNameField);
        frame.add(SaveRegButton);
        frame.add(AddPupilButtonDetails);
        frame.add(AddPupilButton);
        frame.add(SetPupilButtonDetails);
        frame.add(SetPupilButton);
        frame.setResizable(true);
        frame.setSize(800,600);
        frame.getContentPane().add(this);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Manually Input Reg")) {
                currentReg = 1;
                UpdateView();
                ButtonsVisible();
                frame.repaint();
            }
            else if (e.getActionCommand().equals("File Loaded Reg")) {
                currentReg = 2;
                UpdateView();
                ButtonsVisible();
                frame.repaint();
            }else if (e.getActionCommand().equals("Save")){
               String fileLocation = SaveFileNameField.getText();
                if(currentReg == 1 ){
                    GUI_Add_Register.ManualEntryReg.SaveRegister(fileLocation);
                }else if(currentReg == 2){
                    GUI_Add_Register.FileEntryReg.SaveRegister(fileLocation);
                }
                SaveFileNameField.setText("");
                UpdateView();
            }else if (e.getActionCommand().equals("Add")){
                boolean tempSex = false;
                String [] tempArray = AddPupilButtonDetails.getText().split(",",-2); //when formatted correctly the text file should have a new pupil on a new line and pupil details comma separated
                if(tempArray[2].equals("b")){ //reads boy and girl ( b / g ) as a boolean value for the pupil class
                    tempSex = false;
                }else if (tempArray[2].equals("g")){
                    tempSex = true;
                }
                if(currentReg == 1 ){
                   GUI_Add_Register.ManualEntryReg.addPupil(tempArray[0],tempArray[1],tempSex);
                }else if(currentReg == 2){
                    GUI_Add_Register.FileEntryReg.addPupil(tempArray[0],tempArray[1],tempSex);
                }
                AddPupilButtonDetails.setText("");
                UpdateView();
            }else if (e.getActionCommand().equals("Set")){
                boolean tempSex = false;
                String [] tempArray = SetPupilButtonDetails.getText().split(","); //when formatted correctly the text file should have a new pupil on a new line and pupil details comma separated
                if(tempArray[3].equals("b")){ //reads boy and girl ( b / g ) as a boolean value for the pupil class
                    tempSex = false;
                }else if (tempArray[3].equals("g")){
                    tempSex = true;
                }
                if(currentReg == 1 ){
                    GUI_Add_Register.ManualEntryReg.setPupil(Integer.parseInt(tempArray[0]),tempArray[1],tempArray[2],tempSex);
                }else if (currentReg ==2 ){
                    GUI_Add_Register.FileEntryReg.setPupil(Integer.parseInt(tempArray[0]),tempArray[1],tempArray[2],tempSex);
                }
                SetPupilButtonDetails.setText("");
                UpdateView();
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
    public void ButtonsVisible(){
        SaveRegButton.setVisible(true);
        SaveFileNameField.setVisible(true);
        AddPupilButton.setVisible(true);
        AddPupilButtonDetails.setVisible(true);
        SetPupilButton.setVisible(true);
        SetPupilButtonDetails.setVisible(true);
    }
    public void UpdateView(){
        if(currentReg == 1 ){
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
                big.append(x + ". "+TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            big.repaint();
        }else if(currentReg == 2){
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
                big.append(x + ". "+TempFN + "," + TempLN + "," + TempSex + "\n");
            }
            big.repaint();
        }
    }
}