import java.math.BigInteger;
import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    private static int getFibonaciLastDigiItteration(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;
    }

    private static int getFibonaciLastDigiFastDoubling(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            // Loop invariant: a = F(m), b = F(m+1)
            // Double it
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
            // Advance by one conditionally
            if ((n & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
            }
        }
        return a.mod(BigInteger.TEN).intValue();
    }
    private static BigInteger multiply(BigInteger x, BigInteger y) {
        return x.multiply(y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long startTime = System.nanoTime();
        int r1 = getFibonaciLastDigiItteration(n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println(String.format("Reslut: %s , It take: %s ms", r1, duration));
        startTime = System.nanoTime();
        int r2 = getFibonaciLastDigiFastDoubling(n);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000;
        System.out.println(String.format("Reslut: %s , It take: %s ms", r2, duration));
    }
}

