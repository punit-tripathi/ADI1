package ADIlec9;

public class Main {
    public static void main(String[] args) {

    }
    static void QSort(int[] arr,int st,int end){
        if(st < end){
            int pi=partition(arr,st,end);

            QSort(arr,st,pi-1);
            QSort(arr,pi+1,end);
        }

    }

    static int partition(int[] arr,int st,int end){
        int pivot=arr[end];

        int i=st-1;
        for(int j=st;j < end;j++){
            if(arr[j] <= pivot){
                i++;
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[end];
        arr[end]=temp;

        return i+1;
    }
}
