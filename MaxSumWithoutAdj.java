public class MaxSumWithoutAdj {

    public static void main(String args[]) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(findMax(arr));
    }

    static int findMax(int[] arr) {
        int exc = 0;
        int inc = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(exc, inc);
            inc = exc + arr[i];
            exc = temp;
        }
        return Math.max(exc, inc);
    }
}
