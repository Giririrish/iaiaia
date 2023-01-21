import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.security.KeyStore;

public class GUI_Add_Register extends JPanel implements ActionListener, DocumentListener {
    private JFrame frame;
    JButton ManualEnter;
    JButton FileEnter;
    JTextField ManualEntry;
    JTextField FileName;
    JButton Entry;
    JLabel enterDetails;
    JLabel enterFileName;
    JButton FileEntryButton;
    JButton ManualFileEntryButton;
    public static Register ManualEntryReg;
    public static Register FileEntryReg;

    //text field for .txt file , text field to enter a pupil
    public GUI_Add_Register() {
        frame = new JFrame("Add Register Menu");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(new Color(143, 124, 89));
        setLayout(null);

        ManualEnter = new JButton("Manual Enter");
        ManualEnter.setBounds(10, 40, 150, 50);
        ManualEnter.addActionListener(this);

        FileEnter = new JButton("File Enter");
        FileEnter.setBounds(10, 130, 150, 50);
        FileEnter.addActionListener(this);

        ManualEntry = new JTextField();
        ManualEntry.setBounds(170, 40, 150, 50);
        ManualEntry.setVisible(false);

        Entry = new JButton("Add Pupil");
        Entry.setBounds(330, 40, 150, 50);
        Entry.addActionListener(this);
        Entry.setVisible(false);

        ManualFileEntryButton = new JButton("Add Register Name");
        ManualFileEntryButton.setBounds(490, 40, 150, 50);
        ManualFileEntryButton.addActionListener(this);
        ManualFileEntryButton.setVisible(false);

        enterDetails = new JLabel("Reg Name/Pupil Details");
        enterDetails.setBounds(170, 10, 150, 30);
        enterDetails.setVisible(false);

        FileName = new JTextField();
        FileName.setBounds(170, 130, 150, 50);
        FileName.setVisible(false);

        enterFileName = new JLabel("Enter File Name");
        enterFileName.setBounds(170, 100, 150, 30);
        enterFileName.setVisible(false);

        FileEntryButton = new JButton("Add File Name");
        FileEntryButton.setBounds(330, 130, 150, 50);
        FileEntryButton.addActionListener(this);
        FileEntryButton.setVisible(false);

        frame.add(FileName);
        frame.add(ManualEntry);
        frame.add(enterDetails);
        frame.add(Entry);
        frame.add(ManualEnter);
        frame.add(FileEnter);
        frame.add(FileEntryButton);
        frame.add(ManualFileEntryButton);
        frame.add(enterFileName);
        frame.setResizable(true);
        frame.setSize(800, 600);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Manual Enter")) {
            System.out.println("MANUAL ENTER");
            FileName.setVisible(false);
            FileEntryButton.setVisible(false);
            enterFileName.setVisible(false);

            ManualEntry.setVisible(true);
            Entry.setVisible(false);
            enterDetails.setVisible(true);
            ManualFileEntryButton.setVisible(true);

            frame.repaint();

        } else if (e.getActionCommand().equals("File Enter")) {
            System.out.println("FILE ENTER");
            ManualEntry.setVisible(false);
            Entry.setVisible(false);
            enterDetails.setVisible(false);
            ManualFileEntryButton.setVisible(false);

            FileName.setVisible(true);
            FileEntryButton.setVisible(true);
            enterFileName.setVisible(true);
            frame.repaint();

        } else if (e.getActionCommand().equals("Add Pupil")) {
            System.out.println("ADD PUPIL");
            Pupil tempPupil;
            tempPupil = pupilConcat();
            if(tempPupil != null) {
                ManualEntryReg.addPupil(tempPupil);
            }
            ManualEntry.setText("");
            ManualEntryReg.displayRegisterInitials();
        } else if (e.getActionCommand().equals("Add Register Name")) {
            System.out.println("ENTER REGISTER NAME");
            String manualEntryValue = ManualEntry.getText();
            System.out.println(manualEntryValue);
            ManualEntryReg = new Register(manualEntryValue);
            ManualEntry.setText("");
            ManualFileEntryButton.setVisible(false);
            Entry.setVisible(true);
        } else if (e.getActionCommand().equals("Add File Name")) {
                System.out.println("ADD FILE NAME");
                String fileEntryValue = FileName.getText();
                FileEntryReg = new Register(fileEntryValue);
                FileEntryReg.addAllFilePupils();
                FileName.setText("");
                FileEntryReg.displayRegisterInitials();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("remove");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("changed");
    }

    public Pupil pupilConcat() {
        Pupil tempPupil;
        String PupilDetails = ManualEntry.getText();
        boolean tempSex = false;
        String[] tempArray = new String[3];
        try {
            tempArray = PupilDetails.split(",", -2); //when formatted correctly the text file should have a new pupil on a new line and pupil details comma separated
            if (tempArray[2].equals("b")) { //reads boy and girl ( b / g ) as a boolean value for the pupil class
                tempSex = false;
            } else if (tempArray[2].equals("g")) {
                tempSex = true;
            }
            tempPupil = new Pupil(tempArray[0], tempArray[1], tempSex);
            return tempPupil;
        } catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Please enter pupil details in the format FN,LN,b/g \n" +
                    "Ex : John,Doe,b", "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
        }
        return null;
        }
    }


