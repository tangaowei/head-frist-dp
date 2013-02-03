public class WeatherStation {
    public static void main(String[] args) {
	WeatherData wd = new WeatherData();
	CurrentConditionDisplay cd = new CurrentConditionDisplay(wd);
	ForecastDisplay fd = new ForecastDisplay(wd);
	//	StatisticsDisplay sd = new StatisticsDisplay(wd);
	//	ForecastDisplay fd = new ForecastDisplay(wd);
	//	HeatIndexDisplay hd = new HeatIndexDisplay(wd);
	
	wd.setMeasurements(80.0f, 65.0f, 30.4f);
	wd.setMeasurements(82.0f, 70.0f, 29.2f);
	wd.setMeasurements(78.0f, 90.0f, 29.2f);
    }
}
