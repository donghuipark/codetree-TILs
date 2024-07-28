import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    private static int n;
    private static int ans = 0;
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
              
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.  
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
            }
        });
        
        int lineSize = line.length;
        int end = 0;
        for(int i=0;i<lineSize;i++){
            if (end < line[i][0]) {
                ans++;
                end = line[i][1];
            }
        }
        System.out.println(ans);
    }
}