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

void insert(int data) {
	
	struct node *t, *newNode = create_node(data);
	
	if(head == NULL) {
		
		head = newNode;
		newNode->next = head;
		
		return;
	}
	t = head;
	
	while(t->next != head) {
		t = t->next;
	}
	newNode->next = head;
	t->next = newNode;
	
	return;
}

int display() {
	
	if(head == NULL) {
		
		printf("Empty!! \n");
	}
	
	struct node *temp = head;
	
	do {
		
		printf("%d --> ", temp->data);
		temp = temp->next;
		
	}while(temp != head);
}

int main() {
	
	int opt, data;
	do{
		
		printf("\n\n1.Insert \n2.Display \n3.Exit \nEnter your option : ");
		scanf("%d", &opt);
		
		switch(opt) {
			
			case 1:
				printf("Enter element : ");
				scanf("%d", &data);
				insert(data);
				break;
				
			case 2:
				display();
				break;
				
			case 3:
				break;
		}
	}while(opt!=3);
	
	return 0;
	
}
