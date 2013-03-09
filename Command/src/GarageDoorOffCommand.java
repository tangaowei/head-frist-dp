public class GarageDoorOffCommand implements Command {
    GarageDoor garagedoor;
    
    public GarageDoorOffCommand(GarageDoor g) {
	garagedoor = g;
    }

    public void execute() {
	garagedoor.lightOff();
    }

    public void undo() {
	garagedoor.lightOn();
    }
}
