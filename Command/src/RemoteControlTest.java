public class RemoteControlTest {
    public static void main(String[] args) {
	SimpleRemoteControl remote = new SimpleRemoteControl();

	Light light = new Light();
	GarageDoor garageDoor = new GarageDoor();
	Stereo stereo = new Stereo("Living Room");

	LightOnCommand lightOn = new LightOnCommand(light);
	LightOffCommand lightOff = new LightOffCommand(light);
	GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
	GarageDoorOffCommand garageOff = new GarageDoorOffCommand(garageDoor);
	StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
	StereoOffCommand stereoOff = new StereoOffCommand(stereo);

	remote.setCommand(0, lightOn, lightOff);
	remote.onButtonWasPressed(0);
	remote.offButtonWasPressed(0);
	remote.undoButtonWasPressed();

	remote.setCommand(1, garageOpen, garageOff);
	remote.onButtonWasPressed(1);
	remote.offButtonWasPressed(1);

	remote.setCommand(2, stereoOnWithCD, stereoOff);
	remote.onButtonWasPressed(2);
	remote.offButtonWasPressed(2);

	System.out.println("\nMacro Commands:\n");
	Command[] onCmds = {lightOn, garageOpen, stereoOnWithCD};
	Command[] offCmds = {lightOff, garageOff, stereoOff};
	MacroCommand onMacro = new MacroCommand(onCmds);
	MacroCommand offMacro = new MacroCommand(offCmds);
	remote.setCommand(3, onMacro, offMacro);

	remote.onButtonWasPressed(3);
	remote.undoButtonWasPressed();
    }
}
