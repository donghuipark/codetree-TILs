import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String A = scanner.nextLine();
        scanner.close();
        
        System.out.println(minRLELength(A));
    }

    public static int minRLELength(String A) {
        int n = A.length();
        int minLength = Integer.MAX_VALUE;

        // 모든 가능한 shift를 확인
        for (int i = 0; i < n; i++) {
            String shifted = rightShift(A, i);
            int rleLength = runLengthEncodingLength(shifted);
            minLength = Math.min(minLength, rleLength);
        }
        return minLength;
    }

    public static String rightShift(String s, int k) {
        int n = s.length();
        k = k % n; // k가 n보다 클 경우를 대비
        return s.substring(n - k) + s.substring(0, n - k);
    }

    public static int runLengthEncodingLength(String s) {
        int n = s.length();
        int rleLength = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                rleLength += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        // 마지막 문자 그룹 처리
        rleLength += 1 + String.valueOf(count).length();

        return rleLength;
    }
}