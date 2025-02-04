package frames;
public class Cart {
    private static int itemCount = 0;

    public static void addItem() {
        itemCount++;
    }

    public static int getItemCount() {
        return itemCount;
    }
    public static void removeItem() {
        itemCount = 0;
    }
}
