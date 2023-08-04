#include <stdio.h>
struct poly {
    int coef, expo;
};

int getPolynomial(struct poly polynomial[]) {
    char separator;
    int i = 0;
    do {
        scanf("%dx^%d", &polynomial[i].coef, &polynomial[i].expo);
        scanf("%c", &separator);
        i++;
    } while (separator == '+');
    return i;
}

void showPolynomial(struct poly polynomial[], int size) {
    int i;
    for (i = 0; i < size; i++) {
        if (!polynomial[i].expo) {
            printf("%d ", polynomial[i].coef);
            continue;
        }
        printf("%dx^%d ", polynomial[i].coef, polynomial[i].expo);
        if (i == size - 1)
            continue;
        printf(" + ");
    }
}

int multiplyPolynomial(struct poly polynomial1[], int size1, struct poly polynomial2[], int size2, struct poly res[]) {
    int i, j, k, r = 0;
    for (i = 0; i < size1; i++) {
        for (j = 0; j < size2; j++) {
            res[r].coef = polynomial1[i].coef * polynomial2[j].coef;
            res[r].expo = polynomial1[i].expo + polynomial2[j].expo;
            r++;
        }
    }
    return r;
}

int main() {
    struct poly poly1[10], poly2[10], res[100];
    int s1, s2, sres;

    printf("Enter polynomial 1 : ");
    s1 = getPolynomial(poly1);

    printf("Enter polynomial 2 : ");
    s2 = getPolynomial(poly2);

    printf("\nEntered Polynomial 1: ");
    showPolynomial(poly1, s1);
    
    printf("\nEntered Polynomial 2: ");
    showPolynomial(poly2, s2);

    sres = multiplyPolynomial(poly1, s1, poly2, s2, res);

    printf("\n\nResult: ");
    showPolynomial(res, sres);

    return 0;
}
