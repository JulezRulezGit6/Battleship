import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String trimmed = input.trim();
        reader.close();
        if (trimmed.length() == 0) {
            System.out.println(0);
        } else {
            String[] s = trimmed.split("\\s+");
            System.out.println(s.length);
        }
    }
}