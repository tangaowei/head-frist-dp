public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] cmds) {
	commands = cmds;
    }

    public void execute() {
	int length = commands.length;
	for(int i = 0; i < length; ++i) {
	    commands[i].execute();
	}
    }

    public void undo() {
	int length = commands.length;
	for(int i = length - 1; i >= 0; --i) {
	    commands[i].undo();
	}
    }
}
