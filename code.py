# Modul pemilih (modules/pemilih.py)
class PemilihManager:
    def __init__(self):
        self.pemilih_list = []

    def tambah_pemilih(self, id, nama, jurusan):
        if any(p['id'] == id for p in self.pemilih_list):
            raise ValueError(f"ID Pemilih '{id}' sudah ada!")
        self.pemilih_list.append({
            "id": id,
            "nama": nama,
            "jurusan": jurusan,
            "sudah_memilih": False
        })

    def validasi_pemilih(self, id):
        return any(p['id'] == id for p in self.pemilih_list)

    def sudah_memilih(self, id):
        for p in self.pemilih_list:
            if p['id'] == id:
                return p['sudah_memilih']
        return False

    def set_sudah_memilih(self, id):
        for p in self.pemilih_list:
            if p['id'] == id:
                p['sudah_memilih'] = True
                return
        raise ValueError(f"ID Pemilih '{id}' tidak ditemukan!")

# Modul calon (modules/calon.py)
class CalonManager:
    def __init__(self):
        self.calon_list = []

    def tambah_calon(self, id, nama, visi):
        if any(c['id'] == id for c in self.calon_list):
            raise ValueError(f"ID Calon '{id}' sudah ada!")
        self.calon_list.append({
            "id": id,
            "nama": nama,
            "visi": visi,
            "jumlah_suara": 0
        })

    def validasi_calon(self, id):
        return any(c['id'] == id for c in self.calon_list)

    def tambah_suara(self, id):
        for c in self.calon_list:
            if c['id'] == id:
                c['jumlah_suara'] += 1
                return
        raise ValueError(f"ID Calon '{id}' tidak ditemukan!")

    def tampilkan_semua(self):
        if not self.calon_list:
            print("Belum ada data calon.")
            return
        print("\nData Calon Ketua dan Jumlah Suara:")
        print(f"{'ID':<10} {'Nama':<20} {'Visi':<30} {'Suara':<6}")
        print("-"*70)
        for c in self.calon_list:
            print(f"{c['id']:<10} {c['nama']:<20} {c['visi']:<30} {c['jumlah_suara']:<6}")
        print("-"*70)

# Modul voting (modules/voting.py)
class VotingManager:
    def __init__(self, pemilih_manager: PemilihManager, calon_manager: CalonManager):
        self.pm = pemilih_manager
        self.cm = calon_manager

    def voting(self, id_pemilih, id_calon):
        if not self.pm.validasi_pemilih(id_pemilih):
            raise ValueError(f"ID Pemilih '{id_pemilih}' tidak valid.")
        if self.pm.sudah_memilih(id_pemilih):
            raise ValueError(f"Pemilih dengan ID '{id_pemilih}' sudah memilih.")
        if not self.cm.validasi_calon(id_calon):
            raise ValueError(f"ID Calon '{id_calon}' tidak valid.")

        self.pm.set_sudah_memilih(id_pemilih)
        self.cm.tambah_suara(id_calon)
        print(f"Pemilih dengan ID '{id_pemilih}' berhasil memilih Calon '{id_calon}'.")

# Modul statistik (modules/statistik.py)
class StatistikManager:
    def __init__(self, pemilih_manager: PemilihManager, calon_manager: CalonManager):
        self.pm = pemilih_manager
        self.cm = calon_manager

    def total_pemilih(self):
        return len(self.pm.pemilih_list)

    def jumlah_yang_memilih(self):
        return sum(1 for p in self.pm.pemilih_list if p['sudah_memilih'])

    def persentase_partisipasi(self):
        total = self.total_pemilih()
        if total == 0: return 0
        return (self.jumlah_yang_memilih() / total) * 100

    def calon_terbanyak(self):
        if not self.cm.calon_list:
            return None
        max_suara = max(c['jumlah_suara'] for c in self.cm.calon_list)
        pemenang = [c for c in self.cm.calon_list if c['jumlah_suara'] == max_suara]
        return pemenang  # Bisa lebih dari 1 kalau seri

    def tampilkan_statistik(self):
        print("\nSTATISTIK PEMILU")
        print(f"Total Pemilih         : {self.total_pemilih()}")
        print(f"Jumlah yang sudah memilih: {self.jumlah_yang_memilih()}")
        print(f"Persentase partisipasi : {self.persentase_partisipasi():.2f}%")
        pemenang = self.calon_terbanyak()
        if not pemenang:
            print("Belum ada calon yang terdaftar.")
        elif len(pemenang) == 1:
            c = pemenang[0]
            print(f"Calon dengan suara terbanyak: {c['nama']} (ID: {c['id']}) dengan {c['jumlah_suara']} suara.")
        else:
            print("Terdapat beberapa calon dengan jumlah suara terbanyak (seri):")
            for c in pemenang:
                print(f"- {c['nama']} (ID: {c['id']}) dengan {c['jumlah_suara']} suara.")

# MAIN interactive CLI
def menu():
    pm = PemilihManager()
    cm = CalonManager()
    vm = VotingManager(pm, cm)
    sm = StatistikManager(pm, cm)

    while True:
        print("\n=== Sistem Simulasi E-Voting ===")
        print("1. Tambah Pemilih")
        print("2. Tambah Calon Ketua")
        print("3. Voting")
        print("4. Tampilkan Hasil Sementara")
        print("5. Tampilkan Statistik Pemilu")
        print("6. Keluar")

        pilihan = input("Pilih menu (1-6): ").strip()
        if pilihan == '1':
            try:
                id = input("Masukkan ID Pemilih: ").strip()
                nama = input("Masukkan Nama Pemilih: ").strip()
                jurusan = input("Masukkan Jurusan Pemilih: ").strip()
                pm.tambah_pemilih(id, nama, jurusan)
                print("Pemilih berhasil ditambahkan.")
            except ValueError as e:
                print("Error:", e)

        elif pilihan == '2':
            try:
                id = input("Masukkan ID Calon: ").strip()
                nama = input("Masukkan Nama Calon: ").strip()
                visi = input("Masukkan Visi Misi Calon: ").strip()
                cm.tambah_calon(id, nama, visi)
                print("Calon ketua berhasil ditambahkan.")
            except ValueError as e:
                print("Error:", e)

        elif pilihan == '3':
            try:
                id_pemilih = input("Masukkan ID Pemilih: ").strip()
                id_calon = input("Masukkan ID Calon Pilihan: ").strip()
                vm.voting(id_pemilih, id_calon)
            except ValueError as e:
                print("Error:", e)

        elif pilihan == '4':
            cm.tampilkan_semua()

        elif pilihan == '5':
            sm.tampilkan_statistik()

        elif pilihan == '6':
            print("Terima kasih telah menggunakan sistem ini.")
            break

        else:
            print("Pilihan tidak valid. Silakan pilih menu yang tersedia.")

if __name__ == "__main__":
    menu()

