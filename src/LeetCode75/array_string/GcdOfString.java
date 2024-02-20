package LeetCode75.array_string;

public class GcdOfString {
    public static void main(String[] args) {
        GcdOfString g = new GcdOfString();
        System.out.println(g.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(g.gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(g.gcdOfStrings("LEET", "CODE"));
        System.out.println(g.gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));

    }

    public int gcd(int a, int b){
        if(b==0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2+str1)) return "";
        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0,gcdLen);
    }
}
