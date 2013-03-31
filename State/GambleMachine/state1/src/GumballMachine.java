public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;
    
    public GumballMachine(int n) {
	soldOutState = new SoldOutState(this);
	noQuarterState = new NoQuarterState(this);
	hasQuarterState = new HasQuarterState(this);
	soldState = new SoldState(this);
	winnerState = new WinnerState(this);
	this.count = n;
	if(n > 0) {
	    state = noQuarterState;
	}
    }

    public void insertQuarter() {
	state.insertQuarter();
    }

    public void ejectQuarter() {
	state.ejectQuarter();
    }

    public void turnCrank() {
	state.turnCrank();
	state.dispense();
    }

    void releaseBall() {
	System.out.println("A gumball comes rolling out the slot...");
	if(count != 0) {
	    --count;
	}
    }

    void setState(State s) {
	state = s;
    }

    State getNoQuarterState() {
	return noQuarterState;
    }

    State getHasQuarterState() {
	return hasQuarterState;
    }

    State getSoldState() {
	return soldState;
    }

    State getSoldOutState() {
	return soldOutState;
    }

    State getWinnerState() {
	return winnerState;
    }

    int getCount() {
	return count;
    }
    
    public String toString() {
	StringBuffer result = new StringBuffer();
	result.append("\nMighty Gumball, Inc.");
	result.append("\nJava-enabled Standing Gumball Model #2004");
	result.append("\nInventory: " + count + " gumball");
	if (count != 1) {
		result.append("s");
	}
	result.append("\n");
	result.append("Machine is " + state + "\n");
	return result.toString();
    }
}
