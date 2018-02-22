import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, List<Pair<Integer, Integer>> items) {
        double maxValue = 0.0;
        items.sort(Comparator.comparingDouble(o -> o.getValue() / (double) o.getWeight()));
        //write your code here

        while (capacity > 0 && !items.isEmpty()) {

            Pair<Integer, Integer> mostValuableItem = items.get(items.size() - 1);
            if (capacity >= mostValuableItem.getWeight()) {
                capacity = capacity - mostValuableItem.getWeight();
                maxValue += mostValuableItem.getValue();
                items.remove(items.size() - 1);
            } else {
                double takenValue = (mostValuableItem.getValue() / (double) mostValuableItem.getWeight()) * capacity;
                maxValue += takenValue;
                capacity = 0;
            }
        }

        return new BigDecimal(maxValue).setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        List<Pair<Integer, Integer>> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items.add(new Pair<>(value, weight));
        }
        System.out.println(getOptimalValue(capacity, items));
    }

    private static class Pair<L, R> {
        private final L value;
        private final R weight;

        Pair(L value, R weight) {
            this.value = value;
            this.weight = weight;
        }

        L getValue() {
            return value;
        }

        R getWeight() {
            return weight;
        }
    }
}
