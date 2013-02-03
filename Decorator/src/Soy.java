public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage b) {
	beverage = b;
    }

    public String getDescription() {
	return beverage.getDescription() + ", Soy";
    }

    public double cost() {
	return 0.10 + beverage.cost();
    }
}
