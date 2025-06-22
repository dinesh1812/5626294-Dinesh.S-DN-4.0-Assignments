import java.util.*;

public class ProductManager {
    private Map <Integer, Product> productMap = new HashMap<>();
    
    public void addProduct(Product product){
        productMap.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, String productName, int qty, double price){
        Product p = productMap.get(productId);
        if(p != null){
            p.setProductName(productName);
            p.setQuantity(qty);
            p.setPrice(price);
        }else{
            System.out.println("Product Not Found !");
        }
    }

    public void deleteProduct(int productId){
        if(productMap.get(productId) == null){
            System.out.println("Product Not Found !");
        }else{
            productMap.remove(productId);
            System.out.println("Product Removed Successfully !");
        }
    }

    public void display(){
        for(Product p : productMap.values()){
            System.out.println("The Product: "+ p.getProductName()+ ", Price : Rs."+ p.getPrice() +", Quantity: "+ p.getQuantity());
        }
    }
}
