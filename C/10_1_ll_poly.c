#include<stdio.h>
#include<malloc.h>

typedef struct poly {

	int coef;
	int exp;
} POLY;

typedef struct node {
	
	POLY poly;
	struct node *next;
} NODE ;


NODE* create_node(int coef, int exp) {
	
	NODE* newNode = (NODE*) malloc(sizeof(NODE));
	newNode->poly.coef = coef;
	newNode->poly.exp = exp;
	newNode->next = NULL;
	return newNode;
}

void insert_node(NODE** head, int coef, int exp) {
	
	NODE *t = *head;
	if(t == NULL) {
		(*head) = create_node(coef, exp);
		return;
	}
	while(t->next != NULL) {
		t= t->next;
	}
	t->next = create_node(coef, exp);
	
}
void readPolynomial(NODE **head) {
    
    char seperator;
    int coef, exp;
    do {
        scanf("%dx^%d",&coef, &exp);
        scanf("%c", &seperator);
        insert_node(head, coef, exp);
        
    }while(seperator == '+');
    
}

void display_polynomial(NODE *t) {
	
	if(t != NULL) {
		printf("%dx^%d ", t->poly.coef, t->poly.exp);
		t = t->next;
	}
	while(t != NULL) {
		printf("+ %dx^%d ", t->poly.coef, t->poly.exp);
		t = t->next;
	}
}

NODE* add_polynomial(){
	
	
}
int main() {
	
	NODE *p1_head = NULL, *p2_head = NULL, sum_head;
	
	printf("Enter polynomial 1 : ");
	readPolynomial(&p1_head);
	display_polynomial(p1_head);
	
	printf("Enter polynomial 1 : ");
	readPolynomial(&p2_head);
	display_polynomial(p2_head);
	
	sum_head = add_polynomials(p1_head, p2_head);
	
	printf("\n\n\n");
	display_polynomial(sum_head);

}
