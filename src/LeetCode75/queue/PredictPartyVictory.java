package LeetCode75.queue;

import java.util.*;

public class PredictPartyVictory {
    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RD"));//Radiant
        System.out.println(predictPartyVictory("RDD"));//Dire
        System.out.println(predictPartyVictory("DDR"));//Dire
        System.out.println(predictPartyVictory("DDRRR"));//DIRE
        System.out.println(predictPartyVictory("RRDDD"));//Radiant
    }
    public static String predictPartyVictory_my(String senate) {
        /* 1. 투표 준비 (당별 상원의원 count, List에 담기) */
        int rCnt = 0;
        List<Character> sList = new ArrayList<>();
        for(int i=0; i<senate.length() ; i++) {
            sList.add(senate.charAt(i));
            if(senate.charAt(i)=='R') rCnt++;
        }

        int rBanned = 0;
        int dBanned = 0;
        String winner = "";
        Queue<Character> queue;

        while(!sList.isEmpty()) {

            /* 다음 라운드에 진출 할 상원의원들 큐 생성 */
             queue = new LinkedList<>();
            /* 2. 한 라운드 진행 */
            for(int i=0; i < sList.size() ; i++) {
                Character senator = sList.get(i);
                if(senator == 'R'){//R 의원
                    /* 3-A. 밴 당했다면 패스 */
                    if(rBanned > 0) {
                        rBanned--; rCnt--;
                        continue;
                    }
                    /* 3-B. 현 라운드에 우리당 밖에 없다면 승리 */
                    else if(rCnt == sList.size()) {
                        return "Radiant";
                    }
                    /* 3-C. 위 두 케이스가 아니라면 다른 당원 밴시키고 다음 라운드 준비 */
                    else{
                        dBanned++;
                        queue.add(senator);
                    }
                } else if (senator == 'D'){//D 의원
                    /* 3-A. 밴 당했다면 패스 */
                    if(dBanned > 0) {
                        dBanned--;
                        continue;
                    }
                    /* 3-B. 현 라운드에 우리당 밖에 없다면 승리 */
                    else if(rCnt == 0) {
                        return "Dire";
                    }
                    /* 3-C. 위 두 케이스가 아니라면 다른 당원 밴시키고 다음 라운드 준비 */
                    else{
                        rBanned++;
                        queue.add(senator);
                    }
                }
            }
            /* 4. 한 라운드가 끝나면 다음 라운드 준비 */
            sList = new ArrayList<>(queue);
        }
        return winner;
    }


    /**
     * 하나의 큐 이용한 풀이
     * @param senate
     * @return
     */
    public static String predictPartyVictory(String senate) {
        /* 1. 투표 준비 (Queue 에 담기) */
        Queue<Character> queue = new LinkedList<>();
        int rCnt = 0;
        for(int i=0; i<senate.length() ; i++){
            queue.add(senate.charAt(i));
            if(senate.charAt(i)=='R') rCnt++; //R 상원 카운트
        }

        /* 2. 투표 진행 */
        int RBanned = 0, DBanned = 0;
        while(rCnt > 0 && queue.size()-rCnt > 0){
            Character senator = queue.poll();
            if(senator == 'R'){
                if(RBanned > 0) {   /* A. 밴 당했다면 탈락 */
                    rCnt--;
                    RBanned--;
                } else {            /* B. 밴 시킨다. */
                    DBanned++;
                    queue.add(senator);
                }
            }else if(senator == 'D'){
                if(DBanned > 0){    /* A. 밴 당했다면 탈락 */
                    DBanned--;
                } else {            /* B. 밴 시킨다. */
                    RBanned++;
                    queue.add(senator);
                }
            }
        }
        return (rCnt > 0) ? "Radiant" : "Dire";
    }


    /**
     * 2개의 Queue 이용한 풀이
     * @param senate
     * @return
     */
    public static String predictPartyVictory_twoQUEUE(String senate) {

        // Number of Senator
        int n = senate.length();

        // Queues with Senator's Index.
        // Index will be used to find the next turn of Senator
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        // Populate the Queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.add(i);
            } else {
                dQueue.add(i);
            }
        }

        // While both parties have at least one Senator
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {

            // Pop the Next-Turn Senate from both Q.
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();

            // ONE having a larger index will be banned by a lower index
            // Lower index will again get Turn, so EN-Queue again
            // But ensure its turn comes in the next round only
            if (dTurn < rTurn) {
                dQueue.add(dTurn + n);
            } else {
                rQueue.add(rTurn + n);
            }
        }

        // One's which Empty is not winner
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }


}
