import java.util.*;

public class GCD {
    private static long gcd_optimized(long a, long b) {
        while (a != 0 && b != 0) {
            if(a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }

        return a + b;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();

        System.out.println(gcd_optimized(a, b));
    }
}
