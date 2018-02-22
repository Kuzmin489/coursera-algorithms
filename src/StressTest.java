import javafx.util.Pair;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;

public class StressTest {

    public static void main(String[] args) {
       stressTest(
               FibonacciSumLastDigit::getFibonacciSumNaive,
               FibonacciSumLastDigit::getFibonacciSumNaive,
               () -> generateRandomLong(1, 60));
    }


    private static long generateRandomLong(int start, int end) {
        return ThreadLocalRandom.current().nextLong(start, end + 1);
    }

    private static<T, R> void stressTest(Function<T, R> naive, Function<T, R> optimized, Supplier<T> parameterGenerator) {
        while (true) {
            T paremeters = parameterGenerator.get();
            long startTime = System.nanoTime();
            R result1 = naive.apply(paremeters);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000;

            long startTime2 = System.nanoTime();
            R result2 = optimized.apply(paremeters);
            long endTime2 = System.nanoTime();
            long duration2 = (endTime2 - startTime2) / 1000;


            if(result1.equals(result2)) {
                System.out.println(String.format("Reslut: %s , Naive method take: %s ms", result1, duration));
                System.out.println(String.format("Reslut: %s , Optimized take: %s ms", result2, duration2));
            } else {
                System.out.println(String.format("Wrong answer: %s %s", result1, result2));
                return;
            }
        }
    }




}
