import java.util.*;
/**
 *
 * @author shivam
 */

 

class FibonacciNumbersDP {
    public static void main(String args[]) {
        int n = 9;
        FibonacciNumbersDP obj = new FibonacciNumbersDP();
        System.out.println(obj.getFib(n));
    }

    int getFib(int n) {
        int fib[] = new int[n+2];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}