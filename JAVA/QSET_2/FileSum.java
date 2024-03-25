import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class FileSum {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileSum <input_file>");
            return;
        }

        String fileName = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int sum = 0;
            while ((line = reader.readLine()) != null) {
                // Tokenize the line
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    // Get next token (integer) and parse it to an integer
                    String token = tokenizer.nextToken();
                    int number = Integer.parseInt(token);

                    // Display the integer
                    System.out.println("Integer: " + number);

                    // Update the sum
                    sum += number;
                }
            }

            // Display the sum of all integers
            System.out.println("Sum of all integers: " + sum);

        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in the file: " + e.getMessage());
        }
    }
}
