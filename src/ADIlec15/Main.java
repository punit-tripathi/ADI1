package ADIlec15;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    List<Integer> topologigicalSort(int vertices,List<List<Integer>>adjlist){
        ArrayList<Integer>result=new ArrayList<>();
        int[] inDegree=new int[vertices+1];
        Queue<Integer>q=new LinkedList<>();


        for(int i=0;i<vertices;i++){
            for(int ele:adjlist.get(i)){
                inDegree[ele]++;
            }
        }
        for(int i=0;i<vertices;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while (!q.isEmpty()){
            int node=q.poll();
            result.add(node);

            for(int ele:adjlist.get(node)){
                inDegree[ele]--;
                if(inDegree[ele] == 0){
                    result.add(ele);
                }
            }
        }
        return result;
    }
}
