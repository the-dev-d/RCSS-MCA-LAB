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

void display_reverse() {
	
	struct node *end = NULL;
	do {
		struct node *temp;
		for(temp = head; temp->next != end; temp = temp->next) {
			
		}
		printf("%d --> ", temp->data);
		end = temp;
		
	}while(end != head);
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
		
		printf("\n\n1.Insert \n2.Display \n3.Reverse \n4.Exit \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1:
				printf("Enter element : ");
				scanf("%d", &data);
				insert_last(data);
				break;
				
			case 2:
				display();
				break;
				
			case 3:
				display_reverse();
				break;
		}
	}while(opt!=4);
	
	return 0;
	
}
