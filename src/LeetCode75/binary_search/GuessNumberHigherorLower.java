package LeetCode75.binary_search;

public class GuessNumberHigherorLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int pick;

        while(true){
            pick = left + (right - left)/2;
            if(guess(pick)==0)
                break;
            else if (guess(pick)>0) {
                left = pick;
            }else {
                right = pick;
            }
        }

        return pick;
    }

    static public int guess(int n){

        if(n==6) return 0;
        else if(n > 6) return -1;
        else {
            return 1;
        }
    }
}
