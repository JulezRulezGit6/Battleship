import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        char[] chars = new char[50];
        int read1 = reader.read(chars);
        for (int i = read1-1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
        // start coding here
        reader.close();
    }
}