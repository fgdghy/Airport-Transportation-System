// --== CS400 File Header Information ==--
// Name: Allison Lee
// Email: aklee25@wisc.edu
// Team: AT
// TA: Cameron
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.util.Hashtable;
import java.util.Map;

//interface (implemented with proposal)
interface ShortestFlightBackEndInterface {
    public AirportDataInterface getAirportByIndex(int index);
    public boolean containsAirport(AirportDataInterface airport);
    public void addAirport(AirportDataInterface airport);
    public void removeAirport(AirportDataInterface airport);

    //prints shortest flight time
    public int flightTime(AirportDataInterface source, AirportDataInterface destination);
    
    //finds shortest flight path between source and destination airports
    public String printShortestPath(AirportDataInterface source, AirportDataInterface destination);

    public String getAllAirport();
}

// public class (implemented primarilly in final app week)

/**
 * This class implements methods such that the user of the application can see if the airport
 * is contained, add an airport, remove an airport, get the shortest flight time, and print
 * the shortest flight path
 *
 * @author Allison Lee
 */
public class ShortestFlightBackEnd implements ShortestFlightBackEndInterface {
     private CS400Graph<AirportDataInterface> graph = new CS400Graph<AirportDataInterface>();
     private Hashtable<Integer, AirportDataInterface> db = new Hashtable<>();
   
    @Override
    public AirportDataInterface getAirportByIndex(int index){
	return this.db.get(index);
    }

    @Override
    public boolean containsAirport(AirportDataInterface airport) {
	return this.graph.containsVertex(airport);
    }

    @Override
    public void addAirport(AirportDataInterface airport) {
	    this.db.put(airport.getIndex(), airport);
    	this.graph.insertVertex(airport);


	    //insert edges for airports known
        for(int i=0; i < airport.getAirportConnected().size(); i++) {
		    Integer connection = airport.getAirportConnected().get(i);
		    if(db.containsKey(connection)){
		        this.graph.insertEdge(airport, db.get(connection), airport.getDistance().get(i));
		    }
	    }

	    //retroactively insert edges that couldn't previously be inserted
	    for(AirportDataInterface prevAirport : this.db.values()) {
		    for(int i=0; i < prevAirport.getAirportConnected().size(); i++) {
			    Integer connection = prevAirport.getAirportConnected().get(i);
			    if (connection == airport.getIndex()) {
				    this.graph.insertEdge(prevAirport, airport, prevAirport.getDistance().get(i));
			    }
		    }
	    }
    }

    @Override
    public void removeAirport(AirportDataInterface airport) {
   	    this.graph.removeVertex(airport);
	    this.db.remove(airport.getIndex());
    }

    @Override
    public int flightTime(AirportDataInterface source, AirportDataInterface destination){
	    //find shortest path and return cost
	    return this.graph.dijkstrasShortestPath(source, destination).distance;
    }

    @Override
    public String printShortestPath(AirportDataInterface source, AirportDataInterface destination) {
        String path = "";
	for (AirportDataInterface airport : this.graph.dijkstrasShortestPath(source, destination).dataSequence){
	    if(!path.equals("")) {
	    	path += " -> ";
	    }
	    //add string representation to path
	    path += airport.toString();
	}
	return path;
    }

    @Override
    public String getAllAirport() {
        String s = "";
        for(Map.Entry<Integer, AirportDataInterface> entry : db.entrySet()) {
            s += entry.getKey() + ": " + entry.getValue().toString() + "\n";
        }
        return s;
    }

}

// placeholder(s) (implemented with proposal, and possibly added to later)
class PlaceholderShortestFlightBackEnd implements ShortestFlightBackEndInterface {
    private AirportDataInterface onlyAirport;
  
    @Override
    public AirportDataInterface getAirportByIndex(int index) {
	return onlyAirport;
    }
    @Override 
    public boolean containsAirport(AirportDataInterface airport){ 
  	return onlyAirport.equals(airport);
    }  
    @Override
    public void addAirport(AirportDataInterface airport) {
        this.onlyAirport = airport;
    }
    @Override
    public void removeAirport(AirportDataInterface airport) {
        this.onlyAirport = null;
    }
    @Override
    public int flightTime(AirportDataInterface source, AirportDataInterface destination){
        return 0;
    }
    @Override
    public String printShortestPath(AirportDataInterface source, AirportDataInterface destination) {
        return onlyAirport.toString();
    }
    @Override
    public String getAllAirport() {
        return "0" + onlyAirport.toString();
    }
}
