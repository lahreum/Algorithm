// 1~N 까지의 수를 모두 뽑아 순서적으로 나열
import java.util.Arrays;

public class P1_PermutationTest {

	private static int N = 4;
	private static int[] numbers;	// 순열 저장 배열
	private static boolean[] isSelected;	// 방문처리 배열
	public static void main(String[] args) {
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		permutation(0);
	}
	
	// 지정된 자리에 순열 뽑기
	private static void permutation(int cnt) {	// cnt: 현재까지 뽑은 순열의 갯수
		
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;		// 더이상 재귀를 타지 않는다~
		}
		
		for(int i=1; i<= N; i++) {
			// 중복확인
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;	// 해당 숫자 사용
			isSelected[i] = true;
			
			permutation(cnt+1);	// 다음 자리 순열 뽑음
			isSelected[i] = false;
		}
	}
}
