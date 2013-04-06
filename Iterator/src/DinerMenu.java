import java.util.Iterator;
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
	menuItems = new MenuItem[MAX_ITEMS];
	
	addItem("Vegetarian BLT",
		"(Fakin') Bacon with lettuce & tomato on whole wheat",
		true,
		2.99);
	addItem("BLT",
		"Bacon with lettuce & tomato on whole wheat",
		false, 2.99);
	addItem("Soup of the day",
		"Soup of the day, with a side of potato salad",
		false, 3.29);
	addItem("Hotdog",
		"A hot dog, with saurkraut, relish, onions, topped with cheese",
		false, 3.05);
    }

    public void addItem(String name, String desc, boolean v, double p) {
	MenuItem menuItem = new MenuItem(name, desc, v, p);
	if(numberOfItems >= MAX_ITEMS) {
	    System.err.println("Sorry, menu is fall! Can't add item to menu");
	} else {
	    menuItems[numberOfItems] = menuItem;
	    numberOfItems = numberOfItems + 1;
	}
    }
 
    public Iterator<MenuItem> createIterator() {
	return new DinerMenuIterator(menuItems);
    }

    public MenuItem[] getMenuItems() {
	return menuItems;
    }
}