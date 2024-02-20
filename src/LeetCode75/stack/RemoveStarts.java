package LeetCode75.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStarts {
    public static void main(String[] args) {

        System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length() ; i++){
            if(s.charAt(i) =='*'){
                sb.delete(sb.length()-1,sb.length());
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
