import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;

public class Classroom { //this class is used as a basic setting selection before selecting what shape is to be used
    boolean registerOrder = false;
    boolean boyGirl  = false;
    int numberOfSeats;
    Register register1;
    public Classroom(Register register){
        register1 = register;
    }
    public void setBoyGirl() {//search and sort
        Register boys = new Register();
        Register girls = new Register();
        for(int x = 0 ; x < register1.getSize() ; x++){
            if(!register1.getPupil(x).getSex()){
                boys.addPupil(register1.getPupil(x));
            }else {
                girls.addPupil(register1.getPupil(x));
            }
        }
        LinkedList boyLL = new LinkedList(boys);
        LinkedList girlLL = new LinkedList(girls);
        boolean BGBSwitch = false;
        register1.clear();
        while(boyLL.getHead() != null && girlLL.getHead() != null ){
            if(!BGBSwitch){
                register1.addPupil(boyLL.getHead().getValue());
                boyLL.removeHead();
                BGBSwitch = true;
            }else if(BGBSwitch){
                register1.addPupil(girlLL.getHead().getValue());
                girlLL.removeHead();
                BGBSwitch = false;
            }
        }
        while(boyLL.getHead() != null){
            register1.addPupil(boyLL.getHead().getValue());
            boyLL.removeHead();
        }
        while(girlLL.getHead() != null){
            register1.addPupil(girlLL.getHead().getValue());
            girlLL.removeHead();
        }
        System.out.println();
        System.out.println("displayed here");
        for (int x = 0 ; x < register1.getSize() ; x++){
            System.out.println(register1.getPupil(x).getFirstName());
        }
    }
    public void setRegisterOrder(boolean setting ){//using selection sort to sort the register into register order(by last name).
        Pupil temp = new Pupil("" , "", false);
        if(setting) {
            for (int unsorted_pos = 0; unsorted_pos < (register1.getSize() - 1); unsorted_pos++) {
                //  MIN_POS = UNSORTED_POS
                int MIN_POS = unsorted_pos;
                //  loop SEARCH_POS from UNSORTED_POS+1 to ARRAY.length-1
                for (int SEARCH_POS = unsorted_pos + 1; SEARCH_POS < register1.getSize(); SEARCH_POS++) {//finding min value from unsorted part
                    //    if ARRAY[SEARCH_POS] < ARRAY[MIN_POS] then
                    if (register1.getPupil(SEARCH_POS).getLastName().compareTo(register1.getPupil(MIN_POS).getLastName()) < 0) {//numbers[SEARCH_POS] < numbers[MIN_POS]
                        //      MIN_POS = SEARCH_POS
                        MIN_POS = SEARCH_POS;
                    }//    end if
                }//  end loop
                //    // swap elements over
                temp = register1.getPupil(unsorted_pos);
                register1.setPupil(unsorted_pos, register1.getPupil(MIN_POS));
                register1.setPupil(MIN_POS, temp);   // temp value used to store original integer before it gets changed
            }//end loop
        }
        registerOrder = setting;
       // register1.displayRegister();
    }

    public void setNumberOfSeats(int NofSeats){
        numberOfSeats = NofSeats;
    }
}