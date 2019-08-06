import java.util.*;

/**
 *
 * @author shivam
 */

/**
 * Cn+1 = sum(Ci*Cn-i)
 */

class CatalianNumberDP {
    public static void main(String args[]) {
        CatalianNumberDP obj = new CatalianNumberDP();
        for (int i = 0; i < 10; i++) {
            System.out.print(obj.getNthCatalianNo(i) + " ");
        }
    }

    int getNthCatalianNo(int n) {
        int[] cat = new int[n + 2];
        Arrays.fill(cat, 0);
        cat[0] = 1;
        cat[1] = 1;
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                cat[i] += cat[j] * cat[i - j - 1];
            }
        }
        return cat[n];
    }
}