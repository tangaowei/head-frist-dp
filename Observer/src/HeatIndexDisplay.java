public class HeatIndexDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public HeatIndexDisplay(Subject wd) {
	weatherData = wd;
	wd.registerObserver(this);
    }
    
    public void update(float t, float h, float p) {
	temperature = t;
	humidity = h;
	pressure = p;
	display();
    }

    public void display() {
	float headIndex = temperature;
	System.out.println("HeatIndex: " + headIndex);
    }
	
}