import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 카드의 개수 n 입력
        int n = scanner.nextInt();
        
        // 첫 번째 플레이어의 카드 배열 입력
        int[] player1 = new int[n];
        for (int i = 0; i < n; i++) {
            player1[i] = scanner.nextInt();
        }

        // 두 번째 플레이어의 카드 배열 입력
        int[] player2 = new int[n];
        for (int i = 0; i < n; i++) {
            player2[i] = scanner.nextInt();
        }

        // 카드들을 정렬
        Arrays.sort(player1);
        Arrays.sort(player2);

        // 두 번째 플레이어가 얻을 수 있는 최대 점수를 계산
        int score = 0;
        int j = 0; // 두 번째 플레이어의 인덱스

        for (int i = 0; i < n; i++) {
            if (j < n && player2[j] < player1[i]) {
                score += player2[j]; // 남우가 점수를 얻음
                j++; // 남우의 카드 버리기
            }
        }

        // 결과 출력
        System.out.println(score);

        scanner.close();
    }
}