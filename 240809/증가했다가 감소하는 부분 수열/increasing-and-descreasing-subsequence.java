import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력: 수열의 길이 N
        int N = scanner.nextInt();

        // 입력: 수열
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = scanner.nextInt();
        }

        // 증가하는 부분 수열의 길이
        int[] increasing = new int[N];
        // 감소하는 부분 수열의 길이
        int[] decreasing = new int[N];

        Arrays.fill(increasing, 1);
        Arrays.fill(decreasing, 1);

        // 각 원소에 대해 왼쪽에서 오른쪽으로 증가하는 부분 수열의 길이를 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    increasing[i] = Math.max(increasing[i], increasing[j] + 1);
                }
            }
        }

        // 각 원소에 대해 오른쪽에서 왼쪽으로 감소하는 부분 수열의 길이를 계산
        for (int i = N-2; i >= 0; i--) {
            for (int j = N-1; j > i; j--) {
                if (sequence[i] > sequence[j]) {
                    decreasing[i] = Math.max(decreasing[i], decreasing[j] + 1);
                }
            }
        }

        // 가장 긴 증가-감소 부분 수열의 길이를 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, increasing[i] + decreasing[i] - 1);
        }

        // 결과 출력
        System.out.println(maxLength);

        scanner.close();
    }
}