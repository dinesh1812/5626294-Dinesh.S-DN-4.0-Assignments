public class ExcelDocument implements Document{

    @Override
    public void create(){
        System.out.println("Creating Excel Document");
    }

    @Override
    public void open(){
        System.out.println("opening Excel Document");
    }

    @Override
    public void close(){
        System.out.println("Closing Excel Document");
    }
}
