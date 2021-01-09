public class MusteriOrt extends Musteri{
    public MusteriOrt(String musteriAdi, double urunSayisi) {
        super(musteriAdi, urunSayisi);
    }


    @Override
    public String toString() {
        return "Musteri Adı : "+ getMusteriAdi() +" ve İşlem Süresi : " + getUrunSayisi() ;
    }
}