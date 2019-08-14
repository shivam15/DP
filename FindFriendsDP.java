import java.util.*;

/**
 *
 * @author shivam
 */

class FindFriendsDP {
    public static void main(String args[]) {
        FindFriendsDP obj = new FindFriendsDP();
        int n = 10;
        System.out.print(obj.countFriendsPairings(n));
    }

    int countFriendsPairings(int n) {
        int a = 1, b = 2, c = 0;
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            c = b + (i - 1) * a;
            a = b;
            b = c;
        }
        return c;
    }
}