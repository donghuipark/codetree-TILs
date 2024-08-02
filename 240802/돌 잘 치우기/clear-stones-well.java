import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n, k, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static Queue<int[]> q = new LinkedList<>();
    //stone 위치 저장하는것
    private static List<int[]> stones = new ArrayList<>();
    //stone pick 저장하는것
    private static List<int[]> pick = new ArrayList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int ans = Integer.MIN_VALUE;
    private static int cnt;

    private static void bfs(int[][] copy){
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int x = curPos[0];
            int y = curPos[1];

            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (canGo(nx, ny, copy)) {
                    cnt++;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean canGo(int x, int y, int[][] copy){
        if (inRange(x, y)) {
            if (!visited[x][y] && copy[x][y] == 0) {
                return true;
            }
        }
        return false;
    }
    private static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    private static void backtracking(int stoneCnt){
        if (stoneCnt == m+1) {
            //1. grid copy 하고
            int[][] copy = initCopy();
            cnt =1;
            //2. stones에 있는 거 반영
            for(int[] stonePos : pick){
                int x = stonePos[0];
                int y = stonePos[1];
                copy[x][y] = 0;
            }
            //3. bfs하기
            bfs(copy);
            //4. 최대한 ans 갱신
            ans = Math.max(ans, cnt);
        }

        //stones에 있는거 for문 돌면서 조합만들기.
        for(int i=stoneCnt; i<stones.size();i++){
            int[] stone = stones.get(i);

            //선택한다.
            pick.add(new int[]{stone[0], stone[1]});
            backtracking(stoneCnt+1);
            //선택안한다.
            pick.remove(pick.size()-1);
        }
    }

    private static int[][] initCopy(){
        int[][] copy = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    stones.add(new int[]{i, j});
                }
                
            }
        }

        for(int i=0; i<k;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            visited[x][y] = true;
            q.add(new int[]{x, y});
        }

        // 돌을 어떻게 할까요 0이 들어오면 일단 리스트에 저장.
        // 이렇게 되면 재귀로 선택을 해야하는 것인가?
        // 재귀로 선택을 하고 m개 선택하면 거기 있는것들 grid수정하고 
        // 그걸 바탕으로 bfs? 근데 있는 돌이 몇개인줄알고... ㅈㄴ많은데

        //1. backtracking해서 stone 조합만들기
        backtracking(0);
        System.out.println(ans);
    }
}