package ADIlec13;

import java.util.Arrays;

public class Main {
   private static int[][] Dp;
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int n=5;
        Dp=new int[n+1][n+1];
        for(int[] row:Dp){
            Arrays.fill(row,-1);
        }
        MCM(arr,1,n-1);
    }
    static int MCM(int[] arr,int i,int j){
        if(i == j) return 0;

        int minimum=Integer.MAX_VALUE;

        if(Dp[i][j] != -1) return Dp[i][j];
        for(int k=i;k<j;k++){
            int currmin=MCM(arr,i,k)+MCM(arr,k+1,j)+arr[i-1] * arr[j] * arr[k];
            minimum=Math.min(minimum,currmin);

        }
        Dp[i][j]=minimum;
        return Dp[i][j];
    }

    static int MCMtab(int[] arr){
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            dp[i][i]=0;
        }
        for(int len=2;len<=n;len++){
            for(int i=1;i<n-len+1;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++){
                    int cost=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    dp[i][j]=Math.min(cost,dp[i][j]);
                }
            }
        }
        return dp[1][n-1];
    }

}
