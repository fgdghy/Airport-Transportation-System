// --== CS400 File Header Information ==--
// Name: Linyu Li
// Email: lli498@wisc.edu
// Team: AT
// TA: Cameron
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

// interface (implemented with proposal)

import java.util.List;
interface AirportDataInterface {
    public String getAirportName();

    public int getIndex();

    public List<Integer> getAirportConnected();

    public List<Integer> getDistance();

    public void connect(int airportIndex, int distance);

    public String toString();
}


// public class (implemented primarily in final app week)

/**
 * This class store the information of an airport
 */
public class AirportData implements AirportDataInterface {
    private String airportName;
    private int index;
    private List<Integer> connected;
    private List<Integer> distance;

    /**
     * Constructor
     *
     * @param index unique index of an airport
     * @param airportName the name of the airport
     * @param connected the index of airports that's connected to current airport
     * @param distance the distance between current airport and other airport connected
     */
    public AirportData(int index, String airportName, List<Integer> connected, List<Integer> distance) {
        this.airportName = airportName;
        this.connected = connected;
        this.distance = distance;
        this.index = index;
    }

    /**
     * Get the name of the airport
     * @return the name of airport
     */
    @Override
    public String getAirportName() {
        return airportName;
    }

    /**
     * Get the unique index of the airport
     * @return the index of airport
     */
    @Override
    public int getIndex() {
        return index;
    }

    /**
     * Find the airport connected to current airport
     * @return a list of index of airport that's connected to current airport
     */
    @Override
    public List<Integer> getAirportConnected() {
        return connected;
    }

    /**
     * Find the distance between airports
     * @return a list of integer storing distance between airports
     */
    @Override
    public List<Integer> getDistance() {
        return distance;
    }

    /**
     * Connect two airport
     * @param airportIndex the index of airport to connect
     * @param distance the distance between airports
     */
    @Override
    public void connect(int airportIndex, int distance) {
        this.connected.add(airportIndex);
        this.distance.add(distance);
    }

    /**
     * The toString() for airport
     * @return the name of airport
     */
    @Override
    public String toString() {
        return airportName;
    }
}


// placeholder(s) (implemented with proposal, and possibly added to later)
//class AirportDataPlaceholderA implements AirportDataInterface {
//    private String airportName;
//    private int index;
//    private List<Integer> connected;
//    private List<Integer> distance;
//
//    @Override
//    public String getAirportName() {
//        return "A";
//    }
//
//    @Override
//    public int getIndex() {
//        return 0;
//    }
//
//    @Override
//    public List<Integer> getAirportConnected() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<Integer> getDistance() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public void connect(int airportIndex, int distance) {
//    }
//
//
//    @Override
//    public String toString() {
//        return "A";
//    }
//}
//
//class AirportDataPlaceholderB implements AirportDataInterface {
//    private String airportName;
//    private int index;
//    private List<Integer> connected;
//    private List<Integer> distance;
//
//    @Override
//    public String getAirportName() {
//        return "B";
//    }
//
//    @Override
//    public int getIndex() {
//        return 1;
//    }
//
//    @Override
//    public List<Integer> getAirportConnected() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<Integer> getDistance() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public void connect(int airportIndex, int distance) {
//    }
//
//    @Override
//    public String toString() {
//        return "B";
//    }
//
//}
//
//class AirportDataPlaceholderC implements AirportDataInterface {
//    private String airportName;
//    private int index;
//    private List<Integer> connected;
//    private List<Integer> distance;
//
//    @Override
//    public String getAirportName() {
//        return "C";
//    }
//
//    @Override
//    public int getIndex() {
//        return 2;
//    }
//
//    @Override
//    public List<Integer> getAirportConnected() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public List<Integer> getDistance() {
//        return new ArrayList<>();
//    }
//
//    @Override
//    public void connect(int airportIndex, int distance) {
//    }
//
//
//    @Override
//    public String toString() {
//        return "C";
//    }
// }