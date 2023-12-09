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

void push(int data) {
	
	struct node *newNode = create_node(data);

	newNode->next = head;
	head = newNode;
	
	return;
}

int pop() {
	
	if(head == NULL) {
		
		printf("Stack underflow!! \n");
		return 0;
	}
	
	int data = head->data;
	
	head = head->next;
	
	printf("Popped : %d", data);
	
	return data;
}

int main() {
	
	int opt, data;
	do{
		
		printf("\n\n1.Push \n2.Pop \n3.Exit \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1:
				printf("Enter element : ");
				scanf("%d", &data);
				push(data);
				break;
				
			case 2:
				data = pop();
				break;
				
			case 3:
				break;
		}
	}while(opt!=3);
	
	return 0;
	
}
