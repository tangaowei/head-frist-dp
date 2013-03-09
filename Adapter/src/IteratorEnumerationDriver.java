import java.util.ArrayList;
import java.util.Arrays;
public class IteratorEnumerationDriver {
    public static void main(String[] args) {
	String[] str = {"LL", "YY", "PP"};
	ArrayList<String> list = new ArrayList<String>(Arrays.asList(str));
	IteratorEnumeration<String> ie = new IteratorEnumeration<String>(list.iterator());

	while(ie.hasMoreElements()) {
	    System.out.println(ie.nextElement());
	}
    }
}
	
