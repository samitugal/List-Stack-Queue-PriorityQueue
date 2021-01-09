import java.util.ArrayList;
import java.util.List;

public class Musteri {

    private String musteriAdi ;
    private double urunSayisi ;

    public Musteri(String musteriAdi,double urunSayisi) {
        this.musteriAdi = musteriAdi;
        this.urunSayisi = urunSayisi;
    }

    public Musteri() {
    }

    public String toString() {
        return "Musteri Adı : " + musteriAdi + " ve Aldığı  Urun Sayısı : " + urunSayisi;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public double getUrunSayisi() {
        return urunSayisi;
    }
    public void setUrunSayisi(double urunSayisi) {
        this.urunSayisi = urunSayisi;
    }

    public int randomInt1to5(){

        double random = ((Math.random()*4)+1);
        int randomSayı = (int) random;
        return randomSayı;
    }

    public ArrayList<List<Musteri>> sheredGenericList(List<Musteri> list){
        int elemanSayısı = list.size();
        int sayac = 0;
        ArrayList<List<Musteri>> mainList = new ArrayList<List<Musteri>>();

        while(elemanSayısı != 0 ){
            List<Musteri> tempList = new ArrayList<Musteri>();
            if(elemanSayısı  > 5){
                for(int i = 0 ; i<randomInt1to5() ; i++){
                    tempList.add(list.get(sayac));
                    elemanSayısı--;
                    sayac++;

                }
            }
            else{
                for (int i = 0 ; i < elemanSayısı ; i++){
                    tempList.add(list.get(sayac));
                    elemanSayısı--;
                    sayac++;
                }
            }
            mainList.add(tempList);

        }
        return mainList;
    }


    public void ortKasaSuresi(List<Musteri> list , String Metod) {
        if(Metod.equals("Kuyruk")){
            ArrayList<Musteri> KuyrukSıralama = new ArrayList<Musteri>();
            ArrayList<Musteri> tempArray = new ArrayList<Musteri>();
            double islemUzunluk = 0;
            double toplamUzunluk=0;
            Kuyruk kuyruk = new Kuyruk(list.size());
            for(int i = 0 ; i<list.size() ; i++){
                kuyruk.ekle(list.get(i));
            }
            for(int k = 0 ; k<list.size() ; k++){
                MusteriOrt musteriOrt = new MusteriOrt(list.get(k).getMusteriAdi(),kuyruk.sil().getUrunSayisi());
                tempArray.add(musteriOrt);
            }
            for(int j = 0 ; j<tempArray.size() ; j++){
                islemUzunluk+=tempArray.get(j).getUrunSayisi();
                Musteri musteri = new Musteri(tempArray.get(j).musteriAdi,islemUzunluk);
                toplamUzunluk+=islemUzunluk;
                KuyrukSıralama.add(musteri);
            }
            for(int n = 0 ; n < KuyrukSıralama.size() ; n++){
                System.out.println("Müşterinin Adı : "+KuyrukSıralama.get(n).getMusteriAdi()+ " Müşterinin İşlem Süresi : " + KuyrukSıralama.get(n).getUrunSayisi());

            }
            System.out.println();
            System.out.println("Kasanın Ortalama Tamamlama Süresi : " + (toplamUzunluk/KuyrukSıralama.size()));
        }
        else{
            ArrayList<Musteri> oncelikliKuyrukSıralama = new ArrayList<>();
            ArrayList<Musteri> tempArray = new ArrayList<Musteri>();
            double islemUzunluk = 0;
            double toplamUzunluk=0;
            OncelikliSıra oncelikliSıra = new OncelikliSıra(list.size());
            OncelikliSıra oncelikliSıra1 = new OncelikliSıra(list.size());
            for(int i = 0 ; i < list.size() ; i++){
                oncelikliSıra.ekle(list.get(i));
                oncelikliSıra1.ekle(list.get(i));
            }
            for(int k = 0 ; k<list.size() ; k++){
                MusteriOrt musteriOrt = new MusteriOrt(oncelikliSıra.sil("min").getMusteriAdi(),oncelikliSıra1.sil("min").getUrunSayisi());
                tempArray.add(musteriOrt);
            }
            for(int j = 0 ; j<tempArray.size() ; j++){
                islemUzunluk+=tempArray.get(j).getUrunSayisi();
                Musteri musteri = new Musteri(tempArray.get(j).musteriAdi,islemUzunluk);
                toplamUzunluk+=islemUzunluk;
                oncelikliKuyrukSıralama.add(musteri);
            }
            for(int n = 0 ; n < oncelikliKuyrukSıralama.size() ; n++){
                System.out.println("Müşterinin Adı : "+oncelikliKuyrukSıralama.get(n).getMusteriAdi()+ " Müşterinin İşlem Süresi : " + oncelikliKuyrukSıralama.get(n).getUrunSayisi());

            }
            System.out.println();
            System.out.println("Kasanın Ortalama Tamamlama Süresi : " + (toplamUzunluk/oncelikliKuyrukSıralama.size()));
        }

            }

    public void ortalamaGoster(ArrayList<List<Musteri>> mainList ){
        Double topUrun = 0.0  ;
        int sayac = 1 ;
        for(int i = 0 ; i<mainList.size() ; i ++){
            topUrun+=mainList.get(i).size();
        }
        System.out.println("Arraylistin İçerdiği Liste Sayısı "+ mainList.size());
        System.out.println("Arraylistin Ortalama Eleman Sayısı : "+ (topUrun / mainList.size()) );
    }

}










