package ch.authenticit.study;

import ch.authenticit.study.hashtable.CharFinder;

public class Main {
    public static void main(String[] args) {
        String input = "a green apple grows";
        var stringChecker = new CharFinder();
        System.out.println(stringChecker.firstNonRepeatedChar(input));
    }
}
