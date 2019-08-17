import java.util.*;

/**
 *
 * @author shivam
 */

class SubsetProblemDP {
    public static void main(String args[]) {
        SubsetProblemDP obj = new SubsetProblemDP();
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(obj.isSubsetPossible(arr, sum));
    }

    boolean isSubsetPossible(int[] arr, int sum) {
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j >= arr[i-1]) {
                    dp[i][j] = dp[i - 1][j] ||
                            dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][sum];
    }
}