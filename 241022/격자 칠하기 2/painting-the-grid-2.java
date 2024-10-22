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

    private static int bfs(boolean[][] visited, int x, int y, int mid){
        int cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int d=0;d<4;d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(isValid(nx, ny) && !visited[nx][ny] && Math.abs(arr[cx][cy]-arr[nx][ny]) <= mid){
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

        int left = 0;
        int right = max;
        int result = -1;
        int required_cells = (n * n + 1) / 2; // 전체 칸의 반을 반올림

        while(left <= right){
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j]){
                        int component_size = bfs(visited, i, j, mid);
                        cnt = Math.max(cnt, component_size);
                    }
                }
            }

            // 최대 연결된 영역의 크기가 전체 칸의 반 이상이면 D 값을 줄여서 최소값을 찾음
            if(cnt >= required_cells){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}