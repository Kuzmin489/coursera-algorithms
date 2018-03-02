import java.util.*;

public class DotProduct {
    private static long maxDotProduct(List<Integer> pricePerClick, List<Integer> clicks) {
        long result = 0;
        pricePerClick.sort(Collections.reverseOrder());
        clicks.sort(Collections.reverseOrder());
        //write your code here
        for (Integer price :
                pricePerClick) {
            result += (long)price * clicks.get(0);
            clicks.remove(0);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(i, scanner.nextInt());
        }
        List<Integer> b = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            b.add(i, scanner.nextInt());
        }
        System.out.println(maxDotProduct(a, b));
    }
}

