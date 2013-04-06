import java.util.Iterator;
public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu p, DinerMenu d) {
	pancakeHouseMenu = p;
	dinerMenu = d;
    }

    public void printMenu() {
	Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
	Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
	System.out.println("MENU\n------\nBREAKFAST");
	printMenu(pancakeIterator);
	System.out.println("\nLUNCH");
	printMenu(dinerIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
	while(iterator.hasNext()) {
	    MenuItem menuItem = iterator.next();
	    System.out.print(menuItem.getName() + ", ");
	    System.out.print(menuItem.getPrice() + " -- ");
	    System.out.println(menuItem.getDescription());
	}
    }
}