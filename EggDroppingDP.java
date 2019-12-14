public class EggDroppingDP {

    public static void main(String args[]) {
        System.out.println(getMin(2,36));
    }

    static int getMin(int n, int k) {
        int dp[][] = new int[n+1][k+1];
        //base case
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for(int j=1;j<=k;j++){
            dp[1][j] = j;
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=k;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1;x<=j;x++){
                    int res = 1+ Math.max(dp[i-1][x-1],dp[i][j-x]);
                    if(res<dp[i][j])
                        dp[i][j] = res;
                }
            }
        }
        return dp[n][k];
    }
}
