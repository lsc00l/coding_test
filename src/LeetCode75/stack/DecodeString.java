package LeetCode75.stack;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        System.out.println(decodeString("3[a]2[bc]"));//aaa bc bc
        System.out.println(decodeString("3[a2[c]]"));//acc acc acc
        System.out.println(decodeString("2[abc]3[cd]ef"));//abc abc cd cd cd ef
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));//abc abc cd cd cd ef
    }

    public static String decodeString(String s) {
        StringBuilder answer = new StringBuilder();

        int brackets = 0;
        Stack<Integer> dstack = new Stack<>();
        Stack<String> wStack = new Stack<>();

        StringBuilder digitSb = new StringBuilder();//몇번 반복할지 숫자
        StringBuilder wordSb = new StringBuilder();//반복할 단어
        StringBuilder word = new StringBuilder();

        for(char w : s.toCharArray()){
            if(w=='['){
                brackets++;
                dstack.push(Integer.parseInt(digitSb.toString()));//숫자
                digitSb.setLength(0);
            } else if (w==']') {
                brackets--;
                if(wordSb.length() > 0){
                    wStack.push(wordSb.toString());//단어
                    wordSb.setLength(0);
                }
                int n = dstack.pop();
                String myW;
                if(!wStack.empty()){
                    myW = wStack.pop() + word.toString();
                }else{
                    myW = word.toString();
                }
                word.setLength(0);
                for(int i = 0; i< n ; i++){
                    word.append(myW);
                }

                if(brackets ==0) {
                    answer.append(word);
                    word.setLength(0);
                }
            }
            else if(Character.isDigit(w)){//숫자
                if(brackets > 0) {
                    word.append(wordSb);//단어
                    wordSb.setLength(0);
                } else if (brackets ==0 && wordSb.length() >0) {
                    answer.append(wordSb);
                    wordSb.setLength(0);
                }
                digitSb.append(w);
            }else {//단어
                wordSb.append(w);
            }
        }
        answer.append(wordSb);

        return answer.toString();
    }
}
