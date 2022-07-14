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

        PlanLL.setHead(blank);//Back row done separately as it does not follow the pattern of the other rows.
        PlanLL.add(blank, backRowLength + 1);
        for (int s = backRowLength + 2 ; s < ((sideRowLength + 1)*(backRowLength +  2 ))-1; s = s + (backRowLength + 2 )){//starts from row 2
            for (int b = s + 1; b < s +(backRowLength) + 1 ; b++ ){
                PlanLL.add(blank , s+1 );//dynamic ll is expanding so the index must stay constant
            }
            System.out.println(s);
        }
        System.out.println("full display hererererererere");
        PlanLL.DisplayAll();
        //add to ll from top row down -- after reversing order of reg and adding to ll
        //maybe add recursive method to fill in 2D arrat
        //Todo fill in 2d grid array
        for(int x ){
            for(int y ){
            }
        }
    }
    public void DisplayPlan(){
        for(int y = 0 ; y < sideRowLength +1 ; y++){
            for (int x = 0 ; x < backRowLength +2 ; x++){
                System.out.println(grid[x][y].getFirstName());
            }
        }
    }
}
