import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    ArrayList<MenuComponent> menuList = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String n, String d) {
	name = n;
	description = d;
    }

    public void add(MenuComponent m) {
	menuList.add(m);
    }

    public void remove(MenuComponent m) {
	menuList.remove(m);
    }

    public MenuComponent getChild(int i) {
	return menuList.get(i);
    }

    public String getName() {
	return name;
    }

    public String getDescription() {
	return description;
    }

    public void print() {
	System.out.println("\n" + getName());
	System.out.println(", " + getDescription());
	System.out.println("------------------------");
	
	Iterator<MenuComponent> iterator = menuList.iterator();
	while(iterator.hasNext()) {
	    MenuComponent menuComp = iterator.next();
	    menuComp.print();
	}
    }

    public Iterator<MenuComponent> createIterator() {
	return new ComponentIterator(menuList.iterator());
    }
}

