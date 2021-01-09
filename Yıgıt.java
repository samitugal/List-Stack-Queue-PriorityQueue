class Yıgıt {
    private int maxSize;
    private static Musteri[] stackArray;
    private static int top;

    public Yıgıt(int s)
    {
        maxSize = s;
        stackArray = new Musteri[maxSize];
        top = -1;
    }

    public static void ekle(Musteri X)
    {
        stackArray[++top] = X;
    }

    public static Musteri sil()
    {
        return stackArray[top--];
    }

    public static boolean bosMu()
    {
        return (top == -1);
    }

    public boolean doluMu()
    {
        return (top == maxSize - 1);
    }
}


