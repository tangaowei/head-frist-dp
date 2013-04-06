import java.util.ArrayList;
import java.util.Iterator;
public class PancakeHouseIterator implements Iterator<MenuItem> {
    ArrayList<MenuItem> items;
    int pos = 0;
    
    public PancakeHouseIterator(ArrayList<MenuItem> items) {
	this.items = items;
    }

    public MenuItem next() {
	MenuItem menuItem = items.get(pos);
	pos++;
	return menuItem;
    }

    public boolean hasNext() {
	if(pos >= items.size()) {
	    return false;
	} else {
	    return true;
	}
    }
    
    public void remove() {}
}