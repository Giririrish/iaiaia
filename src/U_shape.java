import java.util.Collection;

public class U_shape extends Classroom{
    int sideRowLength;
    int backRowLength;
    Pupil[][] grid;
    public U_shape(int SideRow , int BackRow, Register register){
        super(register);
        this.sideRowLength = SideRow;
        this.backRowLength = BackRow;
        grid = new Pupil[backRowLength + 2][sideRowLength + 1];
    }
    public void constructPlan(){
        Register PlanReg = new Register();
        System.out.println(register1.getSize());
        for(int a = register1.getSize()   ; a > 0 ; a--) {
            PlanReg.addPupil(register1.getPupil(a -1));
        }

        LinkedList PlanLL = new LinkedList(PlanReg);//Linked list used to fill empty space in this shape
        System.out.println("HERHEHRE");
        PlanLL.DisplayAll();
        Pupil blank = new Pupil(" " , " " , true);

        PlanLL.setHead(blank);
        PlanLL.add(blank, backRowLength + 1);
        for (int s = 0 ; s < sideRowLength ; r++){
            for (int b =  )
        }

        //add to ll from top row down -- after reversing order of reg and adding to ll

        //for( int x = 0 ; x <(sideRowLength * (backRowLength + 2)) - 1 ; x = x + (backRowLength + 2)){
           // for (int i = x; i < x + (backRowLength -1); i++) {
          //      PlanLL.add(blank, i + 1 );//adds in blanks in positions where there are no students sitting
        //    }
        //}
        //System.out.println("here");
        // PlanLL.DisplayAll();//the ends of the back row will be empty
      //  for (int p = (sideRowLength * (backRowLength + 2)) ; p <(sideRowLength * (backRowLength + 2)) + backRowLength-1 ; p++ ){
      //      PlanLL.add(blank, p   );//not done
      //  }

        //ListNode n = new ListNode(blank);
       // n.setNext(PlanLL.getHead());
        //for(int y = 0 ; y < sideRowLength +1 ; y++){
            //for (int x = 0 ; x < backRowLength +2 ; x++){
                //grid[x][y] = n.getNext().getValue();
           // }
        //}
        //Todo put blank in between and finish the sorting algorithm
    }
    public void DisplayPlan(){
        for(int y = 0 ; y < sideRowLength +1 ; y++){
            for (int x = 0 ; x < backRowLength +2 ; x++){
                System.out.println(grid[x][y].getFirstName());
            }
        }
    }
}
