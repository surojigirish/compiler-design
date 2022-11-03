package Experiment_1;

import java.util.HashMap;
import java.util.Map;

public class LexicalAnalysis {

    public static void main(String[] args) {

        String[] id = new String[25];
        int a=0;
        for (char i = 'a'; i < 'z'; i++) {
            id[a] = String.valueOf(i);
            a++;
        }

        String[] operator = {"+","-","*","/","<",">"};

        int n = 1000;
        String[] literal = new String[n];                       // Sorted Array of 10000
        for (int i = 0; i < literal.length; i++) {
            literal[i] = String.valueOf(i + 1);
        }

        String[] keyword = { "and", "break", "continue", "class", "else if", "else", "except", "finally", "for","if", "not",
                "or", "try", "while", "do", "catch"};

        String[] symbol = {"!","=","@",";","%","(",")","{","}"};

        String input = "if ( a > b ) + a - 12 + 1";

        String[] toStringArray = null;
        toStringArray = input.split(" ");

        int idCounter = 1;
        int symbolCounter = 1;
        // Declare HashMap to Store Character and its id
        Map<String, Integer> identifier = new HashMap<>();

        for (int i = 0; i < toStringArray.length; i++) {
            // Identifier check in the input
            for (String s : id) {
                if (toStringArray[i].equals(s)) {
                    // true if HashMap doesn't contain the key
                    if (!identifier.containsKey(toStringArray[i])) {
                        identifier.put(toStringArray[i], idCounter);  // Storing the <Key, Value> pair
                        // Iterating through the HashMap
                        for (Map.Entry entry: identifier.entrySet()) {
                            // Check if the HashMap contains any key stored previously and prints the <key, value> for the first time
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> id " + entry.getValue());
                            }
                        }
                    } else {
                        // Iterating through the HashMap
                        for (Map.Entry entry: identifier.entrySet()) {
                            // HashMap contains key stored previously and prints the <key, value> for the every time, TRUE
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> id " + entry.getValue());
                            }
                        }
                    }
                    // Increments the counter for next id
                    idCounter++;
                }
            }
            // Operator check in the Input
            for (String s : operator) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> operator");
                }
            }
            // Literal check in the Input
            for (String s : literal) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> literal");
                }
            }
            // Keyword check in the Input
            for (String s : keyword) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> keyword");
                }
            }
            // Symbol check in the Input
            for (String s : symbol) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> symbol " + symbolCounter);
                    symbolCounter++;
                }
            }
        }
    }
}
