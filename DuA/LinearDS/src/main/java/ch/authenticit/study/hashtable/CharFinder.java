package ch.authenticit.study.hashtable;

import java.util.HashMap;

public class CharFinder {
    public Character firstNonRepeatedChar(String inputString) {
        var charArray = inputString.toCharArray();
        var map = new HashMap<Character, Integer>();

        for (char ch : charArray) {
            var count = map.getOrDefault(ch, 0);
            map.put(ch, ++count);
        }

        for (char ch : charArray){
            if (map.get(ch) == 1)
                return ch;
        }
        return Character.MIN_VALUE;
    }
}
