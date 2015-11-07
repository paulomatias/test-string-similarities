import java.util.*;

public class MapSorter {
    public static Map<String, Double> sortByComparator(Map<String, Integer> unsortMap, boolean ascOrder) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));
        if (!ascOrder) {
            Collections.reverse(list);
        }

        Map<String, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), (double) (entry.getValue()) / Values.TEN_THOUSAND);
        }
        return sortedMap;
    }
}
