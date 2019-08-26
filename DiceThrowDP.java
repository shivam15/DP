import java.util.*;

/**
 * @author shivam
 */

public class DiceThrowDP {

    public static void main(String args[]) {
        System.out.println(getWays(4, 2, 1));
        System.out.println(getWays(2, 2, 3));
        System.out.println(getWays(6, 3, 8));
    }

    static int getWays(int n, int m, int x) {
        int[][] dp = new int[n + 1][x + 1];

        for (int i = 1; i <= m && i <= x; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m && k < j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        return dp[n][x];
    }
}
