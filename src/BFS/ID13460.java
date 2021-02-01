// https://www.acmicpc.net/problem/13460
package BFS;

import java.util.ArrayDeque;
import java.util.Queue;

class ID13460 {
    // east west south north
    private static final int[] dy = { 0, 0, 1, -1 };
    private static final int[] dx = { 1, -1, 0, 0 };

    private static class Snapshot {
        int ry;
        int rx;
        int by;
        int bx;
        int cnt;

        public Snapshot(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        int N = 3;
        int M = 10;
        String[] inputs = {"##########", "#.O....RB#", "##########"};

        // int N = 10;
        // int M = 10;
        // String[] inputs = {"##########", "#R#...##B#", "#...#.##.#", "#####.##.#", "#......#.#", "#.######.#", "#.#....#.#", "#.#.##...#", "#O..#....#", "##########"};

        // int N = 7;
        // int M = 7;
        // String[] inputs = {"#######", "#...RB#", "#.#####", "#.....#", "#####.#", "#O....#", "#######" };

        // int N = 5; // row
        // int M = 5; // col
        // String[] inputs = {"#####", "#..B#","#.#.#","#RO.#","#####"};
        //
        char[][] map = new char[N][M];
        int[] red = new int[2]; 
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = inputs[i].charAt(j);
                if (map[i][j] == 'R') {
                    red[0] = i; red[1] = j;
                } else if (map[i][j] == 'B') {
                    blue[0] = i; blue[1] = j;
                }
            }
        }

        bfs(map, red, blue);
    }

    private static void bfs(char[][] map, int[] srcRed, int[] srcBlue) {

        boolean isRedGoaled = false;
        boolean isBlueGoaled = false;
        int n = map.length; int m = map[0].length;
        Queue<Snapshot> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        q.offer(new Snapshot(srcRed[0], srcRed[1], srcBlue[0], srcBlue[1], 1));

        while (!q.isEmpty()) {
            Snapshot snap = q.poll();
            visited[snap.ry][snap.rx][snap.by][snap.bx] = true;

            for (int i = 0; i < 4; i++) {
                int[] nr = new int[] {snap.ry + dy[i], snap.rx + dx[i]};
                int[] nb = new int[] {snap.by + dy[i], snap.bx + dx[i]};
                // red
                int[] tmpRed = new int[] {snap.ry, snap.rx}; // this is the legal value which meets the condition
                while (map[nr[0]][nr[1]] != '#') { // check and then confirm
                    tmpRed[0] = nr[0]; tmpRed[1] = nr[1]; // copy value 
                    // fin!
                    if (map[nr[0]][nr[1]] == 'O') {
                        isRedGoaled = true;
                        break;
                    }
                    
                    nr[0] += dy[i]; nr[1] += dx[i]; // update the ref's value
                }
                // blue
                int[] tmpBlue = new int[] {snap.by, snap.bx};
                while (map[nb[0]][nb[1]] != '#') {
                    tmpBlue[0] = nb[0]; tmpBlue[1] = nb[1];
                    // skip!
                    if (map[nb[0]][nb[1]] == 'O') {
                        isBlueGoaled = true;
                        break;
                    }

                    nb[0] += dy[i]; nb[1] += dx[i];
                }

                // if red and blue are overlapped each other
                if (tmpRed[0] == tmpBlue[0] && tmpRed[1] == tmpBlue[1]) {
                    if (isRedGoaled && isBlueGoaled) {
                        // skip 
                    } else if (i == 0) { // east
                        if (snap.rx < snap.bx) 
                            tmpRed[1] -= 1;
                        else 
                            tmpBlue[1] -= 1;
                    } else if (i == 1){
                        if (snap.rx < snap.bx) 
                            tmpBlue[1] += 1;
                        else 
                            tmpRed[1] += 1;
                    } else if (i == 2) {
                        if (snap.ry < snap.by) 
                            tmpRed[0] -= 1;
                        else 
                            tmpBlue[0] -= 1;
                    } else if (i == 3) {
                        if (snap.ry < snap.by) 
                            tmpBlue[0] += 1;
                        else 
                            tmpRed[0] += 1; 
                    }

                }
                // check the red ball is only goaled. If not, reset.
                if (isRedGoaled && !isBlueGoaled){
                    break;
                } else if (!isRedGoaled && isBlueGoaled) {
                    isBlueGoaled = false;
                    continue; 
                } else if (isRedGoaled && isBlueGoaled) {
                    isRedGoaled = false;
                    isBlueGoaled = false;
                    continue;
                }
                
                // q.offer
                if (!visited[tmpRed[0]][tmpRed[1]][tmpBlue[0]][tmpBlue[1]] && snap.cnt <10) { 
                    q.offer(new Snapshot(tmpRed[0], tmpRed[1], tmpBlue[0], tmpBlue[1], snap.cnt+1));
                }

            }
            // print ans and break the while-loop 
            if (isRedGoaled && !isBlueGoaled) {
                System.out.println(snap.cnt);
                break;
            }
        }
        if (!isRedGoaled) System.out.println(-1);
        
    }
}

/**
 * Considered as locations, not as Dimentions, 
 * we can directly access by the four indices!!
 * boolean[][][][] visited = new boolean[n][m][n][m]; 
 * 
 * If we need to know changes of few things 
 * and they change at the same time, 
 * Take a snapshot!!
 */