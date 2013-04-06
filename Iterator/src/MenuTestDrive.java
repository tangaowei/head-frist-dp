public class MenuTestDrive {
    public static void main(String[] args) {
	PancakeHouseMenu pm = new PancakeHouseMenu();
	DinerMenu dm = new DinerMenu();
	
	Waitress waitress = new Waitress(pm, dm);
	
	waitress.printMenu();
    }
}