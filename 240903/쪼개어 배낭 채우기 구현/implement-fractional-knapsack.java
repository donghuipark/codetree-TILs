import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        double[][] arr = new double[n][3];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double w = Double.parseDouble(st.nextToken());
            double v = Double.parseDouble(st.nextToken());
            arr[i][0] = w;
            arr[i][1] = v;
            arr[i][2] = v / w; // 단위 무게당 가치
        }

        // 단위 무게당 가치를 기준으로 내림차순 정렬
        Arrays.sort(arr, (a, b) -> Double.compare(b[2], a[2]));

        double maxValue = 0.0;
        long remainingCapacity = m;

        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            double weight = arr[i][0];
            double value = arr[i][1];

            if (remainingCapacity >= weight) {
                // 보석을 전부 담을 수 있을 때
                maxValue += value;
                remainingCapacity -= weight;
            } else {
                // 보석의 일부만 담을 수 있을 때
                maxValue += value * (remainingCapacity / weight);
                remainingCapacity = 0;
            }
        }

        // 결과를 소수점 셋째 자리까지 반올림하여 출력
        System.out.printf("%.3f\n", maxValue);
    }
}