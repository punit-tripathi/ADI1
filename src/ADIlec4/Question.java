package ADIlec4;

import java.util.PriorityQueue;

public class Question {
    public static void main(String[] args) {
        int arr[] ={4,5,6,1,3,4};
        int k=3;

        PriorityQueue<Integer>pq=new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        System.out.println(pq.peek());
    }


}
