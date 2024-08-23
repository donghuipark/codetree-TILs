import java.util.Arrays;
import java.util.Scanner;

public class Main {

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

        int score = 0;
        int i = 0, j = 0;

        // 두 플레이어의 카드를 비교하며 남우가 이길 수 있는 경우 최대한 점수를 얻도록 함
        while (i < n && j < n) {
            if (player2[j] < player1[i]) {
                score += player2[j];
                j++;
            }
            i++;
        }

        // 결과 출력
        System.out.println(score);

        scanner.close();
    }
}