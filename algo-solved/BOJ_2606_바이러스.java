import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static boolean[] visit;
	static int n,m, count = 0;
	
	public static int bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		visit[i] = true;	// '큐에 넣을때' 동시에 반드시 방문처리를 해줘야함. 
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			for(int k=0; k<=n; k++) {	// 정점마다 모두 연결되었나 확인
				if(map[temp][k] == 1 && visit[k] == false) {
					queue.offer(k);
					visit[k] = true;
					count++;	// 연결되어있다는 거니까 곧 감염이 된다는 뜻. -> count 증가
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 정점 개수
		m = sc.nextInt();	// 간선 개수
		map = new int[n+1][n+1];	// 각 정점간 탐색 경로 저장
		visit = new boolean[n+1];	// 정점의 탐색 여부 체크
		
		for(int i=0; i<m; i++) {	// 간선 개수만큼 연결된 쌍을 map위에 표시
			int a = sc.nextInt();	// 출발
			int b = sc.nextInt();	// 도착
			map[a][b] = map[b][a] = 1;	// 연결됨
		}
		
		System.out.println(bfs(1));	// 1번 컴퓨터부터 탐색시작
		sc.close();
	}

}
