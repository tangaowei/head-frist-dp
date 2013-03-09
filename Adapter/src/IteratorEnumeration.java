import java.util.Enumeration;
import java.util.Iterator;
public class IteratorEnumeration<E> implements Enumeration<E> {
    private Iterator<E> it;
    public IteratorEnumeration(Iterator<E> it) {
	this.it = it;
    }

    public boolean hasMoreElements() {
	return it.hasNext();
    }

    public E nextElement() {
	return it.next();
    }
}
