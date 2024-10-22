import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int max = Integer.MIN_VALUE;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    private static int bfs(boolean[][] visited, Queue<int[]> q, int mid){
        int cnt = 1;
        while(!q.isEmpty()){
            if(cnt > n*n/2){
                return cnt;
            }
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isValid(nx, ny) && !visited[nx][ny] && Math.abs(arr[x][y]-arr[nx][ny]) <= mid){
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args)throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int left = 1;
        int right = max;
        int result = 0;
        while(left <= right){
            int mid = (left+right) / 2;
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    boolean[][] visited = new boolean[n][n];
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    cnt = Math.max(cnt, bfs(visited, q, mid));
                }
            }
            //색칠하는게 반이상이다? 그럼 mid값 줄여야지
            if(cnt >= n*n/2){
                result = mid;
                right = mid - 1;
            }
            else{
                //색칠하는게 반이상이 안되면 mid값 올려야지
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}