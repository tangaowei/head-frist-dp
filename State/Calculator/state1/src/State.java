public abstract class State {
    private Calculator cal;
    
    public State(Calculator c) {
	this.cal = c;
    }

    public void s0(char v) {
	if(cal.isDigit(v)) {
	    cal.appendDigit(v);
	    cal.setState(cal.getState1());
	}
	cal.updateDisplay();
    }

    public void s1(char);
    public void s2(char);
    public void s3(char);
    public void s4(char);
}
