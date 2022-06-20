public class Main {

    public static void main(String[] args) {
        Register myRegister = new Register();
        myRegister.addPupil("Isfan" , "Zamonov" , false);
        myRegister.addPupil("Ben" , "Walker" , false);
        myRegister.addPupil("benjammin" , "walking" , false);
        myRegister.displayRegister();
        myRegister.setPupil(2 , "Girish" , "Kharal" , false);
        myRegister.addPupil("Qax" ,"Qarko" , false );
        myRegister.addPupil("Wax" ,"Warko" , false );
        myRegister.addPupil("Eax" ,"Earko" , false );
        myRegister.addPupil("Rax" ,"Rarko" , false );
        myRegister.addPupil("Tax" ,"Tarko" , false );
        myRegister.addPupil("Yax" ,"Yark" , true );
        myRegister.SaveRegister("savedRegister");
        Register myReg2 = new Register("savedRegister");
        myReg2.addAllFilePupils();
        Row_shape myRowPlan = new Row_shape(3 , 3 , myReg2);
        myRowPlan.constructPlan();
        myRowPlan.displayPlan();
        //testing swapping functionality
        System.out.println("here");
        myRowPlan.swapStudentUsingCoordinates(0,0,1,1);
        myRowPlan.displayPlan();
        System.out.println("here 2 ");
        myRowPlan.swapStudentUsingCoordinates(1,1,2,2);
        myRowPlan.displayPlan();
        System.out.println("here 3");
        myRowPlan.swapStudentsUsingInitials("BW" , "GK");
        myRowPlan.displayPlan();
        //test swapping here
        System.out.println();
        System.out.println();
        System.out.println("text register : ");
        Register textRegister = new Register("testRegister.txt");
        textRegister.addAllFilePupils();
        textRegister.displayRegister();
        Row_shape textRegRowPlan = new Row_shape(2,2,textRegister);
        textRegRowPlan.constructPlan();
        textRegRowPlan.displayPlan();
        System.out.println("bubble sort here ");
        textRegRowPlan.setRegisterOrder(false);
        System.out.println();
        System.out.println("ll test");
        LinkedList testList = new LinkedList(textRegister);
        System.out.println();
        System.out.println("get head test");
        System.out.println(testList.getHead().getValue().getFirstName());
        System.out.println();
        System.out.println("get next test");
        System.out.println(testList.getHead().getNext().getValue().getFirstName());

    }
}
