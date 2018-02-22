import java.util.Scanner;

public class Fibonacci {
    private static long calcFibNaive(int n) {
        if (n <= 1)
            return n;

        return calcFibNaive(n - 1) + calcFibNaive(n - 2);
    }

    private static long calcFibOptimized(int n) {
        if (n <= 1) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();


        long startTime = System.nanoTime();
        System.out.println(calcFibNaive(n));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println(String.format("It took %s ms", duration));
        startTime = System.nanoTime();
        System.out.println(calcFibOptimized(n));
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000;
        System.out.println(String.format("Optimized algorithm  took %s ms", duration));
    }
}
