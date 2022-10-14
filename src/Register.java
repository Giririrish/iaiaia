import java.security.PublicKey;
import java.util.ArrayList;
public class Register {
    ArrayList<Pupil> Register = new ArrayList<>(); //using an array list as it is a dynamic data type making it easy to add and remove pupils
    public String fileName;
    FileHandler fileHandler = new FileHandler();

    public Register() { //if manually input register then a filename is not needed
    }
    public Register(String fileName ){ // if input through a .txt file
        this.fileName = fileName;
    }
    public int getSize(){
        return Register.size();
    }
    //simple polymorphism to differentiate if the user wants to manually input a register or load one
    public void addAllFilePupils(){ //this function is used to load the register with pupils from a text file given the text file is formatted correctly
        int indexCounter = 0;
        boolean tempSex = false;
        for(int x = 0 ;  x <fileHandler.countLines(fileName ); x++){ //loops through the text file and splits each line(a new pupil) at the commas and stores the pupil in the register
            String [] tempArray = fileHandler.readLineIndex(indexCounter , fileName).split(",",-2); //when formatted correctly the text file should have a new pupil on a new line and pupil details comma separated
            if(tempArray[2].equals("b")){ //reads boy and girl ( b / g ) as a boolean value for the pupil class
                tempSex = false;
            }else if (tempArray[2].equals("g")){
                tempSex = true;
            }
            addPupil(tempArray[0],tempArray[1],tempSex);
            indexCounter++;
        }

    }
    public void SaveRegister(String saveFileName){
        String tempSex = "";
        if(Register.get(0).getSex() == false){
            tempSex = "b";
        }else if(Register.get(0).getSex() == true){
            tempSex = "g";
        }//written in same format as needed to load the register
        fileHandler.falseAppendLine(saveFileName ,Register.get(0).getFirstName() + "," + Register.get(0).getLastName() + "," + tempSex);
        for(int x = 1 ; x < Register.size() ; x++){
            if(Register.get(x).getSex() == false){
                tempSex = "b";
            }else if(Register.get(x).getSex() == true){
                tempSex = "g";
            }//written in same format as needed to load the register
            fileHandler.appendLine(saveFileName ,Register.get(x).getFirstName() + "," + Register.get(x).getLastName() + "," + tempSex);
        }
    }
    public void addPupil(String fn , String ln , boolean sex){ //adds a new pupil to the arraylist register
        Pupil p = new Pupil(fn , ln , sex);
        Register.add(p);
    }
    public void addPupil(Pupil p ){ //adds a new pupil to the arraylist register
        Register.add(p);
    }
    public Pupil getPupil(int index){
        return Register.get(index);
    }//gets a pupil
    public String getPupilInitials(int index){
        return Register.get(index).getInitials();
    }//returns the initial of a certain pupil in the arraylist
    public void setPupil(int index,  String fn , String ln , boolean sex){
        Pupil p = new Pupil(fn , ln , sex);
        Register.set(index,p);//setting is much easier when using an arraylist
    }
    public void setPupil(int index , Pupil p){
        Register.set(index,p);//setting is much easier when using an arraylist
    }
    public void setPupil(String initials, String fn , String ln , boolean sex){ //this second set pupil class is to replace a pupil by finding the intials rather than the index of the pupil in the arraylist which may not be known to the user at any given time
        int index = 0;
        Pupil p = new Pupil(fn , ln , sex);
        for(int x = 0 ; x < Register.size(); x++ ){
            if (Register.get(index).getInitials() == initials){
                Register.set(index, p );
                index++;
            } else{
                System.out.println("error pupil not found ");
            }
        }
    }
    public void clear(){Register.clear();}
    public void displayRegister(){
        for( int x = 0 ; x < Register.size(); x++){
            System.out.println(Register.get(x).getFirstName() +" "+ Register.get(x).getLastName());
        }
    }
    public void displayRegisterInitials(){
        for( int x = 0 ; x < Register.size(); x++){
            System.out.println(Register.get(x).getInitials());
        }
    }

}


