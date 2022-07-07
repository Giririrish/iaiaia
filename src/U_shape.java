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
        LinkedList PlanLL = new LinkedList(register1);
        for(int i = 0 ; i < register1.getSize() ; i++){
            PlanLL.addItem(register1.getPupil(i));
        }
        Pupil blank = new Pupil(" " , " " , true);
        //Todo put blank in between and finish the sorting algorithm
        for( int x = 0 ; x <(sideRowLength * (backRowLength + 2)) - 1 ; x = x + (backRowLength + 2)){
            for (int i = x; i < x + (backRowLength -1); i++) {
                PlanLL.add(blank, i + 1 );//not done
            }
        }
        for (int p = (sideRowLength * (backRowLength + 2)) ; p <(sideRowLength * (backRowLength + 2)) + backRowLength-1 ; p++ ){
            PlanLL.add(blank, p + 1  );//not done
        }
        ListNode n = new ListNode(blank);
        n.setNext(PlanLL.getHead());
        PlanLL.DisplayAll();

        //for(int y = 0 ; y < sideRowLength +1 ; y++){
            //for (int x = 0 ; x < backRowLength +2 ; x++){
                //grid[x][y] = n.getNext().getValue();
           // }
        //}
    }
    public void DisplayPlan(){
        for(int y = 0 ; y < sideRowLength +1 ; y++){
            for (int x = 0 ; x < backRowLength +2 ; x++){
                System.out.println(grid[x][y].getFirstName());
            }
        }
    }
}
