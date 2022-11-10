package Experiment_2;

import java.util.ArrayList;
import java.util.List;

public class LeftRecursion {
    public static void main(String[] args) {
        String leftSide = "T";
        String rightSide = "T+EA|e";
        String repetition = "";
        String error = "";

        String[] operators = {"+", "-", "*", "/"};

        String[] toRightSideArray = null;
        toRightSideArray = rightSide.split("");
        List<String> newRight = new ArrayList<>();

        for (String s : toRightSideArray) {
            if (!s.equals(leftSide)) {
                newRight.add(s);
            } else {
                repetition = s + "'";
            }
            for (String op: operators) {
                if (s.equals(op)) {
                    newRight.remove(s);
                }
            }
            if (s.equals("|") || s.equals("e")) {
                newRight.remove(s);
                error = "#";
            }
        }
        System.out.println(leftSide + " -> " + rightSide);  // original statement

        for (String s : newRight) {
            System.out.print(s);
        }
        System.out.println(repetition + error);
    }
}
