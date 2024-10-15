package ADILEC3;

public class main {
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        Heapsort h1=new Heapsort();
        h1.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
class Heapsort{
    void sort(int arr[]){
        int n=arr.length;
        for(int i=n/2 -1;i>=0;i--){
            heapify(arr,i,n);
        }

        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);


        }


    }

    void heapify(int arr[],int idx,int len){
            int parent =idx;
            int left=parent*2 + 1;
            int right=parent*2+2;

            if(left<len &&  arr[parent] < arr[left]){
                parent = left;
            }
            if(right < len && arr[parent] < arr[right]){
                parent = right;
            }
            if(parent != idx){
                int temp=arr[parent];
                arr[parent] = arr[idx];
                arr[idx] = temp;

                heapify(arr,parent,len);
            }
    }
}

