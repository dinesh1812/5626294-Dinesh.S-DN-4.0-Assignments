public class CustomerService {
    private CustomerRepository cRepo;

    public CustomerService(CustomerRepository cRepo){
        this.cRepo = cRepo;
    }
    public void displayCustomer(int id){
        String customer = cRepo.findCustomerById(id);
        System.out.println(customer);
    }
}
