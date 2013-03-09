public class LightOffCommand implements Command {
    Light light;
    
    public LightOffCommand(Light l) {
	light = l;
    }

    public void execute() {
	light.off();
    }
    
    public void undo() {
	light.on();
    }
}
