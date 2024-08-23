import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // n: 숫자의 개수, k: 최대 허용 음수 개수
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int left = 0, right = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int negativeCount = 0;

        while (right < n) {
            // 오른쪽 포인터가 가리키는 값을 윈도우에 추가
            if (numbers[right] < 0) {
                negativeCount++;
            }
            currentSum += numbers[right];

            // 음수 개수가 k를 초과하면 왼쪽 포인터를 오른쪽으로 이동
            while (negativeCount > k) {
                if (numbers[left] < 0) {
                    negativeCount--;
                }
                currentSum -= numbers[left];
                left++;
            }

            // 음수 개수가 k 이하일 때, 최대 부분합을 갱신
            maxSum = Math.max(maxSum, currentSum);

            // 오른쪽 포인터를 한 칸 오른쪽으로 이동
            right++;
        }

        // 결과 출력
        System.out.println(maxSum);

        scanner.close();
    }
}