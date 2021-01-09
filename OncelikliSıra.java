import java.util.ArrayList;
import java.util.List;

class OncelikliSıra {
    private int maxSize;
    List<Musteri> oncelikliList;
    private int nItems;

    public OncelikliSıra(int s) {
        maxSize = s;
        oncelikliList = new ArrayList<>(maxSize);
        nItems = 0;
    }

    public void ekle(Musteri obj) {
        oncelikliList.add(obj);
        nItems++;

    }

    public Musteri sil(String data) {
        if(data.equals("max")){
            int max = 0;

            for (int i = 0; i < oncelikliList.size(); i++) {
                if (oncelikliList.get(max).getUrunSayisi() < oncelikliList.get(i).getUrunSayisi()) {
                    max = i;
                }
            }
            Musteri musteri = oncelikliList.get(max);
            oncelikliList.remove((musteri));
            return musteri ;
        }

        else{
            int min = 0;
            for(int i =0;i<oncelikliList.size();i++){
                if(oncelikliList.get(min).getUrunSayisi() > oncelikliList.get(i).getUrunSayisi()){
                    min = i;
                }
            }
            Musteri musteri1 = oncelikliList.get(min);
            oncelikliList.remove((musteri1));
            return musteri1;
        }



    }


    public boolean bosMu() {
        return (nItems==0);
    }

    public boolean doluMu() {
        return (nItems == maxSize);
    }

}


