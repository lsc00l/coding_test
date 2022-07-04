# 주차 요금 계산

## 문제 
[코딩테스트 연습 - 주차 요금 계산](https://programmers.co.kr/learn/courses/30/lessons/92341)

## 풀이
1. Map<차량번호, 주차시간> 을 사용하여
In 일때는 "- 시간", out 일때는 "+ 시간" 을 한다. 

2. map을 돌며 주차요금을 계산한다. 
(시간 값이 0보다 같거나 작으면 12:59시간을 빼서 계산한다.)

## 코드
```java
import java.util.*;
class Solution {
    public List<Integer> solution(int[] fees, String[] records) {

		Comparator<String> comparator = (s1, s2)->s1.compareTo(s2);		
		
        Map<String, Integer> timeMap = new TreeMap<>(comparator);
        
        final int basetime = fees[0];
        final int baseFee = fees[1];
        final int plustime = fees[2];
        final int plusFee = fees[3];
        
        for(String record : records) {
        	String[] rArr = record.split(" ");
        	
        	String carNum = rArr[1];
        	int time = Integer.parseInt(rArr[0].split(":")[0]) * 60 + Integer.parseInt(rArr[0].split(":")[1]);
        	time = (rArr[2].equals("IN")) ? time*-1 : time;
        	timeMap.put(carNum, timeMap.getOrDefault(carNum, 0) + time);
        	
        }        
       
        timeMap.forEach((key, value) -> {
    		int howlong = (value <= 0) ? value + 1439 : value;        	
    		int howmuch = (howlong < basetime) ? baseFee : baseFee + (int) Math.ceil(((float)(howlong - basetime) / plustime)) * plusFee; 
    		timeMap.put(key, howmuch);
        });
                
        return new ArrayList<>(timeMap.values());
    }
}
```
