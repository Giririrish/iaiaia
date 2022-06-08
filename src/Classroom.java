import java.util.ArrayList;

public class Classroom { //this class is used as a basic setting selection before selecting what shape is to be used
    boolean registerOrder = false;
    boolean boyGirl  = false;
    int numberOfSeats;
    Register register1;
    public Classroom(Register register){
        register1 = register;
    }
    public void setBoyGirl(boolean setting) {//search and sort
        boyGirl = setting;
        boolean SexSwitcher = false;
        int pointOfSwitch = 0;
        int pointOfSwitchFemale = 0;
        ArrayList<Pupil> tempArrayList = new ArrayList<>();
        for(int i = 0 ; i < 2; i++) {//will fill the temp list with all boys first then all girls at the pointOfSwitch index
            for (int x = 0; x < register1.getSize(); x++) {
                if (register1.getPupil(x).getSex() == SexSwitcher) {
                    tempArrayList.add(register1.getPupil(x));
                    if (!SexSwitcher) {
                        pointOfSwitch++;
                    }
                }
            }
            SexSwitcher = true;
        }
        System.out.println();
        System.out.println("sorted here");
        for(int x = 0 ; x < tempArrayList.size() ; x++){
            System.out.println(tempArrayList.get(x).getFirstName());
        }
        SexSwitcher = false;
        pointOfSwitchFemale = register1.getSize() - pointOfSwitch;
        System.out.println("point of switch male " + pointOfSwitch);
        System.out.println("point of switch female " + pointOfSwitchFemale);
        //TODO sort from temp array list to main register
        if(pointOfSwitch * 2 > register1.getSize()){

        }else if (pointOfSwitch * 2 < register1.getSize()){

        }else if(pointOfSwitch * 2 == register1.getSize()){
            for(int x =0 ; x < register1.getSize() - 1   ; x = x + 2){

            }



            for(int x =0 ; x < register1.getSize() - 1   ; x = x + 2){
                register1.setPupil(x, tempArrayList.get(x / 2));
            }
            for(int x = 1  ; x < pointOfSwitch  ;x++){
                register1.setPupil((x * 2) - 1   , tempArrayList.get((x -1) + pointOfSwitch));
            }
            register1.setPupil(register1.getSize() -1 ,tempArrayList.get(pointOfSwitch-1));
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