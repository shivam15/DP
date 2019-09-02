import java.util.*;

/**
 * @author shivam
 */
public class MinJumpsDP {

    public static void main(String args[]) {
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }

    static int minJumps(int[] arr) {
        if (arr.length <= 1)
            return 0;
        int jumps = 1;
        int step = arr[0];
        int maxReach = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jumps;
            maxReach = Math.max(maxReach, i + arr[i]);
            step--;
            if (step == 0) {
                jumps++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }
        return -1;
    }
}
