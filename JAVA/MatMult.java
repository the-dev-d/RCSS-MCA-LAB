import java.util.Scanner;

class MatMult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for the first matrix:");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        System.out.println("Enter the elements of the first matrix:");
        int[][] matrix1 = inputMatrix(rows1, cols1, scanner);

        System.out.println("Enter the number of rows and columns for the second matrix:");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible because the number of columns in the first matrix "
                    + "does not match the number of rows in the second matrix.");
            return;
        }

        System.out.println("Enter the elements of the second matrix:");
        int[][] matrix2 = inputMatrix(rows2, cols2, scanner);

        int[][] result = multiplyMatrices(matrix1, matrix2);

        // Displaying the result
        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int[][] inputMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
}

