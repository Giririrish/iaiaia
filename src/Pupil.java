import java.lang.String;
public class Pupil {
    public String firstName;
    public String lastName;
    public boolean Sex; //false - male , true - female
    public boolean flag;
    public Pupil(String FN , String LN, boolean sex){
        this.firstName = FN;
        this.lastName = LN;
        this.Sex = sex;
        flag = false;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public boolean getSex(){
        return Sex;
    }
    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }
    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    public void setSex(boolean newSex){
        Sex = newSex;
    }
    public void flagPupil(){
        flag = true;
    }
    public void unflagPupil(){
        flag = false;
    }
    public String getInitials(){return getFirstName().substring(0,1) + getLastName().substring(0,1);
    }

}
