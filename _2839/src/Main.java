import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sugar = Integer.parseInt(br.readLine());
        int fiveKg = sugar / 5;
        int remainder = sugar % 5;

        while (fiveKg >= 0) {
            if (remainder % 3 == 0) {
                System.out.println(fiveKg + remainder / 3);
                return;
            }

            fiveKg--;
            remainder += 5;
        }

        System.out.println("-1");
    }
}