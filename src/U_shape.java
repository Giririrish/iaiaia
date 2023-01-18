import java.util.Collection;

public class U_shape extends Classroom{
    int sideRowLength;
    int backRowLength;
    Pupil[][] grid;
    public Pupil getFromGrid(int x, int y){
        return grid[x][y];
    }
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
        PlanLL.DisplayAll();
        Pupil blank = new Pupil(" " , " " , true);
        PlanLL.setHead(blank);//Back row done separately as it does not follow the pattern of the other rows.
        PlanLL.add(blank, backRowLength + 1);
        for (int s = backRowLength + 2 ; s < ((sideRowLength + 1)*(backRowLength +  2 ))-1; s = s + (backRowLength + 2 )){//starts from row 2
            for (int b = s + 1; b < s +(backRowLength) + 1 ; b++ ){
                PlanLL.add(blank , s+1 );//dynamic ll is expanding so the index must stay constant
            }
        }
        Register gridReg = new Register();
        for(int a = PlanLL.Size()+1   ; a > 0 ; a--) {
            gridReg.addPupil(PlanLL.getPupil(a));
        }
        gridReg.displayRegisterInitials();
        System.out.println(gridReg.getSize());
        int counter1D = 0;
        for (int x = 0 ; x < (sideRowLength+1) ; x++){
            for (int y = 0; y < (backRowLength +2) ; y++) {
                grid[y][x] = gridReg.getPupil(counter1D);
                counter1D++;
            }
        }
    }
    public void DisplayPlan(){
        System.out.println();
        System.out.println("TEACHER DESK");


        for(int x = 0 ; x < sideRowLength + 1 ; x ++){
            for(int y = 0 ; y < backRowLength + 2 ; y++){
                System.out.print(" " + grid[y][x].getInitials() + " ");
            }
            System.out.println();
        }
    }
    public int getXdimension(){return backRowLength + 2;}
    public int getYdimension(){return sideRowLength + 1;}

    public int findPosOfInitials(String initials , boolean xory){ //x = true , y = false
        int xVal;
        int yVal;
        if(xory == true){
            for(int x = 0 ; x < sideRowLength + 1 ; x ++){
                for(int y = 0 ; y < backRowLength + 2 ; y++){
                    if(grid[x][y].getInitials().equals(initials)){
                        xVal = x;
                        return xVal;
                    }
                }
            }
        } else if (xory == false){
            for(int x = 0 ; x < sideRowLength + 1 ; x ++){
                for(int y = 0 ; y < backRowLength + 2 ; y++){
                    if(grid[x][y].getInitials().equals(initials)){
                        yVal = y;
                        return yVal;
                    }
                }
            }
        }
        return -1;
    }
    public void swapStudentUsingCoordinates( int xVal , int yVal ,int xVal2 , int yVal2 ){
        Pupil tempPupil = new Pupil(grid[xVal][yVal].getFirstName(),grid[xVal][yVal].getLastName() ,grid[xVal][yVal].getSex());
        grid[xVal][yVal] = grid[xVal2][yVal2];
        grid[xVal2][yVal2] = tempPupil;
    }
    public void swapStudentsUsingInitials(String initials1 , String initials2 ){
        int xVal = findPosOfInitials(initials1 , true);
        int yVal = findPosOfInitials(initials1 , false);
        int xVal2 = findPosOfInitials(initials2 , true);
        int yVal2 = findPosOfInitials(initials2 , false);
        swapStudentUsingCoordinates(xVal , yVal , xVal2 , yVal2);
    }
}
