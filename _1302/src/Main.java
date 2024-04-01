import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        var bookMap = new HashMap<String, Integer>();
        String answer = null;

        for (int i = 0; i < number; i++) {
            String bookName = br.readLine();

            if (bookMap.containsKey(bookName)) {
                int value = bookMap.get(bookName);
                bookMap.put(bookName, value + 1);
            } else {
                bookMap.put(bookName, 1);
            }
        }

        Set<String> ketSet = bookMap.keySet();
        String[] keys = ketSet.toArray(new String[0]);

        int max = 0;

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            int value = bookMap.get(key);
            if (value > max || (value == max && key.compareTo(answer) < 0)) {
                max = value;
                answer = key;
            }
        }

        System.out.println(answer);
    }
}