import java.util.*;
import java.io.*;

public class Main {
    private static int n, t;
    private static int[] times;

    // k명씩 무대에 올라가게 했을 때 모든 사람이 무대에서 내려갈 때까지 걸리는 시간을 계산
    private static int simul(int k) {
        // 우선순위 큐: 무대에 올라간 사람들 중 가장 먼저 내려갈 사람을 관리
        PriorityQueue<Integer> stage = new PriorityQueue<>();
        int totalTime = 0;
        int index = 0;

        // 처음에 k명 올리기
        for (int i = 0; i < k && i < n; i++) {
            stage.add(times[index++]);
        }

        // 무대에서 계속 내려가면서 새로운 사람을 올리기
        while (!stage.isEmpty()) {
            // 현재 무대에서 가장 먼저 끝나는 사람의 시간
            int tempTime = stage.poll();
            totalTime = tempTime;  // 무대에서 가장 먼저 끝난 사람의 시간으로 전체 시간 갱신

            // 남아 있는 사람이 없으면 종료
            if (index < n) {
                // 새로운 사람 무대에 올리기
                stage.add(times[index++] + tempTime);  // 새로 올라가는 사람의 시작 시간은 현재까지 경과 시간만큼 더해짐
            }
        }

        return totalTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // N명
        t = Integer.parseInt(st.nextToken());  // Tmax 값
        times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(br.readLine());  // 각 사람의 무대에서의 머무르는 시간 입력
        }

        int left = 1;
        int right = n;
        int result = n;

        // 이진 탐색으로 K의 최솟값 찾기
        while (left <= right) {
            int mid = (left + right) / 2;

            if (simul(mid) <= t) {
                result = mid;  // Tmax 이하일 때 K값 저장
                right = mid - 1;  // 더 작은 K 찾기
            } else {
                left = mid + 1;  // Tmax를 초과하면 더 큰 K 값 탐색
            }
        }

        System.out.println(result);
    }
}