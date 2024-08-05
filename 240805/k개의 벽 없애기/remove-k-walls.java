import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k, r1, c1, r2, c2;
    private static int[][] grid;
    private static List<int[]> walls = new ArrayList<>();
    private static List<int[]> wallPick = new ArrayList<>();
    private static int ans = Integer.MAX_VALUE;
   

    private static int[][] initCopy(){
        int[][] copy = new int[n][n];
        //일단 copy
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
    private static boolean canGo(int[][] newGrid, boolean[][] visited, int x, int y){
        return inRange(x, y) && !visited[x][y] && newGrid[x][y] != 1;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    
    private static int bfs(int[][] newGrid, boolean[][] visited){
        
        visited[r1][c1] = true;
        newGrid[r1][c1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1, c1});

        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx == r2 && ny == c2) {
                    return newGrid[x][y]+1;
                }

                if (canGo(newGrid, visited, nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    newGrid[nx][ny] = newGrid[x][y] + 1;
                }
            }
        }
        return -1;
    }
    private static void backtracking(int depth, int start){
        // k개 선택했다면 그걸로 bfs진행
        if (depth == k) {
            int[][] copy = initCopy();
            for(int[] wall : wallPick){
                copy[wall[0]][wall[1]] = 0;
            }

            boolean[][] visited = new boolean[n][n];
            int result = bfs(copy, visited);
            if (result != -1) {
                ans = Math.min(ans, result);
            }
            return;
        }

        for(int i=start;i<walls.size();i++){
            //선택하기
            wallPick.add(walls.get(i));
            backtracking(depth+1, start+1);
            //선택안함
            wallPick.remove(wallPick.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
       
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    walls.add(new int[]{i, j});
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken())-1;
        c1 = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        r2 = Integer.parseInt(st.nextToken())-1;
        c2 = Integer.parseInt(st.nextToken())-1;
        


        backtracking(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);


    }
}