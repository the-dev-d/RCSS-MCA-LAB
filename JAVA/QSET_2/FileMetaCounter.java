import java.io.*;
import java.util.*;

public class FileMetaCounter {

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("No file provided");
            return;
        }

        File file = new File(args[0]);
        int lettersCount = 0, wordsCount = 0, linesCount = 0;

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String data = br.readLine();

            while (data != null) {

                linesCount++;

                String words[] = data.split(" ");
                wordsCount += words.length;

                for (int i = 0; i < words.length; i++) {

                    for (int j = 0; j < words[i].length(); j++) {

                        if (Character.isAlphabetic(words[i].charAt(j))) {
                            lettersCount++;
                        }
                    }
                }
                wordsCount += words.length;
                data = br.readLine();

            }

            fileReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Words : " + wordsCount + "\nLetter count :" + lettersCount + "\nLine count :" + linesCount);

    }
}
