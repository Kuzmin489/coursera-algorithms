import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //10 denomination
        int tenCoins = m / 10;
        m = m - (tenCoins * 10);
        //5 denomination
        int fiveCoins = m / 5;
        m = m - (fiveCoins * 5);
        return tenCoins + fiveCoins + m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

