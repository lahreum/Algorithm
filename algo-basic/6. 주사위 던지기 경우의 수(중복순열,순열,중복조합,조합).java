import java.util.Arrays;
import java.util.Scanner;

public class DiceTest{
	
	private static int N, numbers[], totalCnt;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	// 주사위 던진횟수
		numbers = new int[N];
		isSelected = new boolean[7];	// 주사위 1~6 까지이므로
		
		int mode = sc.nextInt();	// 주사위 던지는 모드
		totalCnt = 0;
		
		switch(mode) {
		case 1:			// 주사위 던지기 1: 중복순열
			dice1(0);
			break;
		case 2:			// 주사위 던지기 2: 순열
			dice2(0);
		case 3:			// 주사위 던지기 3: 중복조합
			dice3(0, 1);		// 주사위 눈 1부터 시작하니까 시작점 1
			break;
		case 4:
			dice4(0, 1);		// 주사위 던지기 4: 조합
		}
		
		System.out.println("총 경우의 수: " + totalCnt);
	}
	
	// 증복순열
	private static void dice1(int cnt) {
		 if(cnt == N) {		// 기저파트
			 ++totalCnt;
			 System.out.println(Arrays.toString(numbers));
			 return;
		 }
		 
		 for(int i=1; i<=6; i++) {		// 유도파트
			 numbers[cnt] = i;
			 dice1(cnt+1);
		 }
	}
	// 순열
	private static void dice2(int cnt) {
		if(cnt == N) {		// 기저파트
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1; i<=6; i++) {		// 유도파트
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
			
		}
	}
	
	// 중복조합 
	private static void dice3(int cnt, int start) {
		// 기저파트
		if(cnt == N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<= 6; i++) {		// 유도파트
			numbers[cnt] = i;
			dice3(cnt+1, i);		// 중복 조합이니까 i+1 아니고 i
		}
	}
	// 조합 
	private static void dice4(int cnt, int start) {
		// 기저파트
		if(cnt == N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start; i<= 6; i++) {		// 유도파트
			numbers[cnt] = i;
			dice4(cnt+1, i+1);		// 일반조합이니까 현재수 다음부터뽑음 i+1
		}
	}
}
