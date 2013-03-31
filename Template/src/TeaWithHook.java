public class TeaWithHook extends CaffeineBeverageWithHook {
    public void brew() {
	System.out.println("Dripping Tea through filter");
    }

    public void addCondiments() {
	System.out.println("Adding lemon");
    }

    public boolean customerWantsCondiments() {
	String answer = getUserInput();
	if(answer.toLowerCase().startsWith("y")) {
	    return true;
	} else {
	    return false;
	}
    }
    
    private String getUserInput() {
	return "y";
    }
}