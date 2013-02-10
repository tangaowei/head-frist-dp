public class PizzaTestDrive {
    public static void main(String[] args) {
	PizzaStore nyStore = new NYPizzaStore();
	PizzaStore chStore = new ChicagoPizzaStore();
	
	Pizza p = nyStore.orderPizza("cheese");
	System.out.println("xx ordered a " + p.getName() + "\n");

	p = chStore.orderPizza("cheese");
	System.out.println("jj ordered a " + p.getName() + "\n");
    }
}
