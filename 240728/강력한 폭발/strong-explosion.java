import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int ans = Integer.MIN_VALUE;
    private static int[][] grid;
    // 입력받은 곳에서 1인 곳 저장하기
    private static List<int[]> bombsPosition;
    // 어떤 방식으로 터뜨릴지에 대한 정보 저장하기
    private static int[] bombs;
    // 위치이동 
    private static int[][] dxs = {{-2, -1, 1, 2}, {-1, 1, 0, 0}, {-1, -1, 1, 1}};
    private static int[][] dys = {{0, 0, 0, 0}, {0, 0, -1, 1}, {-1, 1, 1, -1}};

    private static void simulate(int depth){
        if (depth == bombsPosition.size()) {
            ans = Math.max(ans, getArea());
            return;
        }

        for(int i=0;i<3;i++){
            bombs[depth] = i;
            simulate(depth+1); 
        }
    }

    private static int getArea(){
        int area = 0;

        //복사본
        int [][] copy = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = grid[i][j];
            }
        }

        //폭탄하나씩 꺼내서 
        for(int i=0;i<bombsPosition.size(); i++){
            //폭탄 위치 좌표 꺼내
            int[] pos = bombsPosition.get(i);
            int x = pos[0];
            int y = pos[1];

            for(int d=0; d<4; d++){
                int nx = x + dxs[bombs[i]][d];
                int ny = y + dys[bombs[i]][d];

                if (inRange(nx, ny)) {
                    copy[nx][ny]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (copy[i][j] > 0) {
                    area++;
                }
            }
        }
        return area;       
    }

    private static boolean inRange(int x, int y){
        return x >=0 && x<n && y>=0 && y<n;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        bombsPosition = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 1) {
                    bombsPosition.add(new int[]{i, j});
                }
            }
        }
        bombs = new int[bombsPosition.size()];
        
        simulate(0);
        System.out.println(ans);

        br.close();
    }
}