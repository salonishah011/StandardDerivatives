package stndder;

/**
 *
 * Name : Saloni Shah
 * Student Id : 00076422
 * Statement of authorship : I,Saloni Shah,00076422,certify that this material is my original work. No other person’s work has been used without due acknowledgment and i have not made my work available to anyone else.
 * List of rules :
 * ==> General Naming Conventions : 
 * 2. Names representing packages should be in all lower case.
 * 4. Variable names must be in mixed case starting with lower case.
 * 6. Names representing methods must contain a verb and written in mixed case starting with lower case.
 * 10. All names should be written in English.
 * 14. is prefix should be used for boolean variables and methods.
 * 15. The term compute can be used in methods where something is computed.
 * 19. Plural form should be used on names representing a collection of objects.
 * 20. n prefix should be used for variables representing a number of objects.
 * 22. Iterator variables should be called i, j, k etc.
 * ==> Comments
 * 80. All comments should be written in English.
 * 81. Javadoc comments
 * 82. There should be a space after the comment identifier.
 * 83. Use // for all non-JavaDoc comments, including multi-line comments.
 * 84. Comments should be indented relative to their position in the code.
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Saloni Shah
 */
public final class DerivationCalculation {

    /**
     *
     * @param <T> Any type which extends Number
     * @param elements list of elements for Average
     * @param isNumber flag for type of list
     * @return average of given elements
     */
    public static <T extends Number> double computeAverage(ArrayList<T> elements, boolean isNumber) {
        // calling summation for summing uup all elements
        double totalSum = computeSummation(elements, isNumber); 
        // counter variable
        int counter = 0; 
        for (int i = 0; i < elements.size(); i++) {
            if (isNumber || elements.get(i).doubleValue() >= 0) {
                // counting numeric elements for division
                counter++; 
            }
        }
        if (counter == 0) {
            // if no elements are greater than 0, it will throw exception 
            throw new IllegalArgumentException("no values are > 0"); 
        }
        // deviding sum with nuber of elements
        return totalSum / counter; 
    }

    /**
     *
     * @param <T> Any type which extends Number
     * @param elements list of elements for calculating Summation
     * @param isNumber flag for type of list
     * @return summation of given elements
     */
    public static <T extends Number> double computeSummation(ArrayList<T> elements, boolean isNumber) {
        if (elements.size() < 0) {
            // throws exeption if list is empty
            throw new IllegalArgumentException("x cannot be empty"); 
        }

        double totalSum = 0.0;
        for (T element : elements) {
            double elementValue = element.doubleValue();
            if (isNumber || elementValue >= 0) {
                // summing up elements
                totalSum += elementValue; 
            }
        }
        return totalSum;
    }

    /**
     *
     * @param <T> Any type which extends Number
     * @param elements list of elements for calculating Median
     * @return median of given elements
     */
    public static <T extends Number & Comparable> double computeMedian(ArrayList<T> elements) {
        if (elements.isEmpty()) {
            // throw exception if list is empty
            throw new IllegalArgumentException("Size of array must be greater than 0"); 
        }

        // sorting elements
        Collections.sort(elements); 

        double median = elements.get(elements.size() / 2).doubleValue();
        if (elements.size() % 2 == 0) {
            median = ((elements.get(elements.size() / 2).doubleValue() + elements.get(elements.size() / 2 - 1).doubleValue())) / 2;
        }

        return median;
    }

    /**
     *
     * @param <T> Any type which extends Number
     * @param elements list of elements for calculating derivatives 
     * @return Standard derivative of elements
     */
    public static <T extends Number> double calculateStandardDeviation(ArrayList<T> elements) {
        if (elements.size() <= 1) {
            // throws an exception if size of list is lesser than two
            throw new IllegalArgumentException("Size of array must be greater than 1"); 
        }

        int nElements = elements.size();
        double totalSum = 0;
        // computing average
        double averageValue = computeAverage(elements,true); 
        
        for (int i = 0; i < nElements; i++) {
            double elementValue = elements.get(i).doubleValue();
            totalSum += Math.pow(elementValue - averageValue,2);
        }
        // getting square root
        double standardDerivation = Math.sqrt(totalSum / (nElements-1)); 
        return standardDerivation;
    }
	
    /**
     *
     * @param args accepts command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> testIntegerDatas = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Double> testDoubleDatas = new ArrayList<>(Arrays.asList(2.2, 3.3, 66.2, 17.5, 30.2, 31.1));

        System.out.printf("The sum of the Integer array = %.0f\n", computeSummation(testIntegerDatas, true));

        System.out.printf("The average of the Integer test set = %.0f\n", computeAverage(testIntegerDatas, true));
        System.out.printf("The average of the Double test set = %.2f\n", computeAverage(testDoubleDatas, true));

        System.out.printf("The median value of the Integer data set = %.1f\n", computeMedian(testIntegerDatas));
        System.out.printf("The median value of the Double data set = %.1f\n", computeMedian(testDoubleDatas));
        
        System.out.printf("The sample standard deviation of the Integer test set = %.2f\n", calculateStandardDeviation(testIntegerDatas));
        System.out.printf("The sample standard deviation of the Double test set = %.2f\n", calculateStandardDeviation(testDoubleDatas));
    }
}