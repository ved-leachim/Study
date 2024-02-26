package ch.authenticit.study;

import ch.authenticit.study.set.CharFinder;

public class Main {
    public static void main(String[] args) {
        String input = "green apple";
        var charFinder = new CharFinder();
        System.out.println(charFinder.findFirstRepeatedChar(input));
    }
}
