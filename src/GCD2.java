import java.util.*;

public class GCD2 {
    public static long gcd_naive(long a, long b) {
        int current_gcd = 1;
        for(int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static long gcd_optimized(long a, long b) {
        while (a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }

    private static long gcd_optimized2(long a, long b) {
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

        long startTime = System.nanoTime();
        long r1 = gcd_optimized2(a, b);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println(String.format("Reslut: %s , It take: %s ms", r1, duration));
        startTime = System.nanoTime();
        long r2 = gcd_optimized(a, b);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000;
        System.out.println(String.format("Reslut: %s , It take: %s ms", r2, duration));
    }
}
