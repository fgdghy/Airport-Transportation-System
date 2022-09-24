//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.List;
//import java.lang.invoke.MethodHandles;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.console.ConsoleLauncher;
//
//
//public class ShortestFlightFinderTests {
//	public static void main(String[] args) throws Exception {
//		// Run Tests
//		String className = MethodHandles.lookup().lookupClass().getName();
//		String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
//		String[] arguments = new String[] {
//		    "-cp",
//		    classPath,
//		    "--include-classname=.*",
//		    "--select-class=" + className };
//		ConsoleLauncher.main(arguments);
//	}
//
//	// Data Wrangler Tests
//
//	// Back End Developer Tests
//	/**
//	 * Test the correctness of the addAirport() method
//	 * Author: Allison Lee, Backend Developer
//	 */
//	@Test
//	public void backendDeveloper_TestAddAirport() {
//	    ShortestFlightBackEnd engine = new ShortestFlightBackEnd();
//
//	    List<Integer> connected1 = new ArrayList<>();
//	    List<Integer> connected2 = new ArrayList<>();
//	    List<Integer> connected3 = new ArrayList<>();
//
//	    List<Integer> distance1 = new ArrayList<>();
//	    List<Integer> distance2 = new ArrayList<>();
//	    List<Integer> distance3 = new ArrayList<>();
//
//	    AirportData airport1 = new AirportData(1, connected1, distance1);
//	    AirportData airport2 = new AirportData(2, connected2, distance2);
//	    AirportData airport3 = new AirportData(3, connected3, distance3);
//
//
//	    engine.addAirport(airport1);
//	    engine.addAirport(airport2);
//	    engine.addAirport(airport3);
//
//
//	    assertTrue(engine.containsAirport(airport1));
//	    assertTrue(engine.containsAirport(airport2));
//	    assertTrue(engine.containsAirport(airport3));
//	}
//
//	/**
//	 * Test the correctness of the removeAirport() method
//	 * Author: Allison Lee, Backend Developer
//	 */
//	@Test
//	public void backendDeveloper_TestRemoveAirport() {
//	    ShortestFlightBackEnd engine = new ShortestFlightBackEnd();
//
//List<Integer> connected4 = new ArrayList<>();
//List<Integer> connected5 = new ArrayList<>();
//List<Integer> connected6 = new ArrayList<>();
//
//List<Integer> distance4 = new ArrayList<>();
//List<Integer> distance5 = new ArrayList<>();
//List<Integer> distance6 = new ArrayList<>();

//	    AirportData airport4 = new AirportData(1, connected4, distance4);
//	    AirportData airport5 = new AirportData(2, connected5, distance5);
//	    AirportData airport6 = new AirportData(3, connected6, distance6);
//
//
//	    engine.addAirport(airport4);
//	    engine.addAirport(airport5);
//	    engine.addAirport(airport6);
//
//	    assertTrue(engine.containsAirport(airport4));
//	    assertTrue(engine.containsAirport(airport5));
//	    assertTrue(engine.containsAirport(airport6));
//
//	    engine.removeAirport(airport4);
//	    engine.removeAirport(airport5);
//	    engine.removeAirport(airport6);
//
//	    assertTrue(!engine.containsAirport(airport4));
//	    assertTrue(!engine.containsAirport(airport5));
//	    assertTrue(!engine.containsAirport(airport6));
//	}
//
//	/**
//	 * Test the correctenss of the printShortestPath() and flightTime() methods
//	 * Author: Allison Lee, BackendDeveloper
//	 */
//	@Test
//	public void backendDeveloper_TestPrintShortestPath() {
//	    ShortestFlightBackEnd engine = new ShortestFlightBackEnd();
//
//	    //Lists of connections for each airport
//	    List<Integer> connected7 = new ArrayList<>();
//	    connected7.add(8);
//	    connected7.add(9);
//	    connected7.add(10);
//	    List<Integer> connected8 = new ArrayList<>();
//	    connected8.add(9);
//	    connected8.add(11);
//	    List<Integer> connected9 = new ArrayList<>();
//	    connected9.add(8);
//	    connected9.add(12);
//	    List<Integer> connected10 = new ArrayList<>();
//	    connected10.add(11);
//	    List<Integer> connected11 = new ArrayList<>();
//	    connected11.add(7);
//	    List<Integer> connected12 = new ArrayList<>();
//	    connected12.add(7);
//	    connected12.add(10);
//
//	    //List of relative distances for each airport's connections
//	    List<Integer> distance7 = new ArrayList<>();
//	    distance7.add(6);
//	    distance7.add(2);
//	    distance7.add(5);
//	    List<Integer> distance8 = new ArrayList<>();
//	    distance8.add(2);
//	    distance8.add(1);
//	    List<Integer> distance9 = new ArrayList<>();
//	    distance9.add(3);
//	    distance9.add(1);
//	    List<Integer> distance10 = new ArrayList<>();
//	    distance10.add(3);
//	    List<Integer> distance11 = new ArrayList<>();
//	    distance11.add(4);
//	    List<Integer> distance12 = new ArrayList<>();
//	    distance12.add(1);
//	    distance12.add(1);
//
//	    AirportData airport7 = new AirportData(7, connected7, distance7);
//	    AirportData airport8 = new AirportData(8, connected8, distance8);
//	    AirportData airport9 = new AirportData(9, connected9, distance9);
//	    AirportData airport10 = new AirportData(10, connected10, distance10);
//	    AirportData airport11 = new AirportData(11, connected11, distance11);
//	    AirportData airport12 = new AirportData(12, connected12, distance12);
//
//	    engine.addAirport(airport7);
//	    engine.addAirport(airport8);
//	    engine.addAirport(airport9);
//	    engine.addAirport(airport10);
//	    engine.addAirport(airport11);
//	    engine.addAirport(airport12);
//
//	    assertEquals(engine.printShortestPath(airport8, airport11), "8 -> 11");
//	    assertEquals(engine.flightTime(airport8, airport11), 1);
//	    assertEquals(engine.printShortestPath(airport10, airport8), "10 -> 11 -> 7 -> 9 -> 8");
//	    assertEquals(engine.flightTime(airport10, airport8), 12);
//	}
// 	// Front End Developer Tests
//    /**
//     * Test method for adding an airport to the database.
//     * Author: Ankit Mohanty, Front End Developer
//     **/
//    @Test
//    public void frontendDeveloper_TestAddAirport() {
//	boolean success = false;
//
//	TextUITester tester = new TextUITester("1\n12\n1\n34\n67\n");
//	ShortestFlightFrontEnd ui = new ShortestFlightFrontEnd();
//	ui.run(new ShortestFlightBackEnd());
//
//	String originPrompt = "Please enter the origin airport to add (numerical values only): ";
//	String addDestPrompt = "Please enter the number of additional airport destinations you'd like to add: ";
//	String destPrompt = "Please enter the destination airport to add (numerical values only): (1)-> ";
//	String timePrompt = "Please enter the flight duration: (12 -> 34) ";
//	String successMessage = "Airport added successfully!";
//	String output = tester.checkOutput();
//
//	if(output.contains(originPrompt) && output.contains(addDestPrompt) && output.contains(destPrompt) && output.contains(timePrompt)
//	   && output.contains(successMessage)) {
//	       success = true;
//	}
//
//	assertEquals(success, true);
//    }
//
//     /**
//     * Test method for removing an airport from the database.
//     * Author: Ankit Mohanty, Front End Developer
//     **/
//    @Test
//  public void frontendDeveloper_TestRemoveAirport() {
//boolean success = false;
//
//TextUITester tester = new TextUITester("2\n456\n");
//ShortestFlightFrontEnd ui = new ShortestFlightFrontEnd();
//ui.run(new ShortestFlightBackEnd());
//
//String originPrompt = "Please enter the airport you'd like to delete: ";
//String failureMessage = "Airport not found within the database!";
//String output = tester.checkOutput();
//
//if(output.contains(originPrompt) && output.contains(failureMessage)) {
//       success = true;
//}

//assertEquals(success, true);
//  }
//
//    /**
//     * Test method for finding the shortest path.
//     * Author: Ankit Mohanty, Front End Developer
//     **/
//   @Test
//   public void frontendDeveloper_TestPrintShortestFlight() {
//	boolean success = false;
//
//	TextUITester tester = new TextUITester("3\n12\n12\n");
//	ShortestFlightFrontEnd ui = new ShortestFlightFrontEnd();
//	ui.run(new ShortestFlightBackEnd());
//
//	String originPrompt = "Please enter the origin airport: ";
//	String destPrompt = "Please enter the destination airport: ";
//	String pathMessage = "Path not found!";
//	String output = tester.checkOutput();
//
//	if(output.contains(originPrompt) && output.contains(destPrompt) && output.contains(pathMessage)) {
//	       success = true;
//	}
//
//	assertEquals(success, true);
//    }
//
//
//
//	// Integration Manager Tests
//}



