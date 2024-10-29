import java.util.*;
import java.io.*;

public class Main {
    private static int n, k, u, d, max = 0;
    private static int[][] map;
    private static List<int[]> pick = new ArrayList<>();
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    private static boolean isValid(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    
    private static void backtracking(int idx, int pickCnt){
        if(pickCnt == k){
            boolean[][] visited = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();

            for(int[] pos : pick){
                int r = pos[0];
                int c = pos[1];

                visited[r][c] = true;
                q.add(new int[]{r, c});
            }

            int cnt = 0;
            while(!q.isEmpty()){
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];
                cnt++;

                for(int dir = 0; dir < 4; dir++){
                    int nx = r + dx[dir];
                    int ny = c + dy[dir];
                    
                    if(isValid(nx, ny) && !visited[nx][ny] && u <= Math.abs(map[r][c] - map[nx][ny]) && Math.abs(map[r][c] - map[nx][ny]) <= d){
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i = idx; i < n * n; i++){
            int x = i / n;
            int y = i % n;
            pick.add(new int[]{x, y});
            backtracking(i + 1, pickCnt + 1);
            pick.remove(pick.size() - 1);
        }
    }
    
    public static void main(String[] args) throws IOException {

        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 수정된 backtracking 호출
        backtracking(0, 0);
        System.out.println(max);
    }
}