public class WinnerState implements State {
    GumballMachine gumballMachine;
    
    public WinnerState(GumballMachine g) {
	gumballMachine = g;
    }

    public void insertQuarter() {
	System.out.println("Please wait, we are already giving you a gumball");
    }
    
    public void ejectQuarter() {
	System.out.println("Sorry, you already turned the crank");
    }

    public void turnCrank() {
	System.out.println("Turned crank twice does not give you another gumball");
    }

    public void dispense() {
	System.out.println("YOU ARE A WINNER! You get two gumballs for your quarter");
	gumballMachine.releaseBall();
	if(gumballMachine.getCount() == 0) {
	    gumballMachine.setState(gumballMachine.getSoldOutState());
	} else {
	    gumballMachine.releaseBall();
	    if(gumballMachine.getCount() > 0) {
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	    } else {
		System.out.println("Oops, out of gumballs");
		gumballMachine.setState(gumballMachine.getSoldOutState());
	    }
	}
    }

    public String toString() {
	return "Winner State";
    }
}