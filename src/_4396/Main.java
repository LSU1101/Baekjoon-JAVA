package _4396;

/*
1. n 입력
2. 지뢰의 위치 입력
3. 열린 칸, 열리지 않은 칸 입력

열린 칸에 0, 8 사이의 숫자 출력 (주변에 있는 지뢰의 개수)
지뢰가 있는 칸이 열렸다면 지뢰가 모두 *로 표시
다른 모든 지점은 .으로 표시
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        var map = new char[n][n];
        var bombMap = new boolean[n][n];
        var openedMap = new boolean[n][n];
        var answerMap = new char[n][n];
        boolean bombOpened = false;

        for (int i = 0; i < map.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = input.charAt(j);

                if (input.charAt(j) == '*') {
                    bombMap[i][j] = true;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            String input = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                if (input.charAt(j) == 'x') {
                    if (bombMap[i][j]) {
                        bombOpened = true;
                    }
                    openedMap[i][j] = true;
                    answerMap[i][j] = '0';
                } else {
                    answerMap[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (bombMap[i][j]) {
                    adder(answerMap, i - 1, j - 1);
                    adder(answerMap, i - 1, j);
                    adder(answerMap, i - 1, j + 1);
                    adder(answerMap, i, j - 1);
                    adder(answerMap, i, j + 1);
                    adder(answerMap, i + 1, j - 1);
                    adder(answerMap, i + 1, j);
                    adder(answerMap, i + 1, j + 1);
                }
            }
        }

        if (bombOpened) {
            for (int i = 0; i < answerMap.length; i++) {
                for (int j = 0; j < answerMap.length; j++) {
                    if (bombMap[i][j]) {
                        System.out.print("*");
                    } else {
                        System.out.print(answerMap[i][j]);
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < answerMap.length; i++) {
                for (int j = 0; j < answerMap.length; j++) {
                    System.out.print(answerMap[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void adder(char[][] answerMap, int i, int j) {
        try {
            if (answerMap[i][j] >= 48 && answerMap[i][j] <= 57) {
                int index = Character.getNumericValue(answerMap[i][j]) + 1;
                answerMap[i][j] = (char)(index + 48);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }
}
