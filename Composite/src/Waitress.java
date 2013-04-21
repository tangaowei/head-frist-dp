import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent m) {
	allMenus = m;
    }
    
    public void printMenu() {
	allMenus.print();
    }

    public void printVegetables() {
	Iterator<MenuComponent> it = allMenus.createIterator();
	while(it.hasNext()) {
	    MenuComponent menu = it.next();
	    if(menu.isVegetarian()) {
		System.out.println(menu.getName());
	    }
	}
    }
}
