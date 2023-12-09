#include<stdio.h>
#include<malloc.h>
struct node {
	
	int data;
	struct node *next;
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

void display() {
	
	struct node* temp = head;
	
	printf("\n\n");
	while(temp != NULL) {
		printf("%d --> ", temp->data );
		temp = temp->next;
	}
}

int main() {
	
	int opt, data;
	do{
		
		printf("\n\n1.Insert \n2.Display \n3.Display \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1:
				printf("Enter element : ");
				scanf("%d", &data);
				insert_last(data);
				break;
				
			case 2:
				display();
				
			case 3:
				break;
		}
	}while(opt!=3);
	
	return 0;
	
}
