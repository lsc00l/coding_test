package LeetCode75.array_string;

public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));//aapbqcr
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder answer = new StringBuilder();
        int idx1 = word1.length();
        int idx2 = word2.length();
        for(int i=0 ; i< Math.max(idx1, idx2) ; i++){
            if(i < idx1)
                answer.append(word1.charAt(i));
            if(i < idx2)
                answer.append(word2.charAt(i));
        }
        return answer.toString();
    }
}
