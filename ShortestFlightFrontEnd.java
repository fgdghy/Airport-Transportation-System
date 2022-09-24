// --== CS400 File Header Information ==--
// Name: Ankit Mohanty
// Email: mohanty5@wisc.edu
// Team: AT
// TA: Cameron Ruggles
// Lecturer: Gary Dahl
// Notes to Grader: None

import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// interface (implemented with proposal)
interface ShortestFlightFrontEndInterface {
	public void run(ShortestFlightBackEndInterface flightEngine);

	// Here is a list of options that the user can choose to interact with
	// the Shortest Flight Finder App.
	// 1. Add a New Airport
	// 2. Remove an Exisiting Airport
	// 3. Find the Shortest Flight
}

// public class (implemented primarily in final app week)
public class ShortestFlightFrontEnd implements ShortestFlightFrontEndInterface  {

	private Scanner scnr = new Scanner(System.in);
	int index;
	public ShortestFlightFrontEnd(int index) {
		this.index = index;
	}


	public static void main(String[] args) {
		ShortestFlightFrontEndInterface ui = new ShortestFlightFrontEnd(1);
		ui.run(new ShortestFlightBackEnd());
	}
	/**
	 * Method to run the Shortest Flight Finder and prompt the user with
	 * menu options.
	 **/
	@Override
	public void run(ShortestFlightBackEndInterface flightEngine) {
		menuOptions(flightEngine);
	}

	/**
	 * Prompts the user with options to find the shortest flight.
	 **/
	private void menuOptions(ShortestFlightBackEndInterface flightEngine) {
		String promptMessage = "->->->->->->->->->-> Shortest Flight Finder <-<-<-<-<-<-<-<-<-<-\n" +
				"\t\t1. Add a New Airport\n" +
				"\t\t2. Remove an Exisitng Aiport\n" +
				"\t\t3. Find the Shortest Flight\n" +
				"\t\t4. Quit\n" +
				"Please enter the desired choice: ";

		String exitPrompt = "n";
		do {
			System.out.println(promptMessage);
			int optionVal = insertedNumber();

			if(optionVal == 1) {
				insertAirport(flightEngine);

			} else if (optionVal == 2) {

				removeAirport(flightEngine);

			} else if (optionVal == 3) {

				printShortestFlight(flightEngine);

			} else if (optionVal == 4) {
				System.out.println("Are you sure you want to exit (y/n)? ");
				exitPrompt = scnr.next();
				if(exitPrompt.equalsIgnoreCase("y")) {
					System.out.println("Program exiting successfully!");
					System.exit(0);
				}
			} else
				System.out.println("Enter a valid input (1-4)!");
		} while(exitPrompt.equalsIgnoreCase("n"));
	}

	/**
	 * Private helper method to take a string
	 */
	private String insertString() {
		String s = "";
		while(!scnr.hasNextLine()){
			scnr.next();
			System.out.println("Please enter a valid input");
		}

		s = scnr.nextLine();
		return s;
	}

	/**
	 * Private helper method to take a number
	 */
	private int insertedNumber() {
		int num = 0;
		while(!scnr.hasNextInt()){
			scnr.next();
			System.out.println("Please enter a valid input");
		}
		num = scnr.nextInt();
		scnr.nextLine();
		return num;
	}

	/**
	 * Method to insert a new aiport into the Shortest Flight Finder App.
	 **/
	private void insertAirport(ShortestFlightBackEndInterface flightEngine) {
		List<Integer> airportDestinations = new ArrayList<>();
		List<Integer> flightTimes = new ArrayList<>();
		int airportIndex = index;

		String promptOriginAirport = "Please enter the name of airport to add: ";
		String promptAdditionalAirportDestinations = "Please enter the number of additional airport destinations you'd like to add: ";
		String promptDestinationAirport = "Please enter the destination airport to add (numerical values only): ";
		String promptFlightTime = "Please enter the flight duration: ";

		System.out.println(promptOriginAirport);
		String originAirport = insertString();

		System.out.println(promptAdditionalAirportDestinations);
		int numberOfDestinations = insertedNumber();

		int count = 1;
		while (numberOfDestinations != 0) {
			System.out.println(flightEngine.getAllAirport());
			System.out.println(promptDestinationAirport + " (" + count + ")" + "-> ");

			int destAirport = insertedNumber();
			System.out.println(promptFlightTime + " (" + originAirport + " -> " + destAirport + ") ");
			int flightTime = insertedNumber();
			--numberOfDestinations;
			++count;
			++index;
			airportDestinations.add(destAirport);
			flightTimes.add(flightTime);
		}

		flightEngine.addAirport(new AirportData(airportIndex, originAirport, airportDestinations, flightTimes));
		System.out.println("Airport added successfully!");
		System.out.println("Index assigned to this airport is: " + index);
	}

	/**
	 * Method to remove airport from the database.
	 **/
	private void removeAirport(ShortestFlightBackEndInterface flightEngine) {
		String promptAirport = "Please enter the airport you'd like to delete: ";
		System.out.println(promptAirport);
		int removeAirport = insertedNumber();

		AirportDataInterface toRemoveAirport = flightEngine.getAirportByIndex(removeAirport);
		if(toRemoveAirport == null) {
			System.out.println("Airport not found within the database!");
		} else if(flightEngine.containsAirport(toRemoveAirport)) {
			flightEngine.removeAirport(toRemoveAirport);
			System.out.println("Airport deleted successfully!");
		}
	}

	/**
	 * Method to find the shortest flight path between two destinations using Dijkstra's algorithm.
	 **/
	private void printShortestFlight(ShortestFlightBackEndInterface flightEngine) {
		String promptOriginAirport = "Please enter the origin airport: ";
		System.out.println(promptOriginAirport);
		int originAirport = insertedNumber();
		AirportDataInterface original = flightEngine.getAirportByIndex(originAirport);

		String promptDestinationAirport = "Please enter the destination airport: ";
		System.out.println(promptDestinationAirport);
		int destAirport = insertedNumber();
		AirportDataInterface destination = flightEngine.getAirportByIndex(destAirport);

		if(original == null || destination == null) {
			System.out.println("Path cannot be found!");
		} else
			flightEngine.printShortestPath(original, destination);
	}


}

// placeholder(s) (implemented with proposal, and possibly added to later)
//class ShortestFlightFrontEndPlaceholder implements ShortestFlightFrontEndInterface {
//  public void run(ShortestFlightFrontEndInterface flightEngine) {
//      System.out.println("This Front End has not been implemented yet!");
//  }
//}
