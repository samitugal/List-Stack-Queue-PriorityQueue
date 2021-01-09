import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] musteriAdi = { "Ali","Merve", "Veli","Gülay","Okan","Zekiye","Kemal","Banu","İlker","Songül","Nuri","Deniz"};
        int[] urunSayisi = { 8, 11, 16, 5, 15, 14, 19, 3, 18, 17, 13, 15 };
        Musteri musteri = new Musteri();
        Kuyruk queue = new Kuyruk(musteriAdi.length);
        Yıgıt yıgıt = new Yıgıt(musteriAdi.length);
        OncelikliSıra oncelikliSıra = new OncelikliSıra(musteriAdi.length);
        List<Musteri> musteriList = new ArrayList<Musteri>();
        OncelikliSıra oncelikliSıraReverse = new OncelikliSıra(musteriAdi.length);

        for(int i = 0 ; i < musteriAdi.length ; i++){
            Musteri musteriTemp = new Musteri(musteriAdi[i],urunSayisi[i]);
            musteriList.add(musteriTemp);
            queue.ekle(musteriTemp);
            yıgıt.ekle(musteriTemp);
            oncelikliSıra.ekle(musteriTemp);
            oncelikliSıraReverse.ekle(musteriTemp);
        }

        ArrayList<List<Musteri>> mainlist = musteri.sheredGenericList(musteriList);

        for(int i = 0 ; i<mainlist.size() ; i++){
            System.out.println(mainlist.get(i));
        }
        System.out.println("------------------------------------------------------------");

        musteri.ortalamaGoster(mainlist);

        System.out.println("------------------------------------------------------------");

        for(int i = 0 ; i < musteriAdi.length ; i++){
            System.out.println(yıgıt.sil());
        }

        System.out.println("------------------------------------------------------------");

        for(int i = 0 ; i < musteriAdi.length ; i++){
            System.out.println(queue.sil());
        }

        System.out.println("------------------------------------------------------------");

        for(int i = 0 ; i < musteriAdi.length ; i++){
            System.out.println(oncelikliSıraReverse.sil("max").toString());
        }

        System.out.println("------------------------------------------------------------");

        for(int i = 0 ; i < musteriAdi.length ; i++){
            System.out.println(oncelikliSıra.sil("min").toString());
        }

        System.out.println("------------------------------------------------------------");
        System.out.println();
        musteri.ortKasaSuresi(musteriList,"Kuyruk");
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
        musteri.ortKasaSuresi(musteriList,"OncelikliKuyruk");
        System.out.println();
        System.out.println("------------------------------------------------------------");



    }




}
