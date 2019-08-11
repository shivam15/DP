import java.util.*;

/**
 *
 * @author shivam
 */

class GoldMineDP {
    public static void main(String args[]) {
        GoldMineDP obj = new GoldMineDP();
        int gold[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
        System.out.print(obj.getMaxGold(gold));
    }

    int getMaxGold(int[][] gold) {
        int n = gold.length;
        int m = gold[0].length;
        int[][] mat = new int[gold.length][gold[0].length];
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                int right = (col == n - 1) ? 0 : mat[row][col + 1];
                int right_up = (row == 0 || col == n - 1) ? 0 : mat[row - 1][col + 1];
                int right_down = (row == m - 1 || col == n - 1) ? 0 : mat[row + 1][col + 1];
                mat[row][col] = gold[row][col] + Math.max(right, Math.max(right_up, right_down));
            }
        }
        int res = mat[0][0];

        for (int i = 1; i < m; i++)
            res = Math.max(res, mat[i][0]);

        return res;
    }
}