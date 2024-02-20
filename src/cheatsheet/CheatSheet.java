package cheatsheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CheatSheet {
    public static void main(String[] args) {
        CheatSheet cheatSheet = new CheatSheet();

        //이진수 구하기
        String binaryString = Long.toBinaryString(42);


        /**
         * 정렬
         */
        //2차원 배열 정렬
        int[][] costs = new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        Arrays.sort(costs, (o1, o2)-> o1[2] - o2[2]);

        //우선순위큐 사용
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        int num1 = 60;
        int num2 = 48;
        //최대공약수
        int gcd = cheatSheet.gcd(num1, num2);
        //최소공배수
        int lcd = (num1*num2) / gcd;

    }

    /* 최대공약수 구하기 */
    public int gcd(int a, int b){
        if(b==0) {
            return a;
        }
        else {
            return gcd(b, a % b);
        }
    }
}
