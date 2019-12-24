import java.util.*;

/**
 * @author shivam
 */
public class RepeatedSubDP {

    public static void main(String args[]) {
        String str = "AAB";

        if (check(str))
            System.out.println("Repeated Subsequence Exists");
        else
            System.out.println("Repeated Subsequence" +
                    " Doesn't Exists");
    }

    private static boolean isPalindrome(String str, int l, int h) {
        while (l < h) {
            if (str.charAt(h--) != str.charAt(l++)) {
                return false;
            }
        }
        return true;
    }

    private static boolean check(String str) {
        int n = str.length();
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i)]++;
            if (freq[str.charAt(i)] > 2)
                return true;
        }
        int k = 0;
        for (int i = 0; i < n; i++)
            if (freq[str.charAt(i)] > 1)
                str.replace(str.charAt(k++), str.charAt(i));

        str.replace(str.charAt(k), '\0');

        if (isPalindrome(str, 0, k - 1)) {
            if ((k & 1) == 1) {
                if (k / 2 >= 1)
                    return (str.charAt(k / 2) ==
                            str.charAt(k / 2 - 1));
            }
            return false;
        }
        return true;
    }

}
