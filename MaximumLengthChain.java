import java.util.*;

/**
 * @author shivam
 */
public class MaximumLengthChain {

    public static void main(String args[]) {
        MaximumLengthChain obj = new MaximumLengthChain();
        Pair arr[] = new Pair[]{new Pair(5, 24), new Pair(27, 40), new Pair(15, 25),
                new Pair(50, 60)};
        System.out.println("Length of maximum size chain is " +
                maxChainLength(arr));
    }

    static int maxChainLength(Pair[] arr) {
        int n = arr.length;
        PairComparator p = new PairComparator();
        //sort array
        Arrays.sort(arr, p);
        int mcl[] = new int[n];
        Arrays.fill(mcl, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].x > arr[j].y && mcl[i] < mcl[j] + 1) {
                    mcl[i] = mcl[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            if (max < mcl[i])
                max = mcl[i];

        return max;

    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.x < o2.x) return -1;
            if (o1.x > o2.x) return 1;
            else return 0;
        }
    }
}
