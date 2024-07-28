import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static int n, m, k; // 턴, 윷놀이판, 말수
    private static int[] moves; 
    private static int[] position;

    private static int simulate(int turn, int curScore){
        if (turn == n) {
            return curScore;
        }

        int maxScore = curScore;

        // 각 말 움직이기
        for(int i=0;i<k;i++){
            int originPosition = position[i];
            int newPosition = position[i] + moves[turn];

            // 끝에 도달하면? -> m자리에 그냥 고정
            if (newPosition >= m) {
                newPosition = m;
            }
            // 말이동
            position[i] = newPosition;

            // 점수 계산
            int gainScore = (newPosition == m && originPosition != m) ? 1 : 0;
            maxScore = Math.max(maxScore, simulate(turn+1, curScore+gainScore));
            // 원래 위치로 복구
            position[i] = originPosition;
        }

        return maxScore;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        moves = new int[n];
        position = new int[k];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int maxScore = simulate(0, 0);

        System.out.println(maxScore);
    }
}