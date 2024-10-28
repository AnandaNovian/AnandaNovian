import java.util.ArrayList;
import java.util.Scanner;

class Buah {
    String nama;
    int harga;

    public Buah(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

class Pembelian {
    Buah buah;
    int jumlah;

    public Pembelian(Buah buah, int jumlah) {
        this.buah = buah;
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return buah.harga * jumlah;
    }
}

public class BelanjaBuah {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Buah> buahList = new ArrayList<>();
        ArrayList<Pembelian> pembelianList = new ArrayList<>();

        buahList.add(new Buah("apel", 35000));
        buahList.add(new Buah("jeruk", 50000));
        buahList.add(new Buah("mangga", 25000));
        buahList.add(new Buah("duku", 15000));
        buahList.add(new Buah("semangka", 20000));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Pilih Buah (0-4): ");
                int indexBuah = scanner.nextInt();
                System.out.print("Masukkan jumlah: ");
                int jumlah = scanner.nextInt();
                
                pembelianList.add(new Pembelian(buahList.get(indexBuah), jumlah));
                
                System.out.print("Input lagi? (y/n): ");
                String lagi = scanner.next();
                if (lagi.equalsIgnoreCase("n")) continue;

            } else if (pilihan == 2) {
                int total = 0;

                System.out.println("\nDaftar Belanja:");
                System.out.println("========================================");
                System.out.println("No.\tNama Buah\tJumlah\tHarga\tSubtotal");

                for (int i = 0; i < pembelianList.size(); i++) {
                    Pembelian pembelian = pembelianList.get(i);
                    int subtotal = pembelian.getSubtotal();
                    System.out.printf("%d\t%s\t\t%d\t%d\t%d\n", 
                        (i + 1), pembelian.buah.nama, pembelian.jumlah, pembelian.buah.harga, subtotal);
                    total += subtotal;
                }

                double diskon = total * 0.15;
                double totalBayar = total - diskon;

                System.out.println("========================================");
                System.out.printf("Total:\t\t\t\t\t%d\n", total);
                System.out.printf("Diskon(15%%):\t\t\t\t%.0f\n", diskon);
                System.out.printf("Total bayar:\t\t\t\t%.0f\n", totalBayar);

            } else if (pilihan == 3) {
                System.out.println("Keluar dari program.");
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
}
