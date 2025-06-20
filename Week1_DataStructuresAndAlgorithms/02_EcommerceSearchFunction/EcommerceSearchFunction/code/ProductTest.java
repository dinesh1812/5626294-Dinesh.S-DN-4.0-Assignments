public class ProductTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Shoes", "Footwear"),
            new Product(3, "Watch", "Accessories"),
            new Product(4, "Camera", "Electronics"),
            new Product(5, "T-shirt", "Apparel")
        };

        // Linear Search
        String result1 = ProductSearch.linearSearch(products, "Camera");
        System.out.println("Linear Search Result: " + result1);

        // Linear Search - Not Available
        String result2 = ProductSearch.linearSearch(products, "TV");
        System.out.println("Linear Search Result: " + result2);

        // Binary Search
        String result3 = ProductSearch.binarySearch(products, "Watch");
        System.out.println("Binary Search Result: " + result3);

        // Binary Search - Not Available
        String result4 = ProductSearch.binarySearch(products, "Clock");
        System.out.println("Binary Search Result: " + result4);
    }
}

