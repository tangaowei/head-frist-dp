public class Whip extends CondimentDecorator {
    Beverage beverage;
    
    public Whip(Beverage b) {
	beverage = b;
    }

    public String getDescription() {
	return beverage.getDescription() + ", Whip";
    }

    public double cost() {
	return 0.15 + beverage.cost();
    }
}
