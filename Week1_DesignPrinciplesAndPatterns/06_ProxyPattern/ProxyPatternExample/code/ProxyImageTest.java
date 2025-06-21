public class ProxyImageTest {
    public static void main(String[] args) {
        Image img1 = new ProxyImage("Watch.png");
        Image img2 = new ProxyImage("Laptop.png");

        // image will be loaded from remote only once per instance
        img1.display();  // loads + displays
        img1.display();  // just displays (no loading)

        img2.display();  // loads + displays
        img2.display();  // just displays
    }
}
