/**
 * @author shivam
 */
public class KnapSackDP {

    public static void main(String args[]) {

        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int W = 50;
        System.out.println(getMaxValue(wt, val, W));

    }

    static int getMaxValue(int[] weight, int[] value, int W) {

        int n = value.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else if(weight[i-1]<=j)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][W];

    }
}
