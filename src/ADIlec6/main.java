package ADIlec6;

public class main {
    public static void main(String[] args) {
        String [][]grid={
                {".",".",".","."},
                {".",".",".","."},
                {".",".",".","."},
                {".",".",".","."}
        };
        Nqueens(grid,0);
    }

    static boolean Nqueens(String [][]grid,int row){
        //base case
        if(row == grid.length){
            return true;      
        }

        //recursive case
        for(int i=0;i< grid.length;i++){
           if(isValid(grid,row,i)){
               grid[row][i]= "Q";
               if(Nqueens(grid,row+1)){
                   return true;
               }
               grid[row][i] = ".";
            }
        }
        return false;
    }
    static boolean isValid(String [][]grid,int row,int col){

        for(int i=row-1;row >=0;row--){
            if(grid[row][col] == "Q") return false;
        }

        for(int i=row, j=col;i>=0 && j>=0;i--,j--){
            if(grid[row][col] == "Q") return false;
        }
        for(int i=row,j=col;i >= 0 && j< grid.length;i--,j++){
            if(grid[row][col] == "Q") return false;
        }
        return true;

    }
}
