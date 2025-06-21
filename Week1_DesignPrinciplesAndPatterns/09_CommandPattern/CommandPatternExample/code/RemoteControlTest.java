public class RemoteControlTest {
    public static void main(String[] args) {
        Light flasLight = new Light();

        Command lightOn = new LightOnCommand(flasLight);
        Command lightOff = new LightOffCommand(flasLight);

        RemoteControl remote = new RemoteControl();

        // Light On
        remote.setCommand(lightOn);
        remote.pressButton();

        //Light Off
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
