/**
 * @author shivam
 */
public class MaximumTriangleSum {

    public static void main(String args[]) {
        int tri[][] = {{1, 0, 0, 0},
                {1, 2, 0, 0},
                {4, 1, 2, 0},
                {2, 3, 1, 1}};
        System.out.println(maxPathSum(tri, 3, 3));
    }

    static int maxPathSum(int[][] tri, int n, int m) {
        for (int i = m - 1; i >= 0; i--) {

            for (int j = 0; j <= i; j++) {
                if (tri[i + 1][j] > tri[i + 1][j + 1]) {
                    tri[i][j] += tri[i + 1][j];
                } else {
                    tri[i][j] += tri[i + 1][j + 1];
                }
            }
        }
        return tri[0][0];
    }
}
