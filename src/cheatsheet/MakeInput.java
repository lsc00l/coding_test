package cheatsheet;

import java.io.*;

/**
 * 프로그래머스 입력을 복사해서 넣으면 자바에서 쓸 수 있게 만들어줌
 */
public class MakeInput {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0 ; i< 10 ; i++){
            String input = reader.readLine();
            input = input.replaceAll("\\[", "\\{").replaceAll("\\]", "\\}");
            String[] inputs = input.split("\t");

            System.out.print("\nSystem.out.println(solution(");
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
            System.out.print("));\t//" + inputs[inputs.length - 1]);
        }
    }
}
