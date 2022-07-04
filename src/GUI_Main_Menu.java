import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Main_Menu extends JPanel implements ActionListener {
    JButton AddRegisterButton;
    JButton EditRegisterButton;
    JButton CreateNewPlanButton;
    JButton LoadPlanButton;
    public GUI_Main_Menu(){
        this.setPreferredSize(new Dimension(1000,500));
        this.setBackground(new Color(143, 89, 89));
        setLayout(null);
        AddRegisterButton = new JButton("ADD REGISTER");
        AddRegisterButton.setBounds(10,10,150,50);
        EditRegisterButton = new JButton("EDIT REGISTER");
        EditRegisterButton.setBounds(10,80,150,50);
        CreateNewPlanButton = new JButton("CREATE NEW PLAN");
        CreateNewPlanButton.setBounds(10,150,150,50);
        LoadPlanButton = new JButton("LOAD PLAN");
        LoadPlanButton.setBounds(10,220,150,50);
        AddRegisterButton.addActionListener(this);;
        EditRegisterButton.addActionListener(this);;
        CreateNewPlanButton.addActionListener(this);;
        LoadPlanButton.addActionListener(this);;
        add(AddRegisterButton);
        add(EditRegisterButton);
        add(CreateNewPlanButton);
        add(LoadPlanButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("ADD REGISTER")) {
            System.out.println("Add reg men");
            GUI_Add_Register newAddRegMenu = new GUI_Add_Register();
        } else if (e.getActionCommand().equals("EDIT REGISTER")) {
            System.out.println("Edit reg men");
            GUI_Edit_Register newEditRegMenu = new GUI_Edit_Register();
        } else if (e.getActionCommand().equals("CREATE NEW PLAN")) {
            System.out.println("Create plan menu");
            GUI_Create_Plan newCreatePlanMenu = new GUI_Create_Plan();
        } else if (e.getActionCommand().equals("LOAD PLAN")) {
            System.out.println("Load Plan Menu");
            GUI_Load_Plan newLoadPlanMenu = new GUI_Load_Plan();
        }
        }
    }

