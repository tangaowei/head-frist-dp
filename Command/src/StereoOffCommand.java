public class StereoOffCommand implements Command {
    Stereo stereo;

    public StereoOffCommand(Stereo s) {
	stereo = s;
    }

    public void execute() {
	stereo.off();
    }

    public void undo() {
	stereo.on();
	stereo.setCD();
	stereo.setVolume(11);
    }
}
