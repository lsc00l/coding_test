package LeetCode75.array_string;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,0,0,1}, 2));
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1,0,0}, 2));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int pots = 0;
        boolean isPosible = true;
        for(int i = 0  ; i < flowerbed.length ; i++){
            if(pots >= n)return true;

            if(isPosible && flowerbed[i] == 0) {
                //마지막이면
                if(i == flowerbed.length - 1){
                    pots++;break;
                }
                //마지막이 아니면 다음 노드도 확인
                if(flowerbed[i+1] == 0){
                    pots++;
                    flowerbed[i] = 1;
                }
            }
            isPosible = (flowerbed[i] == 0) ? true : false;
        }
        return (pots >= n) ? true : false;
    }
}
