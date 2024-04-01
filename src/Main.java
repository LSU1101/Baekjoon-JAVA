import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution sol = new Solution();
        int[] answer = sol.solution(array, commands);

        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int length = end - start + 1; // 4
            var cutArray = new int[length];

            int k = 0;
            for (int j = start - 1; j < end; j++) {
                cutArray[k++] = array[j];
            }

            sorting(cutArray);
            answer[i] = cutArray[commands[i][2] - 1];
        }

        return answer;
    }

    public void sorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}