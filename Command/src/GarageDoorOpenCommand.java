public class GarageDoorOpenCommand implements Command {
    GarageDoor garagedoor;
    
    public GarageDoorOpenCommand(GarageDoor g) {
	garagedoor = g;
    }

    public void execute() {
	garagedoor.lightOn();
    }

    public void undo() {
	garagedoor.lightOff();
    }
}
