import java.util.Scanner;

public class Main {

    public static int runLengthEncoding(String str) {
        StringBuilder result = new StringBuilder();
        char c = str.charAt(0);
        int cnt = 1;
        int size = str.length();

        for (int i = 1; i < size; i++) {
            if (str.charAt(i) != c) {
                result.append(c).append(cnt);
                c = str.charAt(i);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt > 1 || str.charAt(size - 1) != str.charAt(size - 2)) {
            result.append(c).append(cnt);
        }

        return result.length();
    }

    public static int shiftStr(String str) {
        int answer = Integer.MAX_VALUE;
        int size = str.length();
        char[] arr = str.toCharArray();

        for (int i = 0; i < size; i++) {
            // Right shift
            char lastElement = arr[size - 1];
            System.arraycopy(arr, 0, arr, 1, size - 1);
            arr[0] = lastElement;

            // Compare
            answer = Math.min(answer, runLengthEncoding(new String(arr)));
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.next();
        scanner.close();

        System.out.println(shiftStr(inputStr));
    }
}