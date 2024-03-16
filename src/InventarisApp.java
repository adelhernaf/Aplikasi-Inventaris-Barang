import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarisApp<T extends Barang> {

    private List<T> daftarBarang = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventarisApp<Barang> app = new InventarisApp<>();
        app.start();
    }

    private void start() {
        int pilihan;
        do {
            System.out.println("=== APLIKASI INVENTARIS BARANG ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Daftar Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Ubah Informasi Barang");
            System.out.println("5. Hapus Barang");
            System.out.println("6. Hitung Total Harga Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    tampilkanDaftarBarang();
                    break;
                case 3:
                    cariBarang();
                    break;
                case 4:
                    ubahInformasiBarang();
                    break;
                case 5:
                    hapusBarang();
                    break;
                case 6:
                    hitungTotalHargaBarang();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    private void tambahBarang() {
        System.out.print("Masukkan kode barang: ");
        String kodeBarang = scanner.next();
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.next();
        System.out.print("Masukkan harga barang: ");
        double hargaBarang = scanner.nextDouble();
        System.out.print("Masukkan jenis barang (elektronik/pakaian): ");
        String jenisBarangStr = scanner.next();
        JenisBarang jenisBarang = JenisBarang.valueOf(jenisBarangStr.toUpperCase());

        Barang barang;
        if (jenisBarang == JenisBarang.ELEKTRONIK) {
            System.out.print("Masukkan garansi (bulan): ");
            int garansi = scanner.nextInt();
            barang = new BarangElektronik(kodeBarang, namaBarang, hargaBarang, garansi);
        } else if (jenisBarang == JenisBarang.PAKAIAN) {
            System.out.print("Masukkan ukuran: ");
            String ukuran = scanner.next();
            barang = new BarangPakaian(kodeBarang, namaBarang, hargaBarang, ukuran);
        } else {
            System.out.println("Jenis barang tidak valid!");
            return;
        }

        daftarBarang.add((T) barang);

        System.out.println("Barang berhasil ditambahkan!");
    }

    private void tampilkanDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang masih kosong!");
            return;
        }

        System.out.println("=== DAFTAR BARANG ===");
        for (T barang : daftarBarang) {
            System.out.println("Kode Barang: " + barang.getKodeBarang());
            System.out.println("Nama Barang: " + barang.getNamaBarang());
            System.out.println("Harga Barang: Rp" + barang.getHargaBarang());
            if (barang instanceof BarangElektronik) {
                BarangElektronik barangElektronik = (BarangElektronik) barang;
                System.out.println("Garansi: " + barangElektronik.getGaransi() + " bulan");
            } else if (barang instanceof BarangPakaian) {
                BarangPakaian barangPakaian = (BarangPakaian) barang;
                System.out.println("Ukuran: " + barangPakaian.getUkuran());
            }
            System.out.println();
        }
    }

    private void cariBarang() {
        System.out.print("Masukkan kode atau nama barang: ");
        String keyword = scanner.next();

        Barang barang = temukanBarang(keyword);
    }