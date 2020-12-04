import java.util.Arrays;
import java.util.Scanner;

// 입력받은 N개의 숫자 중 R개를 선택하는 조합
public class C1_CombinationTest {

	private static int N = 4, R = 2;
	private static int[] numbers;	// 조합 저장 배열
	private static int[] input;		// 입력된 숫자 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// 전체 숫자
		R = sc.nextInt();		// 몇개 뽑을지?
		
		numbers = new int[R];
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0, 0);
	}
	
	// 지정된 자리에 조합수 뽑기
	// cnt: 현재까지 뽑은 순열의 갯수, start: 조합에 시작점으로 시도할 원소 인덱스
	private static void combination(int cnt, int start) {	
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;		// 더이상 재귀를 타지 않게 return 해줌
		}
		// 현 자리에 시작위치 수부터 끝위치 수까지 시도
		for(int i= start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt+1, i+1);	// 너는 i+1 위치부터 시도해봐~ 
		}
	}
}
