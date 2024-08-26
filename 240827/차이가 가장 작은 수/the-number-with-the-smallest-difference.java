import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n과 m을 입력받습니다.
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // n개의 정수를 담을 배열을 선언합니다.
        int[] arr = new int[n];

        // 배열에 값을 채워 넣습니다.
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 배열을 오름차순으로 정렬합니다.
        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int minDifference = Integer.MAX_VALUE;

        // 투 포인터를 이용해 차이가 m 이상이면서 가장 작은 값을 찾습니다.
        while (right < n) {
            int diff = arr[right] - arr[left];

            // 차이가 m 이상인 경우
            if (diff >= m) {
                minDifference = Math.min(minDifference, diff);
                left++;
            } else {
                right++;
            }

            // 두 포인터가 겹치면 right를 증가시킵니다.
            if (left == right) {
                right++;
            }
        }

        // minDifference가 초기값 그대로라면, 조건을 만족하는 쌍이 없었다는 의미이므로 -1을 출력
        if (minDifference == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDifference);
        }

        scanner.close();
    }
}