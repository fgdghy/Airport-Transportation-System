// --== CS400 File Header Information ==--
// Name: Linyu Li
// Email: lli498@wisc.edu
// Team: AT
// TA: Cameron
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;


// interface (implemented with proposal)
interface AirportLoaderInterface {
    public Hashtable<String, Integer> loadIndex(String filePath) throws FileNotFoundException;
    public List<AirportDataInterface> loadFile(String FilePath, String indexPath) throws FileNotFoundException;
    public List<AirportDataInterface> loadAllFilesInDirectory(String directoryPath, String indexPath) throws FileNotFoundException;
}

/**
 * This class helps to load in the airports information
 */
// public class (implemented primarily in final app week)
public class AirportLoader implements AirportLoaderInterface {
    /**
     * Load the file containing the index of airports
     *
     * @param filePath the file path containing the index of airports
     * @return a hashmap, key is index of airport, value is airport name
     * @throws FileNotFoundException when the file is not found
     */
    @Override
    public Hashtable<String, Integer> loadIndex(String filePath) throws FileNotFoundException{
        File indexFile = new File(filePath);
        Scanner scanner = new Scanner(indexFile);
        Hashtable<String, Integer> indexTable = new Hashtable<>();

        // skip first line
        scanner.nextLine();

        while (scanner.hasNext()) {
            String[] split = scanner.next().split(",");
            for(int i = 0; i < 2; i++)
                split[i] = split[i].replace("\"", "");

            indexTable.put(split[0], Integer.valueOf(split[1]));
        }

        scanner.close();
        return indexTable;
    }

    /**
     * Load the file containing airports information
     *
     * @param filePath file to load
     * @param indexPath the file containing the index of airports
     * @return a list of airport instance
     * @throws FileNotFoundException when the file is not found
     */
    @Override
    public List<AirportDataInterface> loadFile(String filePath, String indexPath) throws FileNotFoundException {
        Hashtable<String, Integer> indexTable = loadIndex(indexPath);

        File airportFile = new File(filePath);
        Scanner scanner = new Scanner(airportFile);
        List<AirportDataInterface> airportList = new LinkedList<>();

        // skip first line
        scanner.nextLine();

        while (scanner.hasNext()) { // loop until the file runs out of lines
            String[] split = scanner.next().split("\",\"");
            for(int i = 0; i < 3; i++)
                split[0] = split[i].replace("\"", "");

            String[] tmp1 = split[1].split(",");
            String[] tmp2 = split[2].split(",");

            int index = indexTable.get(split[0]);
            List<Integer> connected = new ArrayList<>();
            List<Integer> distance = new ArrayList<>();

            for(int i = 0; i < tmp1.length; i++) {
                connected.add(indexTable.get(tmp1[i]));
                distance.add(Integer.valueOf(tmp2[i]));
            }

            airportList.add(new AirportData(index, split[0], connected, distance));
        }


        //close scanner
        scanner.close();
        return airportList;

        System.out.println(airport);
        System.out.println(airport.getAirportConnected());
        System.out.println(airport.getDistance());
        System.out.println("------------------------------");

}

    /**
     * Load all the files containing airports information
     *
     * @param directoryPath the directory path containing airports information files
     * @param indexFile the file containing index of the airports
     * @return a list of airports instance
     * @throws FileNotFoundException when the directory or file path is not found
     */
    @Override
    public List<AirportDataInterface> loadAllFilesInDirectory(String directoryPath, String indexFile) throws FileNotFoundException {
        File fileDirectory = new File(directoryPath);
        String[] list = fileDirectory.list();

        List<AirportDataInterface> airportList = new LinkedList<>();

        for (int i = 0; i < list.length; ++i) {
            if(list[i].equals(indexFile)) continue;

            if (list[i].endsWith(".csv")) {
                airportList.addAll(loadFile(list[i], indexFile));
            }
        }
        return airportList;
    }
}


// placeholder(s) (implemented with proposal, and possibly added to later)
//class AirportLoaderPlaceholder implements AirportLoaderInterface {
//    @Override
//    public Hashtable<String, Integer> loadIndex(String filePath) throws FileNotFoundException {
//        return new Hashtable<String, Integer>();
//    }
//
//    @Override
//    public List<AirportDataInterface> loadFile(String csvFilePath, String indexFile) throws FileNotFoundException{
//        List<AirportDataInterface> list = new LinkedList<>();
//        list.add(new AirportDataPlaceholderA());
//        list.add(new AirportDataPlaceholderB());
//        list.add(new AirportDataPlaceholderC());
//        return list;
//    }
//
//    @Override
//    public List<AirportDataInterface> loadAllFilesInDirectory(String directoryPath, String indexFile) throws FileNotFoundException{
//        List<AirportDataInterface> list = new LinkedList<>();
//        list.add(new AirportDataPlaceholderA());
//        list.add(new AirportDataPlaceholderB());
//        list.add(new AirportDataPlaceholderB());
//        return list;
//    }
//}
