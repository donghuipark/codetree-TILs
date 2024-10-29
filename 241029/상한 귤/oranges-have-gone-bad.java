import java.util.*;
import java.io.*;

public class Main {
    private static int n, k;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int[][] result;
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        result = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());//0아무것도없음 1귤 2 상함
                if(arr[i][j] == 0){
                    result[i][j] = -1;
                }
                if(arr[i][j] == 2){
                    result[i][j] = 0;
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] current  = q.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];

            

            for(int d=0;d<4;d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(isValid(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,time+1});
                    result[nx][ny] = time+1;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    result[i][j] = -2;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }




    }
}