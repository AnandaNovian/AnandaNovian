import java.util.Scanner;

public class HargaJeruk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah jeruk yang ingin dibeli: ");
        int jumlah = scanner.nextInt();
        
        int totalHarga = hitungHarga(jumlah);
        
        System.out.println("beli " + jumlah + " = " + totalHarga);
    }

    public static int hitungHarga(int jumlah) {
        int total = 0;

        // Menghitung jumlah paket 5
        int paket5 = jumlah / 5;
        total += paket5 * 10000;

        // Menghitung jumlah paket 2 setelah paket 5
        int sisaSetelah5 = jumlah % 5;
        int paket2 = sisaSetelah5 / 2;
        total += paket2 * 5000;

        // Menghitung sisa jeruk yang tidak terpaket
        int sisaSetelah2 = sisaSetelah5 % 2;
        total += sisaSetelah2 * 3000;

        return total;
    }
}

