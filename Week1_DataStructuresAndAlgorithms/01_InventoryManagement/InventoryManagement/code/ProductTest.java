public class ProductTest {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "TV", 100, 12000.00));
        manager.addProduct(new Product(2, "Laptop", 200, 20000.00));
        System.out.println("Inventory List : ");
        manager.display();
        System.out.println("");

        System.out.println("\nUpdating Product 1:");
        manager.updateProduct(1, "Gel Pen", 150, 12.0);
        manager.display();

        System.out.println("");
        System.out.println("\nDeleting Product 2:");
        manager.deleteProduct(2);
        manager.display();
    }
}
