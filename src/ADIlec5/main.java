package ADIlec5;

public class main {
    public static void main(String[] args) {
        int [][] maze={
                {1,1,1,0},
                {1,1,0,1},
                {1,1,1,1}
        };
        int n=maze.length;
        int m=maze[0].length;

        uniquePath(maze,0,0,n,m);
    }
    static int uniquePath(int [][]maze,int sr,int sc,int n,int m){
        //base case
        if(sr == n-1 && sc == m-1){
            return 1;
        }

        int totalPath=0;
        if(sr+1 < n && maze[sr+1][sc] != 0){
           totalPath += uniquePath(maze,sr+1,sc,n,m);
        }
        if(sc+1 < m && maze[sr][sc+1] != 0){
            totalPath += uniquePath(maze,sr,sc+1,n,m);
        }

        return totalPath;
    }
}
