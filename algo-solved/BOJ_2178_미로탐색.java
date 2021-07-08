import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visit;
	static int[] di = {-1, 1, 0, 0};	// 상하좌우
	static int[] dj = {0, 0, -1, 1};	// 상하좌우
	static int N, M;
	static int min;	// 최소횟수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String line = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = line.charAt(j-1) - '0';	// char to int
			}
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Ground> queue = new LinkedList<>();
		
		queue.add(new Ground(1,1));
		visit[1][1] = true;
		
		while(!queue.isEmpty()) {
			Ground temp = queue.poll(); 
			
			for(int d=0; d<4; d++) {
				int ni = temp.i + di[d];
				int nj = temp.j + dj[d];
				
				if(ni>=1 && ni <= N && nj >=1 && nj <=M && !visit[ni][nj] && map[ni][nj] == 1) {
					queue.add(new Ground(ni,nj));
					visit[ni][nj] = true;
					map[ni][nj] = map[temp.i][temp.j]+1;	// 최소 이동거리를 나타내기 위해서 
				}
			}
		}
		System.out.println(map[N][M]);
	}
	
	static class Ground{
		int i,j;

		public Ground(int i, int j) {
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}
		
	}
}
