public class NoQuarterState implements State {
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine g) {
	this.gumballMachine = g;
    }

    public void insertQuarter() {
	System.out.println("You inserted a quarter");
	gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
	System.out.println("You haven't inserted a quarter");
    }

    public void turnCrank() {
	System.out.println("You turned, but there's no quarter");
    }

    public void dispense() {
	System.out.println("You need to pay first");
    }

    public String toString() {
	return "No Quarter State";
    }
}
	