public class Kuyruk {

    private int maxSize;
    private Musteri[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Kuyruk(int s)
    {
        maxSize = s;
        queArray = new Musteri[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void ekle(Musteri j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public Musteri sil()
    {
        Musteri temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public boolean bosMu()
    {
        return (nItems==0);
    }
}



