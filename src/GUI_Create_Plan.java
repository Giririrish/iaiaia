import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI_Create_Plan extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    JButton ManualRegButton;
    JButton FileRegButton;
    JTextArea MiniDisplay;
    JComboBox ShapeSelect;
    JComboBox SortSelect;
    JTextField EnterShapeParas;
    JLabel enterShapeParas;
    JLabel selectSort;
    JLabel selectShape;
    JButton SaveSettings;
    int currentReg = 0;
    int rowPlanCount = 0;
    int UPlanCount = 0;
    String[] rowPlanNames = new String[4];
    String[] UPlanNames = new String[4];
    Row_shape[] rowPlanArrays = new Row_shape[4];
    U_shape[] UPlanArrays = new U_shape[4];
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
        selectShape = new JLabel("Seating Plan Shape");
        selectShape.setBounds(10,100,200,20);
        selectShape.setVisible(false);

        String[] ShapeItems = { "Rows", "U Shape"};
        ShapeSelect = new JComboBox(ShapeItems);
        ShapeSelect.setBounds(10,120,150,20);
        ShapeSelect.addActionListener(this);
        ShapeSelect.setVisible(false);

        EnterShapeParas = new JTextField("Name,Rows,Columns");
        EnterShapeParas.setBounds(170,120,200,20);
        EnterShapeParas.setVisible(false);

        enterShapeParas = new JLabel("Enter Shape Parameters :");
        enterShapeParas.setBounds(170, 100, 200,20);
        enterShapeParas.setVisible(false);

        selectSort = new JLabel("Select Sort");
        selectSort.setBounds(10,180,200,20 );
        selectSort.setVisible(false);

        String[] SortItems = { "Unchanged", "Register Order", "Boy-Girl-Boy Order"};
        SortSelect = new JComboBox(SortItems);
        SortSelect.setBounds(10,200,150,20);
        SortSelect.addActionListener(this);
        SortSelect.setVisible(false);


        SaveSettings = new JButton("Create");
        SaveSettings.setBounds(10, 280, 120,70);
        SaveSettings.addActionListener(this);
        SaveSettings.setVisible(false);

        frame.add(selectShape);
        frame.add(selectSort);
        frame.add(enterShapeParas);
        frame.add(SortSelect);
        frame.add(ShapeSelect);
        frame.add(EnterShapeParas);
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
        }
        else if (e.getActionCommand().equals("File Reg")) {
            currentReg = 2;
            UpdateView();
            setButtonsVisible(true);
        }else if(e.getSource() == ShapeSelect){
            System.out.println(ShapeSelect.getSelectedItem());
            if(ShapeSelect.getSelectedIndex() == 0 ){
                EnterShapeParas.setText("Name,Rows,Columns");
            }else if(ShapeSelect.getSelectedIndex() == 1){
                EnterShapeParas.setText("Name,Side Row length,Back Row Length");
            }
        }else if(e.getSource() == SortSelect){

        }else if(e.getActionCommand().equals("Create")){//before finihs put all inside if statemetn for both registers
            String[] ParaTextFieldSplit = EnterShapeParas.getText().split(",");
            String planName = ParaTextFieldSplit[0];
            int para1 = Integer.parseInt(ParaTextFieldSplit[1]);
            int para2 = Integer.parseInt(ParaTextFieldSplit[2]);
            System.out.println(para1);
            System.out.println(para2);
            if(ShapeSelect.getSelectedIndex() == 0 ){
                rowPlanArrays[rowPlanCount] = new Row_shape(para1,para2,chosenReg());
                rowPlanNames[rowPlanCount] = planName;
                    if(SortSelect.getSelectedIndex() == 1 ){
                        rowPlanArrays[rowPlanCount].setRegisterOrder(true);
                    }else if(SortSelect.getSelectedIndex() == 2){
                        rowPlanArrays[rowPlanCount].setBoyGirl();
                    }
                rowPlanCount = rowPlanCount + 1;
            }else if(ShapeSelect.getSelectedIndex() == 1 ){
                UPlanArrays[UPlanCount] = new U_shape(para1,para2,chosenReg());
                UPlanNames[UPlanCount] = planName;
                if(SortSelect.getSelectedIndex() == 1 ){
                    UPlanArrays[UPlanCount].setRegisterOrder(true);
                }else if(SortSelect.getSelectedIndex() == 2){
                    UPlanArrays[UPlanCount].setBoyGirl();
                }
                UPlanCount = UPlanCount + 1;
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
        EnterShapeParas.setVisible(para);
        enterShapeParas.setVisible(para);
        selectShape.setVisible(para);
        selectSort.setVisible(para);
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
    public Register chosenReg(){
        if(currentReg == 1){
            return GUI_Add_Register.ManualEntryReg;
        }else {
            return GUI_Add_Register.FileEntryReg;
        }
    }
}
