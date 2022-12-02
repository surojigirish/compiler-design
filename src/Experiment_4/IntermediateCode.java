package Experiment_4;

public class IntermediateCode {
    public static void main(String[] args) {
        // Input Expression  a + b * c
        String input = "X=a+b*c/e*f";
        String P = "P" ;
        String Q = "Q" ;
        String R = "R" ;
        char opt[] = {'*','/','+','-'};
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == opt[0]) {
                System.out.println(input.charAt(i));
                //p = input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1);
                input = input.replace((input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1)), "P");
                System.out.println(input);
            }
            if (input.charAt(i) == opt[1]) {
                System.out.println(input.charAt(i));
                //p = input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1);
                input = input.replace((input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1)), "Q");
            }
            if (input.charAt(i) == opt[2]) {
                System.out.println(input.charAt(i));
                //p = input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1);
                input = input.replace((input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1)), "R");
            }
            if (input.charAt(i) == opt[3]) {
                System.out.println(input.charAt(i));
                //p = input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1);
                input = input.replace((input.charAt(i-1) + "" + input.charAt(i) + input.charAt(i+1)), "S");
            }
        }
        System.out.println(input);


    }
}
