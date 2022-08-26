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
    JButton Entry;
    JLabel PupilIndex;
    JLabel enterDetails;
    JLabel enterFileName;
    //text field for .txt file , text field to enter a pupil
    public GUI_Add_Register(){
        frame = new JFrame("Add Register Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);

        ManualEnter = new JButton("Manual Enter");
        ManualEnter.setBounds(10,40,150,50);
        ManualEnter.addActionListener(this);

        FileEnter = new JButton("File Enter");
        FileEnter.setBounds(10,130,150,50);
        FileEnter.addActionListener(this);

        ManualEntry = new JTextField();
        ManualEntry.setBounds(170, 40, 150 , 50);
        ManualEntry.setVisible(false);

        Entry = new JButton("Add");
        Entry.setBounds(330, 40, 70, 50);
        Entry.setVisible(false);

        enterDetails = new JLabel("Enter Pupil Details:");
        enterDetails.setBounds(170 ,10 , 150 , 30);
        enterDetails.setVisible(false);

        FileName = new JTextField();
        FileName.setBounds(170, 130, 150, 50);
        FileName.setVisible(false);

        frame.add(FileName);
        frame.add(ManualEntry);
        frame.add(enterDetails);
        frame.add(Entry);
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
            FileName.setVisible(false);

            ManualEntry.setVisible(true);
            Entry.setVisible(true);
            enterDetails.setVisible(true);

            frame.repaint();
            Register newReg = new Register();
            if(e.getActionCommand().equals("Add")){
                String PupilDetails = ManualEntry.getText();
                boolean tempSex = false;
                String[] tempArray = PupilDetails.split(",",-2); //when formatted correctly the text file should have a new pupil on a new line and pupil details comma separated
                if(tempArray[2].equals("b")){ //reads boy and girl ( b / g ) as a boolean value for the pupil class
                    tempSex = false;
                }else if (tempArray[2].equals("g")){
                    tempSex = true;
                }
                newReg.addPupil(tempArray[0],tempArray[1],tempSex);
                ManualEntry.setText("");
            }
        } else if(e.getActionCommand().equals("File Enter")) {
            System.out.println("FILE ENTER");
            ManualEntry.setVisible(false);
            Entry.setVisible(false);
            enterDetails.setVisible(false);

            FileName.setVisible(true);

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

