import java.util.*;

/**
 * @author shivam
 */
public class SubarrayMaxSum {

    public static void main(String args[]) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(a));
    }

    static int maxSubArraySum(int[] arr) {
        int n = arr.length;
        int start = 0, end = 0, s = 0;
        int maxEnding = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (maxEnding + arr[i] > 0) {
                maxEnding += arr[i];
                if (max < maxEnding) {
                    max = maxEnding;
                    start = s;
                    end = i;
                }
            } else {
                maxEnding = 0;
                s = i + 1;
            }
        }
        return end - start + 1;
    }
}
