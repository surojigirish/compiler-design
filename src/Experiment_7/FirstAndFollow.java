package Experiment_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstAndFollow {

    static char[] nTerm1, term1;
    static int nTLen, tLen;
    static String[][] grammar;
    static String[] first;
    static String[] follow;

    public static void main(String[] args) throws IOException {
        String nt, t;
        int i, j, n;

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the non-terminals");
        nt = br.readLine();
        nTLen = nt.length();
        nTerm1 = new char[nTLen];
        nTerm1 = nt.toCharArray();

        System.out.println("Enter the terminals");
        t = br.readLine();
        tLen = t.length();
        term1 = new char[tLen];
        term1 = t.toCharArray();

        System.out.println("Specify the grammar (Enter 9 for epsilon production)");
        grammar = new String[nTLen][];
        for (i = 0; i < nTLen; i++) {
            System.out.println("Enter the number of productions for " +nTerm1[i]);
            n = Integer.parseInt(br.readLine());
            grammar[i] = new String[n];
            System.out.println("Enter the productions");
            for (j = 0; j < n; j++) {
                grammar[i][j] = br.readLine();
            }
        }

        first = new String[nTLen];
        for (i = 0; i < nTLen; i++) {
            first[i] = first(i);
        }
        System.out.println("First Set");
        for (i = 0; i < nTLen; i++) {
            System.out.println(removeDuplicates(first[i]));
        }
        follow = new String[nTLen];
        for (i = 0; i < nTLen; i++) {
            follow[i] = follow(i);
        }
        System.out.println("Follow Set");
        for (i = 0; i < nTLen; i++) {
            System.out.println(removeDuplicates(follow[i]));
        }
    }

    static String first(int i) {
        int found = 0;
        String temp = "", str = "";
        for (int j = 0; j < grammar[i].length; j++) { //number of productions
            for (int k = 0; k < grammar[i][j].length(); k++) {
                //when non-terminal has epsilon production
                for (int l = 0; l < nTLen; l++) {
                    // finding non terminal
                    if (grammar[i][j].charAt(k) == nTerm1[l]) {
                        //for non-terminal in first set
                        str = first(l);
                        if (!(str.length() == 1 && str.charAt(0) == '9')) {
                            //when epsilon production is the only non terminal production
                            temp = temp + str;
                            found = 1;
                            break;
                        }
                    }
                } if (found == 1) {
                    if (str.contains("9"))  //here epsilon will lead to next non-terminal's first set
                        continue;
                } else {
                    //if first set includes terminal
                    temp = temp + grammar[i][j].charAt(k);
                    break;
                }
            }
        }
        return temp;
    }

    static String follow(int i) {
        char[] pro, chr;
        String temp = "";
        int j, k, l, m, n, found = 0;

        if (i == 0) {
            temp = "$";
        }

        for (j = 0; j < nTLen; j++) {
            for (k = 0; k <grammar[j].length; k++) {
                //entering grammar matrix
                pro = new char[grammar[j][k].length()];
                pro = grammar[j][k].toCharArray();
                for (l = 0; l < pro.length; l++) {
                    //entering each production
                    if (pro[l] == nTerm1[i]) {
                        //finding the nonterminal whose follow set is to be found
                        if (l == pro.length-1) {
                            //if it is the last terminal/ non terminal than follow of current non terminal
                            if (j < i) {
                                temp = temp + follow[j];
                            }
                        } else {
                            for (m = 0; m < nTLen; m++) {
                                if (pro[l + 1] == nTerm1[m]) {
                                    //first of next non-terminal otherwise (else later)
                                    chr = new char[first[m].length()];
                                    chr = first[m].toCharArray();
                                    for (n = 0; n < chr.length; n++) {
                                        if (chr[n] == '9') {
                                            //if first includes epsilon
                                            if (l + 1 == pro.length-1) {
                                                temp = temp + follow(j);  //when non terminal is second last
                                            } else {
                                                temp = temp + follow(m);
                                            }
                                        } else {
                                            temp = temp + chr[n];  //include whole first set except epsilon
                                        }
                                    }
                                    found = 1;
                                }
                            } if (found != 1) {
                                temp = temp + pro[l + 1]; //follow set will include terminal
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    static String removeDuplicates(String str) {
        char ch;
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder(seen.length);
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}