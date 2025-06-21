public class PdfDocument implements Document{

    @Override
    public void create(){
        System.out.println("Creating Pdf Document");
    }

    @Override
    public void open(){
        System.out.println("opening Pdf Document");
    }

    @Override
    public void close(){
        System.out.println("Closing Pdf Document");
    }
}
