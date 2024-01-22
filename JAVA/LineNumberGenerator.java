import java.io.*;
import java.util.*;

class LineNumberGenerator {

    public static void main(String[] args) {

        try {

            File inputFile = new File("sample.txt");

            FileReader fileReader = new FileReader(inputFile);

            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();
            String content = "";

            for (int i = 1; line != null; i++) {
                String wl = i + ": " + line + "\n";
                content += wl;
                line = br.readLine();
            }

            File temp = new File("sample.txt");
            FileWriter fileWriter = new FileWriter(temp);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(content);
            bw.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        }

    }

}
