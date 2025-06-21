public class CustomerTest {
    public static void main(String[] args) {
        CustomerRepository cRepo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(cRepo);

        service.displayCustomer(1);
        service.displayCustomer(2);
    }
}
