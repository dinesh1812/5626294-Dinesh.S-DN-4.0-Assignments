public class ComputerBuilderTest {
    public static void main(String[] args) {
        // Basic configuration
        Computer basicComputer = new Computer.ComputerBuilder()
                .setCpu("Intel i3")
                .setRam("4GB")
                .setStorage("256GB SSD")
                .build();

        // High-end gaming configuration
        Computer gamingComputer = new Computer.ComputerBuilder()
                .setCpu("AMD Ryzen 9")
                .setRam("32GB")
                .setStorage("1TB NVMe")
                .setGpu("NVIDIA RTX 4080")
                .setOs("Windows 11")
                .build();

        System.out.println("Basic Computer: " + basicComputer.display());
        System.out.println("Gaming Computer: " + gamingComputer.display());
    }
}
