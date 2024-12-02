package ADIlec12;

import java.util.Arrays;

public class LCS {

    private static int[][]Dp;
    public static void main(String[] args) {
        String s1="ABCDE";
        String s2="ACE";
        int n1=5;
        int n2=3;

        Dp=new int[n1+1][n2+1];
        for(int[] row:Dp){
            Arrays.fill(row,-1);
        }
        System.out.println(Lcshelper(s1,s2,n1,n2));

    }

    static int Lcshelper(String s1,String s2,int n1,int n2){
        if(n1 == 0 || n2 == 0) return 0;


        if(Dp[n1][n2] != -1) return Dp[n1][n2];
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            Dp[n1][n2] = 1+Lcshelper(s1,s2,n1-1,n2-1);
        }
        else{
            Dp[n1][n2] = Math.max(Lcshelper(s1,s2,n1-1,n2)
                    ,Lcshelper(s1,s2,n1,n2-1));
        }

        return Dp[n1][n2];
    }
    static  int LCStab(String s1,String s2,int n1,int n2){
        int[][] dp=new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

}
