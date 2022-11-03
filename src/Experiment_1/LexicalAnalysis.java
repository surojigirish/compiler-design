package Experiment_1;

public class LexicalAnalysis {

    public static void main(String[] args) {

//        char[] identifier = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
//                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'z'};

        String[] id = new String[25];
        int a=0;// Sorted Array of 100
        for (char i = 'a'; i < 'z'; i++) {
            id[a] = String.valueOf(i);
            a++;
        }

        String[] operator = {"+","-","*","/","<",">"};

//        String[] literal = {"1","2","3","4","5","6","7","8","9","10"};
        int n = 10000;
        String[] literal = new String[n];                       // Sorted Array of 100
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

        String[] storeId = new String[idCounter];
        int symbolCounter = 1;

        for (int i = 0; i < toStringArray.length; i++) {
            for (String s : id) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> id " + idCounter);
                    idCounter++;
                }
            }
            for (String s : operator) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> operator");
                }
            }
            for (String s : literal) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> literal");
                }
            }
            for (String s : keyword) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> keyword");
                }
            }
            for (String s : symbol) {
                if (toStringArray[i].equals(s)) {
                    System.out.println(toStringArray[i] + " -> symbol " + symbolCounter);
                    symbolCounter++;
                }
            }
        }
    }
}
