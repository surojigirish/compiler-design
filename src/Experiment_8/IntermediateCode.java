package Experiment_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntermediateCode {

    // Array of operators
    private static final char[][] precedence = {
            {'/', '1'},
            {'*', '1'},
            {'+', '2'},
            {'-', '2'}
    };

    private static int checkPrecedence(String t) {
        char token = t.charAt(0);
        for (char[] chars : precedence) {
            if (token == chars[0]) {
                return Integer.parseInt(chars[1] + "");
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int i, j, opCount = 0;
        char token;
        boolean[] checkPrecess;
        String[][] operators = new String[10][2];
        String expression = "", temp;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Expression: ");
        expression = read.readLine();

        checkPrecess = new boolean[expression.length()];
        for (i = 0; i < checkPrecess.length; i++) {
            checkPrecess[i] = false;
        }

        for (i = 0; i < expression.length(); i++) {
            token = expression.charAt(i);
            for (j = 0; j < precedence.length; j++) {
                if (token == precedence[j][0]) {
                    operators[opCount][0] = token + "";
                    operators[opCount][1] = i + "";
                    opCount++;
                    break;
                }
            }
        }
        for (i = opCount-1; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (checkPrecedence(operators[j][0]) > checkPrecedence(operators[j+1][0])) {
                    temp = operators[j][0];
                    operators[j][0] = operators[j+1][0];
                    operators[j+1][0] = temp;
                    temp = operators[j][1];
                    operators[j][1] = operators[j+1][1];
                    operators[j+1][1] = temp;
                }
            }
        }
        System.out.println();
        for (i = 0; i < opCount; i++) {
            j = Integer.parseInt(operators[i][1] + "");
            String operandOne = "", operandTwo = "";
            if (checkPrecess[j - 1]) {
                if (checkPrecedence(operators[i-1][0]) == checkPrecedence(operators[i][0])) {
                    operandOne = "temp" + i;
                } else {
                    for (int k = 0; k < opCount; k++) {
                        if ((j-2) == Integer.parseInt(operators[k][1])) {
                            operandOne = "temp" + (k + 1) + "";
                        }
                    }
                }
            } else {
                operandOne = expression.charAt(j - 1) + "";
            }
            if (checkPrecess[j + 1]) {
                for (int k = 0; k < opCount; k++) {
                    if ((j + 2) == Integer.parseInt(operators[k][1])) {
                        operandTwo = "temp" + (k + 1) + "";
                    }
                }
            } else {
                operandTwo = expression.charAt(j + 1) + "";
            }
            System.out.println("temp" + (i + 1) + " = " + operandOne + operators[i][0] + operandTwo);
            checkPrecess[j] = checkPrecess[j-1] = checkPrecess[j+1] = true;
        }
    }
}
