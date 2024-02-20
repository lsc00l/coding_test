package LeetCode75.sliding_window;

import java.util.Set;

public class MaxVowels {
    public static void main(String[] args) {
        System.out.println(maxVowels_my("abciiidef", 3));//3
        System.out.println(maxVowels_my("aeiou", 2));//2
        System.out.println(maxVowels_my("leetcode", 3));//2
        System.out.println(maxVowels_my("weallloveyou", 7));//4
        System.out.println(maxVowels_my("abciiidef", 3));//3
        System.out.println(maxVowels_my("uaiptsvkdadtefchtnftwjepohdfvgn", 24));//6
    }

    public static int maxVowels(String s, int k) {
        final String vowels = "aeiou";
        char[] sArr  = s.toCharArray();
        int[] cntArr = new int[sArr.length];
        int max = 0;
        cntArr[0] = (vowels.indexOf(sArr[0]) >= 0 ) ? 1 : 0;
        for(int i=1; i< sArr.length ; i++){
            cntArr[i] = (vowels.indexOf(sArr[i]) >= 0 ) ? cntArr[i-1] + 1 : cntArr[i-1];
            if(i > k) max = Math.max(cntArr[i] - cntArr[i-k], max);
            if (i == k-1) max = Math.max(cntArr[i], max);
        }
        return (max > k) ? k : max;
    }

    public static int maxVowels_my(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int cnt = 0;
        for(int i=0 ; i<k ; i++){
            cnt += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int max = cnt;
        for(int i=k ; i < s.length() ; i++){
            cnt += vowels.contains(s.charAt(i)) ? 1 : 0;
            cnt -= vowels.contains(s.charAt(i-k)) ? 1 : 0;
            max = Math.max(max, cnt);
        }

        return max;
    }

    public static int answer(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Build the window of size k, count the number of vowels it contains.
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int answer = count;

        // Slide the window to the right, focus on the added character and the
        // removed character and update "count". Record the largest "count".
        for (int i = k; i < s.length(); i++) {
            count += vowels.contains(s.charAt(i)) ? 1 : 0;
            count -= vowels.contains(s.charAt(i - k)) ? 1 : 0;
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
