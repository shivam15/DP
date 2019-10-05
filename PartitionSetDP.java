import java.util.*;

/**
 * @author shivam
 */
public class PartitionSetDP {

    public static void main(String args[]) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        System.out.println(getMin(arr));
    }

    private static int getMin(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n][i] == true) {
                diff = sum - 2 * i;
                break;
            }
        }

        return diff;

    }
}
