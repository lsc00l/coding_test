package LeetCode75.array_string;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords r = new ReverseWords();
        System.out.println(r.reverseWords2("the sky is blue"));
        System.out.println(r.reverseWords2("  hello world  "));
        System.out.println(r.reverseWords2("a good   example"));

    }
    public String reverseWords(String s) {
        StringBuilder answer = new StringBuilder();
        String[] array = s.split(" ");
        for(int i=array.length -1 ; i>= 0 ; i--){
            if(array[i].length() == 0) continue;
            answer.append(array[i]);
            answer.append(" ");
        }
        return answer.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] str = s.trim().split("\\s+");
        String ans =  "";
        for(int i=str.length-1; i>0; i--){
            ans+=str[i]+" ";
        }
        return ans + str[0];

    }

}
