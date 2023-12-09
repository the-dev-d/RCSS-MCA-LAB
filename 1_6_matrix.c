#include <stdio.h>
#define MAX 100

void printMatrix(int rows, int cols, int matrix[][MAX]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

void inputMatrix(int rows, int cols, int matrix[][MAX]) {

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
}

void addMatrices(int rows, int cols, int matrix1[][MAX], int matrix2[][MAX], int result[][MAX]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }
}

void subtractMatrices(int rows, int cols, int matrix1[][MAX], int matrix2[][MAX], int result[][MAX]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = matrix1[i][j] - matrix2[i][j];
        }
    }
}

void multiplyMatrices(int rows, int cols, int matrix1[][MAX], int matrix2[][MAX], int result[][MAX]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = 0;
            for (int k = 0; k < cols; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }
}

int main() {

    int matrix1[MAX][MAX];
    int matrix2[MAX][MAX];
    int result[MAX][MAX];
    int rows, cols;
    
    printf("Enter the number of rows and columns for the matrices: ");
    scanf("%d %d", &rows, &cols);

    printf("Enter matrix 1 : \n");
    inputMatrix(rows, cols, matrix1);
    printf("Enter matrix 2 : \n");
    inputMatrix(rows, cols, matrix2);

    printf("Matrix 1:\n");
    printMatrix(rows, cols, matrix1);
    printf("\nMatrix 2:\n");
    printMatrix(rows, cols, matrix2);

    addMatrices(rows, cols, matrix1, matrix2, result);
    printf("\nAddition Result:\n");
    printMatrix(rows, cols, result);

    subtractMatrices(rows, cols, matrix1, matrix2, result);
    printf("\nSubtraction Result:\n");
    printMatrix(rows, cols, result);

    multiplyMatrices(rows, cols, matrix1, matrix2, result);
    printf("\nMultiplication Result:\n");
    printMatrix(rows, cols, result);

    return 0;
}
