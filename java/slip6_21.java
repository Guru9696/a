// Command interface
interface Command {
    void execute();
}

// Concrete Command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Receiver
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command
class TVOnCommand implements Command {
    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

// Receiver
class TV {
    public void turnOn() {
        System.out.println("TV is ON");
    }

    public void turnOff() {
        System.out.println("TV is OFF");
    }
}

// Remote Control
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class slip6_21 {
    public static void main(String[] args) {
        // Create the receivers
        Light livingRoomLight = new Light();
        TV livingRoomTV = new TV();

        // Create the concrete commands
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command tvOnCommand = new TVOnCommand(livingRoomTV);

        // Create the remote control
        RemoteControl remote = new RemoteControl();

        // Set the commands for the remote control
        remote.setCommand(lightOnCommand);
        remote.pressButton(); // Turns on the light

        remote.setCommand(tvOnCommand);
        remote.pressButton(); // Turns on the TV
    }
}

