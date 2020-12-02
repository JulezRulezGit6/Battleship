import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        char[] chars = new char[50];
        int read1 = reader.read(chars);
        for (int i = read1-1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

    }

}