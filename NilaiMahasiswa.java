import java.util.ArrayList;

class Mahasiswa {
    String nama;
    int nilai;

    public Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getStatus() {
        return nilai >= 60 ? "Lulus" : "Tidak Lulus";
    }
}

public class NilaiMahasiswa {
    public static void main(String[] args) {
        ArrayList<Mahasiswa> mahasiswaList = new ArrayList<>();

        // Data input langsung sesuai contoh
        mahasiswaList.add(new Mahasiswa("Santi", 100));
        mahasiswaList.add(new Mahasiswa("Aldi", 50));
        mahasiswaList.add(new Mahasiswa("Riko", 100));
        mahasiswaList.add(new Mahasiswa("Rahmi", 90));
        mahasiswaList.add(new Mahasiswa("Koko", 50));

        System.out.println("DAFTAR NILAI MAHASISWA");
        System.out.println("================================");
        System.out.println("No\tNama\tNilai\tStatus");

        int total = 0;
        for (int i = 0; i < mahasiswaList.size(); i++) {
            Mahasiswa mhs = mahasiswaList.get(i);
            System.out.printf("%d\t%s\t%d\t%s\n", (i + 1), mhs.nama, mhs.nilai, mhs.getStatus());
            total += mhs.nilai;
        }

        double rataRata = (double) total / mahasiswaList.size();
        System.out.println("================================");
        System.out.printf("Jumlah: %d\n", total);
        System.out.printf("Nilai Rata-rata: %.2f\n", rataRata);
    }
}
