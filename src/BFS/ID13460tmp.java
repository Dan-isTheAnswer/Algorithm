// https://www.acmicpc.net/problem/13460
package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ID13460tmp {
    private int[][] map;
    // east west south north
    private int[] dy = {0, 0, 1, -1};
    private int[] dx = {1, -1, 0, 0};

    private static class Snapshot {
        int rx, ry;
        int bx, by;
        // int dir;
        // int count;

        public Snapshot(int ry, int rx, int by, int bx) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            // this.dir = dir;
        }
    }

    public static void main(String[] args) {
        int N = 7;
        int M = 7;

        String[] inputs = {"#######",
                           "#..R#B#",
                           "#.#####",
                           "#.....#",
                           "#####.#",
                           "#O....#",
                           "#######"};
        // int N = 5; // row
        // int M = 5; // col

        // String[] inputs = {"#####", 
        //                    "#..B#",
        //                    "#.#.#",
        //                    "#RO.#",
        //                    "#####"};

        ID13460tmp balls = new ID13460tmp();
        balls.solve(N, M, inputs);
        // System.out.println(ans);

        
    }

    public void solve(int N, int M, String[] inputs) {
        this.map = new int[N][M];
        int[] dest = conversion(inputs, map);
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(dest));
        System.out.println();

        bfs(dest);
        for (int[] arr : map) {
            System.out.println(Arrays.toString(arr));
        }

        // return result;
    }

    public void bfs(int[] dest) {
        int N = this.map.length;
        int M = this.map[0].length;
        Queue<Snapshot> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][M][N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (this.map[i][j] == 1) {
                    red[0] = i; red[1] = j;
                }
                if (this.map[i][j] == -2) {
                    blue[0] = i; blue[1] = j;
                }
            }
        }
        Snapshot snap = new Snapshot(red[0], red[1], blue[0], blue[1]);
        q.offer(snap);
        
        while(!q.isEmpty()) {
            snap = q.poll();
            visited[snap.ry][snap.rx][snap.by][snap.bx] = true;

            for (int i = 0; i < 4; i++) {
                int nrY = snap.ry + dy[i];
                int nrX = snap.rx + dx[i];
                int nbY = snap.by + dy[i];
                int nbX = snap.bx + dx[i];
                // if (nrY >= 0 && nrY < N && nrX >= 0 && nrX < M) {
                // red first
                if (priority(snap, i) == 1) {
                    // move the red ball
                    while (nrY >= 0 && nrY < N && nrX >= 0 && nrX < M &&
                           map[nrY][nrX] != -1 && map[nrY][nrX] != -2) {
                        this.map[nrY][nrX] = this.map[snap.ry][snap.rx];
                        this.map[snap.ry][snap.rx] = 0;

                        if (map[dest[0]][dest[1]] != 0) {
                            break;
                        }

                        // if (nrY >= 0 && nrY < N && nrX >= 0 && nrX < M) {
                        if (map[nrY+dy[i]][nrX+dx[i]] != -1) {
                            nrY += dy[i]; // need to set border
                            nrX += dx[i];
                        } else {
                            // out of scope
                            break;
                        }
                    }
                    if (map[dest[0]][dest[1]] != 0) {
                        System.out.println(map[dest[0]][dest[1]]);
                        break;
                    }


                    // move the blue ball
                    while (nbY >= 0 && nbY < N && nbX >= 0 && nbX < M && 
                           map[nbY][nbX] != -1 && map[nbY][nbX] == 0) {
                        this.map[nbY][nbX] = this.map[snap.by][snap.bx]; // move the blue ball
                        this.map[snap.by][snap.bx] = 0; // reset the previous pos

                        if (map[dest[0]][dest[1]] == -2) {
                            break;
                        }
                        
                        // if (nbY >= 0 && nbY < N && nbX >= 0 && nbX < M) {
                        if (map[nbY+dy[i]][nbX+dx[i]] != -1) {
                            nbY += dy[i];
                            nbX += dx[i];
                        } else {
                            // out of scope
                            break;
                        }
                    }
                    if (map[dest[0]][dest[1]] == -2) {
                        this.map[nbY][nbX] = 0; // move the blue ball
                        this.map[snap.by][snap.bx] = -2; // reset the previous pos
                        continue;
                    }
                } else { // blue first
                    // move the blue ball
                    while (nbY >= 0 && nbY < N && nbX >= 0 && nbX < M && 
                            map[nbY][nbX] != -1 && map[nbY][nbX] == 0) {
                        this.map[nbY][nbX] = this.map[snap.by][snap.bx]; // move the blue ball
                        this.map[snap.by][snap.bx] = 0; // reset the previous pos

                        if (map[dest[0]][dest[1]] == -2) {
                            break;
                        }

                        // if (nbY+dy[i] >= 0 && nbY+dy[i] < N && nbX+dx[i] >= 0 && nbX+dx[i] < M) {
                        if (map[nbY+dy[i]][nbX+dx[i]] != -1) {
                            nbY += dy[i];
                            nbX += dx[i];
                        } else {
                            break;
                        }
                    }
                    if (map[dest[0]][dest[1]] == -2) {
                        this.map[nbY][nbX] = 0; // move the blue ball
                        this.map[snap.by][snap.bx] = -2; // reset the previous pos
                        continue;
                    }

                    // move the red ball
                    while ( nrY >= 0 && nrY < N && nrX >= 0 && nrX < M && 
                            map[nrY][nrX] != -1 && map[nrY][nrX] != -2) {
                        this.map[nrY][nrX] = this.map[snap.ry][snap.rx];
                        this.map[snap.ry][snap.rx] = 0;

                        if (map[dest[0]][dest[1]] != 0) {
                            break;
                        }

                        // if (nrY+dy[i] >= 0 && nrY+dy[i] < N && nrX+dx[i] >= 0 && nrX+dx[i] < M) {
                        if (map[nrY+dy[i]][nrX+dx[i]] != -1) {
                            nrY += dy[i];
                            nrX += dx[i];
                        } else {
                            break;
                        }
                    }
                    if (map[dest[0]][dest[1]] != 0) {
                        System.out.println(map[dest[0]][dest[1]]);
                        break;
                    }
                }

                // if !visited
                if (!visited[nrY][nrX][nbY][nbX]) {
                    this.map[nrY][nrX] += 1;
                    q.add(new Snapshot(nrY, nrX, nbY, nbX));
                }
            }
        }

        if (this.map[dest[0]][dest[1]] == 0) System.out.println(-1);;
    }

    // return 1 if red first; return -2 if blue first
    public int priority(Snapshot snap, int i) {
                
        if (i == 0) {
            if (snap.rx > snap.bx) return 1;
            else return -2;
        } else if (i == 1) {
            if (snap.rx < snap.bx) return 1;
            else return -2; 
        } else if (i == 2) {
            if (snap.ry > snap.by) return 1;
            else return -2;
        } else if (i == 3) {
            if (snap.ry < snap.by) return 1;
            else return -2;
        } 

        return 0;
    }

    public void moveRedBall(int nrY, int nrX, int i) {
    }

    public void moveBlueBall(int nbY, int nbX) {
    }

    // R is 1, B is -2 but B is moved 
    public int[] conversion(String[] inputs, int[][] map) {
        int[] dest = new int[2];
        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs[i].length(); j++) {
                if (inputs[i].charAt(j) == '#') map[i][j] = -1;
                else if (inputs[i].charAt(j) == 'R') map[i][j] = 1;
                else if (inputs[i].charAt(j) == 'B') map[i][j] = -2;
                else if (inputs[i].charAt(j) == 'O') dest = new int[] {i, j};
            }
        }

        return dest;
    }
}