import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
    Observable observable;
    private float currentPressure = 29.92f;
    private float lastPressure;
    
    public ForecastDisplay(Observable o) {
	observable = o;
	observable.addObserver(this);
    }
    
    public void update(Observable o, Object arg) {
	if(o instanceof WeatherData) {
	    WeatherData wd = (WeatherData)o;
	    lastPressure = currentPressure;
	    currentPressure = wd.getPressure();
	    display();
	}
    }

    public void display() {
	System.out.println("Forecast, current pressure: " + currentPressure);
    }
}
	
