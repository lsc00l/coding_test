## ๋จ์ด๋ณํ

### ๐๋ฌธ์ 
[๐ ํ๋ก๊ทธ๋๋จธ์ค - ๋จ์ด๋ณํ๋ฌธ์ ](https://programmers.co.kr/learn/courses/30/lessons/43163)

DFS/BFS ์นดํ๊ณ ๋ฆฌ, level 3

<br/>

### ๐๋ก์ง
๋ฌธ์ ์ ์๋ ํ์คํธ์ผ์ด์ค๋ก ๊ทธ๋ฆผ์ ํ๋ฒ ๊ทธ๋ ค๋ดค๋ค.

์ฃผ์ด์ง words ๋ฆฌ์คํธ์ target๋ฌธ์์ด์ด ์๋์ง ๋จผ์  ์ฒดํฌ ํ ํ
target๋ฌธ์์ด์ด ์๋ค๋ฉด ์๋ ๊ทธ๋ฆผ์ฒ๋ผ ๋ชจ๋  ๊ฒฝ์ฐ์ ์๋ฅผ ํ์ํ๋ค. 

begin ๋ถํฐ ์์ํด ๋ณํ ๊ฐ๋ฅํ ๋จ์ด๋ก ๊ฐ์ง์น๊ธฐ ํ๋ฏ์ด ๋ชจ๋  ๊ฒฝ์ฐ๋ฅผ ๋ชจ๋ ์ฐพ์ ์นด์ดํธ๋ฅผ ํ๋ค.
๊ฐ์ง์น๊ธฐ(?) ํ๊ณณ์์ ์นด์ดํธ๊ฐ ์์ ์ชฝ์ด ๋ฆฌํด๋๋ค. 
์ด ๊ณผ์ ์ ๋ฐ๋ณตํ์ฌ ์ต์ข์ ์ผ๋ก ๋ชจ๋  ๊ฒฝ์ฐ์ ์ ์ค ๊ฐ์ฅ ์์ ๊ฐ์ด ๋ฆฌํด๋๋ค.<br/>

![hit์์ cog๊น์ง์ ๊ฒฝ์ฐ์ ์](https://images.velog.io/images/co_ol/post/d544fb52-5635-49aa-9ec2-eef71abd3b08/image.png)


์ ๋ฆฌํ๋ฉด
```
1. words ์ target ์๋์ง ํ์ธ
2. ๋จ์ด๋ณํ ๊ฒฝ๋ก ํ์
2-1. target์ด ๋์์๋ RETURN (ํ์ถ์กฐ๊ฑด)
2-2. ๊ฐ๋ฅํ ๋จ์ด ์ฒดํฌ ํ ์ฌ๊ท(2๋ฒ์ผ๋ก)

```
<br/>

### ๐ํ์คํธ์ผ์ด์ค
##### - "begin", "target", words  //๊ฒฐ๊ณผ
```
- "hit", "cog", {"hot", "dot", "dog", "lot", "log", "cog"}	//4
- "hit", "log", {"hot", "dot", "dog", "lot", "log", "cog"}	//3
- "hit", "cog", {"cog", "log", "lot", "dog", "dot", "hot"}	//4
- "hit", "cog", {"hot", "dot", "dog", "lot", "log"}		//0
- "1234567000", "1234567899", {"1234567800", "1234567890", "1234567899"}//3
```
<br/>

### ๐์ฝ๋

```java
public int solution(String begin, String target, String[] words) {
	int n = words.length;
    
	/* 1. words ์ target ์๋์ง ํ์ธ*/
	int index = -1;
	for(int i = 0 ; i < n ; i++) {
		if(words[i].equals(target)) index = i;
	}
	if(index< 0) {
		return 0;
	}
	/* 2. ๋จ์ด๋ณํ ๊ฒฝ๋ก ํ์ */
	boolean[] chk = new boolean[n];
	return dfs(begin, target, -1, words, chk, 0);
}

/**
 * ๋จ์ด๋ณํ์ ๋ชจ๋  ๊ฒฝ๋ก ํ์ ์ต์  ์นด์ดํธ ์ ๋ฐํ
 */
public int dfs(String begin, String target, int idx, String[] words, boolean[] chk , int cnt) {		
	/* target์ด ๋์์๋ RETURN (ํ์ถ์กฐ๊ฑด) */
	if(target.equals(begin)) {
		return cnt;
	}
	
	/* ๋ฐฉ๋ฌธ์ฒดํฌ, ์นด์ดํธ */
	if(idx >= 0) chk[idx] = true;
	cnt++;
	
	/* ๊ฐ๋ฅํ ๋จ์ด ์ฒดํฌ ํ ์ฌ๊ท */
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
 * ๊ฐ๋ฅํ ๋จ์ด์ธ์ง ์ฒดํฌ 
 */
public boolean wordCheck(char[] begin, char[] target) {
	/* ํ๊ธ์๋ง ๋ค๋ฅธ์ง ์ฒดํฌ */
	int cnt = 0;
	for(int j=0 ; j<begin.length ; j++) {
		if(begin[j] != target[j])
			cnt ++;
	}
	return (cnt ==1) ? true : false;
}
```
<br/>
