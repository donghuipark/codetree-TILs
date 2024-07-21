import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int[][] grid = new int[4][4];
    private static String dir;

    private static void goleft(){
        //한 가로줄씩 봐야돼.
        for(int i=0;i<4;i++){
            //일단 공백이 있는 지없는지 먼저 봐야할것같은데...
            //이제 왼쪽으로밀어
            int[] tmp = new int[4];
            int endOfTmp =0;
            for(int j=0;j<4;j++){
                if (grid[i][j] != 0) {
                    tmp[endOfTmp++] = grid[i][j];
                }
            }

            //이제 옮겨
            for(int j=0;j<4;j++){
                grid[i][j] = tmp[j];
            }
            //벽쪽에서부터 같은 수가 2개 있는가 없을때까지 돌려봐야할것같은데.
            for(int curIdx = 0; curIdx<3;curIdx++){
                if(grid[i][curIdx] == 0){
                    continue;
                }
                if (grid[i][curIdx] == grid[i][curIdx+1]) {
                    grid[i][curIdx] = 2*grid[i][curIdx];
                    grid[i][curIdx+1] = 0;
                }
            }

            //이제 왼쪽으로밀어
            int[] tmp = new int[4];
            int endOfTmp =0;
            for(int j=0;j<4;j++){
                if (grid[i][j] != 0) {
                    tmp[endOfTmp++] = grid[i][j];
                }
            }

            //이제 옮겨
            for(int j=0;j<4;j++){
                grid[i][j] = tmp[j];
            }
        }
    }
    private static void goright(){
        //가로줄 보자
        for(int i=0;i<4;i++){
             //오른쪽으로 이제 밀기
             int[] tmp = new int[4];
             int endOfTmp = 3;
             for(int j=3; j>=0; j--){
                 if (grid[i][j] !=0) {
                     tmp[endOfTmp--] =grid[i][j];
                 }
             }
             // 다시 옮기기
             for(int j=0;j<4;j++){
                 grid[i][j] = tmp[j];
             }
            //벽면 오른쪽이니깐 cur을 3부터 0까지
            for(int curIdx =3 ; curIdx>0 ; curIdx--){
                if (grid[i][curIdx] == 0) {
                    continue;
                }
                if (grid[i][curIdx] == grid[i][curIdx-1]) {
                    grid[i][curIdx] = 2*grid[i][curIdx];
                    grid[i][curIdx-1] = 0;
                }
            }
            //오른쪽으로 이제 밀기
            int[] tmp = new int[4];
            int endOfTmp = 3;
            for(int j=3; j>=0; j--){
                if (grid[i][j] !=0) {
                    tmp[endOfTmp--] =grid[i][j];
                }
            }
            // 다시 옮기기
            for(int j=0;j<4;j++){
                grid[i][j] = tmp[j];
            }
        }
    }
    private static void goup(){
        //세로줄
        for(int j=0;j<4;j++){
            
            //위로 밀기
            int[] tmp = new int[4];
            int endOfTmp = 0;
            for(int i=0;i<4;i++){
                if (grid[i][j] != 0) {
                    tmp[endOfTmp++] = grid[i][j];
                }
            }
            //copy
            for(int i=0;i<4;i++){
                grid[i][j] = tmp[i];
            }
            //위가 벽면이다.
            for(int curIdx =0; curIdx<3; curIdx++){
                if (grid[curIdx][j] == 0) {
                    continue;
                }
                if (grid[curIdx][j] == grid[curIdx+1][j]) {
                    grid[curIdx][j] = 2*grid[curIdx][j];
                    grid[curIdx+1][j] = 0; 
                }
            }

            //위로 밀기
            int[] tmp = new int[4];
            int endOfTmp = 0;
            for(int i=0;i<4;i++){
                if (grid[i][j] != 0) {
                    tmp[endOfTmp++] = grid[i][j];
                }
            }
            //copy
            for(int i=0;i<4;i++){
                grid[i][j] = tmp[i];
            }
        }
    }
    private static void godown(){
        //세로줄
        for(int j=0;j<4;j++){
            
            //밑으로 밀기
            int[] tmp = new int[4];
            int endOfTmp = 3;
            for(int i=3;i>=0;i--){
                if (grid[i][j] !=0) {
                    tmp[endOfTmp--] = grid[i][j];
                }
            }
            //copy
            for(int i=0;i<4;i++){
                grid[i][j] = tmp[i];
            }
            //벽이 밑이다.
            for(int curIdx = 3; curIdx>0; curIdx--){
                if (grid[curIdx][j] == 0) {
                    continue;
                }

                if (grid[curIdx][j] == grid[curIdx-1][j]) {
                    grid[curIdx][j] = 2*grid[curIdx][j];
                    grid[curIdx-1][j] = 0;
                }
            }

            //밑으로 밀기
            int[] tmp = new int[4];
            int endOfTmp = 3;
            for(int i=3;i>=0;i--){
                if (grid[i][j] !=0) {
                    tmp[endOfTmp--] = grid[i][j];
                }
            }
            //copy
            for(int i=0;i<4;i++){
                grid[i][j] = tmp[i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }    
        }

        dir = br.readLine();
        if  (dir.equals("L")){
            goleft();
        }
        else if(dir.equals("R")){
            goright();
        }
        else if(dir.equals("U")){
            goup();
        }
        else if(dir.equals("D")){
            godown();            
        }

        for(int i=0;i<4;i++)
        {
            for(int j=0; j<4; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}