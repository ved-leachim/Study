package ch.authenticit.study;

import ch.authenticit.study.hashtable.HashTableExercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----EX 1:-----");
        var hte = new HashTableExercises();
        var inputArray = new int[] {1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
        System.out.println(hte.mostFrequent(inputArray));
        System.out.println(hte.mostFrequentFunctional(inputArray));

        System.out.println("-----EX 2:-----");
        var inputArray2 = new int[] {1, 7, 5, 9, 2, 12, 3, 19, 21, -2, -4};
        var countOfPairs = hte.countPairsWithDiff(inputArray2, 2);
        System.out.println("Count of Pairs diff 2 = " + countOfPairs);

        System.out.println("-----EX 3:-----");
        var inputArray3 = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(hte.twoSum(inputArray3, 17)));
    }
}
