package ADIlec14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
}
class Graph{
    int V;
    List<Integer>[] adjlist;

    public Graph(int V){
        this.V=V;
        adjlist=new List[V+1];
        for(int i=0;i<=V;i++){
            adjlist[i]=new ArrayList<>();
        }
    }

    int addEdge(int v1,int v2){
        adjlist[v1].add(v2);
        return v2;
    }

    void BFS(int startVertex){
        boolean[] vis=new boolean[V+1];
        Queue<Integer>q=new LinkedList<>();

        q.add(startVertex);
        vis[startVertex]=true;

        while(!q.isEmpty()){
            int vertex=q.poll();

            System.out.println(vertex);
            for(int ele:adjlist[vertex]){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
    }

    void DFS(int startVertetx){
        boolean[] vis=new boolean[V+1];
        DFShelper(startVertetx,vis);
    }

    void DFShelper(int startVertex,boolean[] vis){
        vis[startVertex]=true;
        System.out.println(startVertex);

        for(int ele:adjlist[startVertex]){
            if(!vis[ele]) DFShelper(ele,vis);
        }
    }

    boolean isCycle(){
        boolean[] vis=new boolean[V+1];
        for(int i=0;i <= V;i++){
            if(!vis[i]){
                if(isCycleUtil(i,vis,-1)) return true;
            }
        }
        return false;
    }

    boolean isCycleUtil(int v,boolean[] vis,int parent){
        vis[v]=true;

        for(int ele:adjlist[v]){
            if(!vis[ele]){
                if(isCycleUtil(ele,vis,v)) return true;
            }
            else if(ele != parent) return true;
        }
        return false;
    }

    int minEdge(int src,int dest){
        boolean[] vis=new boolean[V+1];
        vis[src]=true;
        Queue<Integer>q=new LinkedList<>();
        int[] dist=new int[V+1];
        dist[src] = 0;
        q.add(src);

        while(!q.isEmpty()){
            int temp=q.poll();

            for(int ele:adjlist[temp]){
                if(!vis[ele]){
                    q.add(ele);
                    dist[ele]=dist[temp]+1;
                    vis[ele]=true;
                }
                if(ele == dest){
                    return dist[ele];
                }
            }

        }
        return -1;
    }

}
class Dirgraph{
    int V;
    List<Integer>[] adjlist;

    Dirgraph(int V){
        this.V=V;
        adjlist=new List[V+1];
        for(int i=0;i<=V;i++){
            adjlist[i]=new ArrayList<>();
        }
    }

    void addEdge(int v1,int v2){
        adjlist[v1].add(v2);
    }

    boolean isCycle(){
        boolean[] vis=new boolean[V+1];
        boolean[] currvis=new boolean[V+1];

        for(int i=0;i<=V;i++){
            if(!vis[i]){
                if(isCyclehelper(i,vis,currvis)) return true;
            }
        }
        return false;
    }
    boolean isCyclehelper(int i,boolean[] vis,boolean[] currvis){
        vis[i]=true;
        currvis[i]=true;

        for(int ele:adjlist[i]){
            if(!vis[ele]){
                if(isCyclehelper(ele,vis,currvis)) return true;
            }
            if(currvis[ele]) return true;
        }
        currvis[i]=false;
        return false;
    }

    boolean isPath(int src,int dest){
        boolean[] vis=new boolean[V+1];
        if(isPathUtil(src,dest,vis)) return true;
        return false;
    }


    boolean isPathUtil(int src,int dest,boolean[] vis){
        if(src == dest) return true;
        vis[src]=true;

        for(int ele:adjlist[src]){
            if(!vis[ele]){
                if(isPathUtil(ele,dest,vis)) return true;
            }
        }
        return false;
    }
}
