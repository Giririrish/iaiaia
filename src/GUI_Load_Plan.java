import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Load_Plan extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    JComboBox PlanNameList;
    JLabel PlanNames;
    JTextField ToBeSwapped1;
    JLabel swap1;
    JTextField ToBeSwapped2;
    JButton Display;
    JButton UpdateIndex;
    JButton UpdateInitials;
    JLabel swap2;
    JLabel swapChoice;

    public GUI_Load_Plan(){
        frame = new JFrame("Load Plan Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);
        String[] listItems = new String[9];
        for(int x = 0 ; x < 4 ; x++){
            if(GUI_Create_Plan.rowPlanNames[x] != null){
                listItems[x] = GUI_Create_Plan.rowPlanNames[x];
            }else{
                listItems[x] = "";
            }
        }
        for(int x = 0 ; x < 4 ; x++){
            if(GUI_Create_Plan.UPlanNames[x] != null){
                listItems[x + 5] = GUI_Create_Plan.UPlanNames[x];
            }else{
                listItems[x + 5] = "";
            }
        }

        PlanNameList = new JComboBox(listItems);
        PlanNameList.setBounds(10,40,150,20);
        PlanNameList.addActionListener(this);
        PlanNameList.setVisible(true);

        PlanNames = new JLabel("Choose plan");
        PlanNames.setBounds(10,20,150,20);
        PlanNames.setVisible(true);

        swap1 = new JLabel("Swap student: ");
        swap1.setBounds(200, 20,200,20);
        swap1.setVisible(true);

        ToBeSwapped1 = new JTextField("First Student Initials");
        ToBeSwapped1.setBounds(200,50, 200,20);
        ToBeSwapped1.setVisible(true);

        swap2 = new JLabel("With student:");
        swap2.setBounds(200, 80, 200, 20);
        swap2.setVisible(true);

        ToBeSwapped2 = new JTextField("Second Student Initials");
        ToBeSwapped2.setBounds(200,110, 200,20);
        ToBeSwapped2.setVisible(true);

        Display = new JButton("Display Plan");
        Display.setBounds(10,100,150, 50);
        Display.addActionListener(this);
        Display.setVisible(true);

        swapChoice = new JLabel("Swap Using : ");
        swapChoice.setBounds(200,140,200,20);
        swapChoice.setVisible(false);

        UpdateIndex = new JButton("Index");
        UpdateIndex.setBounds(200,160, 95, 50);
        UpdateIndex.addActionListener(this);
        UpdateIndex.setVisible(false);

        UpdateInitials = new JButton("Update");
        UpdateInitials.setBounds(305,160, 95, 50);
        UpdateInitials.addActionListener(this);
        UpdateInitials.setVisible(true);

        frame.add(swapChoice);
        frame.add(swap2);
        frame.add(Display);
        frame.add(UpdateInitials);
        frame.add(UpdateIndex);
        frame.add(swap1);
        frame.add(PlanNameList);
        frame.add(PlanNames);
        frame.add(ToBeSwapped1);
        frame.add(ToBeSwapped2);
        frame.setResizable(true);
        frame.setSize(800,400);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Display Plan")){
            //fill this in
            //creates new instance of grid display obj
            //if statement for which type is selected from list
            //
            int takenIndex = PlanNameList.getSelectedIndex();
           if (!PlanNameList.getSelectedItem().equals("")) {
               if (takenIndex > 4) {
                   takenIndex = takenIndex - 5;
                   GUI_Grid_Display newDisplay= new GUI_Grid_Display(GUI_Create_Plan.UPlanArrays[takenIndex]);
               } else {
                   GUI_Grid_Display newDisplay= new GUI_Grid_Display(GUI_Create_Plan.rowPlanArrays[takenIndex]);
               }
           }
        }else if(e.getActionCommand().equals("Update")){
            String firstInit = ToBeSwapped1.getText();
            String secondInit = ToBeSwapped2.getText();
            int takenIndex;
            if(PlanNameList.getSelectedIndex() > 4){
                takenIndex = PlanNameList.getSelectedIndex() - 5;
                GUI_Create_Plan.UPlanArrays[takenIndex].swapStudentsUsingInitials(firstInit,secondInit);
            }else{
                takenIndex = PlanNameList.getSelectedIndex();
                GUI_Create_Plan.rowPlanArrays[takenIndex].swapStudentsUsingInitials(firstInit,secondInit);
            }
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
