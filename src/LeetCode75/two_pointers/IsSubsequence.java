package LeetCode75.two_pointers;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("", "ahbgdc"));
        System.out.println(isSubsequence("b", "c"));
        System.out.println(isSubsequence("bb", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int idx =0;
        for(int i=0; i < t.length() ; i++){
            if(idx == s.length()) return true;
            if(t.charAt(i) == s.charAt(idx)) idx++;
        }
        return (idx == s.length()) ? true :false;
    }
}
