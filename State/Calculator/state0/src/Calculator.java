/*
A simple calculator, based on finite automation machine.
2013-3-24
 */
public class Calculator {
    final static int STATE0 = 0;
    final static int STATE1 = 1;
    final static int STATE2 = 2;
    final static int STATE3 = 3;
    final static int STATE4 = 4;

    final static String INPUTSTR = "0123456789.+-*/=C";
    final static String OPERATOR = "+-*/";

    private int state = STATE0;
    private String input = "";
    private String result = "";
    private String operator = "";
    private boolean inputDot = false;

    private boolean isDigit(char v) {
	return (v == '.') ||
	    (v >= '0' && v <= '9');
    }
    
    private boolean isOperator(char v) {
	return OPERATOR.indexOf(v) != -1;
    }

    private void clear() {
	state = STATE0;
	input = "";
	result = "";
	operator = "";
	inputDot = false;
    }

    private void updateDisplay() {
	String display = "0";
	if(input.length() != 0) {
	    display = input;
	} else if(result.length() != 0) {
	    display = result;
	}
	System.out.println(">>"+display);
    }

    private void calculate() {
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

    private void appendDigit(char v) {
	if(v == '.') {
	    if(inputDot) return;
	    if(input.length() == 0)
		input = "0";
	    inputDot = true;
	}
	input += v;
    }

    public void s0(char v) {
	if(isDigit(v)) {
	    appendDigit(v);
	    state = STATE1;
	}
	updateDisplay();
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
