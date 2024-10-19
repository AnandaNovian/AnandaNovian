public class PolaPercabangan {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= i + 5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 6; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("1 ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j % 2 == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            for (int j = i; j <= 5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int[] deret = {1, 1, 2, 4, 7, 13, 24, 44, 81};
        for (int num : deret) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}