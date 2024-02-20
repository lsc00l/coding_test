## 단어변환

### 📌문제
[📄 프로그래머스 - 단어변환문제](https://programmers.co.kr/learn/courses/30/lessons/43163)

DFS/BFS 카테고리, level 3

<br/>

### 📌로직
문제에 있는 테스트케이스로 그림을 한번 그려봤다.

주어진 words 리스트에 target문자열이 있는지 먼저 체크 한 후
target문자열이 있다면 아래 그림처럼 모든 경우의 수를 탐색한다. 

begin 부터 시작해 변환 가능한 단어로 가지치기 하듯이 모든 경우를 모두 찾아 카운트를 한다.
가지치기(?) 한곳에서 카운트가 작은 쪽이 리턴된다. 
이 과정을 반복하여 최종적으로 모든 경우의 수 중 가장 작은 값이 리턴된다.<br/>

![hit에서 cog까지의 경우의 수](https://images.velog.io/images/co_ol/post/d544fb52-5635-49aa-9ec2-eef71abd3b08/image.png)


정리하면
```
1. words 에 target 있는지 확인
2. 단어변환 경로 탐색
2-1. target이 되었을때 RETURN (탈출조건)
2-2. 가능한 단어 체크 후 재귀(2번으로)

```
<br/>

### 📌테스트케이스
##### - "begin", "target", words  //결과
```
- "hit", "cog", {"hot", "dot", "dog", "lot", "log", "cog"}	//4
- "hit", "log", {"hot", "dot", "dog", "lot", "log", "cog"}	//3
- "hit", "cog", {"cog", "log", "lot", "dog", "dot", "hot"}	//4
- "hit", "cog", {"hot", "dot", "dog", "lot", "log"}		//0
- "1234567000", "1234567899", {"1234567800", "1234567890", "1234567899"}//3
```
<br/>

### 📌코드

```java
public int solution(String begin, String target, String[] words) {
	int n = words.length;
    
	/* 1. words 에 target 있는지 확인*/
	int index = -1;
	for(int i = 0 ; i < n ; i++) {
		if(words[i].equals(target)) index = i;
	}
	if(index< 0) {
		return 0;
	}
	/* 2. 단어변환 경로 탐색 */
	boolean[] chk = new boolean[n];
	return dfs(begin, target, -1, words, chk, 0);
}

/**
 * 단어변환의 모든 경로 탐색 최저 카운트 수 반환
 */
public int dfs(String begin, String target, int idx, String[] words, boolean[] chk , int cnt) {		
	/* target이 되었을때 RETURN (탈출조건) */
	if(target.equals(begin)) {
		return cnt;
	}
	
	/* 방문체크, 카운트 */
	if(idx >= 0) chk[idx] = true;
	cnt++;
	
	/* 가능한 단어 체크 후 재귀 */
	int answer = chk.length;
	for(int i=0 ; i<chk.length ; i++) {			
		if(!chk[i]) {
			if(wordCheck(begin.toCharArray(), words[i].toCharArray())) {
				answer = Math.min(answer, dfs(words[i], target, i, words, chk, cnt));
				chk[i] = false;
			}
		}
	}
	return answer;
}

/**
 * 가능한 단어인지 체크 
 */
public boolean wordCheck(char[] begin, char[] target) {
	/* 한글자만 다른지 체크 */
	int cnt = 0;
	for(int j=0 ; j<begin.length ; j++) {
		if(begin[j] != target[j])
			cnt ++;
	}
	return (cnt ==1) ? true : false;
}
```
<br/>
