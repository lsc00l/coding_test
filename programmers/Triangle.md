## 정수 삼각형
### 🔺문제
[📃프로그래머스 - 정수 삼각형](https://programmers.co.kr/learn/courses/30/lessons/43105)

동적계획법(Dynamic Programming) 카테고리의 level3 문제다. 

### 🔺동적프로그래밍
처음엔 동적프로그래밍이 뭔지 공부도 안하고 모든 경우의 수를 재귀로 풀려고 했다.
역시나 효율성 제로ㅎ

동적프로그래밍이 무엇인지 찾아보니..

**< 동적프로그래밍 >**
- 큰 문제를 작은 문제로 분할하여 해결하는 알고리즘이다.
- 작은 문제는 반복되지 않고 풀때마다 항상 값이 같다.
- 작은 문제의 답을 어딘가에 메모 해놓는다. → Memoization

설명만 읽고는 잘 와닿지 않았다. 문제를 풀며 조금씩 감이 잡혔다.

이 문제는 위에서 아래로 대각선 방향으로 내려오며 더했을 때 가장 큰 경우를 찾는 문제이다.



### 🔺로직
이 문제의 로직은 간단하다.
대각선 방향으로 한줄씩 내려오며 숫자를 더하는걸 작은 문제로 나눠서 풀면 된다.
작은 문제의 답은 풀때마다 항상 같다.



아래가 이 문제의 작은문제다.
노랑(자신 + 왼쪽 대각선) vs 초록(자신 + 오른쪽 대각선)
이 두개를 비교하여 더 큰수가 해당 자리의 답이 된다. 
![](https://images.velog.io/images/co_ol/post/aa4b766c-b312-4ab1-aaed-d8bd3ce7fc38/image.png)


두번째 줄 부터
1. 줄의 왼쪽 끝 숫자는 자신과 윗줄의 왼쪽 숫자와 더한다.
![](https://images.velog.io/images/co_ol/post/a263c9ed-ed1b-44a7-8d3f-5dde5e4150d0/image.png)

2. 왼쪽과 더한 수 , 오른쪽과 더한 수 두 개를 비교하여 더 큰수가 해당 자리의 답이 된다. 
![](https://images.velog.io/images/co_ol/post/aa4b766c-b312-4ab1-aaed-d8bd3ce7fc38/image.png)

3. 오른쪽 끝 숫자는 자신과 윗줄의 오른쪽 숫자와 더한다. 
![](https://images.velog.io/images/co_ol/post/a648a377-70d8-4e1d-9e10-3e9fb49b3604/image.png)



위 과정을 반복하여 memoization을 거치면 오른쪽과 같이 된다.
이 중 가장 큰 수 가 문제의 답이된다. 
![](https://images.velog.io/images/co_ol/post/5dfca397-f293-4807-970b-5af6dc79d9d7/image.png)



### 🔺코드
```java
for(int i = 1; i < n ; i++) {
	for(int j = 0; j < triangle[i].length ; j++) {

		if(j == 0) {//왼쪽 끝
			triangle[i][j] += triangle[i-1][j];
		}
		else if(j == i) {//오른쪽 끝
			triangle[i][j] += triangle[i-1][j-1];
		}
		else {
			triangle[i][j] += Math.max(triangle[i-1][j], triangle[i-1][j-1]);
		}

		answer = Math.max(answer, triangle[i][j]);
	}
}
return answer;
```
