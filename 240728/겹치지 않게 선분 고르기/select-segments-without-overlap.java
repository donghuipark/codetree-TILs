import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int ans = 1;
    private static int[][] line;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        line = new int[n][2];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                line[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // (배열, override 함수);
        Arrays.sort(line, new Comparator<int[]>() { // new Comparator 함수 Override
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){ // 첫번째 원소의 값이 같을 때 두번쨰 원소의 값을 기준으로 정렬
                    return o1[1] - o2[1];
                }else{ // 같지 않을 시 첫번째 원소를 기준으로 정렬
                    return o1[0] - o2[0];
                }
            }
        });
        
        int lineSize = line.length;
        // 시작점
        int start = line[0][0];
        int end = line[0][1];
        for(int i=1;i<lineSize;i++){
            if (end < line[i][0]) {
                ans++;
                start = line[i][0];
                end = line[i][1];
            }
        }
        System.out.println(ans);
    }
}