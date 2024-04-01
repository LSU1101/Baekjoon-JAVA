import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine()); // 후보수
        var candidate = new int[number];
        int answer = 0;

        for (int i = 0; i < number; i++) {
            candidate[i] = Integer.parseInt(br.readLine());
        }

        int me = candidate[0];
        int maxIndex = findMax(candidate);

        while (maxIndex != 0) {
            candidate[0]++;
            candidate[maxIndex]--;
            maxIndex = findMax(candidate);
            answer++;
        }

        System.out.println(answer);
    }

    public static int findMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= array[max]) {
                max = i;
            }
        }

        return max;
    }
}