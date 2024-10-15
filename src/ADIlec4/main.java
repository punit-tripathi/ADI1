package ADIlec4;

public class main {
    public static void main(String[] args) {
        int n=5;


    }
    static int fact(int n){

        if(n==1 || n==0) return 1;
        return n*fact(n-1);
    }

    static int fib(int n){
        if(n<=1) return n;

        return fib(n-1) + fib(n-2);
    }
}
