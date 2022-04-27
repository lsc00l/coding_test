## 전화번호 목록 문제

### 📠문제
[📃프로그래머스 - 전화번호 목록 문제](https://programmers.co.kr/learn/courses/30/lessons/42577)

해시 카테고리의 level 2문제다.


### 📠코드
``` java
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < phone_book.length ; i++) {
        	map.put(phone_book[i], i);
        }              
        
    	for(int i = 0 ; i < phone_book.length ; i++) {
    		
			char[] phone_nums = phone_book[i].toCharArray();
    		for(int j=0 ; j < phone_nums.length ; j++) {
    			if(map.containsKey(new String(phone_nums, 0, j)))
    				return false;    			
    		}
    	}
        
        return answer;
    }
}
```
