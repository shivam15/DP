import java.util.*;

/**
 * @author shivam
 */

public class RodCuttingDP {
    public static void main(String args[]) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxValue(arr, arr.length));
    }

    static int getMaxValue(int[] price, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
