package Experiment_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeftRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Left side Non-Terminal");
        String leftSide = sc.next();
        System.out.println("Enter Right side of the Grammar");
        String rightSide = sc.next();
        String repetition = "";

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
