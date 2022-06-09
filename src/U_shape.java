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
        LinkedList PlanLL = new LinkedList(register1.Register);
        for(int i = 0 ; i < register1.getSize() ; i++){
            PlanLL.addItem(register1.getPupil(i));
        }
        Pupil blank = new Pupil(" " , " " , true);
        //Todo put blank inbetween
        for(int i = 0 ; i < sideRowLength ; i++){

        }
    }
}
