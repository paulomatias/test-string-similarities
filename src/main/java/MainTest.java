import info.debatty.java.stringsimilarity.Cosine;
import info.debatty.java.stringsimilarity.Levenshtein;
import info.debatty.java.stringsimilarity.NormalizedLevenshtein;
import org.simmetrics.StringMetric;
import org.simmetrics.StringMetrics;
import org.simmetrics.metrics.CosineSimilarity;
import org.simmetrics.simplifiers.Simplifiers;
import org.simmetrics.tokenizers.Tokenizers;

import java.util.Locale;

import static org.simmetrics.StringMetricBuilder.with;

public class MainTest {

    public static void main(String... s) {
        System.out.println("Tests for java-string-similarity lib");
        System.out.println("\nTests for Levenhstein - distance");
        Levenshtein levenshtein = new Levenshtein();
        TestStringSimilarity.displayDistanceResultsforLevenshtein(levenshtein, Values.YELLOW_VALUE, Values.YELLOW_VALUES);
        TestStringSimilarity.displayDistanceResultsforLevenshtein(levenshtein, Values.RED_VALUE, Values.RED_VALUES);
        TestStringSimilarity.displayDistanceResultsforLevenshtein(levenshtein, Values.YELLOW_VALUE, Values.RED_VALUES);

        System.out.println("\nTests for NormalizedLevenhstein - distance and similarity");
        NormalizedLevenshtein normalizedLevenshtein = new NormalizedLevenshtein();
        TestStringSimilarity.displayDistanceAndSimilarityResultsforNormalizedLevenshtein(normalizedLevenshtein, Values.YELLOW_VALUE, Values.YELLOW_VALUES);
        TestStringSimilarity.displayDistanceAndSimilarityResultsforNormalizedLevenshtein(normalizedLevenshtein, Values.RED_VALUE, Values.RED_VALUES);
        TestStringSimilarity.displayDistanceAndSimilarityResultsforNormalizedLevenshtein(normalizedLevenshtein, Values.YELLOW_VALUE, Values.RED_VALUES);

        System.out.println("\nTests for cosine - distance and similarity for shingles from 1 to 5");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Cosine : " + i);
            Cosine cosine = new Cosine(i);
            TestStringSimilarity.displayDistanceAndSimilarityResultsforCosine(cosine, Values.YELLOW_VALUE, Values.YELLOW_VALUES);
            TestStringSimilarity.displayDistanceAndSimilarityResultsforCosine(cosine, Values.RED_VALUE, Values.RED_VALUES);
            TestStringSimilarity.displayDistanceAndSimilarityResultsforCosine(cosine, Values.YELLOW_VALUE, Values.RED_VALUES);
            System.out.println("");
        }

        System.out.println("Tests for simmetrics lib");
        System.out.println("\nTests for cosine - distance and similarity");
        StringMetric cosineMetric = StringMetrics.cosineSimilarity();
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineMetric, Values.YELLOW_VALUE, Values.YELLOW_VALUES);
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineMetric, Values.RED_VALUE, Values.RED_VALUES);
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineMetric, Values.YELLOW_VALUE, Values.RED_VALUES);

        System.out.println("\nTests for cosine extended - distance and similarity");
        StringMetric cosineExtendedMetric =
                with(new CosineSimilarity<>())
                        .simplify(Simplifiers.toLowerCase(Locale.ENGLISH))
                        .simplify(Simplifiers.replaceNonWord())
                        .tokenize(Tokenizers.whitespace())
                        .build();
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineExtendedMetric, Values.YELLOW_VALUE, Values.YELLOW_VALUES);
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineExtendedMetric, Values.RED_VALUE, Values.RED_VALUES);
        TestSimmetrics.displayDistanceAndSimilarityResultsForSimmetricsCosine(cosineExtendedMetric, Values.YELLOW_VALUE, Values.RED_VALUES);


    }
}
