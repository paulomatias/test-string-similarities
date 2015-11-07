import org.simmetrics.StringMetric;

import java.util.HashMap;
import java.util.Map;

public class TestSimmetrics {
    public static void displayDistanceAndSimilarityResultsForSimmetricsCosine(StringMetric metric, String shopValue, String[] operatorValues) {
        System.out.println("Valeur shop : " + shopValue);

        Map<String, Integer> operatorValuesToNormalizedLevenshteinDistance = new HashMap<>();
        Map<String, Integer> operatorValuesToNormalizedLevenshteinSimilarity = new HashMap<>();
        for (String operatorValue : operatorValues) {
            operatorValuesToNormalizedLevenshteinDistance.put(operatorValue, Values.TEN_THOUSAND - ((Float) (Values.TEN_THOUSAND * metric.compare(shopValue, operatorValue))).intValue());
            operatorValuesToNormalizedLevenshteinSimilarity.put(operatorValue, ((Float) (Values.TEN_THOUSAND * metric.compare(shopValue, operatorValue))).intValue());
        }

        System.out.println("Distance : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinDistance, true));
        System.out.println("Similarity : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinSimilarity, false) + "\n");
    }
}
