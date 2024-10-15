package ADIlec4;

import java.util.PriorityQueue;

public class Questions {
    public static void main(String[] args) {
        int arr[][] ={{1,3},{-2,2},{3,3},{5,-5}};
        int k=2;

        PriorityQueue<Points>pq=new PriorityQueue<>((a,b) -> b.dist - a.dist);

        for(int i=0;i<arr.length;i++){
            Points p=new Points(arr[i][0],arr[i][1]);
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }

    }
}

class Points{
    int x;
    int y;

    Points(int x,int y){
        this.x=x;
        this.y=y;
    }

    int dist= (x*x) + (y*y);

}