/*
A simple calculator, based on finite automation machine.
2013-3-24
 */
public class Calculator {
    private State STATE0;
    private State STATE1;
    private State STATE2;
    private State STATE3;
    private State STATE4;
    private State state;

    final static String INPUTSTR = "0123456789.+-*/=C";
    final static String OPERATOR = "+-*/";

    private String input = "";
    private String result = "";
    private String operator = "";
    private boolean inputDot = false;

    public Calculator() {
	STATE0 = new State0(this);
	STATE1 = new State1(this);
	STATE2 = new State2(this);
	STATE3 = new State3(this);
	STATE4 = new State4(this);
	state = STATE0;
    }

    public boolean isDigit(char v) {
	return (v == '.') ||
	    (v >= '0' && v <= '9');
    }
    
    public boolean isOperator(char v) {
	return OPERATOR.indexOf(v) != -1;
    }

    public void clear() {
	state = STATE0;
	input = "";
	result = "";
	operator = "";
	inputDot = false;
    }

    public void updateDisplay() {
	String display = "0";
	if(input.length() != 0) {
	    display = input;
	} else if(result.length() != 0) {
	    display = result;
	}
	System.out.println(">>"+display);
    }

    public void calculate() {
	double tmp = 0;
	double op1 = Double.parseDouble(result);
	double op2 = Double.parseDouble(input);
	switch(operator) {
	case "+":
	    tmp = op1 + op2;
	    break;
	case "-":
	    tmp = op1 - op2;
	    break;
	case "*":
	    tmp = op1 * op2;
	    break;
	case "/":
	    tmp = op1 / op2;
	    break;
	}
	result = Double.toString(tmp);
	input = "";
	inputDot = false;
    }

    public void appendDigit(char v) {
	if(v == '.') {
	    if(inputDot) return;
	    if(input.length() == 0)
		input = "0";
	    inputDot = true;
	}
	input += v;
    }

    public State getState0() {
	return STATE0;
    }

    public State getState1() {
	return STATE1;
    }

    public State getState2() {
	return STATE2;
    }

    public State getState3() {
	return STATE3;
    }

    public State getState4() {
	return STATE4;
    }

    public void setState(State s) {
	state = s;
    }

    public void s0(char v) {
	state.s0(v);
    }

    public void s1(char v) {
	if(isDigit(v)) {
	    appendDigit(v);
	} else if(isOperator(v)) {
	    operator = String.valueOf(v);
	    result = input;
	    input = "";
	    state = STATE2;
	} else if(v == 'C') {
	    clear();
	    state = STATE0;
	} else if(v == '=') {
	    result = input;
	    input = "";
	    state = STATE4;
	}
	updateDisplay();
    }

    public void s2(char v) {
	if(isDigit(v)) {
	    appendDigit(v);
	    state = STATE3;
	} else if(isOperator(v)) {
	    operator = String.valueOf(v);
	} else if(v == 'C') {
	    clear();
	    state = STATE0;
	} else if(v == '=') {
	    operator = "";
	    state = STATE4;
	}
	updateDisplay();
    }

    public void s3(char v) {
	if(isDigit(v)) {
	    appendDigit(v);
	} else if(isOperator(v)) {
	    calculate();
	    operator = String.valueOf(v);
	    state = STATE2;
	} else if(v == 'C') {
	    clear();
	    state = STATE0;
	} else if(v == '=') {
	    calculate();
	    operator = "";
	    state = STATE4;
	}
	updateDisplay();
    }

    public void s4(char v) {
	if(isDigit(v)) {
	    result = "";
	    appendDigit(v);
	    state = STATE1;
	} else if(isOperator(v)) {
	    operator = String.valueOf(v);
	    state = STATE2;
	} else if(v == 'C') {
	    clear();
	    state = STATE0;
	} else if(v == '=') {
	}
	this.updateDisplay();
    }

    public void go(char v) {
	switch(state) {
	case STATE0:
	    s0(v);
	    break;
	case STATE1:
	    s1(v);
	    break;
	case STATE2:
	    s2(v);
	    break;
	case STATE3:
	    s3(v);
	    break;
	case STATE4:
	    s4(v);
	    break;
	}
    }

    public void testDrive(String ops) {
	System.out.println("\n");
	System.out.println(ops);
	for(int i = 0; i < ops.length(); ++i) {
	    char c = ops.charAt(i);
	    if(INPUTSTR.indexOf(c) != -1)
		go(c);
	}
    }
}
