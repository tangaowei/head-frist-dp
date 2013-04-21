import java.util.Iterator;
import java.util.Stack;
import java.util.ArrayList;

public class ComponentIterator implements Iterator<MenuComponent> {
    private Stack<MenuComponent> stack = new Stack<MenuComponent>();
    
    public ComponentIterator(Iterator<MenuComponent> it) {
	while(it.hasNext()) {
	    stack.push(it.next());
	}
    }

    public boolean hasNext() {
	return !stack.empty();
    }

    public MenuComponent next() {
	MenuComponent topMenu = stack.pop();
	if(topMenu instanceof MenuItem) {
	    return topMenu;
	} else {
	    Iterator<MenuComponent> it = topMenu.createIterator(); 
	    while(it.hasNext()) // depth first search
		stack.push(it.next());
	    return next();
	}
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }
}
