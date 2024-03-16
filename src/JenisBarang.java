public enum JenisBarang {
    Elektronik,
    Pakaian;

    Barang barangElektronik = new BarangElektronik("B001", "TV LED", 5000000, 12);
    System.out.println("Jenis Barang: " + barang.getJenisBarang());

    Barang barangPakaian = new BarangPakaian("P001", "Uniqlo", 100000, 10);
    System.out.println("Jenis Barang: " + barang.getJenisBarang());
}