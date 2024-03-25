import java.io.*;
import java.net.URL;

public class FileDownloader {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileDownloader <file_url>");
            return;
        }

        String fileUrl = args[0];
        String outputFileName = args[1];

        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            FileWriter writer = new FileWriter(outputFileName);
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + "\n");
            }
            reader.close();
            writer.close();
            System.out.println("File downloaded successfully.");

        } catch (IOException e) {
            System.err.println("Error downloading the file: " + e.getMessage());
        }
    }
}
