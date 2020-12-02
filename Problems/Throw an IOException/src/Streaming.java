import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Streaming {


    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Repository\\Battleship1\\Problems\\Throw an IOException\\src\\file.TXT");

        FileReader fileReader = new FileReader(file);
        int charAsNum = fileReader.read();
        while (charAsNum!=-1){
            int character = charAsNum;
            System.out.println(character);
            charAsNum = fileReader.read();

        }
fileReader.close();

    }
}
