package ADIlec11;

import java.util.Arrays;

public class CountNumberOfWays {
    static int[] memo;
    static int[] tab;
    public static void main(String[] args) {
        int n=12;
        memo=new int[n+2];
        tab=new int[n+2];

        Arrays.fill(memo,0);
        Arrays.fill(tab,0);

        System.out.println(Cnwmemo(n));
        System.out.println(Cnwtab(n));
    }

    static int Cnwmemo(int n){
        if( n < 0) return 0;
        if(n == 0) return 1;

        if(memo[n] != 0) return memo[n];

        memo[n] = Cnwmemo(n-1)
                    +Cnwmemo(n-2)
                    +Cnwmemo(n-3);

        return memo[n];
    }

    static int Cnwtab(int n){
        tab[0] = 1;

        for(int i=1;i<=n;i++){
            tab[i] += tab[i-1];
            if(i >= 2) tab[i] += tab[i-2];
            if(i >= 3) tab[i] += tab[i-3];
        }

        return tab[n];
    }
}
