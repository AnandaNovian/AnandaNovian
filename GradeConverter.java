import java.util.Scanner;

public class GradeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai: ");
        int score = scanner.nextInt();

        String grade = convertGrade(score);

        System.out.println(" Anda mendapatkan grade " + grade);

    }

    public static String convertGrade(int score) {
        if (score > 85) {
            return "A";
        } else if (score > 75) {
            return "B";
        } else if (score > 65) {
            return "C";
        } else if (score > 55) {
            return "C";
        } else  {
            return "E";
        }

    }
}
