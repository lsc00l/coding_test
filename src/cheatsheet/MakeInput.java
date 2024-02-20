package cheatsheet;

import java.io.*;

public class MakeInput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i< 10 ; i++){
            String input = input = reader.readLine();
            input = input.replaceAll("\\[", "\\{").replaceAll("\\]", "\\}");
            String[] inputs = input.split("\t");

            System.out.print("System.out.println(solution(");
            for (int j = 0; j < inputs.length - 1; j++) {
                String value = inputs[j];

                if (value.matches("^\\{\\{\\\".+")) {
                    System.out.print("new String[][] ");
                } else if (value.matches("^\\{\\{.+")) {
                    System.out.print("new int[][] ");
                } else if (value.matches("^\\{\\\".+")) {
                    System.out.print("new String[] ");
                } else if (value.matches("^\\{.+")) {
                    System.out.print("new int[] ");
                }
                System.out.print(value);
                if (j < inputs.length - 2) {
                    System.out.print(", ");
                }
            }
            System.out.println("));\t//" + inputs[inputs.length - 1]);
        }
    }
}
