import javax.swing.*;
import java.awt.*;

public class GUI_Main_Menu extends JPanel {
    JButton AddRegisterButton;
    JButton EditRegisterButton;
    JButton CreateNewPlanButton;
    JButton LoadPlanButton;
    public GUI_Main_Menu(){
        this.setPreferredSize(new Dimension(1000,500));
        this.setBackground(new Color(143, 89, 89));
        setLayout(null);
        AddRegisterButton = new JButton("ADD REGISTER");
        AddRegisterButton.setBounds(10,10,100,20);
        EditRegisterButton = new JButton("EDIT REGISTER");
        EditRegisterButton.setBounds(10,120,100,20);
        CreateNewPlanButton = new JButton("CREATE NEW PLAN");
        CreateNewPlanButton.setBounds(10,230,100,20);
        LoadPlanButton = new JButton("LOAD PLAN");
        LoadPlanButton.setBounds(10,340,100,20);
        add(AddRegisterButton);
        add(EditRegisterButton);
        add(CreateNewPlanButton);
        add(LoadPlanButton)   ;
    }
}
