package Experiment_2;

import java.util.ArrayList;
import java.util.List;

public class LeftRecursion {
    public static void main(String[] args) {
        String leftSide = "T";
        String rightSide = "T+E|e";
        String repetition = "";
        String error = "";

        String[] toLeftSideArray = null;
        toLeftSideArray = leftSide.split("");

        String[] toRightSideArray = null;
        toRightSideArray = rightSide.split("");
        List<String> newRight = new ArrayList<>();

        for (String s : toRightSideArray) {
            for (String ls : toLeftSideArray) {
                if (!s.equals(ls)) {
                    newRight.add(s);
                } else {
                    repetition = s + "'";
                }
                if (s.equals("|") || s.equals("e")) {
                    newRight.remove(s);
                }
            }
        }

        System.out.println("Grammar \n" + leftSide + " -> " + rightSide);  // original statement

        System.out.println("output");
        for (String s : newRight) {
            System.out.print(s);
        }
        System.out.println(repetition);
    }
}
