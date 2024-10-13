import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DenominationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah uang: ");
        int amount = scanner.nextInt();

        Map<Integer, Integer> results = calculateDenominations(amount);

        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            System.out.println(entry.getValue() + " lembar " + entry.getKey());
        }
    }

    public static Map<Integer, Integer> calculateDenominations(int amount) {
        int[] denominations = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 100};
        Map<Integer, Integer> results = new HashMap<>();

        for (int denomination : denominations) {
            int count = amount / denomination;
            amount %= denomination;
            if (count > 0) {
                results.put(denomination, count);
            }
        }

        return results;
    }
}
