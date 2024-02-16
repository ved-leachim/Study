package ch.authenticit.study.stack;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionChecker {
    public static boolean isBalanced(String expression) {
        var openers = new Stack<Character>();
        var chars = expression.toCharArray();

        for (char c : chars) {
            if (isOpeningBracket(c)) {
                openers.push(c);
                continue;
            }

            if (isClosingBracket(c)) {
                if (openers.empty()) return false;

                var lastOpeningBracket = openers.pop();
                if (!isCounterpart(c, lastOpeningBracket))
                    return false;
            }
        }
        return openers.empty();
    }

    private static boolean isOpeningBracket(char c) {
        var openingBrackets = new char[] {'(', '[', '{', '<'};

        for (char bracket : openingBrackets) {
            if (c == bracket)
                return true;
        }
        return false;
    }

    private static boolean isClosingBracket(char c) {
        var closingBrackets = new char[] {')', ']', '}', '>'};

        for (char bracket : closingBrackets) {
            if (c == bracket)
                return true;
        }
        return false;
    }

    private static boolean isCounterpart(char closingBracket, char openingBracket) {
        var bracketPairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
                put('>', '<');
            }
        };
        return (bracketPairs.get(closingBracket) == openingBracket);
    }
}
