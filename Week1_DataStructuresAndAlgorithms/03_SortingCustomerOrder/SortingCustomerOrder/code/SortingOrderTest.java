public class SortingOrderTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1 , "Dinesh", 1000.00),
            new Order(2 , "Alice", 500.00),
            new Order(3 , "Bob", 1200.00)
        };

        OrderSort sort = new OrderSort();
        //Bubble Sort
        sort.bubbleSort(orders);
        System.out.println("Sorted using Bubble Sort:");
        for (Order o : orders){
            o.printOrder();
        }

        orders = new Order[]{
            new Order(1 , "Dinesh", 1000.00),
            new Order(2 , "Alice", 500.00),
            new Order(3 , "Bob", 1200.00)
        };

        // Quick Sort
        sort.quickSort(orders, 0, orders.length - 1);
        System.out.println("Sorted using Quick Sort:");
        for (Order o : orders)
        {
            o.printOrder();
        }
    }
}
