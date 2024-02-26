package ch.authenticit.study.set;

import java.util.HashSet;

public class CharFinder {
    public char findFirstRepeatedChar(String inputString) {
        var set = new HashSet<Character>();

        for (char ch : inputString.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
