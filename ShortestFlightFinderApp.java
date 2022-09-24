import java.io.FileNotFoundException;
import java.util.List;

public class ShortestFlightFinderApp {
	public static void main() throws FileNotFoundException {
		List<AirportDataInterface> airports = new AirportLoader().loadAllFilesInDirectory(
				".", "airportIndex.csv");

		ShortestFlightBackEndInterface engine = new ShortestFlightBackEnd();
		for (AirportDataInterface airport : airports) engine.addAirport(airport);

		int count = airports.size();
		ShortestFlightFrontEndInterface ui = new ShortestFlightFrontEnd(count);
		ui.run(engine);

		Exception e = new Exception();
		e.printStackTrace();
	}
}
