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
        //Todo put blank inbetween and fininsh the sorting algorithm
        for( int x = 0 ; x < sideRowLength; x = x +2) {
            for (int i = x; i < backRowLength - 1; i++) {
                PlanLL.add(blank, i + 1 );//not done
            }
        }
    }
}
