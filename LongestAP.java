import java.util.Arrays;

public class LongestAP {

    public static void main(String args[]) {
        int[] a = {9, 4, 7, 2, 10};
        System.out.print(getLongestAP(a) + "\n");
    }

    private static int getLongestAP(int[] arr) {
        if(arr.length<=2){
            return 2;
        }
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 2);
        Arrays.sort(arr);
        int ans = 2;
        for (int j = n - 2; j >= 0; j--) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < n) {
                if (arr[i] + arr[k] == arr[j] * 2) {
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                    ans = Math.max(ans, dp[j]);
                    i--;
                    k++;
                } else if (arr[i] + arr[k] > arr[j] * 2)
                    i--;
                else
                    k++;
            }
        }
        return ans;
    }
}
