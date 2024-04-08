package LeetCode75.binary_search;

public class GuessNumberHigherorLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(2));
    }
    static int guessNumber(int n) {
        int left = 1;
        int right = n;
        int pick;

        while(true){
            pick = (int) (left + (right - left)/2);
            if(guess(pick)==0)
                break;
            else if (guess(pick)>0) {
                left = pick+1;
            }else {
                right = pick-1;
            }
        }

        return pick;
    }

    static public int guess(int n){

        if(n==2) return 0;
        else if(n > 2) return -1;
        else {
            return 1;
        }
    }
}
