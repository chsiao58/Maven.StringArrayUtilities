package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */
    public static boolean contains(String[] array, String value) {
        for(String string: array)
            if (string.equals(value))
                return true;
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */
    public static String[] reverse(String[] array) {
        String[] reversed = new String[array.length];

        for(Integer i = 0; i < array.length; i++)
            reversed[i] = array[(array.length-1)-i];
        return reversed;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */
    public static boolean isPalindromic(String[] array) {
        for(Integer i = 0; i < array.length / 2; i++)
            if (array[i] != array[(array.length-1)-i])
                return false;
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */
    public static boolean isPangramic(String[] array) {

        for (Integer index = 0; index < array.length; index++)
            array[index] = array[index].toUpperCase();

        for(Character alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            Boolean isAlphabetIn = false;
            for (String word : array) {
                if (word.indexOf(alphabet) != -1) {
                    isAlphabetIn = true;
                }
                if (isAlphabetIn)    // if word contain that alphabet, stop searching this alphabet in all word
                    break;
            }
            if(!isAlphabetIn)   // if there is one alphabet not in this array, it is not Pangramic
                return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */
    public static int getNumberOfOccurrences(String[] array, String value) {
        Integer counter = 0;
        for(String word: array)
            if (word.equals(value))
                counter++;

        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] result = new String[array.length-getNumberOfOccurrences(array,valueToRemove)];

        Integer resultIndex = 0;
        for(String word: array)
            if (!word.equals(valueToRemove)) {
                result[resultIndex] = word;
                resultIndex++;
            }
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */
    public static String[] removeConsecutiveDuplicates(String[] array) {
        List<String> resultList = new ArrayList<String>();
        resultList.add(array[0]);

        for(Integer index = 1; index < array.length; index++)
            if(!array[index].equals(array[index-1]))
                resultList.add(array[index]);

        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);

        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */
    public static String[] packConsecutiveDuplicates(String[] array) {
        List<String> resultList = new ArrayList<String>();
        resultList.add(array[0]);

        for(Integer index = 1; index < array.length; index++)
            if(!array[index].equals(array[index-1]))    // add the string to result
                resultList.add(array[index]);
            else                                        // if it's a repeat, concat to the last element
                resultList.set(resultList.size()-1, resultList.get(resultList.size()-1).concat(array[index]));


        String[] result = new String[resultList.size()];
        result = resultList.toArray(result);

        for(String word: result)
            System.out.println(word);
        System.out.println(" ");
        return result;
    }


}
