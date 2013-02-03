import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){}
    
    public void measurementsChanged() {
	setChanged();
	notifyObservers();
    }
    
    public void setMeasurements(float t, float h, float p) {
	temperature = t;
	humidity = h;
	pressure = p;
	measurementsChanged();
    }

    public float getTemperature() {
	return temperature;
    }

    public float getHumidity() {
	return humidity;
    }

    public float getPressure() {
	return pressure;
    }
}
