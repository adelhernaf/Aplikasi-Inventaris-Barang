public class BarangElektronik extends Barang {
    
    private int garansi;

    public BarangElektronik(String kodeBarang, String namaBarang, double hargaBarang, int garansi) {
        super(kodeBarang, namaBarang, hargaBarang) ;
        this.garansi = garansi;
    }

    @Override
    public double hitungHargaTotal (int kuantitas) {
        return kuantitas * hargaBarang * (1 + (diskon/100)) ;
    }

    public int getGagransi() {
        return garansi;
    }
    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }
}
