import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelBook {
    private Map<String, ArrayList<String>> map;

    public TelBook () {
        map = new HashMap<>();
    }

    public void add (String name, String...tel) {
        List<String> tels = new ArrayList<String>();
        for (String i : tel) {
            tels.add(i);
        }
        map.put(name, (ArrayList<String>) tels);
    }

    public String toString () {
        return "" + map;
    }
}
