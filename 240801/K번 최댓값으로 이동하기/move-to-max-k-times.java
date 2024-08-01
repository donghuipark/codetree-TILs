import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, k, startX, startY;
    private static int[][] grid;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static Queue<int[]> q = new LinkedList<>();
    private static List<int[]> list;

    private static void bfs(){
        while (!q.isEmpty()) {
            int[] curV = q.poll();
            int x = curV[0];
            int y = curV[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (canGo(nx, ny)) {
                    list.add(new int[]{grid[nx][ny], nx, ny});
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
    private static boolean canGo(int nx, int ny){
        if (inRange(nx, ny)) {
            if (!visited[nx][ny] && grid[startX][startY] > grid[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
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
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken())-1;
        startY = Integer.parseInt(st.nextToken())-1;

        for(int i=0; i<k; i++){
            visited = new boolean[n][n];
            visited[startX][startY] = true;
            list = new ArrayList<>();
            q.add(new int[]{startX, startY});
            bfs();
            
            if (list.isEmpty()) {
                break;
            }
            else{
                //정렬해서 첨 값 startx,y로 초기화
                list.sort(
                    Comparator.comparingInt((int[] arr) -> arr[0]).reversed()
                    .thenComparingInt(arr -> arr[1]) 
                    .thenComparing(arr -> arr[2])
                );

                startX = list.get(0)[1];
                startY = list.get(0)[2];
            }
        }
        System.out.println((int)(startX+1) + " " + (int)(startY+1) + " ");
    }
}