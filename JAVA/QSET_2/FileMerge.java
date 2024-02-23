import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileMerge {

    public static void main(String[] args) {

        String fileName1 = args[0];
        String fileName2 = args[1];

        try {
            File file1 = new File(fileName1);
            File file2 = new File(fileName2);
            File file3 = new File(fileName1 + fileName2 + "_merge.txt");

            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            BufferedWriter bw = new BufferedWriter(new FileWriter(file3));

            String line1 = br1.readLine();
            String line2 = br2.readLine();

            while (line1 != null && line2 != null) {
                bw.write(line1 + "\n");
                bw.write(line2 + "\n");
                line1 = br1.readLine();
                line2 = br2.readLine();
            }

            while (line1 != null) {
                bw.write(line1 + "\n");
                line1 = br1.readLine();
            }

            while (line2 != null) {
                bw.write(line2 + "\n");
                line2 = br2.readLine();
            }

            br1.close();
            br2.close();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
