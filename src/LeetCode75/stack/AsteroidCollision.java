package LeetCode75.stack;

import java.util.*;

public class AsteroidCollision {
    public static void main(String[] args) {
//        printMethod(asteroidCollision(new int[] {5,10,-5}));
//        printMethod(asteroidCollision(new int[] {8,-8}));
//        printMethod(asteroidCollision(new int[] {10,2,-5}));//10
//        printMethod(asteroidCollision(new int[] {-2,-1,1,2}));
//        printMethod(asteroidCollision(new int[] {-2,2,-1,-2}));//-2
        printMethod(asteroidCollision(new int[] {-2,-2,1,-2}));//[-2,-2,-2]


    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>(); /* 살아남은 행성들 */

        for (int asteroid : asteroids) {
            if(stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            boolean flag = true;
            while(!stack.isEmpty() && (stack.peek() > 0 &&  asteroid < 0)){ /* A. 충돌 O ( → ← 방향일때만 충돌) */
                if(Math.abs(asteroid) == Math.abs(stack.peek())){ //case-1. 같은크기면 둘다 사라짐
                    stack.pop();
                    flag = false;
                    break;
                } else if (Math.abs(stack.peek()) < Math.abs(asteroid)) { //case-2.
                    stack.pop();
                } else { //Math.abs(live) > Math.abs(asteroid)
                    flag = false;
                    break;
                }
            }
            if(flag) {
                stack.push(asteroid);
            }
        }

        /*정답 처리 : live Stack 을 int[] 로 변환 */
        if(stack.isEmpty()) return new int[0]; //stack 비었으면 빈 배열 리턴
        int size = stack.size();
        int[] answer = new int[size];
        while(!stack.empty()){ answer[--size] = stack.pop(); }
        return answer;
    }




    public static int[] asteroidCollision_as(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!st.isEmpty() && (st.peek() > 0 && asteroid < 0)) {
                // If the top asteroid in the stack is smaller, then it will explode.
                // Hence pop it from the stack, also continue with the next asteroid in the stack.
                if (Math.abs(st.peek()) < Math.abs(asteroid)) {
                    st.pop();
                    continue;
                }
                // If both asteroids have the same size, then both asteroids will explode.
                // Pop the asteroid from the stack; also, we won't push the current asteroid to the stack.
                else if (Math.abs(st.peek()) == Math.abs(asteroid)) {
                    st.pop();
                }

                // If we reach here, the current asteroid will be destroyed
                // Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if (flag) {
                st.push(asteroid);
            }
        }

        // Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[st.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = st.peek();
            st.pop();
        }

        return remainingAsteroids;
    }

    public static void printMethod(int[] arr){
        System.out.print("\"");
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\"");
    }
}
