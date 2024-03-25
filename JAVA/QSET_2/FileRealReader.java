import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileRealReader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileStatistics <input_file>");
            return;
        }

        String fileName = args[0];
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double number = Double.parseDouble(line);
                sum += number;
                min = Math.min(min, number);
                max = Math.max(max, number);
                count++;
            }

            if (count == 0) {
                System.out.println("No numbers found in the file.");
            } else {
                double average = sum / count;
                double range = max - min;
                System.out.println("Minimum: " + min);
                System.out.println("Maximum: " + max);
                System.out.println("Average: " + average);
                System.out.println("Range: " + range);
            }

        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the file: " + e.getMessage());
        }
    }
}
