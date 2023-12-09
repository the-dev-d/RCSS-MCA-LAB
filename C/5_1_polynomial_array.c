#include <stdio.h>

#define MAX 100

int readPolynomial(int polynomial[][2]) {
    
    char seperator;
    int i = 0;
    do {
        scanf("%dx^%d",&polynomial[i][0], &polynomial[i][1]);
        scanf("%c", &seperator);
        i++;
    }while(seperator == '+');
    
    return i;
}

void displayPolynomial(int polynomial[][2], int n) {
    int i = 0;

    printf("%dx^%d", polynomial[i][0], polynomial[i][1]);
    for (i = 1; i < n; i++) {

        printf(" + %dx^%d", polynomial[i][0], polynomial[i][1]);
    }
    printf("\n");
}

int main() {
    int polynomial[MAX][2] = {0}; 
    int n;

    n = readPolynomial(polynomial);
    
    printf("The polynomial is: ");
    displayPolynomial(polynomial, n);

    return 0;
}
