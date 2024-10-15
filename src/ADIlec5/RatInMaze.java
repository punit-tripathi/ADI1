package ADIlec5;

import java.util.ArrayList;

public class RatInMaze {
    public static void main(String[] args) {
        int [][] maze ={
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        int [][] visited ={
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };

        int n=maze.length;
        int m=maze[0].length;
        ArrayList<String> res=new ArrayList<>();
        helper(maze,0,0,n,m,res,"",visited);
        System.out.println(res);
    }
    static void helper(int [][]maze,int sr,int sc,int n,int m,ArrayList<String>res,String path,int [][]visited){
        //base case
        if(sr == n-1 && sc == m-1){
            res.add(path);
            return;
        }

        visited[sr][sc] =1;

        if(sc+1 < m && maze[sr][sc+1] == 1 && visited[sr][sc+1] == 0){
            helper(maze,sr,sc+1,n,m,path + "R",res,visited);
        }
        if(sc-1 >= 0 && maze[sr][sc-1] == 1 && visited[sr][sc-1] == 0){
            helper(maze,sr,sc-1,n,m,path + "L",res,visited);
        }
        if(sr+1 < n && maze[sr+1][sc] == 1 && visited[sr+1][sc] == 0){
            helper(maze,sr+1,sc,n,m,path + "D",res,visited);
        }
        if(sr-1 >= 0 && maze[sr-1][sc] == 1 && visited[sr-1][sc] == 0){
            helper(maze,sr-1,sc,n,m,path + "U",res,visited);
        }
        visited[sr][sc]=0;

    }
}
