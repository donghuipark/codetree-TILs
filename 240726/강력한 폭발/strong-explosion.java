import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int[][] grid;
    private static int[][] dxs = {{-2, -1, 1, 2}, {-1, 1, 0, 0}, {-1, -1, 1, 1}};
    private static int[][] dys = {{0, 0, 0, 0,}, {0, 0, -1, 1}, {-1, 1, 1, -1}};
    // 폭탄 좌표 넣기
    private static List<int[]> bombPositions;
    // 폭탄 개수
    private static int bombSize;
    // 각 폭탄 폭파 모양을 저장하기
    private static int[] bombs;
    private static int maxArea;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        bombPositions = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 1) {
                    bombPositions.add(new int[]{i, j});
                }
            }
            
        }
        // 폭탄의 개수
        bombSize = bombPositions.size();
        // 폭탄 모양 저장
        bombs = new int[bombSize];

        //첨에있는 폭탄부터 터뜨리기
        simulate(0);
        System.out.println(maxArea);

        br.close();     
    }

    private static void simulate(int depth){ //depth = 폭탄 하나 꺼내기
        // 폭탄하나씩 꺼내서 터뜨릴 모양 결정다했으면 즉 bomsize에 도달하면
        // 첫번재 폭탄 ~ 마지막 폭탄 모양 다 설정했다는 소리. 그럼 getArea()로 최대 구하기
        if (depth == bombSize) { 
            maxArea = Math.max(maxArea, getArea());
            return;
        }   

        for(int i=0;i<3;i++){
            bombs[depth] = i; // 몇번째 폭탄(depth) 터질 모양(i) 정하기
            simulate(depth+1);
        }
    }

    private static int getArea(){
        int area = 0;
        //일단 폭파모양 따로 복사본에다가 하자.
        int[][] copy = copyGrid();

        for(int i=0;i<bombSize;i++){
            int[] pos = bombPositions.get(i); // 좌표꺼내
            int x = pos[0];
            int y = pos[1];

            for(int j=0;j<4;j++){
                int nx = x + dxs[bombs[i]][j];
                int ny = y + dys[bombs[i]][j];

                if (inRange(nx, ny)) {
                    copy[nx][ny]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (copy[i][j]>0) {
                    area++;
                }
            }
        }

        return area;
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }


    private static int[][] copyGrid(){
        int[][] newGrid = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newGrid[i][j] =  grid[i][j];
            }
        }
        return newGrid;
        }
}