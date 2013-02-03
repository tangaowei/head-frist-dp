import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Observable o) {
	observable = o;
	observable.addObserver(this);
    }

    public void update(Observable obs, Object arg) {
	if(obs instanceof WeatherData) {
	    WeatherData wd = (WeatherData)obs;
	    temperature = wd.getTemperature();
	    humidity = wd.getHumidity();
	    display();
	}
    }

    public void display() {
	System.out.println("Current conditions: " + temperature
			   +"F degrees and " + humidity + "% humidity");
    }
}
