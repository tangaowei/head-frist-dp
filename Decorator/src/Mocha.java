public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage b) {
	beverage = b;
    }

    public String getDescription() {
	return beverage.getDescription() + ", Mocha";
    }

    public double cost() {
	return 0.2 + beverage.cost();
    }
}
