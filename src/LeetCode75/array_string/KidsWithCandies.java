package LeetCode75.array_string;

import java.util.*;

public class KidsWithCandies {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[] {2,3,5,1,3}, 3));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i=0; i< candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        Boolean[] chk = new Boolean[candies.length];
        for(int i=0; i< candies.length; i++) {
            chk[i] = (candies[i] + extraCandies >= max ) ? true : false;
        }
        return new ArrayList<Boolean>(List.of(chk));
    }
}
