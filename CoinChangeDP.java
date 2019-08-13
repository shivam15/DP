import java.util.*;

/**
 *
 * @author shivam
 */

class CoinChangeDP {
    public static void main(String args[]) {
        CoinChangeDP obj = new CoinChangeDP();
        int[] coins = { 1, 2, 3 };
        int n = 10;
        System.out.print(obj.getWays(coins, n));
    }

    int getWays(int[] coins, int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                table[j] += table[j - coins[i]];
            }
        }
        return table[n];
    }
}