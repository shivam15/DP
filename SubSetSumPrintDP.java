import java.util.*;

/**
 * @author shivam
 */

public class SubSetSumPrintDP {

    static boolean[][] dp;

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        int sum = 10;
        subsetSum(arr, sum);
    }

    static void subsetSum(int[] arr, int sum) {
        int n = arr.length;
        dp = new boolean[n][sum + 1];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[n - 1][sum] == false) {
            System.out.println("There are no subsets with" +
                    " sum " + sum);
            return;
        }
        ArrayList<Integer> p = new ArrayList<>();
        printSubsetsRec(arr, n - 1, sum, p);

    }

    static void printSubsetsRec(int[] arr, int n, int sum, ArrayList<Integer> p) {

        if (n == 0 && sum != 0 && dp[0][sum]) {
            p.add(arr[n]);
            System.out.println(p);
            p.clear();
            return;
        }
        //sum achieved
        if (n == 0 && sum == 0) {
            System.out.println(p);
            p.clear();
            return;
        }
        //excluding
        if (dp[n - 1][sum]) {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            printSubsetsRec(arr, n - 1, sum, b);
        }
        //including
        if (sum >= arr[n] && dp[n - 1][sum - arr[n]]) {
            p.add(arr[n]);
            printSubsetsRec(arr, n - 1, sum - arr[n], p);
        }
    }
}
