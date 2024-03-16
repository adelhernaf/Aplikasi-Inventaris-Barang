public class BarangPakaian extends Barang {

    private String ukuran;

    public BarangPakaian (String kodeBarang, String namaBranag, double hargaBarang, String ukuran) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.ukuran = ukuran;
    }

    @Override
    public double hitungHargaTotal(int kuantitas) {
        double hargaTotal = kuantitas * hargaBarang;
        if (kuantitas >= 10) {
            hargaTotal *= (1 - (diskon/100));
        }
        return hargaTotal;
    }

    public String getUkuran() {
        return ukuran;
    }
    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }
}
