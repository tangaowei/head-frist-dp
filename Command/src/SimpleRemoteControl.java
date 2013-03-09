public class SimpleRemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;
    
    public SimpleRemoteControl() {
	onCommands = new Command[7];
	offCommands = new Command[7];
	Command noCommand = new NoCommand();
	for(int i = 0; i < 7; ++i) {
	    onCommands[i] = noCommand;
	    offCommands[i] = noCommand;
	}
	undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCmd, Command offCmd) {
	onCommands[slot] = onCmd;
	offCommands[slot] = offCmd;
    }

    public void onButtonWasPressed(int slot) {
	onCommands[slot].execute();
	undoCommand = onCommands[slot];
    }

    public void offButtonWasPressed(int slot) {
	offCommands[slot].execute();
	undoCommand = offCommands[slot];
    }
    
    public void undoButtonWasPressed() {
	undoCommand.undo();
    }
}
