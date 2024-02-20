package LeetCode75.hashmap_set;

import java.util.*;

public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("abbzzca", "babzzcz"));
    }
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i=0 ; i<word1.length() ; i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 1) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 1) + 1);
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
        }
        if(!set1.equals(set2)) return false;
        Set<Integer> vset1 = new HashSet<>(map1.values());
        Set<Integer> vset2 = new HashSet<>(map2.values());
        if(!vset1.equals(vset2)) return false;
        return true;
    }
}
