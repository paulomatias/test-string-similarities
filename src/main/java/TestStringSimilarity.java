import info.debatty.java.stringsimilarity.*;

import java.util.*;

public class TestStringSimilarity {
    public static void displayDistanceResultsforLevenshtein(Levenshtein levenshtein, String shopValue, String[] operatorValues) {
        System.out.println("Valeur shop : " + shopValue);

        Map<String, Integer> operatorValuesToLevenshteinDistance = new HashMap<>();
        for (String operatorValue : operatorValues) {
            operatorValuesToLevenshteinDistance.put(operatorValue, ((Double) (Values.TEN_THOUSAND * levenshtein.distance(shopValue, operatorValue))).intValue());
        }

        System.out.println("Distance : " + MapSorter.sortByComparator(operatorValuesToLevenshteinDistance, true) + "\n");
    }

    public static void displayDistanceAndSimilarityResultsforNormalizedLevenshtein(NormalizedLevenshtein normalizedLevenshtein, String shopValue, String[] operatorValues) {
        System.out.println("Valeur shop : " + shopValue);

        Map<String, Integer> operatorValuesToNormalizedLevenshteinDistance = new HashMap<>();
        Map<String, Integer> operatorValuesToNormalizedLevenshteinSimilarity = new HashMap<>();
        for (String operatorValue : operatorValues) {
            operatorValuesToNormalizedLevenshteinDistance.put(operatorValue, ((Double) (Values.TEN_THOUSAND * normalizedLevenshtein.distance(shopValue, operatorValue))).intValue());
            operatorValuesToNormalizedLevenshteinSimilarity.put(operatorValue, ((Double) (Values.TEN_THOUSAND * normalizedLevenshtein.similarity(shopValue, operatorValue))).intValue());
        }

        System.out.println("Distance : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinDistance, true));
        System.out.println("Similarity : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinSimilarity, false) + "\n");
    }

    public static void displayDistanceAndSimilarityResultsforCosine(Cosine cosine, String shopValue, String[] operatorValues) {
        System.out.println("Valeur shop : " + shopValue);

        Map<String, Integer> operatorValuesToNormalizedLevenshteinDistance = new HashMap<>();
        Map<String, Integer> operatorValuesToNormalizedLevenshteinSimilarity = new HashMap<>();
        for (String operatorValue : operatorValues) {
            operatorValuesToNormalizedLevenshteinDistance.put(operatorValue, ((Double) (Values.TEN_THOUSAND * cosine.distance(shopValue, operatorValue))).intValue());
            operatorValuesToNormalizedLevenshteinSimilarity.put(operatorValue, ((Double) (Values.TEN_THOUSAND * cosine.similarity(shopValue, operatorValue))).intValue());
        }

        System.out.println("Distance : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinDistance, true));
        System.out.println("Similarity : " + MapSorter.sortByComparator(operatorValuesToNormalizedLevenshteinSimilarity, false) + "\n");
    }


}
