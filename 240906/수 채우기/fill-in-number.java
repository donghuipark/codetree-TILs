import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        System.out.println(getMiniCoins(n));
    }

    public static int getMiniCoins(int n) {
        // 5원 동전 최대 개수를 구합니다.
        for (int i = n / 5; i >= 0; i--) {
            int remaining = n - (i * 5);  // 5원 동전을 사용한 후 남은 금액
            if (remaining % 2 == 0) {  // 남은 금액이 2원 동전으로 나누어 떨어지면
                return i + (remaining / 2);  // 5원 동전 개수 + 2원 동전 개수
            }
        }
        return -1;  // 정확히 맞출 수 없는 경우
    }
}