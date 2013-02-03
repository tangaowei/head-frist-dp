public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject wd) {
	weatherData = wd;
	wd.registerObserver(this);
    }

    public void update(float t, float h, float p) {
	temperature = t;
	humidity = h;
	display();
    }

    public void display() {
	System.out.println("Current condition:" + temperature +
			   "F degrees and " + humidity + "% humidity");
    }
}