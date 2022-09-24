import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.lang.invoke.MethodHandles;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
// import org.junit.platform.console.ConsoleLauncher;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        Hashtable<String, Integer> tem = new AirportLoader().loadIndex("indexTable.csv");


    }


    /**
     * Test if the constructor create the correct data instance
     * Author: Linyu Li, Data Wrangler
     */
    @Test
    public void DataWrangler_TestConstructor() {
        AirportDataInterface data = new AirportData(1, "1", new ArrayList<>(), new ArrayList<>());
        assertEquals(false, data == null);

        assertEquals(1, data.getIndex());
        assertEquals("1", data.getAirportName());
        assertEquals(0, data.getAirportConnected().size());
        assertEquals(0, data.getDistance().size());
    }

    /**
     * Test if the loaderIndex() function load the file correctly
     * Author: Linyu Li, Data Wrangler
     */
    @Test
    public void DataWrangler_TestLoadIndex() throws Exception {
        Hashtable<String, Integer> table = new AirportLoader().loadIndex("indexTable.csv");

        assertEquals(7, table.size());

        assertEquals(0, table.get("CLE"));
        assertEquals(1, table.get("CAK"));
        assertEquals(2, table.get("ORD"));
        assertEquals(3, table.get("MDV"));
        assertEquals(4, table.get("CVG"));
        assertEquals(5, table.get("DAY"));
        assertEquals(6, table.get("CMH"));
        assertEquals(7, table.get("DTW"));
    }


    /**
     * Test if the loadFile() function load the file correctly
     * Author: Linyu Li, Data Wrangler
     */
    @Test
    public void DataWrangler_TestLoader() throws Exception {
        List<AirportDataInterface> list = new AirportLoader().loadFile(".", "indexTable.csv");
        List<String> expect = new ArrayList<>();
        expect.add("CLE");
        expect.add("CAK");
        expect.add("ORD");
        expect.add("MDV");
        expect.add("CVG");
        expect.add("DAY");
        expect.add("CMH");
        expect.add("DTW");

        for(int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), list.get(i).toString());
        }
    }
}
