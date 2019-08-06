import java.util.*;
/**
 *
 * @author shivam
 */

 

class UglyNumbersDP {
    public static void main(String args[]) {
        int n = 150;
        UglyNumbersDP obj = new UglyNumbersDP();
        System.out.println(obj.getNthUglyNo(n));
    }

    int getNthUglyNo(int n) {
        int ugly[] = new int[n];
        int two = 2;
        int three = 3;
        int five = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(two, Math.min(three, five));
            if (ugly[i] == two) {
                i2++;
                two = ugly[i2] * 2;
            }
            if (ugly[i] == three) {
                i3++;
                three = ugly[i3] * 3;
            }
            if (ugly[i] == five) {
                i5++;
                five = ugly[i5] * 5;
            }
        }
        return ugly[n - 1];
    }
}