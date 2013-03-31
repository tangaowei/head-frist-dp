public class GumballMachineTestDrive {
    public static void main(String[] args) {
	GumballMachine gm = new GumballMachine(5);
	
	gm.testDrive("it");

	gm.testDrive("iet");

	gm.testDrive("itite");

	gm.testDrive("iititit");
    }
}
