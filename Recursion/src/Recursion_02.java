
public class Recursion_02 {
    public static int factNonTail(int n) {
        if (n == 0) {
            return 1; // 0! = 1, base case
        }
        // Induction case: n! = n * (n-1)!
        return n * factNonTail(n-1); // non-tail recursion
    }
    public static int factTail(int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }
        return factTail(n-1, accumulator * n);
    }
    public static int factTailLoop(int n) {
        int accumulator = 1;
        int ind = n;
        while (ind > 0) {
            accumulator = accumulator * ind;
            ind = ind - 1;
        }
        return accumulator;
    }
    public static int factLoop(int n) {
        int res = 1;
        for(int i=2; i<=n; i++)
            res = res * i;
        return res;
    }
    public static int factUsingDP(int n) {
        int[] f = new int[n+1]; // 0, 1, .., n
        f[0] = 1; // Elementary solution
        for(int i=1; i<=n; i++)
            f[i] = f[i-1] * i;
        return f[n];
    }
    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        return (reverse(s.substring(1, s.length())) + s.charAt(0));
    }
    public static boolean palindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return ( (s.charAt(0) == s.charAt(s.length()-1))
                &&
                palindrome(s.substring(1, s.length()-1))
        );
    }
    public static void main(String[] args) {
        String s = "matym";
        if (palindrome(s)) System.out.println(s+" is Palindrome");
        else System.out.println(s+" is NOT Palindrome");
        System.out.println("The reverse of "+ s + " is " + reverse(s));

        int n = 5;
//        System.out.println(n + "! = " + factTailLoop(n));
//        System.out.println(n + "! = " + factTail(n, 1));
//        System.out.println(n + "! = " + factNonTail(n));
//        System.out.println(n + "! = " + factLoop(n));
//        System.out.println(n + "! = " + factUsingDP(n));
        System.out.println("Fibo2 " + n + " is " + fibo2(n));
        System.out.println("FiboLoop " + n + " is " + fiboLoop(n));
        System.out.println("FiboDP " + n + " is " + fiboDP(n));
    }
    public static int fiboDP(int n) {
        int[] f = new int[n+1];
        f[0] = 0; f[1] = 1; // two elementary solutions
        for(int i=2; i<=n; i++)
            f[i] = f[i-2] + f[i-1];
        return f[n];
    }
    public static int fiboLoop(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0, curr = 1;
        for(int i=2; i<=n; i++) {
            int f = prev + curr;
            prev = curr;
            curr = f;
        }
        return curr;
    }
    public static int fibo2(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo2(n-2) + fibo2(n-1);
    }
}