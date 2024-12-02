package ADIlec16;

import java.util.List;
import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {

    }
    int primsalgo(List<int[]>edges,int V){
        boolean[] vis=new boolean[V];
        PriorityQueue<int[]>pq=new PriorityQueue<>();
        int mstweight=0;

        pq.add(new int[]{0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[1];
            int weight=curr[0];
            if(vis[node]) continue;
            mstweight+=weight;
            vis[node]=true;
            for(int[] edge:edges){
                if (!vis[edge[0]]) {
                    pq.add(edge);
                }
            }
        }
        return mstweight;
    }
}
