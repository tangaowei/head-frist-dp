public class SoldOutState implements State {
    GumballMachine gumballMachine;
    
    public SoldOutState(GumballMachine g) {
	gumballMachine = g;
    }

    public void insertQuarter() {
	System.out.println("You can not insert a quarter, the machine is sold out");
    }

    public void ejectQuarter() {
	System.out.println("You can not eject, you have not inserted a quarter yet");
    }

    public void turnCrank() {
	System.out.println("You turned but there is no gumballs");
    }

    public void dispense() {
	System.out.println("No gumball dispensed");
    }
    
    public String toString() {
	return "Sold Out State";
    }
}