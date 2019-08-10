import java.util.*;

/**
 *
 * @author shivam
 */

/**
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 */

class BinomialDP {
    public static void main(String args[]) {
        BinomialDP obj = new BinomialDP();
        System.out.print(obj.getBinomialCoff(10, 2) + " ");
    }

    int getBinomialCoff(int n, int k) {
        int[][] bin = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++)
                if (j == 0 || j == i)
                    bin[i][j] = 1;
                else
                    bin[i][j] = bin[i - 1][j - 1] + bin[i - 1][j];
        }
        return bin[n][k];
    }
}