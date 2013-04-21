public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String n, String d, boolean v, double p) {
	name = n;
	description = d;
	vegetarian = v;
	price = p;
    }

    public String getName() {
	return name;
    }

    public String getDescription() {
	return description;
    }

    public double getPrice() {
	return price;
    }

    public boolean isVegetarian() {
	return vegetarian;
    }

    public void print() {
	System.out.println(" " + getName());
	if(isVegetarian()) {
	    System.out.println("(v)");
	}
	System.out.println(", " + getPrice());
	System.out.println("      --" + getDescription());
    }
}
