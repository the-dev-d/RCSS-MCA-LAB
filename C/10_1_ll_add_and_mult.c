#include <stdio.h>
#include <stdlib.h>

typedef struct poly {
    int coef;
    int exp;
} POLY;

typedef struct node {
    POLY poly;
    struct node* next;
} NODE;

NODE* create_node(int coef, int exp) {
    NODE* newNode = (NODE*)malloc(sizeof(NODE));
    newNode->poly.coef = coef;
    newNode->poly.exp = exp;
    newNode->next = NULL;
    return newNode;
}

NODE* insert_node(NODE** head, int coef, int exp) {
    NODE* t = *head;
    if (t == NULL) {
        (*head) = create_node(coef, exp);
        return (*head);
    }
    while (t->next != NULL) {
        t = t->next;
    }
    t->next = create_node(coef, exp);
    t->next->next = NULL;
    return t->next;
}

void readPolynomial(NODE** head) {
    char separator;
    int coef, exp;
    do {
        scanf("%dx^%d", &coef, &exp);
        scanf("%c", &separator);
        insert_node(head, coef, exp);
    } while (separator == '+');
}

void display_polynomial(NODE* t) {
    if (t != NULL) {
        printf("%dx^%d ", t->poly.coef, t->poly.exp);
        t = t->next;
    }
    while (t != NULL) {
        printf("+ %dx^%d ", t->poly.coef, t->poly.exp);
        t = t->next;
    }
    printf("\n");
}

NODE* add_polynomials(NODE* p1_head, NODE* p2_head) {
    NODE* sum_head = NULL;
    NODE* sum_current = NULL;

    while (p1_head != NULL && p2_head != NULL) {
        if (p1_head->poly.exp == p2_head->poly.exp) {
            int sum_coef = p1_head->poly.coef + p2_head->poly.coef;
            if (sum_coef != 0) {
                NODE* new_node = create_node(sum_coef, p1_head->poly.exp);
                if (sum_head == NULL) {
                    sum_head = new_node;
                    sum_current = sum_head;
                } else {
                    sum_current->next = new_node;
                    sum_current = new_node;
                }
            }
            p1_head = p1_head->next;
            p2_head = p2_head->next;
        } else if (p1_head->poly.exp > p2_head->poly.exp) {
            sum_current = insert_node(&sum_head, p1_head->poly.coef, p1_head->poly.exp);
            p1_head = p1_head->next;
        } else {
            sum_current = insert_node(&sum_head, p2_head->poly.coef, p2_head->poly.exp);
            p2_head = p2_head->next;
        }
    }

    while (p2_head != NULL) {
        insert_node(&sum_head, p2_head->poly.coef, p2_head->poly.exp);
        p2_head = p2_head->next;
    }

    while (p1_head != NULL) {
        insert_node(&sum_head, p1_head->poly.coef, p1_head->poly.exp);
        p1_head = p1_head->next;
    }

    return sum_head;
}

NODE* multiply_polynomials(NODE* p1_head, NODE* p2_head_t) {
    NODE* product_head = NULL;
    NODE* p2_head = NULL;

    while (p1_head != NULL) {
        p2_head = p2_head_t;
        NODE* temp_head = NULL;
        NODE* temp_current = NULL;

        while (p2_head != NULL) {
            int product_coef = p1_head->poly.coef * p2_head->poly.coef;
            int product_exp = p1_head->poly.exp + p2_head->poly.exp;

            if (product_coef != 0) {
                NODE* new_node = create_node(product_coef, product_exp);
                if (temp_head == NULL) {
                    temp_head = new_node;
                    temp_current = temp_head;
                } else {
                    temp_current->next = new_node;
                    temp_current = new_node;
                }
            }

            p2_head = p2_head->next;
        }

        product_head = add_polynomials(product_head, temp_head);

        p1_head = p1_head->next;
    }

    return product_head;
}

int main() {
    NODE* p1_head = NULL;
    NODE* p2_head = NULL;
    NODE* product_head;
    NODE* sum_head;

    printf("Enter polynomial 1 : ");
    readPolynomial(&p1_head);
    display_polynomial(p1_head);

    printf("Enter polynomial 2 : ");
    readPolynomial(&p2_head);
    display_polynomial(p2_head);

    sum_head = add_polynomials(p1_head, p2_head);
    printf("\nSum of the polynomials:\n");
    display_polynomial(sum_head);

    product_head = multiply_polynomials(p1_head, p2_head);
    printf("\nProduct of the polynomials:\n");
    display_polynomial(product_head);

    return 0;
}
