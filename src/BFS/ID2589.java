package BFS;

import java.io.*;
import java.util.*;

public class ID2589{
	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map = new char[51][51];
	static int[][] dist = new int[51][51];
	static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int l, w, max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		for (int i = 0; i < l; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = str.charAt(j);
			}
		}

        // **
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < w; j++) {
				dist = new int[l][w]; // instead of visited, it marks visited and dist
				if (dist[i][j] >= 1 || map[i][j] == 'W') {
					continue;
				}
				bfs(i, j);
				
				// print
				// System.out.println("print dist: " + (w*i+j+1));
				// System.out.println(k++);
				// for (int[] arr : dist) {
				// 	System.out.println(Arrays.toString(arr));
				// }
			}
		}

		sb.append(max - 1);
		System.out.print(sb);
		br.close();
	}

	static void bfs(int x, int y) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		dist[x][y] = 1;
		q.offer(new Pair(x, y));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];
				if (nx < 0 || nx >= l || ny < 0 || ny >= w) {
					continue;
				}
                // **visited or water 
				if (dist[nx][ny] >= 1 || map[nx][ny] == 'W') {
					continue;
				}
				dist[nx][ny] = dist[p.x][p.y] + 1;
				max = Math.max(max, dist[nx][ny]);
				q.offer(new Pair(nx, ny));
			}
		}
	}
}

/**
 * note that you can run bfs as many as the number of land. 
 * 
 * The worst case is that row is 50 and col is 50
 * 
 * "육지를 나타내는 두 곳 사이를 최단 거리로 이동하려면 같은 곳을 
 * 두 번 이상 지나가거나, 멀리 돌아가서는 안 된다." 
 * means never allowing cycle (DFS).
 */