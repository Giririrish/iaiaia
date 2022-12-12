public class Row_shape extends Classroom {// a row shaped classroom can be represented in a 2d array as it is a grid
    int rowLength;
    int rowWidth;
    Pupil[][] grid;
    public Row_shape(int rowLength , int rowWidth , Register register){
        super(register);
        this.rowLength = rowLength;
        this.rowWidth = rowWidth;
        grid = new Pupil[rowLength][rowWidth];
    }
    public void constructPlan(){ //default plan with teacher at the top //no flag or boy girl algorithm
        int counter1D = 0;
        for(int x = 0 ; x < rowWidth ; x ++){
            for(int y = 0 ; y < rowLength ; y++){
                grid[x][y] = register1.getPupil(counter1D);
                counter1D++;
            }
        }
        for(int x = 0 ; x < rowWidth ; x ++){
            for(int y = 0 ; y < rowLength ; y++){
                if (grid[x][y] == null){
                    grid[x][y] = new Pupil("","",true);
                }
            }
        }
    }
    public int findPosOfInitials(String initials , boolean xory){ //x = true , y = false
        int xVal;
        int yVal;
        if(xory == true){
            for(int x = 0 ; x < rowWidth ; x ++){
                for(int y = 0 ; y < rowLength ; y++){
                    if(grid[x][y].getInitials().equals(initials)){
                        xVal = x;
                        return xVal;
                    }
                }
            }
        } else if (xory == false){
            for(int x = 0 ; x < rowWidth ; x ++){
                for(int y = 0 ; y < rowLength ; y++){
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

    public void displayPlan(){
        System.out.println();
        System.out.println("TEACHER DESK");
        for(int x = 0 ; x < rowWidth ; x ++){
            for(int y = 0 ; y < rowLength ; y++){
                System.out.print(" " +grid[x][y].getInitials() + " ");
            }
            System.out.println();
        }
    }
    public int getXdimension(){return rowLength;}
    public int getYdimension(){return rowWidth;}
}
