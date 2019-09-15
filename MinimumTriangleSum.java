/**
 * @author shivam
 */
public class MinimumTriangleSum {

    public static void main(String args[]) {
        int tri[][] = {{2, 0, 0, 0},
                {3, 7, 0, 0},
                {8, 5, 6, 0},
                {6, 1, 9, 3}};
        System.out.println(maxPathSum(tri, 3, 3));
    }

    static int maxPathSum(int[][] tri, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {
                if (tri[i + 1][j] > tri[i + 1][j + 1]) {
                    tri[i][j] += tri[i + 1][j+1];
                } else {
                    tri[i][j] += tri[i + 1][j];
                }
            }
        }
        return tri[0][0];
    }
}
