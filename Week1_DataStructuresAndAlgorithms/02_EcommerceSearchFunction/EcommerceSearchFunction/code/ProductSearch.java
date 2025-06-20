import java.util.*;

public class ProductSearch {

    // Linear Search by Product Name
    public static String linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(name)) {
                return p.getProductName() +" is Available";
            }
        }
        return name +" is not Available";
    }

    // Binary Search by Product Name
    public static String binarySearch(Product[] products, String name) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(name);
            if (cmp == 0) return products[mid].getProductName()+" is Available";
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return name +" is not Available";
    }
}
