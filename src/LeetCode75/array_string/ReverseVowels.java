package LeetCode75.array_string;

import java.util.*;

//https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
public class ReverseVowels {

    public static void main(String[] args) {
        ReverseVowels r = new ReverseVowels();
        System.out.println(r.reverseVowels("hello"));
        System.out.println(r.reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        boolean[] chk = new boolean[sArr.length];
        Stack<Character> stack = new Stack<>();
        for(int  i=0; i< sArr.length ; i++) {
            if(vowels.indexOf(sArr[i]) > -1) {
                chk[i] = true;
                stack.push(sArr[i]);
            }
        }

        for(int  i=0; i< sArr.length ; i++) {
            if(chk[i]) {
                sArr[i] = stack.pop();
            }
        }

        return String.valueOf(sArr);
    }
}
