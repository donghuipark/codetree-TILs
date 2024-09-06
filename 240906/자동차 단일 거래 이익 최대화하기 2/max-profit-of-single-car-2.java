import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int minPrice = arr[0]; // 첫 번째 해의 가격을 초기 최소값으로 설정
        int maxProfit = 0; // 최대 이익은 처음엔 0으로 시작
        
        // 가격을 하나씩 살펴보며 최대 이익 계산
        for (int i = 1; i < n; i++) {
            // 현재 가격에서 최소 가격을 뺀 값과 이전까지의 최대 이익 중 큰 값을 선택
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
            // 최소 가격 갱신
            minPrice = Math.min(minPrice, arr[i]);
        }
        
        // 결과 출력
        System.out.println(maxProfit);
        
    }
}