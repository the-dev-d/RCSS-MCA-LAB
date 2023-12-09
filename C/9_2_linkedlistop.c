#include<stdio.h>
#include<malloc.h>
struct node {
	
	int data;
	struct node *next;
};

typedef struct node node;

enum L_OP{
	INSERT_FIRST=1,
	INSERT_LAST,
	INSERT_AT,
	DISPLAY
};

struct node *head;

struct node* create_node(int data) {
	
	struct node *newNode = ( struct node* )malloc(sizeof(struct node));
	newNode->data = data;
	newNode->next = NULL;
	
	return newNode;
}

void insert_last(int data) {
	
	struct node *temp, *newNode = create_node(data);
	if(head == NULL) {
		head = newNode;
		return;
	}
	
	temp = head;
	
	while(temp->next != NULL) {
		temp = temp->next;
	}
	
	
	temp->next = newNode;
	return;
}

void insert_first(int data) {
	
	node *newNode = create_node(data);
	newNode->next = head;
	head = newNode;
}

void insert_at(int data, int pos) {
	
	int i;
	node* t, *newNode;
	t=head;
	for(i=1; i<pos-1 && t!=NULL ;i++) {
		t = t->next;
	}
	
	if(t==NULL) {
		printf("Invalid position!!");
		return;
	}
	
	newNode = create_node(data);
	newNode->next = t->next;
	t->next = newNode;
}

void display() {
	
	struct node* temp = head;
	
	printf("\n\n");
	while(temp != NULL) {
		printf("%d --> ", temp->data );
		temp = temp->next;
	}
}

int main() {
	
	int opt, data, pos;
	do{
		
		printf("\n\n1.Insert first \n2.Insert last \n3.Insert at \n4.Display \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case INSERT_FIRST:
				printf("Enter element : ");
				scanf("%d", &data);
				insert_first(data);
				break;
				
			case INSERT_LAST:
				printf("Enter element : ");
				scanf("%d", &data);
				insert_last(data);
				break;
				
			case INSERT_AT:
				printf("Enter element : ");
				scanf("%d", &data);
				
				printf("Enter position : ");
				scanf("%d", &pos);
				insert_at(data, pos);
				break;
				
			case DISPLAY:
				display();
				break;
		}
	}while(opt!=5);
	
	return 0;
	
}
