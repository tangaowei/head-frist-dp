public class LightOnCommand implements Command {
    Light light;
    
    public LightOnCommand(Light l) {
	light = l;
    }

    public void execute() {
	light.on();
    }

    public void undo() {
	light.off();
    }
}
