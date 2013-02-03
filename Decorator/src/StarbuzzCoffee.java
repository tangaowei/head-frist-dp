public class StarbuzzCoffee {
    public static void main(String[] args) {
	Beverage beverage = new Espresso();
	System.out.println(beverage.getDescription() + "$" + beverage.cost());
	
	Beverage b1 = new DarkRoast();
	b1 = new Mocha(b1);
	b1 = new Mocha(b1);
	b1 = new Whip(b1);
	System.out.println(b1.getDescription() + "$" + b1.cost());

	Beverage b2 = new HouseBlend();
	b2 = new Soy(b2);
	b2 = new Mocha(b2);
	b2 = new Whip(b2);
	System.out.println(b2.getDescription() + "$" + b2.cost());
    }
}
