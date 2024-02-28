package ch.authenticit.study.hashtable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashTableExercises {
    public int mostFrequent(int[] input) {
        // O(n)
        var map = new HashMap<Integer, Integer>();
        for (int number : input) {
            var count = map.getOrDefault(number, 0);
            map.put(number, ++count);
        }

        var max = Integer.MIN_VALUE;
        var key = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            var currentValue = entry.getValue();
            if (currentValue > max) {
                max = currentValue;
                key = entry.getKey();
            }
        }

        return key;
    }

    public int mostFrequentFunctional(int[] input) {
        return Arrays.stream(input)        // we are working with an array
                .boxed()            // stream works with Objects
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))     // aggregate by value + sum up occurrences
                .entrySet()         // get all entries of the map
                .stream()           // new stream
                .max(Map.Entry.comparingByValue())          // Provide Comparator of a Map-Entry-Object, use comparingByValue()
                .map(Map.Entry::getKey)                     // Get the key of the remaining Entry-Object
                .orElseThrow(NoSuchElementException::new);  // If there is no element, throw an NoSuchElementException
    }

    public int countPairsWithDiff(int[] input, int diff) {
        // O(n)
        var set = new HashSet<Integer>();
        for (int number : input)
            set.add(number);

        var count = 0;
        for (int number : set) {
            if (set.contains(number + diff))
                count++;
        }

        return count;
    }

    // return indexes of the two numbers such that
    // they add up to a specific target
    // Assume: Each input has exactly one solution
    //         and may not use the same element twice
    public int[] twoSum(int[] input, int target) {
        // O(n)
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < input.length; i++) {
            var complement = target - input[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(input[i], i);
        }
        return null;
    }
}
