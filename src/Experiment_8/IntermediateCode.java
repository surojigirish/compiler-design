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
        for (int i = 0; i < precedence.length; i++) {
            if (token == precedence[i][0]) {
                return Integer.parseInt(precedence[i][1] + "");
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        int i, j, opCount = 0;
        char token;
        boolean[] checkPrecess;
        String[][] operators = new String[10][2];
        String expr = "", temp;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter Expression: ");
        expr = read.readLine();

        checkPrecess = new boolean[expr.length()];
        for (i = 0; i < checkPrecess.length; i++) {
            checkPrecess[i] = false;
        }

        for (i = 0; i < expr.length(); i++) {
            token = expr.charAt(i);
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
            String op1 = "", op2 = "";
            if (checkPrecess[j - 1]) {
                if (checkPrecedence(operators[i-1][0]) == checkPrecedence(operators[i][0])) {
                    op1 = "temp" + i;
                } else {
                    for (int k = 0; k < opCount; k++) {
                        if ((j-2) == Integer.parseInt(operators[k][1])) {
                            op1 = "temp" + (k + 1) + "";
                        }
                    }
                }
            } else {
                op1 = expr.charAt(j - 1) + "";
            }
            if (checkPrecess[j + 1]) {
                for (int k = 0; k < opCount; k++) {
                    if ((j + 2) == Integer.parseInt(operators[k][1])) {
                        op2 = "temp" + (k + 1) + "";
                    }
                }
            } else {
                op2 = expr.charAt(j + 1) + "";
            }
            System.out.println("temp" + (i + 1) + " = " + op1 + operators[i][0] + op2);
            checkPrecess[j] = checkPrecess[j-1] = checkPrecess[j+1] = true;
        }
    }
}
