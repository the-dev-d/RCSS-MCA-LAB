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

int addPolynomial(int polynomial1[][2], int size1, int polynomial2[][2], int size2, int res[][2]) {
    
    int i,j,k;
    for(i =0,j=0,k=0; j<size1 && k<size2; i++ ) {
        
        if(polynomial1[j][1] == polynomial2[k][1]) {
            res[i][0] = polynomial1[j][0] + polynomial2[k][0];
            res[i][1] = polynomial1[j][1];
            j++;k++;
        }
        else if(polynomial1[j][1] > polynomial2[k][1]) {
            res[i][1] = polynomial1[j][1];
            res[i][0] = polynomial1[j][0];
            j++;
        }
        else {
            res[i][1] = polynomial2[k][1];
            res[i][0] = polynomial2[k][0];
            k++;
        }
    }
    if(j==size1) {
        while(k<size2) {
            res[i][1] = polynomial2[k][1];
            res[i][0] = polynomial2[k][0];
            k++;
            i++;
        }
    }
    if(k==size2) {
        while(j<size1) {
            res[i][1] = polynomial1[j][1];
            res[i][0] = polynomial1[j][0];
            j++;i++;
        }
    }
    
    return i;
}

int main() {
    int p1[MAX][2];
    int p2[MAX][2];
    int res[MAX*2][2];
    int n1,n2, nres;

    printf("Enter polynomial 1 : ");
    n1 = readPolynomial(p1);

    printf("Enter polynomial 2 : ");
    n2 = readPolynomial(p2);
    
    printf("polynomial 1 : ");
    displayPolynomial(p1, n1);

    printf("polynomial 2 : ");
    displayPolynomial(p2,n2);


    nres = addPolynomial(p1, n1, p2, n2, res);


    printf("\n The sum is : ");
    displayPolynomial(res,nres);

    return 0;
}
