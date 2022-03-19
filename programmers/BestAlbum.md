## 베스트앨범

### 💿📀 문제
[📃프로그래머스 - 베스트앨범] (https://programmers.co.kr/learn/courses/30/lessons/42579)

해시 카테고리, level 3

### 💿📀 풀이

문제의 조건에 따라 고려 대상의 우선순위는 아래와 같다.

** 장르별 총 재생수 → 앨범별 재생 수 → 앨범의 고유번호 **

 장르별 정렬이 우선이기 때문에 장르명이 Key값인 Map을 이용해 풀어야 할 것 같은데 value를 어떻게 잡을지 고민이 됐다. 

장르명에 따라 총 재생수와 앨범의 정보(재생수 와 고유번호)가 필요했다. 
앨범의 고유번호는 plays 배열의 인덱스다. 고유번호만 있으면 앨범의 재생수는 plays[고유번호]로 알 수 있다.

따라서, value로 필요한 정보를 총재생수와 고유번호 리스트로 정했다. 
둘의 타입이 달라 Genre라는 클래스를만들었다. 

Genre클래스는
장르별 총재생수를 누적할 수 있는 total 변수와
앨범의 고유번호를 담는 albumList 리스트로 구성했다.

아래와 같은 Map 구조로 문제를 풀었다.
![](https://images.velog.io/images/co_ol/post/2ead7132-e398-4b72-a477-b4a5cdaf3235/image.png)


<br/>

### 💿📀 로직

#### 입력데이터
문제에 나와있는 기본 테스트케이스이다. 
```
genres : ["classic", "pop", "classic", "classic", "pop"]
plays  : [500, 600, 150, 800, 2500]
```
<br/>

#### 1. 입력 데이터를 Map에 넣는다.
→ 데이터가 장르별로 구분된다.<br/>
![](https://images.velog.io/images/co_ol/post/d75d88cd-b47a-428d-9eba-db5285fb8029/image.png)


#### 2. 총재생수로 정렬
이제 장르명은 필요없다!
Map의 value값을 List<Genre>로 변환 후 
장르별 총재생수로 List를 정렬한다.
~~사실 List로 변환하지 않고 Map 그대로 정렬하려고 했는데,  Map 정렬하는 코드가 좀 더러워서 간단하게 List로 변환하여 정렬하였다.~~
<br/>
![](https://images.velog.io/images/co_ol/post/b9ee1dde-8977-419a-aa9e-5a935414578e/image.png)

#### 3. 마지막, 장르별로 베스트 앨범 두개를 선정
앨범별 재생수를 비교하기 위해 우선순위큐(PriorityQueue)에
고유번호와 재생수를 put해준 후 
베스트앨범 두개or한개를 poll해주면 답이 나온다.
<br/>
![](https://images.velog.io/images/co_ol/post/07fcb58f-7ffa-4369-9ab6-c3d8446bddbf/image.png)
<br/>답!!<br/>
![](https://images.velog.io/images/co_ol/post/38c4cf42-b691-45fb-b5db-72a11711de60/image.png)
  <br/><br/>


  
  
### 💿📀 코드
```java
public List<Integer> solution(String[] genres, int[] plays) {
	List<Integer> answer = new ArrayList<Integer>();
    
    Map<String, Genre> gMap = new HashMap<>();
    
    /* 1. map에 장르별로 데이터 추가 */
    for(int i=0; i< genres.length ; i++) {    	
    	if(gMap.containsKey(genres[i])) {        		
    		Genre oriGen = gMap.get(genres[i]);
    		oriGen.addGenre(plays[i], i);
    		gMap.put(genres[i], oriGen);
    	}
    	else {
    		gMap.put(genres[i], new Genre(plays[i], i));
    	}
    }
    
    /* 2. 장르별 정렬 */
    List<Genre> gList = new ArrayList<>(gMap.values());
    //총재생수를 이용하여 비교
    gList.sort((o1, o2)-> o2.getTotal() - o1.getTotal());
            
    /* 3. 장르별 베스트앨범 2개 선정 */
    for (Genre list : gList) {
    	/* PriorityQueue 
    	 * 재생수 큰 순서대로 정렬 
    	 * 같을 경우 앨범고유번호 순으로  */
    	PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> {
    		if(o2[1] - o1[1] == 0)
    			return o1[0] - o2[0];
    		else
    			return o2[1] - o1[1];
    	});
    	// 큐에 모든 앨범 추가
    	for(int i : list.getAlbumList()) {	
    		int[] play = {i,plays[i]};
    		q.offer(play);
    	}

    	// 상위 두개만 꺼낸다.
    	answer.add(q.poll()[0]);
    	if(!q.isEmpty())
    		answer.add(q.poll()[0]);
	}
            
    return answer;
}

class Genre{
	int total = 0;	//총 재생 수
	List<Integer> albumList = new ArrayList<>();	//앨범 고유번호 리스트
	
	/**
	 * 앨범 추가
	 * - 재생수 누적, 앨범리스트 추가
	 */
	public void addGenre(int total, int album) {
		this.total += total;
		this.albumList.add(album);
	}

	public Genre(int total, int album) {
		this.total += total;
		this.albumList.add(album);
	}
	
	// Getter, Setter 생략 //
}
```
   <br/><br/>
