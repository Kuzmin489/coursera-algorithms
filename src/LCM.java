import java.util.*;

public class LCM {

    private static long lcm_optimized(long a, long b) {
        return (a * b) / gcd_optimized(a, b);
    }

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

        System.out.println(lcm_optimized(a, b));
    }
}
