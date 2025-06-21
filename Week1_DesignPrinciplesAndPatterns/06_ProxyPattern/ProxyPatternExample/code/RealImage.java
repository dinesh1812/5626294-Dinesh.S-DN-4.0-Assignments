public class RealImage implements Image{
    private String filename;

    public RealImage(String filename){
        this.filename = filename;
        loadfromLocalServer();
    }
    private void loadfromLocalServer(){
        System.out.println("Loading Image from Local Server: "+ filename);
        display();
    }
    @Override
    public void display(){
        System.out.println("Displaying image: "+ filename);
    }

    public void lazyDisplay(){
        System.out.println("Displaying after Loading image: "+ filename);
    }
}
