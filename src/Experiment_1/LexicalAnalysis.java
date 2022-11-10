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

        String[] operator = {"+","-","*","/","<",">", "="};

        int n = 1000;
        String[] literal = new String[n];                       // Sorted Array of 10000
        for (int i = 0; i < literal.length; i++) {
            literal[i] = String.valueOf(i + 1);
        }
        String[] keyword = { "and", "break", "continue", "class", "else if", "else", "except", "finally", "for","if", "not",
                "or", "try", "while", "do", "catch", "exp", "pos"};
        String[] symbol = {"!","@",";","%","(",")","{","}"};

        String input = "if ( a > b )";   // User input
        String[] toStringArray = null;
        toStringArray = input.split(" ");  // Conversion to array of string

        int idCounter = 1;
        int literalCounter = 1;
        Map<String, Integer> identifier = new HashMap<>();  // Declare HashMap to Store Character and its id (K,V) pair
        System.out.println("input statement: " + input);  // Print the input values

        for (int i = 0; i < toStringArray.length; i++) {
            for (String s : id) {  // Identifier check in the input
                if (toStringArray[i].equals(s)) {
                    if (!identifier.containsKey(toStringArray[i])) {  // true if HashMap doesn't contain the key
                        identifier.put(toStringArray[i], idCounter);  // Storing the <Key, Value> pair
                        for (Map.Entry entry: identifier.entrySet()) {  // Iterating through the HashMap
                            // Check if the HashMap contains any key stored previously and prints the <key, value> for the first time
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> id " + entry.getValue());
                            }
                        }
                    } else {
                        for (Map.Entry entry: identifier.entrySet()) {
                            // HashMap contains key stored previously and prints the <key, value> for the every time, TRUE
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> id " + entry.getValue());
                            }
                        }
                    }
                    idCounter++;  // Increments the counter for next id
                }
            }
            for (String s : operator) {  // Operator check in the Input
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> operator");
                }
            }
            for (String s : literal) {  // Literal check in the Input
                if (toStringArray[i].equals(s)) {
                    if (!identifier.containsKey(toStringArray[i])) {
                        identifier.put(toStringArray[i], literalCounter);
                        for (Map.Entry entry: identifier.entrySet()) {
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> literal " + entry.getValue());
                            }
                        }
                    } else {
                        for (Map.Entry entry: identifier.entrySet()) {
                            if (entry.getKey().equals(toStringArray[i])) {
                                System.out.println(entry.getKey() + " -> literal " + entry.getValue());
                            }
                        }
                    }
                    literalCounter++;
                }
            }
            for (String s : keyword) {  // Keyword check in the Input
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> keyword");
                }
            }
            for (String s : symbol) {  // Symbol check in the Input
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> symbol ");
                }
            }
        }
    }
}
