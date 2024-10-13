import java.util.Scanner;

public class PassOrFail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai: ");
        int score = scanner.nextInt();

        String result = checkPass(score);

        System.out.println(" Anda " + result);
    }

    public static String checkPass(int score) {
        if (score > 75) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}


    





   