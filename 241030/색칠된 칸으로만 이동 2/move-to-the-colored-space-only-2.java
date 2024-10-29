import java.util.*;
import java.io.*;

public class Main {
    private static int m, n;
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static List<int[]> colors = new ArrayList<>();
    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }
    private static boolean isPossible(boolean[][] visited){
        for(int[] color : colors){
            if(!visited[color[0]][color[1]]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        int right = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                right = Math.max(right, arr[i][j]);
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int color = Integer.parseInt(st.nextToken());
                if(color == 1){
                    colors.add(new int[]{i, j});
                }
            }
        }

        int left = 1;
        int result = -1;
        while(left <= right){
            int mid = (left + right) / 2;

            boolean[][] visited = new boolean[m][n];
            Queue<int[]> q = new LinkedList<>();

            int[] first = colors.get(0);
            visited[first[0]][first[1]] = true;
            q.add(new int[] {first[0], first[1]});

            while(!q.isEmpty()){
                int[] current = q.poll();

                int x = current[0];
                int y = current[1];
                
                for(int d=0;d<4;d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(isValid(nx, ny) && !visited[nx][ny] && Math.abs(arr[x][y] - arr[nx][ny]) <= mid){
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }

            //이제 다 돌았는지 확인해야돼.
            if(isPossible(visited)){
                //mid를 좀더 줄여도돼.
                result = mid;
                right = mid -1;
            }
            else{
                //mid를 좀더 늘려야돼.
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}